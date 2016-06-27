# Multi Tasks 

You are given 3 tasks. You can run them using process or using thread, means 3 different process or combining them and run 3 different threads in a single process. Which one will you prefer and why?

## Solutions

1. Threads are useful when they share some variables or address space. Thus context switching between them is more efficient as compared to between processes. Thus implementing multiple threads in the given case would prove useful only when the tasks have some variables shared. If they are completely independent of each other, there is no difference between using separate processes or separate memory.
 
Also multithreading would be favored in case of uniprocessor architecture while multiprocessing in multiprocessor. 

2. The cost of spawning a thread is much cheaper than creating a separate process. 
Create a process when you want a part of your system to run independently, such as something that provides a service. You can still communicate with IPC (Inter Process Communication). But if you want to speed up your program and share some data, address space, then use threads.