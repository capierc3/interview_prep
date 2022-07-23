package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class strings {

    public static int makeAnagram(String a, String b) {
        // Write your code here
        int del = 0;
        char[] aA = a.toCharArray();
        char[] bA = b.toCharArray();

        for (int i = 0; i < aA.length; i++) {
            if (!b.contains(Character.toString(aA[i]))) {
                aA[i] = ' ';
                del++;
            }
        }
        a = new String(aA).replace(" ","");
        System.out.println(a);
        System.out.println(b);
        System.out.println(del);
        for (int i = 0; i < bA.length; i++) {
            if (!a.contains(Character.toString(bA[i]))) {
                bA[i] = ' ';
                del++;
            }
        }
        Arrays.sort(aA);
        Arrays.sort(bA);

        System.out.println(aA);
        System.out.println(bA);
        return del;
    }

    public static boolean isUnique(String a) {
        char[] s = a.toCharArray();
        Arrays.sort(s);
        for (int i = 0; i < s.length; i++) {
            if (i + 1 != s.length && s[i] == s[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static char[] urlify(char[] a) {

        int marker = a.length - 1;
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] != 0 && a[i] != ' ') {
                a[marker] = a[i];
                 marker--;
            } else if (a[i] != 0 && a[i] == ' ') {
                a[marker] = '0';
                a[--marker] = '2';
                a[--marker] = '%';
                marker--;
            }
        }
        return a;
    }

    public static void isPal(String s) {
        char[] a = s.replace(" ","").toLowerCase().toCharArray();
        Arrays.sort(a);
        char[] f = new char[a.length/2];
        char[] b = new char[a.length/2];
        char odd = ' ';
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (i + 1 >= a.length) {
                if (odd == ' ') {
                    odd = a[i];
                } else {
                    System.out.println("End false");
                    return;
                }
            } else {
                if (a[i] == a[i + 1]) {
                    f[j] = a[i];
                    b[j] = a[++i];
                    j++;
                } else if (a[i] != a[i + 1] && odd == ' ') {
                    odd = a[i];
                } else {
                    System.out.println(a[i] + " " + a[i+1]);
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(f);
        System.out.println(b);
        System.out.println(odd);


    }

    public static boolean edits(String s1, String s2) {

        int edits = 0;
        if (s1.length() - s2.length() > 1 || s2.length() - s1.length() > 1) {
            return false;
        } else {
            int j = s2.length() - 1;
            int i = s1.length() - 1;
            while (j >= 0 && i >= 0 && edits <= 1) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (s1.charAt(i) != s2.charAt(j)) {
                        if (s1.charAt(i) == s2.charAt(j - 1)) {
                            edits++;
                            j--;
                        } else if (s1.charAt( i - 1) == s2.charAt(j)){
                            edits++;
                            i--;
                        } else {
                            return false;
                        }
                    }
                } else if (s1.charAt(i) != s2.charAt(j)) {
                    edits++;
                    if (i == 0) j++;
                    if (j == 0) j++;
                } else {
                    return true;
                }
                i--;
                j--;
            }
            return edits <= 1;
        }
    }



    public static void main(String[] args) {
        System.out.println(edits("pale", "bake"));
    }
}
