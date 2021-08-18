pipeline {
  agent any
  stages {
    stage('scan') {
      steps {
        echo 'Hey there'
      }
    }

    stage('done') {
      steps {
        sh 'echo \'hello\''
      }
    }

  }
  environment {
    test = 'Hello'
  }
}