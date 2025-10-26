pipeline {
    agent any

    environment {
        // Update these paths if needed
        MAVEN_HOME = "C:\\Program Files\\Apache\\maven-3.9.9"
        DOCKER_IMAGE = "cgpa-app"
        GIT_REPO = "https://github.com/karimunnisa-123/cgpa-app.git"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: "${GIT_REPO}", credentialsId: 'github-creds'
            }
        }

        stage('Build with Maven') {
            steps {
                bat '"%MAVEN_HOME%\\bin\\mvn" clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Run Docker Container') {
            steps {
                bat "docker stop ${DOCKER_IMAGE} || echo 'No old container'"
                bat "docker rm ${DOCKER_IMAGE} || echo 'No old container'"
                bat "docker run -d -p 8080:8080 --name ${DOCKER_IMAGE} ${DOCKER_IMAGE}"
            }
        }
    }

    post {
        success {
            echo '✅ Build and deployment successful!'
        }
        failure {
            echo '❌ Build failed. Check logs.'
        }
    }
}
