/// <reference types="cypress" />

const btnCheckout = '.checkout_button'
const firstNameField = '[data-test=firstName]'
const lastNameField = '[data-test=lastName]'
const postalCodeField = '[data-test=postalCode]'
const btnContinue = '[data-test="continue"]'
const btnFinish = '[data-test="finish"]'
const headearBanner = '.complete-header'
const labelItemPrice = '.inventory_item_price'
const labelTotalPrice = '.summary_subtotal_label'

export class Cart {

  static clickCheckout() {
    cy.get(btnCheckout).click();
  }

  static fillYourInfo(fname, lname, postal) {
    cy.get(firstNameField).type(fname);
    cy.get(lastNameField).type(lname);
    cy.get(postalCodeField).type(postal);
  }

  static clickContinue() {
    cy.get(btnContinue).click();
  }

  static clickFinish() {
    cy.get(btnFinish).click();
  }

  static validateOrderIsSuccessful() {
    cy.get(headearBanner).should('have.text', 'Thank you for your order!')
  }

  static verifyCheckoutIsDisabled() {
    cy.get(btnCheckout).should('be.disabled')
  }

  static verifyPriceInCart(price) {
    cy.get(labelItemPrice).contains(price)
  }

  static verifyTotalPrice(price) {
    cy.get(labelTotalPrice).contains(price)
  }


}
