package ru.krsu;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        //task 1
        System.out.println(reverseString("qwerty"));
        //task 2
        System.out.println(isPalindrome("Он - верба, но Она - бревно"));
        //task 3
        printMap(countSymbols("финанссофт"));
    }
    //task 1
    /*Реализовать алгоритм переворота строки (Reverse string)
    не используя сторонних библиотек.
    Пример: "qwerty" -> "ytrewq"*/
    public static String reverseString(String str){
        char[] reverse = new char[str.length()];
        for(int i = 0, j = reverse.length - 1; i < j || i == j; i++, j--){
            reverse[j]  = str.charAt(i);
            reverse[i] = str.charAt(j);
        }
        return new String(reverse);
    }
    //task 2
    /*Реализовать алгоритм определения строки-палиндрома.
    Палиндром - это строка которая читается зеркально (то есть и слева-направо и справа-налево одинаково).
    Например:  "Потоп", "Топот",  и т.д.
    Для усложнения задания можете попробовать улучшить алгоритм чтобы он распознавал не только слова но и выражения.
    Например: "Спел Лепс", "А роза упала на лапу Азора", "Он - верба, но Она - бревно" и т.д. в интернете по запросу куча примеров*/
    public static boolean isPalindrome(String str){
        String strFormatted = formatString(str);
        for(int i = 0, j = strFormatted.length() - 1; i < j || i == j; i++, j--){
            if(strFormatted.charAt(i) != strFormatted.charAt(j)) return false;
        }
        return true;
    }
    public static String formatString(String str){
        return str.replaceAll("[^a-zA-ZА-Яа-я0-9]", "").toLowerCase();
    }
    //task 3
    /*Реализовать алгоритм который подсчитывает количество вхождений каждого из символов в строке.
    Пример: "финанссофт" -> ф : 2, и : 1, н : 2, с : 2, о : 1, а : 1
    "Евгений" -> е : 2, в : 1, г : 1, н : 1, и : 1, й : 1*/
    public static Map<Character, Integer> countSymbols(String str){
        String strFormatted = str.toLowerCase();
        Map<Character, Integer> map = new TreeMap<>();
        for(var c: strFormatted.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
        }
        return map;
    }
    public static void printMap(Map<Character, Integer> map){
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
