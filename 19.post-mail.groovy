//send a mail based on the status of the job

pipeline {
    agent any 
    stages {
        stage ('Build') {
            steps {
                echo "testing the mail job"
            }
        }
    }
    post {
        always {
            script {
                //mail bcc: '', body: 'build is success', cc: '', from: '', replyTo: '', subject: 'jenkins job status ', to: 'honeyi27k8s@gmail.com'
                def subject = "Job status is: ${currentBuild.currentResult}"
                def body = "Build number is: ${currentBuild.number}\n" + "Status is: ${currentBuild.currentResult}\n" + "Job URL is: ${env.JOB_URL}"
                mail (
                    to: 'honey127k8s@gmail.com',
                    subject: subject,
                    body: body
                )       
            }
        }
    }
}