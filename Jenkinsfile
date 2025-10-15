pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                // Get some code from a GitHub repository
                echo 'Hello!'
            }
        }

        stage('Identify User') {
            steps {
                script {
                    echo "Sprawdzanie, jako który użytkownik Jenkins wykonuje komendy..."

                    // Komenda whoami
                    echo "Nazwa użytkownika (whoami):"
                    sh 'whoami'

                    // Komenda id (bardziej szczegółowa)
                    echo "Szczegóły użytkownika (id):"
                    sh 'id'

                    echo "Zakończono identyfikację użytkownika."
                }
            }
        }

        stage('deleteWorkspace') {
            steps {
                deleteDir()
            }
        }

         stage('clone') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main',
                url: 'https://github.com/ProductivityTools-Habits/ProductivityTools.Habits.Api.git'
            }
        }
        

        stage('build') {
            steps {
                script {
                    echo "build"
                    sh 'java -version'
                    sh 'echo $JAVA_HOME'
                    sh 'chmod +x gradlew'
                    sh './gradlew --stop'
                    sh './gradlew --version'
                    sh './gradlew --stop'
                    sh 'java -version; ./gradlew clean build --rerun-tasks'
                }
            }
        }

        stage('Copy Jar to /opt/PT.Habits') {
            steps {
                script {
                    echo "Copying JAR to /opt/PT.Habits"
                    sh '''
                        umask 002
                        JAR=build/libs/habits.api-0.0.1-SNAPSHOT.jar
                        if [ ! -f "$JAR" ]; then
                          echo "Jar not found at $JAR"; exit 1
                        fi
                        mkdir -p /opt/PT.Habits
                        cp "$JAR" /opt/PT.Habits/
                    '''
                }
            }
        }

        // Run Application stage requires the following environment variables:
        // SPRING_DATASOURCE_PASSWORD - Database password (e.g., "fsdafafa")
        // SERVER_PORT - Server port (e.g., "9003")
        // 
        // To set these environment variables in Jenkins:
        // 1. Go to your Jenkins job configuration
        // 2. Under "Build Environment" section, check "Use secret text(s) or file(s)"
        // 3. Add bindings:
        //    - Variable: SPRING_DATASOURCE_PASSWORD, Credential: [Select your secret]
        //    - Variable: SERVER_PORT, Credential: [Select your secret] or use "Inject environment variables"
        // 
        // Alternative method (Pipeline-level):
        // Add an 'environment' block at the pipeline level (before 'stages') with:
        // environment {
        //     SPRING_DATASOURCE_PASSWORD = credentials('spring-datasource-password-id')
        //     SERVER_PORT = '9003'
        // }
        // Or use withCredentials step if you prefer to keep secrets in Jenkins credentials store
        // stage('Run Application') {
        //     steps {
        //         script {
        //             echo "Running application on Ubuntu"
        //             sh '''
        //                 java -version
        //                 java -jar build/libs/habits.api-0.0.1-SNAPSHOT.jar --spring.datasource.password=${SPRING_DATASOURCE_PASSWORD} --server.port=${SERVER_PORT}
        //             '''
        //         }
        //     }
        // }
    }
}
