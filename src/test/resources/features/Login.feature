Feature: Test Login Page

  Scenario: Test1 Login to the system
	Given I navigate to the ellos website
	And I click Logon link
	When I fill in Email field "test@123test.com"
	And I fill in Pass field "123test"
	And Click on "LoginButton"
	Then I check that Email was filling incorrect

