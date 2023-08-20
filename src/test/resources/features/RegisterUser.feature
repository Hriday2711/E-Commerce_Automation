@RegisterUser

Feature: Register A User on Automation Exercise Website

  #Below scenario will allow the user to register on Automation exercise website
  Scenario: Register a User - Enter Details on Create an Account page - Verify if the Account is created - Delete the account
    Given Home Page - Launch App and Verify Home screen
      And Home Page - Verify if the user is on Home Page
      And Home Page - Click on SignUp/Login Button
     When Login Page - Verify User is on Sign Up and Login section
      And Login Page - Enter the details on the Sign Up section
      And Login Page - Click on Sign Up button
     Then Sign Up - Verify the Content of Sign Up Page
      And Sign Up - Enter the Account details
      And Sign Up - Enter the Address Details
      And Sign Up - Click on Create Account Button