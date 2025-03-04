# Name chain

Given a list of names _(first and last)_ find out the maximum length we can create a name chain.
Two names will be in a chain if the last name of 1st person is same as the first name of 2nd person.

We can assume no duplicates.

## Example:

[(bob, ross), (ross, taylor), (lary, page), (taylor, griffin)]

O/P should be: 3 [(bob, ross), (ross, taylor), (taylor, griffin)]

## Solution:

Since their last name is linked to next persones first name, we can easily navigate through a Map