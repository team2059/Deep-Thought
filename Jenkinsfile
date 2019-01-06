def notifySlack(String buildStatus = 'STARTED') {
    // Build status of null means success.
    buildStatus = buildStatus ?: 'SUCCESS'

    def color

    if (buildStatus == 'STARTED') {
        color = '#D4DADF'
    } else if (buildStatus == 'SUCCESS') {
        color = '#BDFFC3'
    } else if (buildStatus == 'UNSTABLE') {
        color = '#FFFE89'
    } else {
        color = '#FF9FA1'
    }

    def msg = "${buildStatus}: `${env.JOB_NAME}` #${env.BUILD_NUMBER}:\n${env.BUILD_URL}"

    slackSend baseUrl: 'https://team2059.slack.com/services/hooks/jenkins-ci/', botUser: true, channel: '#builds', color: color, message: msg, teamDomain: 'team2059', tokenCredentialId: 'team2059slack'
}

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './gradlew jar'
            }
        }
    }
    post {
        success {
            notifySlack('SUCCESS')
        }
        failure {
            notifySlack('FAILURE')
        }
        unstable {
            notifySlack('UNSTABLE')
        }
        aborted {
            notifySlack('ABORTED')
        }
    }
}
