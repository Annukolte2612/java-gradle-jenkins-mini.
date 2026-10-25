pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'if [ -f ./gradlew ]; then chmod +x ./gradlew && ./gradlew --no-daemon clean build; else gradle --no-daemon clean build; fi'
                    } else {
                        bat 'if exist gradlew.bat (call gradlew.bat --no-daemon clean build) else (gradle --no-daemon clean build)'
                    }
                }
            }
        }
        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }
    }
}
