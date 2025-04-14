pipeline {
    agent any

    environment {
        MAVEN_IMAGE = 'maven:3.8-eclipse-temurin-17'
    }

    stages {
        stage('Build Backend') {
            steps {
                script {
                    docker.image(MAVEN_IMAGE).inside("-v $HOME/.m2:/root/.m2") {
                        dir('backend') {
                            sh 'mvn clean package -DskipTests'
                        }
                    }
                }
            }
        }

        stage('Build Frontend') {
            steps {
                dir('frontend') {
                    sh 'echo "No build step needed – static files assumed"'
                }
            }
        }

        stage('Docker Compose Up') {
            steps {
                sh 'docker-compose -f backend/docker-compose.yml up -d --build'
                sh 'docker-compose -f frontend/docker-compose.yml up -d --build'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
        success {
            echo '✅ Deployment successful!'
        }
        failure {
            echo '❌ Deployment failed!'
        }
    }
}
