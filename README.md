# Selenium Webdriver with Cucumber


## Requirements

1. jdk/jre
1. maven version

## Setup

1. create a maven project
1. add the maven dependencies: selenium-java, selenium-chrome-driver, junit, cucumber-java, cucumber-junit, rest-assured
1. create the "features" package in resource
1. create the packages for runners and steps
1. add the configuration for run the runner correctly. It will be like this

    ````java
   @RunWith(Cucumber.class)
      @CucumberOptions(
              tags = "@AllCenarios",
              features = "src/test/resources/features/search.feature",
              glue = {"steps.search"},
              plugin = {"pretty",
                      "html:target/cucumber-pretty.html",
                      "json:target/cucumber.json",
                      "junit:target/JunitCucumber.json"},
              snippets = CAMELCASE,
              monochrome = true
      )   
   ````
   
 1. put the chromedriver.exe (you can find in the Selenium website) in your project - in this project I put inside the resource package
 
 ps: the project was configured to run on windows
  
## Create the first Scenario
  To create the first scenario inside the features folder we create a file with the .feature extension, describe the language, put the tags and describe all the scenario steps
  
  ````gherkin
  #language: en
  
  @AllCenarios
  Feature: Search website
  ````

  The first time you run the feature all defined steps will appear to be inserted into a class you can call Steps.
  In this class you will import cucumber annotations and in the methods created you will insert the logic you want to apply.
     
## Connect to the API
  To connect to the exchange rate API we use Rest Assured. The method used is requestGet(), all elements are described like this. 
  First I instanciated the RestAssured, put other informations and waited for the response was success
  ```java
    RestAssured
                .given()
                .filter(new RequestLoggingFilter())
                .baseUri(URL_API)
                .when()
                .queryParam("access_key", "KEY")
                .get("/endpoint")
                .then()
                .statusCode(200)
                .extract()
                .response();
  ```
  
## How to run the project

   Assuming everything works, in the SearchRunner class you will run 'SearchRunner' as if you were running a test scenario.
   Everything defined in the methods will be called and your application will start.
   Another alternative is to use Ctrl+Shift+F10 inside the class.


## Report

   The test report is present in the target folder generated after the test is completed. 
   It's called cucumber-pretty.html.
   
## References
   
      