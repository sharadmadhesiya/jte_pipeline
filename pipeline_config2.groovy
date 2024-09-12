// Load the YAML configuration
def config = readYaml file: 'config.yaml'

// Ensure the configuration is loaded properly
if (config == null) {
    error "Failed to load configuration from 'config.yaml'"
}

// Access and use the 'libraries' list
def libraries = config.libraries ?: []
if (libraries instanceof List) {
    libraries.each { lib ->
        echo "Library: ${lib}"
        // Load libraries or perform actions as needed
        // Example: if (lib == 'maven') { // load maven library }
    }
} else {
    echo "No libraries found or 'libraries' is not a list"
}

// Check if SCM Jenkinsfile is allowed
if (config.allow_scm_jenkinsfile) {
    echo "SCM Jenkinsfile is allowed"
} else {
    echo "SCM Jenkinsfile is not allowed or not set"
}

// Access application environments
def envs = config.application_environments ?: [:]
if (envs instanceof Map) {
    envs.each { envName, envConfig ->
        echo "Environment: ${envName}"
        if (envConfig.ip_addresses) {
            echo "IP Addresses: ${envConfig.ip_addresses.join(', ')}"
        } else {
            echo "No IP Addresses found for ${envName}"
        }
        if (envConfig.long_name) {
            echo "Long Name: ${envConfig.long_name}"
        } else {
            echo "No Long Name found for ${envName}"
        }
    }
} else {
    echo "No application environments found or 'application_environments' is not a map"
}
