package com.company;

import java.util.*;

public class Leet {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }


    // Problem answers
    public static boolean isIsomorphic(String s, String t) {

        return true;
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedHash = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        int amt = 0;
        String res = "";
        HashMap<String,Integer> counts = new HashMap<>();
        for (String word: words) {
            if (!bannedHash.contains(word)) {
                counts.merge(word, 1, Integer::sum);
                if (counts.get(word) > amt) {
                    amt = counts.get(word);
                    res = word;
                }
            }
        }
        return res;
    }

    public static int shortestSubarray(int[] nums, int k) {

        int shortest = nums.length + 1;
        HashMap<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) return 1;
            values.put(i,nums[i]);
            int addSpot = 0;
            while (addSpot < i) {
                if (values.get(addSpot) != k) {
                    values.put(addSpot, values.get(addSpot) + nums[i]);
                    if (values.get(addSpot) == k) {
                        shortest = Math.min(shortest, i);
                    }
                }
                addSpot++;
            }
        }
        for (Map.Entry<Integer, Integer> value : values.entrySet()) {
            if (value.getValue() == k) {
                System.out.println(value.getKey());
                shortest = Math.min(shortest, nums.length - value.getKey());
            }
        }
        if (shortest == nums.length + 1) return -1;
        return shortest;
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int longest = releaseTimes[0];
        char button = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            if (longest < releaseTimes[i] - releaseTimes[i - 1]) {
                longest = releaseTimes[i] - releaseTimes[i - 1];
                button = keysPressed.charAt(i);
            } else if (longest == releaseTimes[i] - releaseTimes[i - 1]) {
                if (button < keysPressed.charAt(i)) {
                    button = keysPressed.charAt(i);
                }
            }
        }
        return button;
    }

    public static boolean isSymmetric(TreeNode root) {
        return sidesEqual(root.left, root.right);
    }
    public static boolean sidesEqual(TreeNode left, TreeNode right) {;
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        // check outside
        if (!sidesEqual(left.left, right.right)) {
            return false;
        }
        if (!sidesEqual(left.right, right.left)) {
            return false;
        }
        return left.val == right.val;
    }

    public static int[] numMovesStones(int a, int b, int c) {
        int low = Math.min(Math.min(a,b),c);
        int high = Math.max(Math.max(a,b),c);
        int mid = (a+b+c) - (low + high);
        int[] result = {1,0};
        //both touch
        if (mid - low == 1 && high - mid == 1) {
            result[0] = 0;
            return result;
        }
        //lower two touch
        else if (mid - low == 1 && high - mid != 1){
            result[1] = high - mid - 1;
        }
        // higher two touch
        else if (mid - low != 1 && high - mid == 1) {
            result[1] = mid - low - 1;
        }
        // neither touch
        else {
            if (mid - low > 2 && high - mid > 2) {
                result[0] = 2;
            }
            result[1] = (high - mid - 1) + (mid - low - 1);
        }
        return result;
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder reversedString = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                reversedString.append(" ");
            }
            StringBuilder temp = new StringBuilder(words[i]);
            temp.reverse();
            reversedString.append(temp);
        }
        return reversedString.toString();
    }

    public static boolean divideArray(int[] nums) {
        if (nums.length %2 == 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            if (nums[i] != nums[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase(Locale.ROOT);
        s = s.replaceAll("[^a-zA-Z\\d]", "");
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static int reverse (int x) {
        boolean neg = false;
        if (x < 0) {
            x *= -1;
            neg = true;
        }
        int divisor = 1;
        int length = (int) (Math.log10(x) + 1);
        if (length > 10) return 0;
        for (int i = 1; i < length; i++) {
            divisor *= 10;
        }
        int num;
        int multi = 1;
        long reversNum = 0;
        while (divisor >= 1) {
            num = x/divisor;
            reversNum += (long) num * multi;
            if (reversNum >>> 32 != 0) {
                return 0;
            }
            multi *= 10;
            x = x - (num * divisor);
            divisor /= 10;
        }
        if ((int) reversNum < 0) return 0;
        if (neg) return (int) (reversNum * -1);
        return (int) reversNum;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Idx = 0;
        int nums2Idx = 0;
        int[] combine = new int[nums1.length + nums2.length];
        int combineIdx = 0;
        while (combineIdx < combine.length) {
            if (nums1Idx < nums1.length && nums2Idx < nums2.length) {
                if (nums1[nums1Idx] < nums2[nums2Idx]) {
                    combine[combineIdx] = nums1[nums1Idx];
                    combineIdx++;
                    nums1Idx++;
                } else if (nums1[nums1Idx] > nums2[nums2Idx]) {
                    combine[combineIdx] = nums2[nums2Idx];
                    combineIdx++;
                    nums2Idx++;
                } else {
                    combine[combineIdx] = nums1[nums1Idx];
                    combineIdx++;
                    combine[combineIdx] = nums2[nums2Idx];
                    combineIdx++;
                    nums1Idx++;
                    nums2Idx++;
                }
            } else if (nums1Idx >= nums1.length) {
                combine[combineIdx] = nums2[nums2Idx];
                combineIdx++;
                nums2Idx++;
            } else {
                combine[combineIdx] = nums1[nums1Idx];
                combineIdx++;
                nums1Idx++;
            }
        }
        int mid = combine.length / 2;
        if (combine.length % 2 == 0) {
             return (combine[mid] + combine[mid - 1]) / 2.0;
        } else {
            return combine[mid];
        }

    }

    public static ListNode reverseList(ListNode l1) {
        ListNode head, tail, temp;
        head = l1.next;
        tail = l1;
        tail.next = null;
        while (head != null) {
            temp = head;
            head = temp.next;
            temp.next = tail;
            tail = temp;
        }
        return tail;
    }

    public static int singleNum (int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (i+1 == nums.length) {
                return nums[i];
            }
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        int carry = 0;
        while (true) {
            if (l1 != null && l2 != null) {
                int add = l1.val + l2.val;
                if (carry == 1) {
                    add++;
                    carry = 0;
                }
                if (add >= 10) {
                    add -= 10;
                    carry = 1;
                }
                temp.val = add;
                l1 = l1.next;
                l2 = l2.next;
                if (l1 != null && l2 != null) {
                    temp.next = new ListNode();
                    temp = temp.next;
                }
            } else if (l2 != null){
                temp.next = new ListNode(l2.val + carry);
                if (temp.next.val >= 10) {
                    temp.next.val -= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                l2 = l2.next;
                temp = temp.next;
            } else if (l1 != null) {
                temp.next = new ListNode(l1.val + carry);
                if (temp.next.val >= 10) {
                    temp.next.val -= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                l1 = l1.next;
                temp = temp.next;
            } else {
                if (carry == 1) {
                    temp.next = new ListNode(1);
                }
                break;
            }
        }
        return result;
    }

    public static int[] twoSum (int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (temp == nums[j]) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{};
    }

}

//Given classes

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 //Definition for a binary tree node.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
  }
