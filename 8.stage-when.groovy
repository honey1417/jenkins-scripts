//when condition
//environment Execute the stage when the specified environment variable is set to the given value, 
//when { environment name: 'DEPLOY_TO', value: 'production' }.
pipeline{
    agent any
    environment {
        //our own custom env variables
        DEPLOY_TO = 'production'
    }
    stages {
        stage('ProdDeploy') {
            when {
                environment name: 'DEPLOY_TO', value: 'other' 
            }
            steps {
                echo "deploying to production"
            }
        }
    }
}
//when not condition
pipeline{
    agent any
    environment {

        DEPLOY_TO = 'production'
    }
    stages {
        stage('ProdDeploy') {
            when {
                not {
                    equals expected: "prod", actual: "${DEPLOY_TO}"
                }
            }
            steps{
                echo "deploying to production"
            }
        }
    }
}

//equals condition 
// when { equals expected: 2, actual: currentBuild.number }.
pipeline{
    agent any
    environment {

        DEPLOY_TO = 'production'
    }
    stages {
        stage('ProdDeploy') {
            when {
                equals expected: 24, actual: currentBuild.number 
            }
            steps{
                echo "deploying to production"
            }
        }
    }
}

//when not condition
pipeline{
    agent any
    environment {

        DEPLOY_TO = 'production'
    }
    stages {
        stage('ProdDeploy') {
            when {
                not {
                    equals expected: 26, actual: currentBuild.number 
                }
            }
            steps{
                echo "deploying to production"
            }
        }
    }
}
