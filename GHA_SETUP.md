# GitHub Actions Setup Guide

This project has been migrated from Jenkins to GitHub Actions. The Jenkinsfile has been replaced by a GitHub Actions workflow located at [build-deploy.yml](file:///.github/workflows/build-deploy.yml).

## Prerequisites for Deployment

The workflow is configured to run on a **self-hosted runner**. This is because the deployment steps require direct access to the target server to:
1.  Stop/Start the `habits` systemd service.
2.  Copy the built JAR to `/opt/PT.Habits`.

### 1. Setup Self-Hosted Runner

You need to install and configure a GitHub Actions self-hosted runner on your deployment server.
Follow the instructions on GitHub: `Settings -> Actions -> Runners -> New self-hosted runner`.

### 2. Sudo Permissions for Runner User

The runner user (e.g., `actions-runner`) needs sudo permissions to restart the service and copy files, without prompting for a password.

You can configure this by adding a file to `/etc/sudoers.d/` (e.g., `/etc/sudoers.d/gha-runner`):

```text
# Allow gha-runner user to restart habits service and copy jar
gha-runner ALL=(ALL) NOPASSWD: /usr/bin/systemctl stop habits, /usr/bin/systemctl start habits, /usr/bin/mkdir -p /opt/PT.Habits, /usr/bin/cp * /opt/PT.Habits/
```
*Note: Adjust the username (`gha-runner`) and paths if they differ on your server.*

### 3. Environment Variables

The application service (`habits.service`) configuration points to `/etc/default/habits` for environment variables. Ensure this file exists on the server and contains:
- `SPRING_DATASOURCE_PASSWORD`
- `SERVER_PORT`

See [habits.env.example](file:///deploy/habits.env.example) for reference.
