Feature: Login
        As a user I should able to login into my app and add to cart the products
 @test
 Scenario: I login with valid credential and add to cart
 				Given Login to saucedemo app
        And I check all valid and invalid username and password
        And verify Able to  select the product and add to cart
        When I click on element having class "radius"
        Then I should get logged out