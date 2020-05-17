# Employee Service SpringBoot Application

As part of this application we read, write & edit an existing XML file and also extending its feature.

## Implemented Features

In this SpringBoot Application have implemented the following features

```bash
1. SpringBoot 2.3 (Latest version)
2. Java8
3. Swagger2 Documentation
4. SpringBoot Actuator End points
5. Spring AOP
6. Logger
7. Global Exception Handler
8. Filter
9. Lambok for DTOs
```

## Available APIs

Here is the list of APIs available as part of this SpringBoot Application

```bash
1. http://localhost:8080/v1/employees GET
2. http://localhost:8080/v1/employees/{empId} GET
3. http://localhost:8080/v1/employees/{empId} DELETE
4. http://localhost:8080/v1/employees/{empId}/add POST
```

## Run Command

Please make sure Employees.xml file exiting in your classpath.

```python
java -jar EmployeeService-0.0.1-SNAPSHOT.jar
```

## Sample XML
```python
<employees>
	<employee id="111">
		<name>Mohan</name> 
		<age>25</age> 
		<designation>Developer</designation> 
	</employee> 
	<employee id="222">
		<name>Anitha</name> 
		<age>40</age> 
		<designation>Senior Developer</designation> 
	</employee> 
</employees>
```