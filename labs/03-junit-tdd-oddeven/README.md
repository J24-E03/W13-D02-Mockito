# Write an Application/Program using Test Driven Development to check given number odd number or even number.

## Overview:
This Program verifies if a given number is Odd or Even number.
Any number after dividing by two, if the remainder is zero then it's **Even Number** otherwise it's **Even Number**.
In Java programming to calculate the remainder, we use "**%**" symbol.

For Example:

%  | Remainder | is Odd number 
--- | ---      | ---
10 % 5 | 0| false
25 % 2 | 1| true

## Task
Write/Implement a OddOrEvenChecker Program which checks if a given number is Odd or Even number.

**Steps:**

Create a TestClass:  **"TestOddOrEvenChecker"**
1. Create a Test Method: **"testOddNumber"** 
   * Implement **isOddNumber()** method which takes integer as parameter and returns **_true_** if remainder is not zero.
      `String isOddNumber(int number)`
   
   * verify the method with below input/output 
        #### Input / Output: 
         25  --> true
         15  --> true 
      
2. Create a Test Method: **"testEvenNumber()"** which calls _isOddNumber()_ which was implemented in above step.
    * Update **isOddNumber()** method which returns **_false_** result if remainder is zero
      `String isOddNumber(int number)`

    * verify the method with below input/output
      #### Input / Output:
          20  --> false
          10  --> false 
   
3. Refactor the method isOddNumber() 
 
When all the tests are passing, you should have an output similar to the one below:

 ![tdd_test_odd.png](tdd_test_odd.png)