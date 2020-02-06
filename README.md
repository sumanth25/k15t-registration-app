# Java Meetup Registraton

We have a small web application allowing to register for the next Java Meetup. A participant can register himself by filling the registration form displayed. On registering, a success information to the user including the entered information.

### Prerequisites

What things you need to install before starting

```
JDK 1.8
SourceTreeSetup-3.3.6/TortoiseGit
Eclipse JEE
Maven
```

## Getting Started

These instructions will help you to get your project up and running on your local machine for development and testing purposes. The application is build on top of Spring Boot (http://projects.spring.io/spring-boot/) providing a runtime container. 
Furthermore Jersey for implementing REST resources, Velocity for templating pages and jQuery and Bootstrap is included and 
can be used as well. Building and packaging the application is done with Maven. 

The source is available as public at https://bitbucket.org/sumanth717/k15t-registration-app/src/master/ 

## How to use git ##

To use git to get repository contents run the following git command:

```
#!bash
git clone https://bitbucket.org/sumanth717/k15t-registration-app.git
```
## Repository Overview ##
Please find the package level details of the cloned repository below:

* com.k15t.pat.registration: The package includes a REST endpoint and a service
* com.k15t.pat.registration.dao: The package having Data Access Object extends JPA repository to store and fetch from H2 DB
* com.k15t.pat.registration.model: The package has Model class containing all required fields for participant registration
 * along with validation
* com.k15t.pat.registration.service: The package includes interfaces to register participant
* com.k15t.pat.registration.service.impl: The package includes implementation for registering participant
* com.k15t.pat.registration.util: The package includes Util classes required for registration application
* com.k15t.pat.registration.constants: The package includes constants required for registration application
* resources/templates: The folder includes registration velocity template forming the main layout for the registration page 
* resources/templates/views: The folder includes the registration form velocity template for the registration page and participant velocity template for displaying success message along with registration details
* resources/templates/common: The folder includes the initial velocity templates for the header and footer for registration page
* resources/public/: The folder includes resources like css, images and index html
* pom.xml: This file has all maven dependencies required for registration application

### Installing

The Maven build creates a executable jar which includes the whole runtime (tomcat) to run the app.
You can start it with java -jar registration-0.1.0.jar. If the application is started the pages are
available under http://localhost:8080/registration.html

```
java -jar registration-0.1.0.jar
```

And view in browser

```
http://localhost:8080/registration.html
```

## Main improvements
* Bean Validation
* Spring Data JPA
* H2 In-memory Database
* lombok
* bootstrap 4.0.0


## Running the tests

To start with:

* Enter valid inputs for the form fields: Full Name (required), Password (required), Address (required), Email (required), Phone number (optional)
* Click on Register button below
* If validation errors exist, correct them and click on Register button again 
* On Success, message is displayed and participant details are shown
* If already registered participant, error message is displayed saying already registered 

## Deployment

* The Maven build creates a executable jar which includes the whole runtime (tomcat) to run the app registration-0.1.0.jar.
* Use jenkins job to automate this build process or move the executable jar in production environment
* Use jenkins job or batch scripts to automate start/stop. You can manually start it with java -jar registration-0.1.0.jar. 
* Use batch script to re-start registraton application on server reboot
* Install SSL certificates and enable secure HTTPS communication
* Apply for new DNS name
* Ensure firewall rules don't block the application port else apply exemption for this port
* The registration application is now available for all at http://k15t.java.meetup/registration.html

## Built With
* [Spring Boot] (http://projects.spring.io/spring-boot/) - Web framework providing a runtime container
* [Maven](https://maven.apache.org/) - Dependency Management
* [Velocity](https://velocity.apache.org/) - Provides the actual templating engine to build UI

## Versioning

For the versions available, see the [tags on this repository](https://bitbucket.org/sumanth717/k15t-registration-app/tags). 

## Authors

* **K15t** - *Initial work* - (https://bitbucket.org/K15t/k15t-full-stack-dev-tasks)
* **Sumanth Sudeendra** - *Improvements* - (https://bitbucket.org/sumanth717/k15t-registration-app)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Thank You K15t!

