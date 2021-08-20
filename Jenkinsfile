pipeline {
  agent any
  tools {
    // Install the Maven version configured as "M3" and add it to the path.
    maven "MAVEN_HOME"
  }
  stages {
    stage ('Checkout') {
      steps {
        // Get some code from a GitHub repository
        git branch: 'main', url: 'https://github.com/sahuShashank12/CucumberHybridFramework.git'
      }
    }

    stage ('Test') {
      steps {
        // Run Test
        sh 'mvn verify'
      }
      post {
        always {
          // publish html
          publishHTML target: [
              allowMissing: false,
              alwaysLinkToLastBuild: false,
              keepAll: true,
              reportDir: 'coverage',
              reportFiles: 'index.html',
              reportName: 'RCov Report'
            ]
        }
        success {
        	junit '**/target/surefire-reports/TEST-*.xml'
        	archiveArtifacts 'target/*.jar'
        }
      }
    }
  }
}