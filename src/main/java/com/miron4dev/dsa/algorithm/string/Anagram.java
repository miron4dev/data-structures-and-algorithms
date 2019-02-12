package com.miron4dev.dsa.algorithm.string;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 */
public class Anagram {

    private final String s;

    public Anagram(String s) {
        this.s = s;
    }

    public boolean isAnagram(String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] temp = new int[26];
        for (char c : s.toCharArray()) {
            temp[c - 'a'] = temp[c - 'a'] + 1;
        }
        for (char c : t.toCharArray()) {
            temp[c - 'a'] = temp[c - 'a'] - 1;
        }
        for (int i : temp) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
