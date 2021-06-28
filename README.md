## **Full Stack Test Automation Final Project**   


### ***Demonstration Project of my knowledge and skills in Automation Testing***
____________________________________________________

### ***About***    
This project demonstates a **smart** and **easily maintained** automation infrastructure. It is built with "divide and conquer" approach and inheritance using packages like: Utilities, Extensions, PageObjects and Workflows. This way, test methods created very simply and comprehensibly with a minimum lines of code while exporting **ALL** of configuration data in to external xml file. This kind of infrastructure supports differend types of platforms thus providing homogeneity, order and organization in managing automation testing.

### **Project Overview**
***
### **_Infrastructure Characterization:_**
* Page Object Design Pattern - OOP
* Project Layers (Extensions/Workflows/Test Cases...)
* Support of Different Clients/Browsers
* Root cause analysis
* External Files Support
* Reporting System (including screenshots)
* Visual Testing
* DDT
* DB support
* CI support  

### _Applications Tested:_
* NopCommerce webpage - Web application
* Mortgage calculator - Mobile application
* Students List - DEMO Server API
* ToDoList - Electron application
* Windows calculator - Desktop application

### _Tools & Frameworks used:_
* TestNG - Testing Framework
* Listeners - interface used to generate logs and customize the TestNG reports
* Monte Screen Recorder - for test recordings (using Listeners)
* MySQL Free Online DB - JDBC
* [Jenkins CI/CD](https://www.jenkins.io/)- for tests execution
* REST Assured - for API testing
* [Allure](http://allure.qatools.ru/) Reports - as the main reporting system of the project

### _Tests Execution_:
Each of the applications has a test class containing a few test cases for demonstration purpose.
[[Sanity Tests]](https://github.com/OxanaDrezner/FullStackTestAutomationFinalProject/tree/master/src/test/java/sanity)   
**Please note**, for running tests on you local machine, use the TestNGSuite***PlatformName*** xml file.      
<br>    

> ### **Known Issues:**
> There are some dependencies conflicts while testing Mobile platform and Desktop platform.
