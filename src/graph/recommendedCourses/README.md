# Find recommended courses from Social Media friends

Given a Student Social Network, find out all the courses your friends have attended or are attending. You have to return a list sorted by popularity.

This Social Network is defined as all direct friends and all direct friends of direct friends. People three levels deep are not part of the social circle.  See it here: [Social Graph](./SocialGraph.jpg)   


## Recommendation Logic

- A user should only be recommended a course that their social network have attended but they have not 
- Recommendation priority is driven by how many people have attended the same course. If multiple people attended the same course, it should be higher in the recommendations than a course that only one person attended

You will be provided two library functions:
- getDirectFriendsForUser - Returns a list of customer IDs representing the direct friends of an user
- getAttendedCoursesForUser - Returns a list of course IDs that an user has attended

Your job is to write a function that provides a ranked(high to low) list of courses(Course IDs) for any given User