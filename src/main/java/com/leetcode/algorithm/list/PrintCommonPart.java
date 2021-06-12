package com.leetcode.algorithm.list;

import com.leetcode.algorithm.list.Node.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @ ClassName PrintCommonPart
 * @ author lskyline
 * @ 2021/6/10 9:58
 * @ Version: 1.0
 */
public class PrintCommonPart {
    /*
     * 打印两个升序链表的公共部分
     */
    public void printCommonPart(ListNode head1, ListNode head2) {
        System.out.println("Common part:");
        while (head1 != null && head2 != null) {
            if (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    head1 = head1.next;
                } else if (head1.val > head2.val) {
                    head2 = head2.next;
                } else {
                    System.out.print(head1.val + " ");
                    head1 = head1.next;
                    head2 = head2.next;
                }
            }
        }
        System.out.println();
    }

    private static ListNode listGenerator(int length, String[] numbers) {
        ListNode head = new ListNode(Integer.parseInt(numbers[0]));
        ListNode cur = head;
        for (int i = 1; i < length; i++) {
            cur.next = new ListNode(Integer.parseInt(numbers[i]));
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] numbers1 = bufferedReader.readLine().split(" ");
        int m = Integer.parseInt(bufferedReader.readLine());
        String[] numbers2 = bufferedReader.readLine().split(" ");
        ListNode head1 = listGenerator(n, numbers1);
        ListNode head2 = listGenerator(m, numbers2);
        PrintCommonPart obj = new PrintCommonPart();
        obj.printCommonPart(head1, head2);
    }

}
