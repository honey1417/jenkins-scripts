//script block will be under steps block
//allows us to write custom code in groovy 
//will be very helpful when creating complex environments

//if condition
pipeline{
    agent any
    stages {
        stage('First stage') {
            steps {
                echo "hello world!!!"
            }
        }
        stage('Build'){
            steps {
                script {
                    def course = "k8s"
                    if (course == "k8s")
                    println("thanks for enrolling into k8s")
                    else 
                    println("do enroll into k8s")
                }
            }
        }
    }
}

//else condition
pipeline{
    agent any
    stages {
        stage('First stage') {
            steps {
                echo "hello world!!!"
            }
        }
        stage('Build'){
            steps {
                script {
                    def course = "docker"
                    if (course == "k8s")
                    println("thanks for enrolling into k8s")
                    else 
                    println("do enroll into k8s")
                }
            }
        }
    }
}

//variable definition
pipeline{
    agent any
    stages {
        stage('First stage') {
            steps {
                echo "hello world!!!"
            }
        }
        stage('Build'){
            steps {
                script {
                    def course = "k8s"
                    if (course == "k8s")
                    println("thanks for enrolling into ${course}")
                    else 
                    println("do enroll into ${course}")
                }
            }
        }
    }
}

