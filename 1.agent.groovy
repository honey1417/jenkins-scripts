//any: execute the pipeline or stage on any available agent
//label: this is a  string, which informs jenkins to run this pipeline on 
//a particular agent 

//any 
pipeline{
    agent any
    stages {
        stage('FirstStage') {
            steps {
                echo "hello world!!!"
            }
        }
    }
}

//label at pipeline level
pipeline{
    agent {
        label 'java-slave'
    }
    stages {
        stage('FirstStage') {
            steps {
                echo "hello world!!!"
            }
        }
    }
}

//label at stage level
pipeline{
    agent none
    stages {
        stage('FirstStage') {
            agent {
                label 'java-slave'
            }
            steps {
                echo "hello world!!!"
                sh "hostname -i"
            }
        }
    }
}

//node agent
pipeline{
    agent none
    stages {
        stage('FirstStage') {
            agent {
                node {
                    label 'java-slave'
                    customWorkspace  "/home/siva/customwork"
                }
            }
            steps {
                echo "hello world!!!"
                sh 'cat siva.txt'
            }
        }
    }
}