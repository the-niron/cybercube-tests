/* eslint-disable no-undef */
/// <reference types="cypress" />

import { Products } from '../../support/pages/products-page'
import { SigninPage } from '../../support/pages/signin-page'

const VALID_USERS = require('../../fixtures/valid_users')

describe('Test the basic login with different users', () => {
  beforeEach(() => {
    Products.navigateToSwagLabs()
  })

  //This is a data-driven test. You can add various valid user credentials to /fixtures/valid_users.json
  VALID_USERS.forEach((user) =>
    it('Verify user is able to signIn successfully with valid users', () => {
      SigninPage.signIn(user.user_name, user.password)
    })
  )

  //Should add more tests to verify different user behaviour
  it('Verify locked_out_user error')

})
