@Grab(group='org.yaml', module='snakeyaml', version='1.30')
import org.yaml.snakeyaml.Yaml
import java.nio.file.Files
import java.nio.file.Paths

// Load YAML file
def loadYaml(String filePath) {
    def yaml = new Yaml()
    def inputStream = Files.newInputStream(Paths.get(filePath))
    return yaml.load(inputStream)
}

// Path to your YAML file
def filePath = 'config.yaml'

// Read the YAML configuration
def config = loadYaml(filePath)

// Access and use the configuration
def libraries = config.libraries ?: []
libraries.each { lib ->
    println "Library: ${lib}"
}

if (config.allow_scm_jenkinsfile) {
    println "SCM Jenkinsfile is allowed"
}

def envs = config.application_environments ?: [:]
envs.each { envName, envConfig ->
    println "Environment: ${envName}"
    if (envConfig.ip_addresses) {
        println "IP Addresses: ${envConfig.ip_addresses.join(', ')}"
    }
    if (envConfig.long_name) {
        println "Long Name: ${envConfig.long_name}"
    }
}
