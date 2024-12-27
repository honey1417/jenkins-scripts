
pipeline {
    agent any
    environment {
        //our own custom env variables
        DEPLOY_TO = 'production'
    }
    stages {
        stage('Deploy to Dev') {
            steps {
                echo "deploying to dev env"
            }
        }
        stage('Dev to Test') {
            steps {
                echo "deploying to testing"
            }
        }
        stage('Test to Stage') {
            when {
                branch 'release*'
            }
            steps {
                echo "deploying to staging"
            }
        }
        stage('Deploy to Prod') {
            when {
                // vx.x.x v1.1.1 v1.2.3 v1.0
                //when { tag pattern: "release-\\d+", comparator: "REGEXP"}
                tag pattern: "v\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}", comparator: "REGEXP"
            }
            steps {
                echo "deploying to production"
            }
        }
    }
}