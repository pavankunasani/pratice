package com.java.eight;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

import org.junit.jupiter.api.Test;

class EightPratice {

	@Test
	void transFormers() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		numbers.forEach((value) -> System.out.print(value));
		System.out.println();
//		numbers.forEach(System.out::println);

		numbers.stream()
				// .map(e ->String.valueOf(e))
				.map(String::valueOf).map(TestingOne::data).forEach(System.out::print);
	}

	@Test
	void transFormersTwo() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		numbers.forEach(System.out::println);

		Optional<Integer> data = numbers.stream()
				// .map(e ->String.valueOf(e))
				// .map(String::valueOf)
				.reduce((total, e) -> Integer.sum(total, e));
//
		if (data.isPresent())
			System.out.println(data.get());

		// String info = numbers.stream().map(String::valueOf).reduce("", (carry, str1)
		// -> carry.concat(str1));

		// String info = numbers.stream().map(String::valueOf).reduce("",
		// String::concat);

		Optional<String> info = numbers.stream().map(String::valueOf).reduce((carry, str1) -> carry.concat(str1));
		System.out.println(info.get());
	}

	@Test
	public void reduce() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		Integer reduceOut = numbers.stream()
				// .reduce(0, (total, e) -> Integer.sum(total, e));
				.reduce(0, Integer::sum);
		System.out.println(reduceOut);

	}

	@Test
	public void filterProcess() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		int result = 0;
		for (int e : numbers) {

			if (e % 2 == 0) {
				result += e * 2;
			}
		}

		System.out.println(result);

		int totalval = numbers.stream().filter(e -> e % 2 == 0).mapToInt(e -> e * 2).sum();
		System.out.println(totalval);
	}

	@Test
	public void manuplicationTest() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Integer first = numbers.stream().filter(e -> e % 2 == 0).map(e -> e * 2).reduce(0, Integer::sum);

		int second = numbers.stream().filter(e -> e % 2 == 0).mapToInt(e -> e * 2).sum();

		System.out.println("First: " + first);

	}

	@Test
	public void collectExample() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		numbers.stream().filter(e -> e % 2 == 0).map(e -> e * 2).collect(toList());

	}

	@Test
	public void performanceTest() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int result = 0;
		for (int e : numbers) {
			if (e > 3 && e % 2 == 0) {
				result = e * 2;
				break;
			}
		}
		System.out.println(result);

		System.out.println(numbers.stream().filter(e -> e > 3).filter(e -> e % 2 == 0).map(e -> e * 2).findFirst());

	}

	@Test
	public void properties() {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 4, 6, 5, 7, 8, 9, 10);

		numbers.stream().sorted().forEach(System.out::print);
		System.out.println();
		numbers.stream().distinct().forEach(System.out::print);

	}

	@Test
	public void infiniteStream() {
		int k = 100;
		Stream<Integer> s = Stream.iterate(k, e -> e + 1);

		s.forEach(System.out::print);

	}
}
