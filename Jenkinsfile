pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('checkout') {
            steps {
                checkout scm
            }
        }

        stage('build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }

        stage('docker') {
            steps {
                bat 'docker build -t myapp:10 .'
            }
        }

        stage('deploy') {
            steps {
                bat 'docker rm -f myapp-container & docker run -d -p 9090:8080 --name myapp-container myapp:10'
            }
        }
    }
}