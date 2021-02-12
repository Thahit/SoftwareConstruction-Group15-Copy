# **Software construction - Assignment 5 - Design Choices**
## **Exercise 1**
**Decorator Design Pattern:**
Adding toppings to a cake or sandwich is very similar to the example: adding e.g. mocha to coffee, which is why we decided to use it there. You add the toppings by constructing the topping and giving the "base", which itself can be a topping or cake/sandwich, as a parameter (e.g. Ham(base)). We decided that Bakeries only can create cakes/sandwichs and and the corresponding toppings. 
Further we added an interface "Pastries" which is implemented by Sweets and Bread. That way we only need one method that calculates the price independently whether it's type of Sweets (e.g. Cake) or Bread (e.g. Sandwich). That way it's maintainable for future changes (e.g. adding Candy)

**Composite Design Pattern:**
It made the most sense to use the composite pattern with the offices and bakeries. The bakeries are in this example the leaves and city- and central Office are composites. 
We decided, to create a singletonclass CentralOffice to ensure there is only one. There were some constraints when applying the composite pattern. For instance, there are no methods that are used by all subclasses (Bakeries, City- and Central Office) besides of print method but even that one has different names (The print methods' names are specified as: printAllBakeriesNames, printAllOffices, printName).

## **Exercise 2**
**Strategy Design Pattern:**
We applied the strategy pattern to the speed and fueltype which the car consumes. For the price and number of allowed bags it doesn't make much sense because these are integer / number. For these types of behavior you would need infinite behaviors or you would have to categorize them into like "few bags allowed", "cheap", "expensive" etc.
As the number of vehicle increases we can add more speed or fuel behavior for example "super fast". The classes would implement the corresponding interface. For any new vehicle,
they would have the variables defined in the abstract class which we define up on creating the class and the choose the fitting behavior. 
For the tests we made sure that every vehicle does not miss any information like "price", "name" etc. and if they should miss some, the customer method "ride" shpuld throw an exception which we test if he really does.
We also made sure that the customer prints the correct information.
