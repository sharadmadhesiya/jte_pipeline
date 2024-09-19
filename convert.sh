#!/bin/bash

# Get the current working directory
current_dir=$(pwd)
output_file="$current_dir/output.groovy"

# Start writing to the output file
{

    # Read YAML configuration
    config_file="$current_dir/config.yaml"

    # Libraries
    libraries=($(yq eval '.libraries[]' "$config_file"))

    # Allow SCM Jenkinsfile
    allow_scm_jenkinsfile=$(yq eval '.allow_scm_jenkinsfile' "$config_file")

    # Function to display environment information
    function display_env_info {
        local env_name=$1
        long_name=$(yq eval ".application_environments.$env_name.long_name" "$config_file")
        ip_addresses=($(yq eval ".application_environments.$env_name.ip_addresses[]" "$config_file"))

        echo "    $env_name {"
        echo "        long_name = \"$long_name\""

        # Format IP addresses correctly
        echo -n "        ip_addresses = [ "
        for ip in "${ip_addresses[@]}"; do
            echo -n "\"$ip\", "
        done
        echo -e " ]"  # Remove trailing comma and space
        echo "    }"
    }

    # Main Execution
    echo "libraries {"
    for lib in "${libraries[@]}"; do
        echo "    $lib"
    done
    echo "}"

    echo "allow_scm_jenkinsfile = $allow_scm_jenkinsfile"
    echo
    echo "application_environments {"
    display_env_info "dev"
    display_env_info "prod"
    echo "}"
} > "$output_file"

echo "Output written to $output_file"
