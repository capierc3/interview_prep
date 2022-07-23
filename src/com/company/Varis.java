package com.company;

import java.util.HashSet;
import java.util.Set;

public class Varis {

    public static void main(String[] args) {
        int[] A = {3,2,-2,5,-3};
        System.out.println(solution(A));

    }

    public static int solution(int[] A) {
        // base value
        int value = 0;
        // create a list to check for duplicates
        Set<Integer> ints = new HashSet<>();
        for (int j : A) {
            // if the list already has the opposite sign of the num check if its higher
            if (ints.contains(j * -1)) {
                if (Math.abs(j) > value) {
                    value = Math.abs(j);
                }
            }
            // add to list
            ints.add(j);
        }
        return value;
    }

//    public static int solution(int N, int K) {
//        // N and K kept throwing me off.
//        int liters = K;
//        int bigCup = N;
//        int fullCups = 0;
//
//        while (liters > 0) {
//            // Not enough
//            if (bigCup == 0) {
//                return -1;
//            }
//            // fill the big cup
//            fullCups++;
//            //use what ever cup is needed to hold the rest
//            if (bigCup >= liters) {
//                break;
//            }
//            // big cup is used, remove liquid and go to next biggest cup
//            else {
//                liters = liters - bigCup;
//                bigCup--;
//            }
//        }
//        return fullCups;
//    }

//    public static String solution(int N, int K) {
//        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
//        Random rand = new Random();
//        ArrayList<Character> characters = new ArrayList<>();
//        while (characters.size() < K) {
//            int idx = rand.nextInt(alpha.length);
//            if (!characters.contains(alpha[idx])) {
//                characters.add(alpha[idx]);
//            }
//        }
//        StringBuilder word = new StringBuilder();
//        int len = N/2;
//        if (N%2 == 1) {
//            len -= 1;
//        }
//        for (Character character : characters) {
//            word.append(character);
//        }
//        while (word.length() < (len)) {
//            word.append(characters.get(rand.nextInt(characters.size())));
//        }
//        String start = word.toString();
//        String end = word.reverse().toString();
//        System.out.println(len);
//        if (len == 0) {
//            return start + word.charAt(1);
//        }
//        if (N%2 == 0) {
//            return start + end;
//        } else {
//            return start + characters.get(rand.nextInt(characters.size())) + end;
//        }
//    }


//    public static int solution(int[] A) {
//
//        int low = 1;
//        Arrays.sort(A);
//        for (int j : A) {
//            if (j > 0) {
//                if (j > low) {
//                    return low;
//                }
//                if (j == low) {
//                    low++;
//                }
//            }
//        }
//        return low;
//    }

}
