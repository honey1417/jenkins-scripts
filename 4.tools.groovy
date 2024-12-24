//tools at pipeline and stage level
pipeline{
    agent {
        label 'java-slave'
    }
    tools {
        maven 'Maven_3.8.8' //the same name should be configured under tools section
    }
    stages {
        stage('Maven') {
            steps {
                echo "hello welcome to maven section"
                sh 'mvn --version'
                sh 'java --version'
            }
        }
        stage('cartmaven') {
            tools {
                jdk 'JDK_18'
            }
            steps{
                echo "hello welcome to cart mvn section"
                sh 'mvn --version'
                sh 'java --version'
            }
        }
    }
}