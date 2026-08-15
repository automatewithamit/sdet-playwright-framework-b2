pipeline {

    agent any

    environment {
        PLAYWRIGHT_IMAGE = 'mcr.microsoft.com/playwright/java:v1.61.0-noble'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out latest code from GitHub...'
                checkout scm

                sh '''
                    echo "Current Git commit:"
                    git log -1 --oneline
                '''
            }
        }

        stage('Verify Docker') {
            steps {
                sh '''
                    docker --version
                    docker ps
                '''
            }
        }

        stage('Build') {
            steps {
                sh """
                    docker run --rm \
                      --ipc=host \
                      -v "\$WORKSPACE:/workspace" \
                      -w /workspace \
                      ${PLAYWRIGHT_IMAGE} \
                      mvn clean compile
                """
            }
        }

        stage('Run Playwright Tests') {
            steps {
                sh """
                    docker run --rm \
                      --ipc=host \
                      -v "\$WORKSPACE:/workspace" \
                      -w /workspace \
                      ${PLAYWRIGHT_IMAGE} \
                      mvn test
                """
            }
        }
    }

    post {

        always {
            echo 'Publishing test results...'

            junit allowEmptyResults: true,
                  testResults: '**/target/surefire-reports/*.xml'
        }

        success {
            echo '=========================================='
            echo 'PLAYWRIGHT TESTS PASSED'
            echo '=========================================='
        }

        failure {
            echo '=========================================='
            echo 'PLAYWRIGHT TESTS FAILED'
            echo 'Check the console output.'
            echo '=========================================='
        }

        cleanup {
            echo 'Cleaning Jenkins workspace...'
            deleteDir()
        }
    }
}
