pipeline {
    agent any

    tools {
        maven 'Maven-Default'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/karimunnisa-123/cgpa-app.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Run') {
            steps {
                bat 'java -jar target/*.jar'
            }
        }
    }
}
