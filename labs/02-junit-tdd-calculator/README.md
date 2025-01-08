# Write Calculator Application using Test Driven Development

## Overview:
Calculator Application contains 3 basic functionalities 
1. Addition
2. Subtraction
3. Multiplication


## Task
Write Calculator Application using Test Driven Development

**Steps:**

Create a TestClass:  **"TestCalculator"**
1. Create a Test Method: **"testAddition"** 
   * Implement **addition()** method which takes two integer parameter and returns integer result
      `int addition(int a, in b)`
   
   * verify addition function with below input/output 
        #### Input / Output: 
         25, 20  --> 45
         5, 10   --> 15 
      
2. Create a Test Method: **"testSubtraction"**
    * Implement **subtraction()** method which takes two integer parameter and returns integer result
       `int subtraction(int a, in b)`

   * verify subtraction function with below input/output
     #### Input / Output:
         25, 20  --> 5
         40, 10   --> 30 


3. Create a Test Method: **"testMultiplication"**
    * Implement **multiplication()** method which takes two integer parameter and returns integer result
       `int testMultiplication(int a, in b)`

    * verify multiplication function with below input/output
      #### Input / Output:
          25, 20  --> 5
          40, 10   --> 30 

4. Create a Test Method: **"testDivision"**
    * Implement **division()** method which takes two integer parameter and returns integer result
      `int testMultiplication(int a, in b)`

    * verify multiplication function with below input/output
      #### Input / Output:
          25, 20  --> 5
          40, 10   --> 30 
    * Verify if someone divides by zero, an exception should be thrown.