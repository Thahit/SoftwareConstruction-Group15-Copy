# **Software construction - Assignment 2**

## Part 1
Regarding the input of the ships' coordinates: 

We assumed that only from *left to right* or from *top to bottom* is correct since the example in the Assignment-Sheet followed this rule as well.
That means if somebody would try to add a ship from right to left (e.g. Submarine H2 F2) it would lead to an error ("Specified input is invalid"). 

## Part 2
**Source:** pdf-swing.src.main.java.com.lowagie.rups.model

Additional Remarks:

Since all classes are public besides one we didn't add the information "+" (for public) in front of them. The class *ThreadWrapper* is the only one that is private and therefore we indicated it as "-" (for private). Further, this class is also the only one that is static (underlined) which makes sense, since it's an inner class of *BackgroundTask* (which is being indicated by the plus-in-circle-arrow)

The arrow between e.g. *ObjectLoader* and *TreeNodeFactory* represents in this UML a dependency as in (not limited to):
- Class A uses a type from Class B
- Class A creates an Object from Class B
- Class A calls a Method from Class B

Other arrows are being used based UML standards (see lecture)

Further, most of the classes from *model* have associations to classes outside of the package *model* or *openpdf* in general.
We did not mention them in our UML since we wanted to focus on *model* itself. However, we did add a few exceptions (marked in blue) for the following reasons:
- PdfReader has been added to the UML because it fills a gap between *ObjectLoader* and *PdfFile*. 
- *XfaFile* and *ProgressDialog* have no connections to any classes of *model*. However, both of them have one important connection that we decided to implement into our UML. 
  *XfaFile* implements the interface "*OutputStreamResource*" from lowagie.rups.io. and *ProgressDialog* extends the java class "JDialog" from javax.swing. 
Since we didn't want to focus on these extra classes too much, we just added a few methods etc. and added "..." to indicate that there would be more.

As a final remark, we did not add any information about input type, parameters in general etc because we wanted to keep the overview simple and focus on the connections between the classes rather than the classes themselves.
![Image of UML](https://cdn.discordapp.com/attachments/755442427086503936/766035331585671210/unknown.png)
