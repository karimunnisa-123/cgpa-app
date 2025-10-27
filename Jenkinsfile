pipeline {
    agent any

    tools {
        maven "Maven-Default"   // use Jenkins default Maven installation
        jdk "JDK17"             // use Jenkins JDK 17 if available
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/karimunnisa-123/cgpa-app.git'
            }
        }

        stage('Build with Maven') {
            steps {
                script {
                    echo "Building project..."
                    bat '"%MAVEN_HOME%\\bin\\mvn" clean package -DskipTests'
                }
            }
        }

        stage('Verify Artifact') {
            steps {
                script {
                    echo "Checking if WAR file was created..."
                    bat 'dir target'
                }
            }
        }

        stage('Deploy Simulation') {
            steps {
                echo "✅ Build completed successfully! WAR file is ready in the target folder."
            }
        }
    }

    post {
        success {
            echo "🎉 Jenkins build succeeded!"
        }
        failure {
            echo "❌ Jenkins build failed. Check logs for details."
        }
    }
}
