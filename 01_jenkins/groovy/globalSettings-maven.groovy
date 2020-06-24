import jenkins.model.*
import org.jenkinsci.plugins.configfiles.maven.GlobalMavenSettingsConfig;
def configStore = Jenkins.instance.getExtensionList('org.jenkinsci.plugins.configfiles.GlobalConfigFiles')[0]



def configId =  'mavenDefaultConfig'
def configName = 'Config default for maven'
def configComment = 'Global Maven Settings Default'
def configContent  = '''<settings>
<!-- your maven settings goes here -->
</settings>'''


def globalConfig = new GlobalMavenSettingsConfig(configId, configName, configComment, configContent, true, null)
configStore.save(globalConfig)
