pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "cgpa-app"
        GIT_REPO = "https://github.com/karimunnisa-123/cgpa-app.git"
    }

    tools {
        maven "Maven"  // Name you set in Jenkins Global Tool Configuration
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: "${GIT_REPO}", credentialsId: 'github-creds'
            }
        }

        stage('Build with Maven') {
            steps {
                // Uses the Maven tool configured in Jenkins
                withMaven(maven: 'Maven') {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Docker Build') {
            steps {
                bat "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Run Docker Container') {
            steps {
                // Stop old container if exists
                bat "docker stop ${DOCKER_IMAGE} || echo 'No old container running'"
                bat "docker rm ${DOCKER_IMAGE} || echo 'No old container to remove'"
                
                // Run new container
                bat "docker run -d -p 8080:8080 --name ${DOCKER_IMAGE} ${DOCKER_IMAGE}"
            }
        }
    }

    post {
        success {
            echo '✅ Build, Dockerize and run successful!'
        }
        failure {
            echo '❌ Pipeline failed. Check console output for errors.'
        }
    }
}
