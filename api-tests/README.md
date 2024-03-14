
# Swagger-pet-store-Automated-API-Tests

## Description

The API test automation framework is developed with TestNG and Rest-assured. Scope of the current automated API tests cover the following functionalities,

1. Pets
2. Store
3. User

## Run API tests in Local


Prerequisites : Java, Maven

1. Clone repository to your local

2. Navigate to cybercube-tests/api-tests in terminal

3. Run "mvn clean test"

  

##### Reports :

After tests are executed, surefire-reports can be found in "target/surefire-reports/emailable-report.html"

You can also generate Allure reports by executing following command:

    allure serve 
    
#### Allure report :

<img width="1707" alt="image" src="https://github.com/TheNiron/backbase-tests/assets/32265029/94bd827c-ca1b-4c80-9cfe-cca48576b6f6">

<img width="1707" alt="image" src="https://github.com/TheNiron/backbase-tests/assets/32265029/36a8c28a-214e-4fb5-af84-8de379a4939d">


## Run API tests in CI/CD pipeline

Github actions workflow is configured to trigger once a change is pushed in to 'main' branch.
  
You can find the workflow setup file here :

https://github.com/the-niron/cybercube-tests/blob/main/.github/workflows/api-test-workflow.yml

Workflow excution of API tests:


