# **Software construction - Assignment 1**

## Part 1.1

Project "OpenPdf" offers several packages and even more classes. However, to create an abstract architecture, we didn’t just want to pick the first best 3 packages but actual meaningful ones. For that we tried to focus on the package “pdf”. On one hand because “pdf” contains probably the most classes of all packages. On the other hand, it would make sense to work with a package called “pdf” in a project called “OpenPdf”. Nevertheless, we also preferred packages on the same level since that would make more sense in our abstract architecture which was unfortunately not the case with most of these packages. After all, we found two packages “xml” and “html” that were connected to “pdf” and were yet on the same level. To show how structured these classes are and yet depending on each other on multiple levels, we decided to still add a few outside of our level into our architecture, marked as orange. Some of them are sub-packages (like simpleparser) and some of them are super-packages (like text). This shows, it’s almost impossible to isolate packages/classes in “OpenPdf”.

![Architecture](https://cdn.discordapp.com/attachments/755442427086503936/761304544566050836/unknown.png)

## Part 1.2

OpenPdf has many prominent entry points. There’s PDFWriter (under openpdf.src.main.java.com.lowagie.text.pdf) which makes sure one can write PDFs. Then there’s PDFReader (under .text.pdf) which is responsible for reading PDFs. And eventually there’s “Rups” which provides tools to inspect the internal structure of a PDF file. Out of these three prominent entry points we picked “Rups” since it’s not only a part of “OpenPdf”’s prominent entry points but also because for this assignment we tried to cover as much as possible of this project. Further we did not track any java classes from libraries outside of “OpenPdf” since we wanted to focus on the actual classes from this project. As for instance, classes we ignored on the second level are (not limited to): "Jframe (javax.swing), getScreenSize(java.awt), setLocation(java.awt), setDefaultCloseOperation(javax.swing) etc. As a last remark, we added the source of each class right underneath it.

![Call graph](https://cdn.discordapp.com/attachments/755442427086503936/761304297412624384/unknown.png)

## Part 2

<img src="https://cdn.discordapp.com/attachments/654003599533408266/762237016385257492/unknown.png" width="238" height="385">

![1](https://cdn.discordapp.com/attachments/526744782207320096/761669126741164082/1.PNG)


<img src="https://cdn.discordapp.com/attachments/654003599533408266/762240145772249138/unknown.png" width="695" height="659">


![2](https://cdn.discordapp.com/attachments/755442427086503936/761879743150161930/unknown.png)


![4](https://cdn.discordapp.com/attachments/689494854811910148/761684865308950558/unknown.png)


![5](https://cdn.discordapp.com/attachments/526744782207320096/761669131682447360/5.PNG)


![6](https://cdn.discordapp.com/attachments/654003599533408266/762236309900361758/unknown.png)

