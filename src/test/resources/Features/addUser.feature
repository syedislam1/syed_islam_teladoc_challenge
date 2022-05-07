Feature: Add and delete User

@add
  Scenario Outline: Add User to the table
   Given user is on the desired page
    When user clicks on add user
    Then add  first name "<fname>"
    Then add  last name "<lname>"
    Then add  user name "<usrname>"
    Then add  password "<password>"
    Then click on company 
    Then User Select Role
    Then User enter email "<email>"
    Then User enter phone number "<phone>"
    Then User Clicks on Save
    And Verify if username "<usrname>" is present
   
  
  Examples:
  | fname | lname | usrname | password| email| phone |
  | tela | doc | teladoc | 123456 | tela.test@tela.cz | 1324589765|

@delete
  
  Scenario Outline: Add User to the table
  Given user is on the desired page
  Then User look for "<username>" and delete
  
  Examples:
  |username|
  |novak|
  
  
  
   