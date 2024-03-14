/// <reference types="cypress" />

import { SAUCEDEMO_URL } from '../constants'

const homePageTitle = 'Swag Labs'
const productComponent = '.inventory_item'
const btnAddToCart = '.btn_inventory'
const btnCart = '.shopping_cart_badge'
const cartLink = '.shopping_cart_link'
const itemName = '.inventory_item_name'

export class Products {

  static navigateToSwagLabs() {
    // credentials and url is defined as an environment variable in cypress.config.js
    cy.visit(Cypress.env(SAUCEDEMO_URL))
    cy.title().should('eq', homePageTitle)
    return this
  }

  static verifySwagLabHome() {
    cy.get('[class="app_logo"]').contains('Swag Labs').should('be.visible')
    cy.url().should('include', '/inventory.html')
    cy.log('Successfully Signed in!')
  }

  static addProductToCart(index) {
    cy.get(productComponent).eq(index - 1).contains('Add to cart').click()
  }

  static validateNoOfItemsInCart(items) {
    cy.get(btnCart).should('contain', items)
  }

  static selectAllProducts() {
    cy.get(productComponent).each(($el) => {
      cy.wrap($el).find(btnAddToCart).click()
    })
  }

  static validateNoOfAllAddedItems() {
    cy.get(btnCart).then(($badge) => {
      cy.get(productComponent).should('have.length', $badge.text())
    })
  }

  static clickRemoveButton(index) {
    cy.get(productComponent).eq(index - 1).contains('Remove').click()
  }

  static validateNoItemsInCart() {
    cy.get(btnCart).should('not.exist')
  }

  static navigateToCart() {
    cy.get(cartLink).click();
  }

  static addProductToCartByName(name) {
    cy.get(itemName).contains(name).parentsUntil('.inventory_item').contains('Add to cart').click()
  }

}
