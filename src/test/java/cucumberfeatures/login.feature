Feature: Login feature.

Scenario: Verify valid user login.
Given launch application
When enter username
And enter password
And click on submit btn
Then verify user is logged in successfully

#Scenario: Verify invalid user login.
#Given launch application
#When enter invalid username
#And enter invalid password
#And click on submit btn
#Then verify user not logged in