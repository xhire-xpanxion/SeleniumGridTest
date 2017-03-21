# Selenium Grid Test
### A quickstart framework created from the [Selenium2-Java-QuickStart-Archetype](https://github.com/sebarmeli/Selenium2-Java-QuickStart-Archetype)
#### Get a test up and running over your grid in no time!


Project Structure
-----------------------------------

The project follows the standard Maven structure, so all the tests go in the *src/test/java* folder.  Tests should inherit from the **TestBase** class. In this class a factory method
from **WebDriverFactory** class is in charge of generating the instance of the WebDriver interface you need. Different parameters are passed into the factory:

* base URL : base URL of the AUT (application under test)
* Grid 2 hub URL :  URL of the hub (if using Grid 2)
* browser fatures: a) name b) version c) platform
* username / password : in case of BASIC authenticated site

Those parameters are retrieved from the *src/main/resources/application.properties* file. You can also populate the properties file from command line (through -D<property in mvn command or through
Hudson/Jenkins).

**TestBase** class provides 30 seconds as interval for polling element from the DOM (implicity wait), and also it takes care of closing the driver when all the tests are executed in the suite. 
(Feel free to update all this values according to your needs)

**HomePageTest** class (in *src/test/java/pages*) is just an example of a test class for testing the homepage of a web application. This test class accepts the *path* parameter
 (set in *src/test/resources/testng.xml)* defining the path appended to the base URL (in case of the home page, usually just "/"). In the setup method of this class, the **PageFactory** class is used
 to help supporting the **PageObject** pattern (see below for more information). Briefly according to this pattern, each page is an object. *src/main/java/pages/HomePage* class is an example of 
 a class representing the home page. Notice how the constructor accepts the "WebDriver" interface as parameter and all the "services" available for that page should be exposed here. It also allows to
 decouple the DOM element from the functionalities offered by the page.
 
 
In the TestBase class, I commented out the method launched after the suite runs and it takes screenshots in case of failure. Feel free to uncomment it out if you need and if your driver supports that
funcitonality. (at the moment it's not supported on mobile devices)


