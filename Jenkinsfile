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
                script {
                    echo '🔹 Finding pom.xml...'
                    // Find pom.xml anywhere in the workspace
                    def pomPath = bat(script: 'for /r %cd% %%f in (pom.xml) do echo %%f', returnStdout: true).trim()
                    echo "✅ Found pom.xml at: ${pomPath}"
                    
                    // Build project
                    bat "\"%MAVEN_HOME%\\bin\\mvn\" -f \"${pomPath}\" clean package -DskipTests=true"
                }
            }
        }

        stage('Verify Artifact') {
            steps {
                echo '✅ Checking target folder...'
                bat 'dir /s /b target\\*.war'
            }
        }

        stage('Deploy Simulation') {
            steps {
                echo '🚀 Build successful. WAR ready for deployment!'
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
