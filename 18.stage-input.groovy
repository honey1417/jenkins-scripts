//input and RBAC

pipeline {
    agent any 
    stages {
        stage('Build') {
            steps {
                echo "building the app"
            }
        }
        stage('Test') {
            steps {
                echo "testing the app"
            }
        }
        stage('Deploy to Dev') {
            steps {
                echo "deploying the app to dev env"
            }
        }
        stage('Deploy to Prod') {
            steps { 
                timeout(time: 300, unit: 'SECONDS') {
                    input message: 'wuld u like to promote to prod', ok: 'yes', submitter: 'maha'

                }
                echo "deploying the app to prod env"
            }
        }
    }
}