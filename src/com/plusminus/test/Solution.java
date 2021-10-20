package com.plusminus.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

class Result {
	/*
	 * Complete the 'plusMinus' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void plusMinus(List<Integer> arr) {
		if(arr.size()< 0 || arr.size()> 100) {
			return;
		}
		HashMap<String, Integer> numbers = new HashMap<String, Integer>();
		int count;
		String key = "";
		for (Integer item : arr) {
			if(item< -100 || item > 100) {
				return;
			}
			if (item > 0) {
				key = "positive";
			} else if (item == 0) {
				key = "zero";
			} else {
				key = "negative";
			}
			if (numbers.get(key) == null) {
				count = 0;
			} else {
				count = numbers.get(key);
			}
			numbers.put(key, ++count);
		}

//		for (String item : numbers.keySet()) {
			
			printResult("positive", numbers, arr.size());
			System.out.println();
			printResult("negative", numbers, arr.size());
			System.out.println();
			printResult("zero", numbers, arr.size());
			
//		}
	}

	public static void printResult(String key , HashMap<String, Integer> map, int size) {
		if(!map.containsKey(key)) {
			map.put(key, 0);
		}
		System.out.format("%.6f", (double) map.get(key) / size);
		
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		Result.plusMinus(arr);

		bufferedReader.close();
	}
}
