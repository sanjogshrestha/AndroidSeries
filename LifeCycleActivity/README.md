# Android Activity Life Cycle

As a user navigates throughout an app, Android maintains the visited activities in a stack, with the currently visible activity always placed at the top of the stack. 

At any point in time a particular activity can be in one of the following 4 states:

| Activity State | Description |
| -------------- |-------------|
| Running | Activity is visible and interacting with the user |
| Paused | Activity is still visible, but no longer interacting with the user |
| Stopped | Activity is no longer visible |
| Killed | Activity has been killed by the system (low memory) or its `finish()` method has been called |

## Activity Lifecycle

The following diagram shows the important state paths of an Activity. The square rectangles represent callback methods you can implement to perform operations when the Activity moves between states. These are described further in the table below the diagram.

![Imgur](https://i.imgur.com/aUd1KA1.png)
