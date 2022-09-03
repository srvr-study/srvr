pipeline {
    agent any
    stages {
        stage('build main server') {
            steps {
                script {
                    sh './gradlew srvr-main:bootJar'
                }
            }
        }

        stage('startup main server') {
            steps {
                script {
                    sh 'java -jar -Dspring.profiles.active=local ./srvr-main-0.0.1-SNAPSHOT.jar'
                }
            }
        }
    }
}