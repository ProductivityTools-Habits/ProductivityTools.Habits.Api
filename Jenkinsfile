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
                    sh 'export JAVA_HOME="/usr/lib/jvm/java-21-openjdk-amd64/bin/java"; ./gradlew clean build --rerun-tasks'
                }
            }
        }
    }
}
