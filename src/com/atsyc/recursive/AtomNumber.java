package com.atsyc.recursive;


import java.util.Map;
import java.util.TreeMap;

/**
 * https://www.codeleading.com/article/94041007803/
 */
public class AtomNumber {

    // 全局指针
    private static int i = 0;

    public static void main(String[] args) {
        System.out.println(countOfAtoms("Mg(OH)2"));
    }

    public static String countOfAtoms(String formula) {
        Map<String, Integer> res = parse(formula.toCharArray());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,Integer> entry : res.entrySet()){
            sb.append(entry.getKey());
            if(entry.getValue()!=1){
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }


    public static Map<String, Integer> parse(char[] arr) {

        Map<String, Integer> res = new TreeMap<>();

        Map<String, Integer> tmp = new TreeMap<>();
        while (i < arr.length) {

            if (arr[i] == '(') {
                i++;
                String atom = countAlpha(arr);
                int cnt = countDigit(arr);
                tmp.put(atom, cnt);
                continue;
            }
            if (arr[i] == ')') {
                i++;
                int mul = countDigit(arr);
                for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
                    tmp.put(entry.getKey(), entry.getValue() * mul);
                }
                addMap(res,tmp);
                tmp.clear();
                continue;
            }
            if (tmp.isEmpty()) {
                String atom = countAlpha(arr);
                int cnt = countDigit(arr);
                res.put(atom, cnt);
            } else {
                String atom = countAlpha(arr);
                int cnt = countDigit(arr);
                tmp.put(atom, cnt);
            }
        }
        return res;
    }


    // 返回分子的个数
    public static int countDigit(char[] array) {
        StringBuilder sb = new StringBuilder();
        while (i < array.length && Character.isDigit(array[i])) {
            sb.append(array[i]);
            i++;
        }
        return "".equals(sb.toString()) ? 1 : Integer.valueOf(sb.toString());
    }


    // 计算得到原子符号
    public  static String countAlpha(char[] array) {
        StringBuilder sb = new StringBuilder();
        while (i < array.length && ("".equals(sb.toString()) || Character.isLowerCase(array[i]))) {
            sb.append(array[i]);
            i++;
        }
        return sb.toString();
    }

    private  static void addMap(Map<String, Integer> t1, Map<String, Integer> t2) {
        if (t2.isEmpty()) {
            return;
        }
        for (String key : t2.keySet()) {
            if (t1.containsKey(key)) {
                t1.put(key, t1.get(key) + t2.get(key));
            } else {
                t1.put(key, t2.get(key));
            }
        }
    }






}
