Feature: My first demo feature

  Scenario: My first demo test
    Given I open test site
    When I fill "Moscow" the form
    Then I see pretty message

  @QA
  Scenario: My second demo test
    Given I open test site
    When I fill "Paris" the form
    Then I see pretty message