Feature: Login

  Scenario: login success
    Given The user opens the page in the browser
    When The user enters the credentials
      | email             | password  |
      | nramos@qvision.us | 123456789 |
    Then The user can see his name