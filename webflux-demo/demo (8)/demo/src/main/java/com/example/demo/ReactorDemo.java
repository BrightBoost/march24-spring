package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactorDemo {

    public static void main(String[] args) {

        // Creational Operator: Just
// This operator creates a Flux (publisher) from the specified elements (book titles).
        Flux<String> bookTitles = Flux.just("The Hobbit", "Moby Dick", "War and Peace");

// Map
// The map operator applies a synchronous transformation function to each item emitted by the publisher.
// Here, it converts each book title to uppercase.
        Flux<String> uppercaseTitles = bookTitles.map(String::toUpperCase);
        System.out.println("Map Operator:");
        uppercaseTitles.subscribe(System.out::println);

// FlatMap
// The flatMap operator applies a function to each item emitted by the publisher and then flattens the
// resulting publishers into a single publisher. This is useful for asynchronous operation, such as
// making a request for each item. Here, it returns the author for each book title.
        Flux<String> authors = bookTitles.flatMap(title -> {
            if (title.equals("The Hobbit")) {
                return Mono.just("J.R.R. Tolkien");
            } else if (title.equals("Moby Dick")) {
                return Mono.just("Herman Melville");
            } else {
                return Mono.just("Leo Tolstoy");
            }
        });
        System.out.println("\nFlatMap Operator:");
        authors.subscribe(System.out::println);

// Merge
// The merge operator combines multiple publishers into a single publisher by merging their emissions.
// It interleave items as they are emitted, which means the merged sequence can be in any order.
        Flux<String> series1 = Flux.just("Harry Potter", "Hermione Granger");
        Flux<String> series2 = Flux.just("Ron Weasley", "Ginny Weasley");
        Flux<String> mergedSeries = Flux.merge(series1, series2);
        System.out.println("\nMerge Operator:");
        mergedSeries.subscribe(System.out::println);

// Concat
// The concat operator combines multiple publishers into a single publisher by concatenating their sequences.
// It preserves the order of sequences; items from series2 will be emitted only after series1 completes.
        Flux<String> concatSeries = Flux.concat(series1, series2);
        System.out.println("\nConcat Operator:");
        concatSeries.subscribe(System.out::println);

// Zip
// The zip operator combines two or more publishers by aggregating their corresponding items (pairwise)
// into a tuple or into a value created by a provided combinator function. Here, it combines characters
// from two series into a string that represents a pair.
        Flux<String> zippedFlux = Flux.zip(
                series1,
                series2,
                (character1, character2) -> character1 + " and " + character2
        );
        System.out.println("\nZip Operator:");
        zippedFlux.subscribe(System.out::println);

    }
}

