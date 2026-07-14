pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
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
    }
}
