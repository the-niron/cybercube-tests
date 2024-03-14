/// <reference types="cypress" />

import { Products } from '../../support/pages/products-page'

export class SigninPage {
  static signIn(username, password) {
    cy.get('[data-test="username"]').type(username)
    cy.get('[data-test="password"]').type(password)
    cy.get('[data-test="login-button"]').click()
    Products.verifySwagLabHome()
  }
}
