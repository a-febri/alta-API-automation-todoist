Feature: Update project
  Scenario: Post update project with all valid value
    Given Post update project
    And Set authorization bearer token
    When Send request post update project
    Then Should return 204 no content

  Scenario: Post update project without authorization
    Given Post update project empty authorization
    When Send request post update project
    Then Should return 401 Unauthorized
    And Return body contain "Forbidden"

  Scenario Outline: Post update project invalid id
    Given Post update project invalid id <id>
    And Set authorization bearer token
    When Send request post update project
    Then Should return 404 not found
    And Return body contain "Project not found"
    Examples:
    |path|
    |2203306141|
    |6727788   |

  Scenario: Post update project empty body request
    Given Post update project empty body request
    And Set authorization bearer token
    When Send request post update project
    Then Should return 404 bad request
    And Return body contain message "At least one of name, color or favorite fields should be set"

  Scenario: Post update project only input body name
    Given Post update project only input body name
    And Set authorization bearer token
    When Send request post update project
    Then Should return 204 no content

  Scenario: Post update project only input body color
    Given Post update project only input body color
    And Set authorization bearer token
    When Send request post update project
    Then Should return 204 no content

  Scenario: Post update project only input body favorite
    Given Post update project only input body favorite
    And Set authorization bearer token
    When Send request post update project
    Then Should return 204 no content

  Scenario: Post update project without input name
    Given Post update project without input name
    And Set authorization bearer token
    When Send request post update project
    Then Should return 204 no content

  Scenario: Post update project without input color
    Given Post update project without input color
    And Set authorization bearer token
    When Send request post update project
    Then Should return 204 no content

  Scenario: Post update project without input favorite
    Given Post update project without input favorite
    And Set authorization bearer token
    When Send request post update project
    Then Should return 204 no content
