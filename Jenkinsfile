pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'build stage'
        bat ' mvnw -DskipTests clean install'
        echo 'fin de Build'
      }
    }

    stage('test') {
      parallel {
        stage('test intégration') {
          steps {
            echo 'test d\'intégration'
            bat 'mvnw -Dtest=com.example.testingweb.integration.** test'
            echo 'fin test integration '
          }
        }

        stage('test fonctionnel') {
          steps {
            echo 'test fonctionnel'
            bat 'mvnw -Dtest=com.example.testingweb.functional.** test'
            echo 'fin test fonctionnel'
          }
        }

        stage('smoke test') {
          steps {
            echo 'smoke test'
            bat 'mvnw -Dtest=com.example.testingweb.smoke.** test'
            echo 'fin test smoke'
          }
        }

      }
    }

    stage('deploy') {
      steps {
        echo 'stage deploy'
        input 'Voulez vous continuer ?'
        bat 'javaw -jar target/testing-web-complete.jar'
        echo 'deploiement reussi'
        emailext(subject: '${env.BUILD_ID} - ${currentBuild.result}', body: '${env.BUILD_ID} - ${env.JENKINS_URL}', to: 'klor97250@gmail.com')
      }
    }

  }
  tools {
    maven 'maven 3.9'
    jdk 'java 11'
  }
}