//multibranch pipeline
pipeline{
    agent any 
    stages {
        stage('First stage') {
            steps {
                echo "first stage done"
            }
        }
        stage('Second stage') {
            steps {
                echo "second stage done"
            }
        }
        stage('Third stage') {
            steps {
                echo "third stage done"
            }
        }
        stage('Fourth stage') {
            steps {
                echo "fourth stage done"
            }
        }
    }
}