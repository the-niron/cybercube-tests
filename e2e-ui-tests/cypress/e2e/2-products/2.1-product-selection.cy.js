/// <reference types="cypress" />

import { SigninPage } from '../../support/pages/signin-page'
import { Products } from '../../support/pages/products-page'
import { USERNAME, PASSWORD } from '../../support/constants'


describe('Test Product selection functionality', () => {

  beforeEach(() => {
    Products.navigateToSwagLabs()
    SigninPage.signIn(Cypress.env(USERNAME), Cypress.env(PASSWORD))
  })

  it('Select a product from the product list', () => {
    Products.addProductToCart(1)
    Products.validateNoOfItemsInCart(1)
  })

  // Failing cause of a bug
  it('Select the same product again', () => {
    Products.addProductToCart(1)
    Products.addProductToCart(1)
    Products.validateNoOfItemsInCart(2)
  })

  it('Select multiple different products', () => {
    Products.addProductToCart(1)
    Products.addProductToCart(2)
    Products.validateNoOfItemsInCart(2)
  })

  it('Select all products', () => {
    Products.selectAllProducts()
    Products.validateNoOfAllAddedItems()
  })

  it('Select a product and then remove it from cart', () => {
    Products.addProductToCart(1)
    Products.validateNoOfItemsInCart(1)
    Products.clickRemoveButton(1)
    Products.validateNoItemsInCart()
  })
})

