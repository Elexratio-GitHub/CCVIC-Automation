Feature: User Login
 
    Background:
    Given Launch the url in Chrome
    Then Enter the credentials and click the signin button
    When Click the Respond Application tab
   
 @CrimeSubpoenaedNotFound
  Scenario:  Subpoenaed Material NOT Found
   Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given  select the Subpoenaed Material not found checkbox
    And  upload a supporting letter
    Then  click the checkbox of My submission is urgent due to an order made by the Court
    Then provide review response and click submit
    
     @CivilSubpoenaedNotFound
  Scenario:  Subpoenaed Material Not Found
   Then Enter the case number and click the search button and click the select button
    And Upload your identity and click the declaration check box and next button
    Given  select the Subpoenaed Material not found checkbox
    And  upload a supporting letter
    Then  click the checkbox of My submission is urgent due to an order made by the Court
    Then provide review response and click submit



