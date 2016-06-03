# Validate a Reverse Polish Notation

Given an RPN expression, determine if its a correct one or not. You can assume all the numbers will be within 0-9 with basic operators [+, -, *, %]


## Example
25+ <br />
This is 2+5, so return true

25++ <br />
Invalid expression. Return false

2-5 <br />
Invalid expression. Return false

538*+ <br />
This is 5+3*8, so return true 

23+4 <br />
(2+3)4 Invalid expression. Return false