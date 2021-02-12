# **Software construction - Assignment 4 - Design Choices**
## **Data Base**
We created a class "database" to help checking if the Id's are unique, and to have a list if the Customers in a convenient way.
The Credit card "dept" does not influence the savings and are not recorded (ok with tutor).

## **States**
Since Customer and CreditCard have the same State-type, we decided to create an interface State. A Class that implements State has to define a behavior pattern for the following three methods: UseCreditCard, upgrade, downgrade. That way, depending which state the CreditCard currently has, its methods will be "adjusted" accordingly. With this technique, the code will be manageable-friendly for future implements. 
Further, we linked the States to the CreditCard, because it's the CreditCard which is directly effected by the corresponding state (max Limit). However, the Customer has the state whichever the CreditCard has currently. 

## **Employees**
MainChief does not extend SectionChief because we wanted to have a clear extension-pattern which wouldn't be possible since SectionChief is assigned to a City, however MainChief is not. That's why both are extending RegularEmployee since this Class is the blueprint of an Employee. Further, all employees are extending the Abstract Class Person, since every Employee has the characteristics of a Person (Name, Surname, ID). 
Also, we decided that Employees can create Customers and the Creditcard of a customer (independently of each other) because it made a little bit more sense for a real-world scenario.

## **Customers**
There's just one Customer Class since we designed the State-behavior with the state interface (see above). All Customers are extending Person, since every Customer has the characteristics of a Person (Name, Surname, ID).

## **Technician**
We created an abstract Class Technician in case of future implements/adjustments. Back- and Webtechnician extending Technician because they're both more specific Technicians with specific functionalities (methods). All Technicians are extending Person, since every Technician has the characteristics of a Person (Name, Surname, ID).

## **UML - Diagramm**
For the sake of visibility we did not draw a direct connection between 2 classes if there is a indirect connection. For example, there is a conncection betweeen SectionChief and the Customer class. But in between those 2 classes there is the RegularEmployee class which has a connection from itself to the customer class.
Furthermore we did not include methods which are only used for testpurposes.

![UML](https://cdn.discordapp.com/attachments/755442427086503936/776829490021924874/Assignment_4.png)
