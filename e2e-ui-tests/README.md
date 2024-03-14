# swagLabs-Automated-UI-Tests

##  Description

The UI E2E test automation framework is developed with Cypress. Scope of the current automated UI tests cover the following functionalities,
1. User sign-in
2. Product selection
3. Product checkout


## Run E2E UI tests in Local

Prerequisites : Node.js 12 or 14 and above

1. Clone repository to your local

2. Navigate to cybercube-tests/e2e-ui-tests in terminal

3. Run "npm install"


#### Run tests in headless mode with Chrome

npx cypress run --browser chrome

  
In the above command you can also change the browser you want to run the tests in with headless mode.

Ex:

* --browser firefox

* --browser edge

* --browser chromium


##### Reports :

After tests are executed, report can be found in "reports/html/index.html"


#### Run with cypress UI

npx cypress open

  
#### html report :

<img width="1650" alt="image" src="![Screenshot 2024-03-13 at 18 25 47](https://github.com/TheNiron/backbase-tests/assets/32265029/7730bb1d-d4ba-47db-b4a8-243f5c0c87d9)">


## Run E2E UI tests in CI/CD pipeline

Github actions workflow is configured to trigger once a change is pushed in to 'main' branch.

You can find the workflow setup file here :
 https://github.com/TheNiron/cybercube-tests/blob/main/.github/workflows/ui-test-workflow.yml

Workflow excution of UI tests: 
<img width="1692" alt="image" src="https://user-images.githubusercontent.com/32265029/191075269-84a4c752-17dd-4311-ad0d-293f67c8ac04.png">
