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
        git branch: 'main', url: 'git@github.com:sahuShashank12/challengingDom.git'
      }
    }

    stage ('Test') {
      steps {
        // Run Test
        sh 'mvn clean test'
      }
      post {
        always {
          // publish html
          publishHTML target: [
              allowMissing: false,
              alwaysLinkToLastBuild: false,
              keepAll: true,
              reportDir: 'test-output/SparkReport',
              reportFiles: 'Spark.html',
              reportName: 'Test Run Report'
            ]
        }
      }
    }
  }
}
