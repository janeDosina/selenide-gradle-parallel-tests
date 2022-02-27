pipeline{
	agent any
	tools {gradle 'Gradle'}
	stages{
		stage("Git checkout"){
			steps{
				git credentialsId: 'git_credentials',
                    branch: 'master',
                    url: 'https://github.com/janeDosina/selenide-gradle-parallel-tests.git'
			}
		}
		stage("Start Selenoid"){
			steps{
				sh "docker-compose up -d --no-color"
				sh "healthcheck.sh"
			}
		}
		stage("Run tests"){
			steps{
				sh "gradle clean test"
			}
		}
		stage("Stop Selenoid"){
			steps{
				sh "docker-compose down"
			}
		}
	}
	post {
        always { 
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                    ])
            }
        }
    }
}