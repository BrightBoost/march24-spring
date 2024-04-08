package com.example.demo;

public class ReactorExercise {

    public static void main(String[] args) {
        // Exercise 1: Create a Flux that emits three favorite movie titles,
        // subscribe to it, and print each title to the console.

        // Your code for Exercise 1 here


        // Exercise 2: Create a Flux that emits numbers from 1 to 10, then apply
        // a map operator to square each number, and finally use a filter operator
        // to retain only those that are even.

        // Your code for Exercise 2 here


        // Exercise 3: Create two Flux instances, one emitting the first names of three friends,
        // and another emitting their favorite colors. Use the zip operator to combine these Flux instances into one
        // that emits strings combining each name with the corresponding favorite color.

        // Your code for Exercise 3 here


        // Exercise 4:  Simulate an asynchronous data-fetch operation by using flatMap. Given a Flux of user IDs,
        // use flatMap to simulate fetching user details for each ID asynchronously
        // (mock this with a Mono.delay and then return the user's name).

        // Your code for Exercise 4 here


        // Exercise 5: Create a Flux that processes a list of integers and inverses each number (1/n).
        // Use error handling to catch any arithmetic exceptions (like division by zero)
        // and fallback to a default value.

        // Your code for Exercise 5 here
    }
}


// STEP BY STEP

// Exercise 1 Tasks:
// 1. Use the Flux.just() method to create a Flux that emits three movie titles.
// 2. Subscribe to the Flux and use System.out.println to print each title.


// Exercise 2 Tasks:
// 1. Use Flux.range to create a Flux that emits numbers from 1 to 10.
// 2. Use the map operator to square each number.
// 3. Use the filter operator to retain only even numbers.
// 4. Subscribe to the resulting Flux and print each value.


// Exercise 3 Tasks:
// 1. Create two Flux instances: one for names and one for colors.
// 2. Use Flux.zip to combine these streams, forming a sentence like "Alex's favorite color is Blue" for each pair.
// 3. Subscribe to the resulting Flux and print each combined string.


// Exercise 4 Tasks:
// 1. Create a Flux that emits several user IDs.
// 2. Use flatMap to simulate an asynchronous fetch for each user's name.
//    Mock the fetch operation with Mono.delay(Duration.ofMillis(100)).thenReturn("User Name").
// 3. Subscribe to the resulting Flux and print each user's name along with a message indicating the fetch is complete.


// Exercise 5 Tasks:
// 1. Create a Flux from a list of integers (e.g., 0 to 5).
// 2. Use the map operator to inverse each number (1/n).
// 3. Apply error handling to catch any ArithmeticException and fallback to a default value (e.g., 0).
// 4. Subscribe to the Flux and print each result or fallback value.