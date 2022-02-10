****************
* Grid Monitor Project
* CS 221
* 11/24/2020
* Kacey Wheeler
**************** 

OVERVIEW:
 GridMonitor is an implementation of the GridMonitorInterface
 which allows users to read in a two-dimensional array (the base grid) 
 from a file and determine locations in the base grid with dangerous 
 values relative to their surrounding locations. 

INCLUDED FILES:

 * GridMonitor.java - source file
 * GridMonitorInterface.java - source file
 * Test.java - source file
 * GridMonitorTest.java - source file
 * README - this file


COMPILING AND RUNNING:

 From the directory containing all source files, compile the test
 class (and all dependent classes) with the command:
 $ javac GridMonitorTest.java

 Run the compiled GridMonitorTest class with the command: 
 $ java GridMonitorTest

 Console output will report which tests GridMonitor passed or failed. 


PROGRAM DESIGN AND IMPORTANT CONCEPTS:
 
 GridMonitor implements the GridMonitorInterface interface which defines
 methods for reading an array from a file and assessing each cell to see if it 
 is in danger of exploding. The only parameter it takes in is the name 
 of the file. 

 GridMonitor allows for the user to assess different cells of a solar
 arrray in order to see if they are in risk of exploding. It does this 
 through many different methods which serve as different steps to 
 finally assessing whether or not the cell will explode. This class 
 allows for the sum of each cell to be found by adding each adjacent 
 cell. If there is not an adjacent cell, the original cell itself is 
 simply added in its place. This class also provides functionality 
 for finding the average of each of these summed cells as well as 
 the maximum delta values for each. 

 Finally, the program assesses the original array of values to see 
 if they fit in the range between the average plus/minus the delta 
 value. This is how each cell is assessed to determine if it is in 
 danger of exploding, ensuring these dangerous imbalances can be 
 accounted for. 

 Each method in the class iterates through the array by using 
 for loops to cycle through each row and column respectedly.
 The row and columns provided in the file are also saved at the 
 beginning of the program, allowing for arrays of different sizes 
 from different files to be read properly. Many of the methods 
 call upon other methods in the class as well, creating encapsulation 
 which provides efficiency and organization. 

 GridMonitorTester confirms correct operation of all GridMonitor
 methods. Test also provides a more simplified version of testing 
 each method. They are both configured to use the GridMonitor
 implementation of GridMontiorInterface.


TESTING:

 Both Test and GridMonitorTest were used for testing GridMonitor. 
 Test was used during the process of development, allowing for 
 testing to be more targeted and less overwhelming to begin with. 
 However, GridMonitorTest was used as a primary form of testing
 after the foundation of GridMonitor was laid. 

 Scenarios being tested by GridMonitorTester include:
    Getting the base grid of the array 
    Getting the summed grid by adding the adjacent cells
    Getting the average grid of the summed grid
    Getting the delta grid of the array
    Assessing each cells' danger of exploding

 GridMonitorTester also tests many different kinds of input,
 including files with arrays with different lengths and arrays 
 which have negative numbers. This makes sure that the program
 can handle all different kinds input, improving its functionality.


DISCUSSION:

 The hardest part of this project was making sure my results
 aligned with the provided test file. It was difficult to be 
 able to read someone else's code to figure out where there
 were errors with mine. However, I did find the GridMonitorTest
 file extremely helpful once I was able to use it effectively. 
 It made testing for all possible scenerios much easier, and the 
 output it provided was invaluable in fixing the bugs in my code. 

 Another part of this project I found to be challenging was learning
 all the proper documentation which I needed such as this file.
 I've never included a README in my project before, so it was 
 a bit of a learning curve figuirng out how to write one. 
 However, I understand why organization and documentation in code 
 is so important after creating my own documentation as well as
 reading the documentation left in the GridMonitorTest and 
 GridMonitorInterface files. I would have been so lost without the 
 clear comments left in these two files, and it would have made 
 debugging considerably harder if I had not included clear 
 documentation of my own. 

 It was great to be able to take some of the concepts we have 
 been learning like inheritance, encapsulation, and interfaces
 and be able to apply them on a larger scale. This project 
 really helped me to solidify some of these concepts I was 
 struggling to gain a grasp on. 
