package com.leetcode.algorithm.sort;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @Description 对字符串进行排序
 * 要求: 小写字母的放到前面，大写字母放在最后，数字放在中间，不用排序算法，要怎么解决呢？
 * 运用双指针进行处理, 首先对小写字母和数字与大写字母进行区分,然后在对小写字母与数字进行区分
 * 而双指针的终止条件是头尾指针相遇
 * @Author lskyline
 * @Date 2020-03-28 15:24:35
 */
public class HandleLetterAndNumber {

    public static Character[] handleLetterAndNumber(Character[] originalArray) {

        int tail = handler(originalArray, c -> Character.isLowerCase(c) || Character.isDigit(c), originalArray.length - 1);
        handler(originalArray, c -> Character.isLowerCase(c), tail);
        return originalArray;
    }

    private static <T> int handler(T[] originalArray, Predicate<T> predicate, int tail) {
        int head = 0;
        while (head <= tail) {
            if (!predicate.test(originalArray[head])) {
                if (predicate.test(originalArray[tail])) {
                    swap(head, tail, originalArray);
                } else {
                    tail --;
                }
            } else {
                head++;
            }
        }
        return tail;
    }

    private static <T> void swap(int preIndex, int afterIndex, T[] arr) {
        T temp = arr[preIndex];
        arr[preIndex] = arr[afterIndex];
        arr[afterIndex] = temp;
    }



    public static void main(String[] args) {
        Character[] letter = handleLetterAndNumber(
                new Character[]{'A', 'a', '1', 'b', 'B', 'g', '6', 't', '8', 'L', 'd'});
        System.out.println(Arrays.toString(letter));
    }
}