# Peopleware

## Dev Environment 
  1. Eclipse
  2. Java Jdk- 1.7
  3. Mysql DB - 5.1
  4. Hibernate 4.3 + JPA
  5. Spring 4.0.7
  6. Maven
  7. Tomcat Server 9.0.8
  
A peopleware-server contains two projects peopleware-app and peopleware-core

### peopleware-core -  
It includes all Entity and DTO classes seperate from business layer.
### peopleware-app - 
It includes the buisness logic (ServiceLayer), Persistence Layer (DAO classes) and Application Controller.
### peopleware-ui -
Web pages to render data to user.
## Project description

People-Ware web app is a common platform for Employer as well as for Employees looking for an opportunity, it includes Registeration page which will allow a candidate to register as job seeker in an application. During registeration candidate has to provide required details such as Name, Contact#, Technical Skills (with their rating), salary expectations. On the other side, the Employer can post a job offer by adding job description, salary range, and require technical skills.

This WebApp automate the process of selecting qualified candidates for particular JobOffer when particular JOb has been selected, in contrast to selecting eligible Job offers for particular Candidate based on technical skills as well as salary expectations.

Pages as follow:
### Applicant List
    Display List of all aplicant at present time in WebApp
### Job Offer List
    Display List of all Job Offer posted by an Employers
### Post Job Offer
    Input Form which allow Employer to post new Job Offer
### Subscription
    Registeration form for an Employee

## Steps to Setup the Project

### Dev
1. Import peopleware-server (peopleware-app+peopleware-core) as maven project into an IDE.
2. Open /peopleware-app/src/main/resources/properties/dev/datasource.properties to change the database url, username and password.
3. Run peopleware-server as Maven install (this will build peopleware-core.jar and peopleware-app.war files)
    ### Note :  Creation of peopleware-app.war file is dependant on peopleware-core.jar, therefore for war to be created peopleware-core.jar should be present.
4. Copy the peopleware-app.war into webapps directory of apache-tomcat (server).
5. Copy the peopleware-ui into the webapps directory of apache-tomcat. It is a frontend of the Peopleware-WebApp
6. Create a Database of name which has been given in datasource.properties in step 2.
7. When server is up and running successfully, please hit the ## url :  pathtomachine:portnumber/peopleware-app/api/ after that JPA wil create tables in selected database.
8 Execute peopleware.sql to populate the prefilled data into DB.
9. Load the start page into the web browser as  below example
    ### For example: http://localhost:8080/peopleware-ui/subscribe.html

### Test
1. Open /peopleware-app/src/main/resources/properties/dev/datasource.properties to change the database url, username and password.
2. Copy the peopleware-app.war into webapps directory of apache-tomcat (server).
3. Copy the peopleware-ui into the webapps directory of apache-tomcat. It is a frontend of the Peopleware-WebApp.
4. Create a Database of name which has been given in datasource.properties in step 2.
5. When server is up and running successfully, please hit the ## url :  pathtomachine:portnumber/peopleware-app/api/ after that JPA wil create tables in selected database.
6. Execute peopleware.sql to populate the prefilled data into DB.
7. Load the start page into the web browser as  below example
    ### For example: http://localhost:8080/peopleware-ui/subscribe.html
    
    



