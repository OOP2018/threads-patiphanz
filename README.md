## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |               10000|        0.0010524|
| Using ReentrantLock     |               10000|        0.0075117|
| Synchronized method     |               10000|        0.0055373|
| AtomicLong for total    |               10000|        0.0032887|

## 1. Using unsynchronized counter object


1.1 I ran it 5 times. Total should be zero but it isn't and total always didn't be the same.

1.2 First runtime 0.018481 sec, Second runtime 0.018378 sec, Third runtime 0.016173 sec, Average runtime 0.017677 sec.

1.3 Total doesn't be the same because the substractTask can be run anytime even through addTask doesn't finished. so sometimes like the counter in addTask is 5 but in substractTask may be 6, so total is not equal to zero.

## 2. Implications for Multi-threaded Applications

In the real world like Banking application that has a lot of task.
It could affect to user like when user1 and user2 withdraws 20 Baht at the same time and same account. User1 and user2 will get total 40 Baht but withdraw at the bank can be 20 baht because 2 threads have withdraw at the same time. 

## 3. Counter with ReentrantLock

3.1 The total is always zero.

3.2 Because it will run just one thread and wait until finish to do other thread.

3.3 ReentrantLock will lock the process to complete first and then unlock to do other thread. We will use it when we use a share resource.

3.4 We write it to unlock the thread after it finish and then do other thread.

## 4. Counter with synchronized method

4.1 Total is zero.

4.2 Because synchronized method will do only one thread until it finished.

4.3 Synchronized will make this method can't be tell more than one at the same time. It should use when we use a share resource.

## 5. Counter with AtomicLong

5.1 Because AtomicLong is already a safe thread for long. It's already locked.

5.2 We use it when we use a same resource.

## 6. Analysis of Results

6.1 AtomicLong is the fastest. ReentrantLock is the slowest.

6.2 Synchronized. Because it is more flexible and the run time is faster than ReentrantLock.

## 7. Using Many Threads (optional)

