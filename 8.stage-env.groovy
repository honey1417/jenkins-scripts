// This environment block can be used at pipeline level and stage level

pipeline {
    agent any
    //can be used across all the stages
    environment {
        name = "honey"
        course = "k8s"
    }
    stages {
        stage ('Build') {
            //specific to this stage only
            environment {
                cloud = "GCP"
            }
            steps {
                echo "Welcome ${name}"
                echo "You enrolled to ${course} Course"
                echo "You are certified in ${cloud}"
            }
        }
    }
}

//to differentiate 
pipeline {
    agent any
    // can be used across all the stages
    environment {
        name = "honey"
        course = "k8s"
    }
    stages {
        stage ('Build') {
            //are specific to this stage only
            environment {
                cloud = "GCP"
            }
            steps {
                echo "Welcome ${name}"
                echo "You enrolled to ${course} Course"
                echo "You are certified in ${cloud}"
            }
        }
        stage ('SecondStage') {
            steps {
                echo "Welcome ${name}" 
                echo "You enrolled to ${course} Course" 
                echo "You are certified in ${cloud}" 
            }
        }
    }
}

// Lets test precedence
pipeline {
    agent any
    environment {
        name = "honey"
        course = "k8s"
    }
    stages {
        stage ('Build') {
            environment {
                cloud = "GCP"
                name = "harshini"
            }
            steps {
                echo "Welcome ${name}"
                echo "You enrolled to ${course} Course"
                echo "You are certified in ${cloud}"
            }
        }
    }
}

// printenv
pipeline {
    agent any
    environment {
        name = "Siva"
        course = "k8s"
    }
    stages {
        stage ('Build') {
            environment {
                cloud = "GCP"
                name = "Maha"
            }
            steps {
                echo "Welcome ${name}"
                echo "You enrolled to ${course} Course"
                echo "You are certified in ${cloud}"
                sh "printenv"
            }
        }
    }
}
