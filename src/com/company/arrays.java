package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class arrays {

    private static List<Integer> rotLeft(List<Integer> a, int d) {

        for (int i = 0; i < d; i++) {
            int temp = a.remove(0);
            a.add(temp);
        }
        return a;
    }

    private static void minimumBribes(List<Integer> q) {
        int swaps = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) != (i + 1)) {
                if (i - 1 >= 0 && q.get(i - 1) == i + 1) {
                    int temp = q.get(i);
                    q.set(i,q.get(i - 1));
                    q.set(i - 1, temp);
                    swaps++;
                } else if ((i - 2 >= 0) && q.get(i - 2) == i + 1) {
                    int temp = q.get(i - 2);
                    q.set(i - 2, q.get(i - 1));
                    q.set(i - 1, q.get(i));
                    q.set(i, temp);
                    swaps += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swaps);
    }


    public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(5);
    list.add(3);
    list.add(7);
    list.add(8);
    list.add(6);
    list.add(4);
    minimumBribes(list);
    }
}
