# Selenium project 
**To conduct the tests you need to have installed:**
* Maven
* Google Chrome and its driver
* Firefox and its driver
* Safari and its driver
* Java 11 or similar

***

## Downloads

**Google Chrome**

* [Chrome browser](https://www.google.com/chrome/?brand=BNSD&gclid=Cj0KCQiAubmPBhCyARIsAJWNpiM2YcHnYN2CXWFslYRJt3isweWCT-HVbDT90VXmUXZt6A95QyQ-lNEaAlDGEALw_wcB&gclsrc=aw.ds)

**Safari**

* [Safari](https://support.apple.com/downloads/safari)

**Firefox**

* [Firefox](https://www.mozilla.org/en-US/firefox/new/)

**Maven**

* [Maven](https://maven.apache.org/)

**Java**

* [Java](https://www.java.com/en/)



**Web drivers**

* [Chrome browser driver](https://chromedriver.storage.googleapis.com/index.html)
* [Firefox browser driver](https://github.com/mozilla/geckodriver/releases)
* [Microsoft Edge browser driver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)
* [Internet Explorer browser driver](https://www.selenium.dev/downloads/)
* Safari has built-in driver

***warning:** notice to install appropriate Web driver to version of installed browser

***

## Steps to run tests:
1. Clone the repository to your local machine
2. Open bash/terminal/cmd and navigate to previously cloned repository
3. Go to "TestFramework" module
4. Execute command: `mvn clean install`
5. Go back to home project folder
6. Go to "Tests" module
7. Execute command: `mvn clean test`

***

## Technologies used
1. **Selenium** - for browser interaction
2. **Assertions** - 
* from TestNG for front-end - [TestNG](https://testng.org/doc/documentation-main.html)
* from Rest-Assureed and TestNG for back-end - [Rest-assured](https://rest-assured.io/)
3. **Reporting** - TestNG default html report - [TestNG](https://testng.org/doc/documentation-main.html)