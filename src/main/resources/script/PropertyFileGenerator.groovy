package script

import org.yaml.snakeyaml.Yaml


final FLAG_KEEP_CONFIG = "keep.config"

def bannerVar = System.getProperty(FrameworkPropertyGenerator.BANNER_PROPERTY, FrameworkPropertyGenerator.DEFAULT_BANNER)
def configVar = System.getProperty(FrameworkPropertyGenerator.CONFIG_PROPERTY, FrameworkPropertyGenerator.DEFAULT_CONFIG)

if (System.getProperty(FLAG_KEEP_CONFIG) == null) {
    new FrameworkPropertyGenerator(targetBanner: bannerVar, targetEnvConfig: configVar).generate()
    println("Generated [${FrameworkPropertyGenerator.CONFIGURATION_PROPERTIES_FILE_PATH}] file for environment [${bannerVar}:${configVar}].")
} else {
    println("Flag -D${FLAG_KEEP_CONFIG} is set, skipping config generation.")
}

class FrameworkPropertyGenerator extends PropertyGenerator {
    static final String YAML_FILE_PATH = "src/main/resources/config/%s/properties.yaml"
    static final String CONFIGURATION_PROPERTIES_FILE_PATH = "src/main/resources/appium.properties"
    static final String ENVIRONMENT_REGEX = "([^-]+)"

    static final String BANNER_PROPERTY = "banner"
    static final String CONFIG_PROPERTY = "test.config"
    static final String DEFAULT_BANNER = "racetrac"
    static final String DEFAULT_CONFIG = "qa1-smoke"

    String targetBanner
    String targetEnvConfig

    @Override
    void generate() {
        String targetEnvironment = targetEnvConfig.find(ENVIRONMENT_REGEX)

        def allYamlProperties = loadYamlFile(String.format(YAML_FILE_PATH, targetBanner))["properties"]
        def selectedEnvProperties = allYamlProperties[targetEnvConfig]

        if (selectedEnvProperties == null)
            throw new RuntimeException("Configuration for [$targetEnvConfig] is missing. Can't generate property file!")

        generatePropertyFile(selectedEnvProperties as Properties, CONFIGURATION_PROPERTIES_FILE_PATH, targetEnvironment)
    }
}

abstract class PropertyGenerator {

    abstract void generate()

    static def loadYamlFile(String yamlFilePath) {
        InputStream yamlFileInputStream = new FileInputStream(new File(yamlFilePath))
        return new Yaml().load(yamlFileInputStream)
    }

    static void generatePropertyFile(Properties properties, String filePath, String environment) {
        def propertyFile = new File(filePath)
        propertyFile.delete()

        properties.each { key, value ->
            value = System.getProperty(key as String, value as String).replace("\${ENVIRONMENT}", environment)

            propertyFile << "${key}=${value}\n"
        }
    }
}
