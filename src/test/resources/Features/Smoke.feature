Feature: Smoke
  It is for studying main features in cucumber

  @SmokeTest
  Scenario: Open Main Page
    Given I am on main page
    And Validate rozetka logo

  Scenario: Login User
    Given I am on main page
    And Validate rozetka logo
    When I open login menu
    And I type "login!" and "password!"
    When I click login button

  Scenario: Login User with DataTable
    Given I am on main page
    When I open login menu
    And I type the following for login
      | UserName | | Password |
      | Roma     | | pass     |
    When I click login button

  Scenario: Login User with DataTable and mapping class
    Given I am on main page
    When I open login menu
  #Be careful with vertical slash, to count them!!!!!!
    When I type the following
      | name |  password |
      | roma |  pass     |
    When I click login button


  Scenario Outline: Login User with DataTable with Scenario outline
    Given I am on main page
    When I open login menu
    And I enter <userName> and <password> on login page
    When I click login button

    Examples:
      | userName   | password   |
      | firstUser  | firstPass  |
      | secondUser | secondPass |
      | thirdUser  | thirdPass  |

  Scenario: Search standard item
    Given I am on main page
    When I open login menu
    When I input Email:sv1