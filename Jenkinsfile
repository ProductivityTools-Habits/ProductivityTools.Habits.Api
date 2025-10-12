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
            // Użycie bloku zEnv do trwałego ustawienia JAVA_HOME dla tego etapu
            // UWAGA: Używamy ścieżki do Javy, którą chcemy użyć (np. Javy 24/25)
            // ZMIEŃ /usr/lib/jvm/jdk-25-oracle-x64 NA PRAWIDŁOWĄ ŚCIEŻKĘ DO JAVY 24, JEŚLI JEST INNA.
            // Jeśli nie masz Javy 24, możesz spróbować Javy 21 lub 25, ale Gradle może dalej odrzucać.
            withEnv(["JAVA_HOME=/usr/lib/jvm/jdk-25-oracle-x64"]) {
                steps {
                    script {
                        echo "build rozpoczęty."
                        
                        // Weryfikacja Javy wewnątrz tego bloku (powinna pokazać Javę 25)
                        sh 'echo "JAVA_HOME wewnątrz etapu: $JAVA_HOME"'
                        sh '$JAVA_HOME/bin/java -version'
                        
                        sh 'chmod +x gradlew'
                        
                        // Zatrzymanie demona, aby na pewno użył Javy 25
                        sh './gradlew --stop'
                        
                        echo "Rozpoczynanie kompilacji za pomocą Gradle i wymuszonej Javy 25/24..."
                        
                        // Główna komenda budowania
                        sh './gradlew clean build --rerun-tasks'
                    }
                }
            }
        }

        // stage('build') {
        //     steps {
        //         script {
        //             echo "build"
        //             sh 'java -version'
        //             sh 'echo $JAVA_HOME'
        //             sh 'chmod +x gradlew'
        //             sh './gradlew --stop'
        //             sh './gradlew --version'
        //             sh './gradlew --stop'
        //             sh 'export JAVA_HOME="/usr/lib/jvm/jdk-25-oracle-x64"; ./gradlew clean build --rerun-tasks'
        //         }
        //     }
        // }
    }
}
