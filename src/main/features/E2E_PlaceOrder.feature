Feature:  E2E_Placing Order_Transaction

  @E2E
  Scenario Outline: E2E_Place Order_Transaction: <firstname> <lastname> | <products_to_add>
    Given User is on the login page
    And User logins into the application using "<email>" and "<password>"
    And User lands on the Dashboard page to view items
    And User selects the products "<products_to_add>" and adds them into cart
    And User opens the cart to verify "<products_to_add>" items on Cart page
    And User navigates to the Checkout information details page to enter "<firstname>","<lastname>"
    And User navigates to the Checkout Review Page
    And User verifies the order details on Checkout Review Page
    When User clicks on the Finish button on Review page
    Then User is navigated to the Order Confirmation Page
    And User clicks on the Continue Shopping button to land back on the Dashboard page
    And User clicks Logout button to logout of the website

    Examples:
      | email                 | password    | firstname | lastname | products_to_add                                        |
      | test@qabrains.com     | Password123 | John      | Doe      | Sample Shirt Name                                      |
      | practice@qabrains.com | Password123 | Carl      | Warren   | Sample Shirt Name,Sample Shoe Name,Sample Trouser Name |
      | student@qabrains.com  | Password123 | Mike      | Ross     | Sample Shoe Name,Sample Trouser Name                  |
