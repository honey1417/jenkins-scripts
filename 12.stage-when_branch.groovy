//based on the branch condition , i can create the pipeline

pipeline {
    agent any
    environment {
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
                expression 
                {
                    BRANCH_NAME ==~ /(qrrelease|hotfix)/
                }
            }
            steps {
                echo "deploying to prod"
            }
        }
    }
}
