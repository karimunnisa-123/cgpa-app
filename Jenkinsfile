pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "cgpa-app"
        CONTAINER_NAME = "cgpa-app"
        HOST_PORT = "8081"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/karimunnisa-123/cgpa-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Run Docker') {
            steps {
                // Stop and remove previous container if exists
                sh 'docker stop $CONTAINER_NAME || true'
                sh 'docker rm $CONTAINER_NAME || true'

                // Run new container
                sh 'docker run -d -p $HOST_PORT:8080 --name $CONTAINER_NAME $DOCKER_IMAGE'
            }
        }
    }
}
