//credentials under env 
pipeline{
    agent any
    stages{
        stage('Build'){
           environment{
            //This directive supports a special helper method credentials()
            GITHUB_CREDS = credentials('siva_creds')//contains username and passwd
           } 
           steps {
           echo "my github credentials are ${GITHUB_CREDS} "
           echo "my username is: ${GITHUB_CREDS_USR}"
           echo "my password is ${GITHUB_CREDS_PSW}"
           }
        }  
    }
}
