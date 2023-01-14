pipeline {
    agent any

    tools {
       
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build') {
            steps {               
               
                bat "mvn clean test "
            }

            post {
                
                success {
                   
                    echo "Test is completed"
                }
            }
        }
    }
}
