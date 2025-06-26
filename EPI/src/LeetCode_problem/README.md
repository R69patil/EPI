# LeetCode Problem Solutions

This directory contains Java solutions to selected problems from LeetCode. Each file typically corresponds to a single LeetCode problem.

Currently, this directory includes:

- **Missing_number.java**: Solves the "Missing Number" problem (LeetCode #268). Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, the task is to find the only number in the range that is missing from the array.
  - *Common Approaches*:
    - Summation: Calculate the expected sum of numbers from 0 to n and subtract the sum of elements in the array.
    - Bitwise XOR: XOR all numbers from 0 to n, then XOR all elements in the array. The result will be the missing number.
    - Cyclic Sort (if applicable to constraints).

More solutions to LeetCode problems may be added here over time.
