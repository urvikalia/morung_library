## Decision and Assumption logs 

Documented the decisions and the assumptions made during the work done 

1. For search results exceptions are thrown from service layer. example search functionality 
can return null , in service layer its wrapped as exception and thrown further  

2. Since I am extending Runtime exceptions , I don't have to bother to handle them , but given the requirement
was one needs to handle gracefully and continue the processing one might want to. And if I see the system being used as is 
Ideally I should be throwing checkedExceptions so that the main takes care of it and handles them 
But that I can still do. So i will still throw runtimeException but catch it and handle gracefully,. 
3. 



## Assumptions 

## Open Questions 

1. Library will be a POJO class or a business class. IT is encapsulating list of POJO's book. Has minor functionality of searching
Open question is should I consider that as a POJO or a business. 

Learning : A POJO is a plain class with attributes and getter and setters. whenever there is a business logic involved make it a business class 
for following reasons:
* It can have control on the way operations are performed on the encapsulated object 
* It also hides the implementation details , if book list is a list , treemmap or something else.


2. User POJO is not abstract , but have extended the class as Student, SeniorCitizen and RegularUser.
But a user has to be of a specific type : so might as well make it abstract and have a factory method creating users 
will come back to this in next phase and relook 

3. As of now basic validations added at entity level. 



## Learnings 
1. Perform input validation as close as possible to the edge of the system (usually in controller or service layer)
There are three layers of validation
* Presentation layer : prevent bad input from entering the system. using Javax validation or custom validation. usually inside rest controller
* Domain Layer/ service layer: enforce business policies . e.g. age > 18 etc   
* Entity Layer : protects domain integrity. e.g. user should not be created with null name, usually done inside the construtor or factory method 