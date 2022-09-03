pipeline {
    agent any
    stages {
        stage('main server') {
            steps {
                dir('./srvr-main/src/main/resources') {
                    writeFile encoding: 'UTF-8', file: './application-secret.properties', text: env.test
                    sh 'cat ./application-secret.properties'

                    writeFile encoding: 'UTF-8', file: './test', text: '${main-server-secret}'
                    sh 'cat ./test'

                    writeFile encoding: 'UTF-8', file: './test2', text: 'test2'
                    sh 'cat ./test2'
                }
                withGradle {
                    sh './gradlew srvr-main:clean'
                    sh './gradlew srvr-main:test'
                    sh './gradlew srvr-main:bootJar'
                }
                dir('./srvr-main/build/libs') {
                    sh 'java -jar -Dspring.profiles.active=dev ./srvr-main-0.0.1-SNAPSHOT.jar'
                }
            }
        }
    }
}