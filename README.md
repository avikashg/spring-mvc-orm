# spring-mvc-orm

### Spring MVC Learning
* Spring MVC is a module of Spring framework which is used to create web applications
* It is built on the top of Servlet API, so basic knowledge of Servlet is mandatory
* It follows the model-view-controller design pattern.
    - model - represents the data
    - view - represents the UI layer
    - controller - represents the business logic or the core application code.

### Pre-requisite
- maven should be setup on your machine.
- jdk should be properly setup on your machine


### Pre-requisite Knowledge
- Java Core
- J2EE concepts like Servlet, JSP etc
- Spring Core Framework

### How to create new project from scratch
```sh
$ mvn archetype:generate -DgroupId=com.mylearning -DartifactId=learn-springmvc -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```
Import this project into development IDE, like Eclipse. After importing, If you find any error in the project, you need to setup the server with your project. Ideally, most of the people use Apache Tomcat. So you need to configure Apache Tomcat with the eclipse.

#### How to setup Apache Tomcat
* Add Apache Tomcat to Eclipse
	- Download Apache Tomcat server from its official website and upzip it on your local machine
	- Go to Eclipse Settings > Server > Runtime Environments > Add > Apache > Apache Tomcat v*.* > Click Next > Select the directory where Apache Tomcat zip is extracted in previous step > click finish
 
* Add Apache Tomcat runtime into the project
	- Select project > Click build path > Add Library > select Server runtime > Select the Apache Tomcat server entry seleected in the previous step


### Pom.xml with all the dependencies needed

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.spring</groupId>
	<artifactId>spring-mvc-orm</artifactId>
	<packaging>war</packaging>
	<version>1.0-SNAPSHOT</version>
	<name>springmvc-orm Maven Webapp</name>
	<url>http://maven.apache.org</url>
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
		
		<!-- Spring webmvc dependency -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>5.3.18</version>
		</dependency>
		
		<dependency>
			<groupId>jstl</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>
		
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.32</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-orm -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-orm</artifactId>
			<version>5.3.18</version>
		</dependency>
		
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>5.3.18</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.6.15.Final</version>
		</dependency>
		
	</dependencies>
	<build>
		<finalName>spring-mvc-orm</finalName>
	</build>
</project>
```

### Steps to configure the Spring MVC and ORM
- Make sure you have all the dependencies installed in your project
- Configure the Dispatcher Servlet in web.xml
- Create Spring Configuration File
- Configure View Resolver
- Create Controller
- Create View to show 


#### Dispatcher Servlet in web.xml 
Create Servlet Entry in web.xml

```xml
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
  <display-name>Archetype Created Web Application</display-name>
  
  <servlet>
  <servlet-name>spring-mvc-orm</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  
  <servlet-mapping>
  <servlet-name>spring-mvc-orm</servlet-name>
  <url-pattern>/</url-pattern>
  
  </servlet-mapping>
  
</web-app>


```
#### Create Spring Configuration File
Create Spring config file under WEB-INF folder. Make sure you name the file in accordance with the Servlet name given in the above step. E.g, if Servlet name is 'xyz' then Spring config file name should be 'xyz-servlet.xml'


#### ViewResolver Bean - Create a bean in Spring Configuration File

```xml
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" name="viewResolver">
		<property name="prefix" value="/WEB-INF/views/" />
		<property name="suffix" value=".jsp" />
	</bean>
```



### How to redirect views in Spring MVC?
- HttpServletRequest
- Redirect Prefix
- RedirectView

#### HttpServletRequest
not recommended way of doing

```java
@RequestMapping("/four")
	public void four(HttpServletResponse res) {
		System.out.println("This is four handler");
		try {
			res.sendRedirect("two");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
```
### RedirectView
```java
@RequestMapping("/three")
	public RedirectView three() {
		System.out.println("This is three handler");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("two");
		return redirectView;
	}
```

#### Redirect Prefix
```java
	@RequestMapping("/one")
	public String one(HttpServletRequest req) {
		System.out.println("This is one handler");
		return "redirect:/two";
	}
 ```
 
 
