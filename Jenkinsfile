pipeline {
    agent any

    tools {
        jdk 'JDK24'
        maven 'Maven 3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                echo '🔹 Checking out source code...'
                git branch: 'main', url: 'https://github.com/karimunnisa-123/cgpa-app.git'
            }
        }

        stage('Build with Maven') {
            steps {
                echo '🔹 Building project...'
                bat '"%MAVEN_HOME%\\bin\\mvn" -f pom.xml clean package -DskipTests=true'
            }
        }

        stage('Verify Artifact') {
            steps {
                echo '✅ Checking target folder...'
                bat 'dir target'
            }
        }

        stage('Deploy Simulation') {
            steps {
                echo '🚀 Deploy simulation (build successful, jar ready).'
            }
        }
    }

    post {
        success {
            echo '✅ Jenkins build succeeded!'
        }
        failure {
            echo '❌ Jenkins build failed. Check logs for details.'
        }
    }
}
