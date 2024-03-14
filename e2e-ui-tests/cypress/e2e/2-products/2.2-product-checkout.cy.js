/// <reference types="cypress" />

import { SigninPage } from '../../support/pages/signin-page'
import { Products } from '../../support/pages/products-page'
import { USERNAME, PASSWORD } from '../../support/constants'
import { Cart } from '../../support/pages/cart-page'

const PRODUCTS = require('../../fixtures/products')

describe('Test Product selection functionality', () => {

  beforeEach(() => {
    Products.navigateToSwagLabs()
    SigninPage.signIn(Cypress.env(USERNAME), Cypress.env(PASSWORD))
  })

  it('Checkout with a Single Product', () => {
    Products.addProductToCart(1);
    Products.navigateToCart();
    Cart.clickCheckout();
    Cart.fillYourInfo('John', 'Steward', '12530');
    Cart.clickContinue();
    Cart.clickFinish();
    Cart.validateOrderIsSuccessful()
  });

  PRODUCTS.forEach((product) => {
    it('Verify information in the cart for different products', () => {
      // Add product to cart
      Products.addProductToCartByName(product.name);
      Products.navigateToCart();
      Cart.verifyPriceInCart(product.price)
      Cart.clickCheckout();
      Cart.fillYourInfo('John', 'Steward', '12530');
      Cart.clickContinue();
      Cart.verifyTotalPrice(product.price)
    });
  });

  it('Checkout with Multiple Products', () => {
    Products.selectAllProducts()
    Products.navigateToCart();
    Cart.clickCheckout();
    Cart.fillYourInfo('John', 'Steward', '12530');
    Cart.clickContinue();
    Cart.clickFinish();
    Cart.validateOrderIsSuccessful()
  });

  // Fails due to an actual bug
  it('Checkout with Empty Cart', () => {
    Products.navigateToCart();
    Cart.verifyCheckoutIsDisabled();
  });

  it('Checkout with Invalid Information', () => {
    Products.addProductToCart(1);
    Products.navigateToCart();
    Cart.clickCheckout();
    Cart.fillYourInfo('John', 'Steward', '{backspace}');
    Cart.clickContinue();
    cy.get('.error-message-container').should('be.visible');
  });
});

