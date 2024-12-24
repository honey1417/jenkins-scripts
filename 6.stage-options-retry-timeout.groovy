//retry under options at stage level
pipeline{
    agent any 
    stages {
        stage('Build'){
            options {
                retry(2)
            }
            steps 
            {
            echo "Before setting current build to failure"
                script 
                {
                    currentBuild.result = 'FAILURE'
                }
            echo "After setting current build to failure"
            }
        }
    }
}


//timeout under options at pipeline level
pipeline {
    agent any
    options {
        timeout(time: 10, unit: 'SECONDS') // Timeout set for 10 minutes
    }
    stages {
        stage('Build') {
            steps {
                echo "sleeping for 8 seconds"
                sleep 8
            }
        }
        stage('Test') {
            steps {
                echo "sleeping for 30 seconds"
                sleep 30
            }
        }
    }
}

//timeout under options at stage level
pipeline {
    agent any
    stages {
            stage('Test') 
           {
            steps {
                echo "sleeping for 30 seconds"
                sleep 30
               }
           }
            stage('Build')
            {
                options 
               {
                timeout(time: 10, unit: 'SECONDS')
               } 
            steps {
                echo "sleeping for 8 seconds"
                sleep 8
        
               }
        
            }
    }
}
