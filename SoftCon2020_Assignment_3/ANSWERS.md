# **Software construction - Assignment 3 - Design Choices**
Some challenges arrived because of previous Design-choices, but redoing the whole programm is not the task, but expanding on previous work.

## **Singleton Design Pattern**
We decided to make the opponent/bot a singleton to prevent accidently having several shooting at the players board.

## **Observer Design Pattern**
In our project, we considered the User's and Opponent's input as the observable subject (both implement the interface "Observable"). This means, everytime an attack was successful, a method called "NotifyCorrespondingObserver" will be called and the observer which is affected by the attack will be updated. Thus, all ships (User's and Opponent's) are observers and vice versa. Since they all use the same update-method, we decided to make "Observer" an abstract class which implements the interface Ship. 
Once a ship is destroyed, and therefore no longer an Observer, it will be removed by the method "RemoveObserver"

Hint: *Playable* is the class of the current "User".

## **Iterator Design Pattern**
We made an iterator specifically for the lists containing all the ships for each the player and the AI. The hasNext() and next() methods are used to traverse the list. We also added a method to return the current ship in the list so we can use it for other purposes and in case we needed a remove option, it would be easy to implement.
