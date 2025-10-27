pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven 3.9'       // or your installed Maven name
        JAVA_HOME = tool 'JDK24'            // or whatever JDK you configured in Jenkins
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${PATH}"
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
                echo '🔹 Building the project with Maven...'
                bat '"%MAVEN_HOME%\\bin\\mvn" clean package -DskipTests=true'
            }
        }

        stage('Verify Artifact') {
            steps {
                echo '🔹 Verifying build output...'
                bat 'dir target'
            }
        }

        stage('Deploy Simulation') {
            steps {
                echo '🚀 Simulating deployment...'
                bat 'echo "Deploying CGPA App (simulation only)"'
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
