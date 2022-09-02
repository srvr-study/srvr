pipeline {
    agent any
    stages {
        stage('Start docker') {
            steps {
                script {
                    sh 'docker compose up -d ./docker/docker-compose.yml'
                }
            }
        }

        stage('build main server') {
            steps {
                script {
                    sh 'gradle srvr-main:bootJar'
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