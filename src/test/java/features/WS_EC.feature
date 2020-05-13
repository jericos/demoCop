Feature: Services test request

  This feature is responsible for testing all the scenarios for car thin flow

  @WSTest
  Scenario: Validate POST services options
    Then I validate POST services
      | channel | status expected |
      |         | 200             |