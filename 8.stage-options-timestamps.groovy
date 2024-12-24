//timestamps at stage levl
pipeline{
    agent any 
    stages {
        stage('First stage') {
            options {
                timestamps()
            }
            steps {
                echo "first stage done"
            }
        }
        stage('second stage') {
            steps {
                echo "second stage done"
            }
        }
    }
}

//timestamps at pipeline level
pipeline{
    agent any 
    options {
        timestamps()
    }
    stages {
        stage('First stage') {
            steps {
                echo "first stage done"
            }
        }
        stage('second stage') {
            steps {
                echo "second stage done"
            }
        }
    }
}