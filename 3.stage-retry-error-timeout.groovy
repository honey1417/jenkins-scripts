//retry error
pipeline{
    agent any 
    stages {
        stage('Build') {
            steps{
                retry(3)
                {
                    echo "welcome to jenkins pipeline"
                    error "test this for retry block"
                }
            echo "after 3 retrys"
            }
        }
    }
}

//timeout
pipeline{
    agent any 
    stages {
        stage('Build') {
            steps {
                timeout (time: 5, unit: 'SECONDS') //Values: NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS
                echo "sleeping for 30 seconds"
                sleep 30
            }
        }
    }
}

//retry and timeout 
pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                // Retry block with 3 attempts
                retry(3) 
                {
                    // Timeout block inside retry
                    timeout(time: 5, unit: 'SECONDS')
                    {
                        echo "Sleeping for 10 seconds"
                        sleep 10
                        // Simulating an error for testing retry functionality
                        error "Testing the Retry block"
                    }
                }
                echo "Completed after retries"
            }
        }
    }
}