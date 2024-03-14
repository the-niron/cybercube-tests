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
      base64_encode_credentials: 'Y2FuZGlkYXRleDpxYS1pcy1jb29s',
      swagLabs_url: 'https://www.saucedemo.com/',
    }
  }
}

