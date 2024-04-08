package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactorSolution {

    public static void main(String[] args) {

        // Exercise 1: Basic Flux Creation and Subscription (Easy)
        Flux<String> movieTitles = Flux.just("Inception", "The Matrix", "Interstellar");
        movieTitles.subscribe(System.out::println);

        // Exercise 2: Mapping and Filtering a Flux (Moderate)
        Flux<Integer> numbers = Flux.range(1, 10);
        numbers.map(number -> number * number)
                .filter(number -> number % 2 == 0)
                .subscribe(System.out::println);

        // Exercise 3: Combining Multiple Streams with Zip (Moderately Challenging)
        Flux<String> names = Flux.just("Gaia", "Jonas", "Bobby");
        Flux<String> colors = Flux.just("Yellow", "Orange", "Red");
        Flux.zip(names, colors, (name, color) -> name + "'s favorite color is " + color)
                .subscribe(System.out::println);

        // Exercise 4: FlatMapping a Flux to Perform Async Operations (Challenging)
        Flux<String> userIds = Flux.just("user1", "user2", "user3");
        userIds.flatMap(userId ->
                        Mono.delay(Duration.ofMillis(100))
                                .thenReturn("Fetched details for " + userId))
                .subscribe(System.out::println);

        // Exercise 5: Handling Errors in a Reactive Stream (Advanced)
        Flux<Integer> integers = Flux.range(-2, 5); // Generates -2 to 2
        integers.map(number -> 1 / number)
                .onErrorResume(e -> Mono.just(0)) // Fallback to 0 on error (e.g., division by zero)
                .subscribe(System.out::println);
    }
}
