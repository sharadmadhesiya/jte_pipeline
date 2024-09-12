
// Load the YAML configuration
def config = readYaml file: 'config.yaml'

// Access and use the 'libraries' list
def libraries = config.libraries
libraries.each { lib ->
    echo "Library: ${lib}"
    // Load libraries or perform actions as needed
    // Example: if (lib == 'maven') { // load maven library }
}

// Check if SCM Jenkinsfile is allowed
if (config.allow_scm_jenkinsfile) {
    echo "SCM Jenkinsfile is allowed"
}

// Access application environments
def envs = config.application_environments
envs.each { envName, envConfig ->
    echo "Environment: ${envName}"
    echo "IP Addresses: ${envConfig.ip_addresses.join(', ')}"
    if (envConfig.long_name) {
        echo "Long Name: ${envConfig.long_name}"
    }
}
