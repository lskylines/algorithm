package com.leetcode.algorithm.num;

/**
 * @ ClassName AddNum
 * @ author lskyline
 * @ 2021/4/22 10:43
 * @ Version: 1.0
 */
public class AddNum {
    /*
     * 两个超级大数相加
     */
    public String addString(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum /  10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "12345";
        String num2 = "2345";
        AddNum obj = new AddNum();
        String str = obj.addString(num1, num2);
        System.out.println(str);
    }
}
