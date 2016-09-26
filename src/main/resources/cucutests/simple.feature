Feature: my first test

  @x
  Scenario: first
    Given there is a valid gmail user
    And user login to the gmail page
#    When user create new email
#    And type send to address
#    And type subgect message
#    And type message body
#    And click submit button
#    Then new message box was closed


  @x2
  Scenario: db
    Given create new 'username' user
    And create new 'pupkin' user
    Then new user 'username' was created


