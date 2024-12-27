//https://www.jenkins.io/doc/book/pipeline/syntax/#post

pipeline {
    agent any 
    stages {
        stage('Build') {
            steps {
                //echo "building the app"
                error "creating a failed scenario"
            }
        }
        
    }
    post {
            //it runs irrespective of failure or success -- means everytime regardless of the status
            always {
                //block
                echo "post ----> always got triggered"
            }
            //it runs only when the current pipeline or stage has a success status
            success {
                //block
                echo "post ---> success is triggered "
            }
            //it runs only when the current pipeline/ stage is having failure status
            failure {
                //block 
                echo "post -----> failure is triggered"
            }

    }

}