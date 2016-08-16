
# How to reverse bits in a 32-bit number?

Given 1101, we should return 0010

We can do this by XORing the input with a number that has 1 in all of its 32 bit positions (i.e. Integer.MAX_VALUE)


## Code

```java
int reverseBits(int n){
	int flag = ~ 0; 	// All 1's; Inverse operations
	return (n ^ flag);
} 
```