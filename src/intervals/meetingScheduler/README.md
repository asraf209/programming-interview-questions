# Meeting Scheduler

Given the availability time slots arrays <code>slots1</code> and <code>slots2</code> of two people and a meeting duration <code>duration</code>, return the earliest time slot that works for both of them and is of duration <code>duration</code>.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements <code>[start, end]</code> representing an inclusive time range from <code>start</code> to <code>end</code>.

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots <code>[start1, end1]</code> and <code>[start2, end2]</code> of the same person, either <code>start1 > end2</code> or <code>start2 > end1</code>.


## Examples
### Example 1
Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8

Output: [60,68]

### Example 2
Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12

Output: []