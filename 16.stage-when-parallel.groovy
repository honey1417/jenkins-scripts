//parallel 
pipeline {
    agent any 
    stages {
        stage('Build Stage')
        {
            steps {
                echo "build stage done"
            }
        }
        stage('Parallel Scans')
        {
            parallel {
                stage('Sonar'){
                    steps {
                        echo "sonar scanning"
                        sleep 10
                    }
                }
                stage('Fortify'){
                    steps {
                        echo "fortify scanning"
                        sleep 10
                    }
                }
                stage('Prisma'){
                    steps {
                        echo "prisma scanning"
                    }
                }   
            }
        }
        stage('Dev Stage')
        {
                steps {
                        echo "dev stage done"
                    }
        }
    }
}