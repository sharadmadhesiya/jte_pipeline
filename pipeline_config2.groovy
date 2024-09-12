@Library('my-shared-library') _

def config = readYaml file: 'yaml_conf.yaml'

// Access libraries
def libraries = config.libraries
libraries.each { lib ->
    // Load libraries as required
    echo "Library: ${lib}"
}

// Check allow_scm_jenkinsfile
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
