pipeline {
    agent any

    tools {
        jdk 'JDK24'
        maven 'Maven_3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '🔹 Checking out source code...'
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                echo '🔨 Building project...'
                bat 'mvn clean package -DskipTests=true'
            }
        }

        stage('Verify Artifact') {
            steps {
                echo '🔍 Verifying build output...'
                bat 'dir target'
            }
        }

        stage('Deploy Simulation') {
            steps {
                echo '🚀 Simulating deployment...'
                bat 'echo Deployment successful!'
            }
        }
    }

    post {
        success {
            echo '✅ Build completed successfully!'
        }
        failure {
            echo '❌ Jenkins build failed. Check logs for details.'
        }
    }
}
