package com.miron4dev.dsa.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {

	public int[] solve(int[] T) {
		int[] result = new int[T.length];
		Stack<Integer> stack = new Stack<>();

		// iterate from the end
		// clear stack while current elem is greater than latest
		// put index of current elem to stack
		for (int i = T.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
				stack.pop();
			}
			result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return result;
	}
}
