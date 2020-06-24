import hudson.tasks.Maven
import hudson.tasks.Maven.MavenInstallation;
import hudson.tools.InstallSourceProperty;
import hudson.tools.ToolProperty;
import hudson.tools.ToolPropertyDescriptor
import hudson.tools.ZipExtractionInstaller;
import hudson.util.DescribableList
import jenkins.model.Jenkins;



def mavenDescriptorImpl = Jenkins.instance.getExtensionList(Maven.DescriptorImpl.class)[0]

List<MavenInstallation> mavenInstallations = []

def name = "maven3"
def url = "file:/usr/share/jenkins_tools/apache-maven-3.6.3-bin.tar.gz"
def subdir = "apache-maven-3.6.3"

def describable = new DescribableList<ToolProperty<?>, ToolPropertyDescriptor>()
def zipInstaller = new ZipExtractionInstaller(null, url, subdir);
describable.add(new InstallSourceProperty([zipInstaller]))
mavenInstallations.add(new MavenInstallation(name, "", describable))

mavenDescriptorImpl.setInstallations(mavenInstallations.toArray(new MavenInstallation[mavenInstallations.size()]))
mavenDescriptorImpl.save()



