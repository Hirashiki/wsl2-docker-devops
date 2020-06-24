#!/usr/bin/env bash



#Download Files

if [[ ! -e tools/openjdk-9.0.4_linux-x64_bin.tar.gz ]]; then
    curl -o tools/openjdk-9.0.4_linux-x64_bin.tar.gz https://download.java.net/java/GA/jdk9/9.0.4/binaries/openjdk-9.0.4_linux-x64_bin.tar.gz
fi
if [[ ! -e tools/apache-maven-3.6.3-bin.tar.gz ]]; then
    curl -o tools/apache-maven-3.6.3-bin.tar.gz https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.6.3/apache-maven-3.6.3-bin.tar.gz
fi


docker-compose down
docker volume rm jenkins_data
docker image rm 01_jenkins_jenkins
docker-compose up &