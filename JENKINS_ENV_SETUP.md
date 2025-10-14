# Jenkins Environment Variables Setup

The "Run Application" stage requires the following environment variables:

- `SPRING_DATASOURCE_PASSWORD` - Database password (e.g., "Password")
- `SERVER_PORT` - Server port (e.g., "9003")

## Method 1: Using Jenkins Job Configuration (UI)

1. Go to your Jenkins job configuration page
2. Scroll down to the **"Build Environment"** section
3. Check **"Inject environment variables to the build process"**
4. In the "Properties Content" field, add:
   ```
   SPRING_DATASOURCE_PASSWORD=Password
   SERVER_PORT=9003
   ```

**OR** for secure password storage:

1. Go to **Jenkins Dashboard** → **Manage Jenkins** → **Manage Credentials**
2. Add a new **Secret text** credential with ID `spring-datasource-password` and value `Password`
3. In your job configuration, under **"Build Environment"**, check **"Use secret text(s) or file(s)"**
4. Add binding:
   - **Variable**: `SPRING_DATASOURCE_PASSWORD`
   - **Credentials**: Select the credential you created
5. For `SERVER_PORT`, use **"Inject environment variables"** and add:
   ```
   SERVER_PORT=9003
   ```

## Method 2: Using Pipeline Environment Block (Recommended)

Add an `environment` block at the pipeline level in your `Jenkinsfile` (after `agent any` and before `stages`):

```groovy
pipeline {
    agent any

    environment {
        SPRING_DATASOURCE_PASSWORD = credentials('spring-datasource-password-id')
        SERVER_PORT = '9003'
    }

    stages {
        // ... your stages
    }
}
```

**To set up the credential:**
1. Go to **Jenkins Dashboard** → **Manage Jenkins** → **Manage Credentials**
2. Add a new **Secret text** credential
3. Set the **ID** to `spring-datasource-password-id` (or match the ID in your pipeline)
4. Set the **Secret** to your password (e.g., `Password`)

## Method 3: Using withCredentials Step (For Secrets)

If you prefer to keep secrets only in specific stages, use `withCredentials`:

```groovy
stage('Run Application') {
    steps {
        withCredentials([string(credentialsId: 'spring-datasource-password-id', variable: 'SPRING_DATASOURCE_PASSWORD')]) {
            script {
                sh '''
                    java -jar build/libs/habits.api-0.0.1-SNAPSHOT.jar \
                        --spring.datasource.password=${SPRING_DATASOURCE_PASSWORD} \
                        --server.port=${SERVER_PORT}
                '''
            }
        }
    }
}
```

And set `SERVER_PORT` as a regular environment variable or in the pipeline environment block.

## Verification

After setting up the environment variables, the application will be invoked as:
```bash
java -jar habits.api-0.0.1-SNAPSHOT.jar --spring.datasource.password=Password --server.port=9003
```

