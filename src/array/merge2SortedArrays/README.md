# Merge two sorted Arrays with O(1) space

We are given two sorted arrays. We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first array and the remaining numbers are in the second array. No extra space allowed.


## Example

Input: ar1[] = {1, 5, 9, 10, 15, 20}; <br />
       ar2[] = {2, 3, 8, 13};
       
Output: ar1[] = {1, 2, 3, 5, 8, 9}	<br />
        ar2[] = {10, 13, 15, 20}  


## Solutions
### 1st Approach
1st array should always contain smaller elements than the 2nd one.	<br /> 
So, if Second[start] < First[end] then swap them and sort individual Array. This will happen untill size(second array)

O(m*(n+m))					<br />
n - Size of First Array		<br />
m - Size of Second Array        

### 2nd Approach (faster)
Compare last items from both the Arrays. The bigger one should be in 2nd Array.	<br /> 
Swap them if they are not. Now sort the 1st Array only. Continue this process untill the size of 2nd Array

O(m*n)					<br />
n - Size of First Array		<br />
m - Size of Second Array        
