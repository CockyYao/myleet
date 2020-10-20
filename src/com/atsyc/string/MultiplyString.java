package com.atsyc.string;

/**
 * Created by doubleyao on 2020-10-19.
 */
public class MultiplyString {

    public static String multiply(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int len = arr1.length + arr2.length;
        int[] res = new int[len];
        for (int i = arr1.length - 1; i >= 0; i--) {
            for (int j = arr2.length - 1; j >= 0; j--) {
                int y = arr2[j] - '0';
                int x = arr1[i] - '0';
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = x * y + res[p2];
                res[p2] = sum % 10;
                res[p1] = res[p1] + (sum / 10);
            }
        }
        int k = 0;
        while (k < res.length && res[k] == 0) {
            k++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = k; i < res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test("123","456");
    }

    public static String test(String num1, String num2){
        if (num1 == null || num2 == null) {
            return null;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        int[] resInts = new int[length1 + length2];
        int sum = 0;

        // 计算 结果数组 的 每一位的值
        for (int i = length1 - 1; i >= 0 ; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                sum = (chars1[i] - '0') * (chars2[j] - '0') + resInts[i + j + 1];
                resInts[i + j + 1] = sum % 10;  // 当前位 仅保存 计算结果的 个位
                resInts[i + j] += sum/10;   // 进位值 += 就算值/10 （注意：此处的 进位值 的 ‘+=’ 操作是因为可能还有别的数组单元也会进到此位）
            }
        }

        // 将 int数组 转换为 字符串
        StringBuilder resStr = new StringBuilder();
        for (int i = 0; i < length1 + length2; i++) {
            if (i == 0 && resInts[i] == 0) {    // 首位 不一定 进位
                continue;
            }
            resStr.append(resInts[i]);
        }
        return resStr.toString();
    }

}
