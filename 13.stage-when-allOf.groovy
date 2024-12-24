//allOf condition
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
        stage('ProdDeploy') {
            when {
                allOf {
                    branch 'prod'
                    environment name: 'DEPLOY_TO', value: 'production'
                }
            }
            steps {
                echo "deploying to production"
            }
        }
    }
}
//allOf condition not met
pipeline {
    agent any
    environment {
        //our own custom env variables
        DEPLOY_TO = 'abc'
    }
    stages {
        stage('Deploy to Dev') {
            steps {
                echo "deploying to dev env"
            }
        }
        stage('ProdDeploy') {
            when {
                allOf {
                    //10 conditions present , all 10 should be satisfied
                    branch 'prod'
                    environment name: 'DEPLOY_TO', value: 'production'
                }
            }
            steps {
                echo "deploying to production"
            }
        }
    }
}