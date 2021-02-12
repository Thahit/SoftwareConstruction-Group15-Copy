# **Software construction - Assignment 6**

**Note:**
The arrow noted below this part represents in this UML a dependency as in (not limited to):
- Class A uses a type from Class B
- Class A creates an Object from Class B
- Class A calls a Method from Class B
Other arrows are being used based UML standards (see lecture)

![Image of UML](https://cdn.discordapp.com/attachments/692811215554215987/785515094464528404/unknown.png)

## Exercise 1
There are four classes. These are the user (MVCPatternDemo), the controller (EmployeeController), the Model (EmployeeModel) and the view (EmployeeView). 
As demonstrated in the lecture the user uses the controller to modify the programm. Once the user has entered his input the controller changes the model from
which the view get its data to represent so the user can see what has changed (here: phone number and address). This process can be repeated as the user
gets feedback from the view and can change things as long as he likes to.

As for the uml diagramm it looks rather simple because there are only 4 classes. We did not make an arrow between controller and view even though the controller has 
a method which updates the view, because it is done through the model (the controller tells the model to update with the updateView() method).

![Image of UML](https://cdn.discordapp.com/attachments/526744782207320096/790958479383986246/ass6.JPG)

## Exercise 2
The customer seems to have a lot of methods but this cannot be prevented, because the customer performs all the actions. A lot of the methods just call the same method in another class which then does the heavy-lifting. The customer does not know how the other classes (like the cart) perform their actions but they can command the method to perform the actions. This is to encapsulate the classes/methods.<br>
The inheritances are utilized because the different child classes perform the same actions/have the same variables. <br>
The Products have a new variable "owner" because this way we can inform the owner that their product has been sold(durring the checkout/paying process), and they can sell something new without going over the limit. ShoppingSW has a database of the items that are on sale at a given moment and a SearchBar accesses this list. <br>
Each customer has their own cart/ SearchBar. This is to prevent having a lot of carts/searchbars. If the customer tries to select(addtocart) an item which  they already own, the cart reacts and tells the customer that they can't do that. The searchbar takes a type of class and checks if the items in the database match the class-type. That way one can either search by category of products, type of clothes or type of shoes. The different Payment methods have their own class, because its more flexible/ better when expanding the program than for example using strings or enums.<br>
If customer methods are used it is checked first, if they are allowed to do that(checks as in: "are they online?", "can they still sell new items?", etc.) The database/the shop has static methods because this is more convenient than always including it in the parameters.

![Image of UML](https://cdn.discordapp.com/attachments/692811215554215987/785513987831234591/unknown.png)


