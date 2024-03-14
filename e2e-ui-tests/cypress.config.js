module.exports = {
  reporter: 'cypress-mochawesome-reporter',
  chromeWebSecurity: false,
  defaultCommandTimeout: 5000,
  e2e: {
    setupNodeEvents(on, config) {
      require('cypress-mochawesome-reporter/plugin')(on)
    },
    video: false,
    env: {
      userName: 'standard_user',
      password: 'secret_sauce',
      swagLabs_url: 'https://www.saucedemo.com/',
    }
  }
}

