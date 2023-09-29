# Java Class to Execute Threads classes
### This is where we test the CPU performance. Why Infinite Loop is bad!

## First execute
The CPU usage rose from 0% to 60% <br>
Last cancellation and it dipped to 7% usage

## Second Execute
The CPU usage increased to 70% <br>
When cancelled after third, it decreased to 40%

## Third Execute
The CPU usage goes to 90%. I am even writing this while the CPU was high af. <br>
I started to cancel the process from here, it decreased to 50-60%


## When I placed the Sleep()
It was within the while loop. Surprisingly, the CPU usage was not increased fortunately