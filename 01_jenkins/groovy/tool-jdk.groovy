import hudson.model.JDK
import hudson.tools.InstallSourceProperty
import hudson.tools.ZipExtractionInstaller

def jdkDescriptorImpl = new JDK.DescriptorImpl();

def List<JDK> jdkInstallations = []

def name = "openjdk9";
def url =  "file:/usr/share/jenkins_tools/openjdk-9.0.4_linux-x64_bin.tar.gz"
def subdir =  "jdk-9.0.4"

def zipInstaller = new ZipExtractionInstaller(null, url, subdir);
def jdk = new JDK(name, null, [new InstallSourceProperty([zipInstaller])])
jdkInstallations.add(jdk)

jdkDescriptorImpl.setInstallations(jdkInstallations.toArray(new JDK[jdkInstallations.size()]))
jdkDescriptorImpl.save()


