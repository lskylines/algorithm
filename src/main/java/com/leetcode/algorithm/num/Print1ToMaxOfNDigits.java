package com.leetcode.algorithm.num;

/**
 * @ ClassName Print1ToMaxOfNDigits
 * @ author lskyline
 * @ 2021/4/20 10:53
 * @ Version: 1.0
 */
public class Print1ToMaxOfNDigits {
    /*
     * 从1打印到最大的N位数
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return ;
        }
        char[] numbers = new char[n];
        backtrack(numbers, 0);
    }

    public void backtrack(char[] numbers, int digit) {
        if (digit == numbers.length) {
            printNum(numbers);
            return ;
        }
        for (int i = 0; i < 10; i++) {
            numbers[digit] = (char)(i + '0');
            backtrack(numbers, digit + 1);
        }
    }

    public void printNum(char[] numbers) {
        int index = 0;
        while (index < numbers.length && numbers[index] == '0') {
            index++;
        }
        while (index < numbers.length) {
            System.out.print(numbers[index++]);
        }
        System.out.println();
    }



    public static void main(String[] args) {
        int n = 3;
        Print1ToMaxOfNDigits obj = new Print1ToMaxOfNDigits();
        obj.print1ToMaxOfNDigits(n);
    }
}
