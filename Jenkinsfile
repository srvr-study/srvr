pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                script {
                    echo 'Hello'
                }
            }
        }

        stage('Stage 2') {
            steps {
                script {
                    echo 'World'
                    sh 'sleep 5'
                }
            }
        }

        stage('Stage 3') {
            steps {
                script {
                    echo 'Good to see you!'
                }
            }
        }
    }
}