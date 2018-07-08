# Dive Into Offer

[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/xlui/dive-into-offer/blob/master/LICENSE)

In order to get a job offer, I'm now training myself through [LeetCode](https://leetcode.com), and I'd like to share my code here.

This project won't stop until it contains all the problems in leetcode.

## Table of Contents

- [1. Two Sum](#1)
- [4. Median of Two Sorted Arrays](#4-median-of-two-sorted-arrays)
- [7. Reverse Integer](#7-reverse-integer)
- [10. Regular Expression Matching](#10)
- [15. 3Sum](#15-3Sum)
- [16. 3Sum Closest](#16-3sum-closest)
- [24. Swap Nodes in Pairs](#24-swap-nodes-in-pairs)
- [28. Implement strStr()](#28)
- [33. Search in Rotated Sorted Array](#33-search-in-rotated-sorted-array)
- [38. Count and Say](#38)
- [39. Combination Sum](#39)
- [40. Combination Sum II](#40-combination-sum-ii)
- [41. First Missing Positive](#41-first-missing-positive)
- [49. Group Anagrams](#49-group-anagrams)
- [62. Unique Paths](#62-unique-paths)
- [76. Minimum Window Substring](#76-minimum-window-substring)
- [83. Remove Duplicates from Sorted List](#83-remove-duplicates-from-sorted-list)
- [100. Same Tree](#100)
- [101. Symmetric Tree](#101)
- [112. Path Sum](#112)
- [114. Flatten Binary Tree to Linked List](#114)
- [120. Triangle](#120)
- [121. Best Time to Buy and Sell Stock](#121)
- [125. Valid Palindrome](#125)
- [137. Single Number II](#137-single-number-ii)
- [141. Linked List Cycle](#141)
- [143. Reorder List](#143)
- [144. Binary Tree Preorder Traversal](#144)
- [162. Find Peak Element](#162)
- [165. Compare Version Numbers](#165)
- [171. Excel Sheet Column Number](#171)
- [182. Duplicate Emails](#182-duplicate-emails)
- [193. Valid Phone Numbers](#193)
- [196. Delete Duplicate Emails](#196)
- [207. Course Schedule](#207)
- [215. Kth Largest Element in an Array](#215)
- [217. Contains Duplicate](#217-contains-duplicate)
- [229. Majority Element II](#229-majority-element-II)
- [232. Implement Queue using Stacks](#232-implement-queue-using-stacks)
- [235. Lowest Common Ancestor of a Binary Search Tree](#235)
- [242. Valid Anagram](#242-valid-anagram)
- [275. H-Index II](#275-h-index-ii)
- [279. Perfect Squares](#279)
- [284. Peeking Iterator](#284)
- [292. Nim Game](#292-nim-game)
- [300. Longest Increasing Subsequence](#300-longest-increasing-subsequence)
- [303. Range Sum Query - Immutable](#303)
- [318. Maximum Product of Word Lengths](#318-maximum-product-of-word-lengths)
- [322. Coin Change](#322-coin-change)
- [342. Power of Four](#342)
- [350. Intersection of Two Arrays II](#350)
- [357. Count Numbers with Unique Digits](#357)
- [367. Valid Perfect Square](#367)
- [368. Largest Divisible Subset](#368-largest-divisible-subset)
- [374. Guess Number Higher or Lower](#374-guess-number-higher-or-lower)
- [387. First Unique Character in a String](#387)
- [400. Nth Digit](#400)
- [406. Queue Reconstruction by Height](#406)
- [413. Arithmetic Slices](#413)
- [417. Pacific Atlantic Water Flow](#417)
- [445. Add Two Numbers II](#445)
- [447. Number of Boomerangs](#447-number-of-boomerangs)
- [450. Delete Node in a BST](#450-delete-node-in-a-bst)
- [467. Unique Substrings in Wraparound String](#467)
- [482. License Key Formatting](#482-license-key-formatting)
- [492. Construct the Rectangle](#492)
- [503. Next Greater Element II](#503)
- [515. Find Largest Value in Each Tree Row](#515)
- [517. Super Washing Machines](#517)
- [526. Beautiful Arrangement](#526)
- [561. Array Partition I](#561-array-partition-i)
- [563. Binary Tree Tilt](#563-binary-tree-tilt)
- [565. Array Nesting](#565-array-nesting)
- [581. Shortest Unsorted Continuous Subarray](#581-shortest-unsorted-continuous-subarray)
- [599. Minimum Index Sum of Two Lists](#599-minimum-index-sum-of-two-lists)
- [605. Can Place Flowers](#605)
- [617. Merge Two Binary Trees](#617)
- [627. Swap Salary](#627)
- [645. Set Mismatch](#645)
- [648. Replace Words](#648-replace-words)
- [659. Split Array into Consecutive Subsequences](#659-split-array-into-consecutive-subsequences)
- [671. Second Minimum Node In a Binary Tree](#671-second-minimum-node-in-a-binary-tree)
- [673. Number of Longest Increasing Subsequence](#673-number-of-longest-increasing-subsequence)
- [676. Implement Magic Dictionary](#676)
- [706. Design HashMap](#706-design-hashMap)
- [717. 1-bit and 2-bit Characters](#717)
- [728. Self Dividing Numbers](#728-self-dividing-numbers)
- [744. Find Smallest Letter Greater Than Target](#744)
- [748. Shortest Completing Word](#748)
- [783. Minimum Distance Between BST Nodes](#783)
- [785. Is Graph Bipartite?](#785-is-graph-bipartite)
- [788. Rotated Digits](#788)
- [792. Number of Matching Subsequences](#792-number-of-matching-subsequences)
- [806. Number of Lines To Write String](#806)
- [819. Most Common Word](#819)
- [826. Most Profit Assigning Work](#826-most-profit-assigning-work)

## 1

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have **exactly** one solution, and you may not use the same element twice.

**Example:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

**Solution:**

找出数组中和为给定值的两个元素的下标。直接计算和肯定是低效的，可以转化一下问题：找出数组中是否存在元素 a 满足 `tagget-a = b ` 并且 b 也在数组中。

一种思路是直接利用 list：

```java
public int[] twoSum(int[] nums, int target) {
    if (nums.length < 2) {
        return null;
    }
    List<Integer> list = new ArrayList<>();
    for (int num : nums) {
        list.add(num);
    }
    for (int i = 0, len = list.size(); i < len; i++) {
        int tmp = list.indexOf(target - list.get(i));
        if (tmp != i && tmp != -1) {
            return new int[]{i, tmp};
        }
    }
    return null;
}
```

这种解法是可以预见的低效的，因为 indexOf 耗费太多时间。

我们可以利用 HashMap 优化一下：

```java
public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    int tmp = 0;
    Map<Integer, Integer> res = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        tmp = target - nums[i];
        if (res.containsKey(tmp)) {
            result[0] = res.get(tmp);
            result[1] = i;
            break;
        }
        res.put(nums[i], i);
    }
    return result;
}
```

## [4 Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/description/)

给定两个有序数组，要求找出两个数组的中位数。即合并之后的中位数。要求时间复杂度为 O(log (m + n))。

我们可以使用归并来做，先将两个数组归并，然后求中位数：

```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int l1 = nums1.length, l2 = nums2.length;
    int mid = (l1 + l2) / 2;
    int[] merge = new int[mid + 1];
    int j = 0, k = 0;
    for (int i = 0; i < mid + 1; i++) {
        if (j < l1 && (k >= l2 || nums1[j] < nums2[k])) {
            merge[i] = nums1[j++];
        } else {
            merge[i] = nums2[k++];
        }
    }
    if ((l1 + l2) % 2 == 0) {
        return (merge[mid - 1] + merge[mid]) / 2.0;
    } else {
        return (double) merge[mid];
    }
}
```

但是算法的时间复杂度为 O(m + n)。

## [7 Reverse Integer](https://leetcode.com/problems/reverse-integer/description/)

翻转整数，比如把 123 翻转为 321. 不考虑越界的情况下很简单，每次求 x 对 10 的余数，然后用一个 res 乘 10 加上余数即可，循环直到 x 为 0. 但是题目明显要求考虑越界。

```
Integer.MAX_VALUE = 2147483647，Integer.MIN_VALUE = -2147483648
```

判断是否越界的时候，我们只需要判断 `abs(res) > 214748364` 即可。我们来分析一下为什么不需要检查 `abs(res) == 214748364` 的情况。x（参数） 是一个整数，所以 x 的范围也是 -2148473648 ~ 2147483647，则如果 x 是 10 位数，翻转后最后一位必定是 1 或 2（不可能是 0，0 代表 x 是 9 位数），即 res 最终必定为 2147483641 或 2147483642。又因为 2147483642 对应的 x 是 2463847421 已经超出了 int 的范围，所以当 res 为 214748364 时，x 只可能是 2147483641，所以不需要检查 res 是否等于 214748364。

```java
public int reverse(int x) {
    int result = 0;
    while (x != 0) {
        if (Math.abs(result) > Integer.MAX_VALUE / 10) {
            return 0;
        }
        result = result * 10 + x % 10;
        x /= 10;
    }
    return result;
}
```

中间的判断过程时分费时，我们也可以不做判断，即：

```java
public int reverse1(int x) {
    int prev = 0, result = 0, tmp;
    while (x != 0) {
        tmp = x % 10;
        result = result * 10 + tmp;
        if ((result - tmp) / 10 != prev) {
            return 0;
        }
        prev = result;
        x /= 10;
    }
    return result;
}
```

## 10

Implement regular expression matching with support for `'.'` and `'*'`.

> '.' Matches any single character.  
> '*' Matches zero or more of the preceding element.
>
> The matching should cover the entire input string (not partial).
>
> The function prototype should be:  
>bool isMatch(const char *s, const char *p)
>
> Some examples:  
> isMatch("aa","a") → false  
> isMatch("aa","aa") → true  
> isMatch("aaa","aa") → false  
> isMatch("aa", "a*") → true  
> isMatch("aa", ".*") → true  
> isMatch("ab", ".*") → true  
> isMatch("aab", "c*a*b") → true  

**Solution:**

这道题使用动态规划来解。令 `dp[i][j]` 表示 `s[0-i]` 与 `p[0-j]` 的匹配情况。

则 `dp[i][j]` 可以由一系列规则计算出来：

```py
if p.charAt(j) == s.charAt(i):  dp[i][j] = dp[i-1][j-1];
if p.charAt(j) == '.': dp[i][j] = dp[i-1][j-1];
if p.charAt(j) == '*':
    if p.charAt(j-1) != s.charAt(i) and p.charAt(i-1) != '.': dp[i][j] = dp[i][j-2]  
    if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                dp[i][j] = dp[i-1][j]
            or  dp[i][j] = dp[i][j-1]
            or  dp[i][j] = dp[i][j-2]
```

代码：

```java
public static boolean isMatch(String s, String p) {
    int lenS = s.length(), lenP = p.length();
    char[] sc = s.toCharArray(), pc = p.toCharArray();
    boolean[][] dp = new boolean[lenS + 1][lenP + 1];
    dp[0][0] = true;    // 两个空数组 match
    // dp 中 i，j 为 0 代表 s 或 p 为空的情况，所以下面的循环中 sc[i] 与 pc[j] 的匹配情况为 dp[i+1][j+1]
    for (int i = 0; i < lenP; i++) {
        if (pc[i] == '*' && dp[0][i - 1]) {
            dp[0][i + 1] = true;
        }
    }

    // dp 中 i，j 为 0 代表 s 或 p 为空的情况，所以下面的循环中 sc[i] 与 pc[j] 的匹配情况为 dp[i+1][j+1]
    for (int i = 0; i < lenS; i++) {
        for (int j = 0; j < lenP; j++) {
            if (sc[i] == pc[j] || pc[j] == '.') {
                // 匹配
                dp[i + 1][j + 1] = dp[i][j];
            } else if (pc[j] == '*') {
                if (sc[i] != pc[j - 1] && pc[j - 1] != '.') {
                    // 如果 pc[j] == '*' 并且 pc[j-1] 与 sc[i] 不匹配，则 i、j 处匹配情况等于 sc[i]、pc[j-2] 处匹配情况
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];
                } else {
                    // 如果 pc[j] == '*' 并且 pc[j-1] 与 sc[i] 匹配，则
                    // 1、'*' 前元素出现 零 次，则 i、j 处匹配情况等于 sc[i]、pc[j-2] 处匹配情况（dp[i+1][j-1]）
                    // 2、'*' 前元素出现 一 次，则 i、j 处匹配情况等于 sc[i] 和 pc[j - 1] 的匹配情况（dp[i+1][j]）
                    // 3、'*' 前元素出现 多 次，可以认为 pc[j] 会重复出现 n 次，则 i、j 处的匹配情况应该等于 sc[i-1] 和 pc[j] 处的匹配情况
                    // 对于第三种情况，很自然我们会想到将 i、j 处匹配情况设置为 sc[i+1]、pc[j] 的匹配情况（sc[i] == pc[j-1]），但是这样不行，会导致 ArrayIndexOutOfBoundsException
                    // 所以我们要做一个同等情况的转换。
                    // 通过观察，我们得出结论，第三种情况代表了元素 sc[i] 在此之前至少出现了一次。
                    // 我们得出这个结论的依据是通过反证法：如果元素 sc[i] 在此之前没有出现过，那么不会进入第三种情况。所以如果进入第三种情况，那么元素 sc[i] 在 sc 中至少出现了一次并且肯定是 sc[i-1]。
                    // 这样，我们就可以把 i、j 处匹配情况替换为 i-1 与 j 的匹配情况。
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
                }
            }
        }
    }
    return dp[lenS][lenP];
}
```

掉头发了....

## [15 3Sum](https://leetcode.com/problems/3sum/description/)

给定一个数组，找出数组中三个元素和为 0 的序列，不允许重复。其实 16 是 15 的衍生，我们直接采用 16 第二种解法。即，先将数组排序，然后对于数组中的每一个元素，考虑其和之后第一个元素与最后一个元素之和，如果和为 0，则得到结果，如果和大于 0，则应选择倒数第二个元素，如果和小于 0，则应该选该元素之后第二个元素。

```java
public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    if (nums == null || nums.length < 3) {
        return new ArrayList<>();
    }
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
    return new ArrayList<>(result);
}
```

## [16 3Sum Closest](https://leetcode.com/problems/3sum-closest/description/)

要求从数组中选出三个数，使其之和与 target 相差最小。先来暴力解：

```java
public int silly(int[] nums, int target) {
    int minDiff = Integer.MAX_VALUE;
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                int tmp = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - tmp);
                if (diff < minDiff) {
                    minDiff = diff;
                    result = tmp;
                }
            }
        }
    }
    return result;
}
```

三重循环直接 AC？？？

对于上面的算法，我们可以简单优化一下。先将数组进行排序，最外层循环不动，对于内层两个循环，我们可以利用数组有序的特点对其计算方式进行优化。可以考虑内层两个数分别取 i 之后的第一个数与最后一个数，因为有序，所以如果三个数的和大于 target，则需要取倒数第二个数进行计算；如果小于 target，则应取 i 之后第二个数，依次类推。这样就得到了高效的算法二：

```java
public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int minDiff = Integer.MAX_VALUE;
    int result = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        int iLeft = i + 1;
        int iRight = nums.length - 1;
        while (iLeft < iRight) {
            int tmp = nums[i] + nums[iLeft] + nums[iRight];
            int diff = Math.abs(target - tmp);
            if (diff < minDiff) {
                minDiff = diff;
                result = tmp;
            }

            if (tmp > target) {
                iRight--;
            } else if (tmp < target) {
                iLeft++;
            } else {
                return tmp;
            }
        }
    }
    return result;
}
```

## [24 Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/description/)

要求我们把相邻的链表节点交换位置，并返回交换后的头结点。

这道题有两种解法：一种是顺序遍历链表，依次交换然后返回；一种是利用递归，因为每次函数调用返回的都是链表的头结点，我们可以利用这个特性来做：

```java
public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode node = head.next;
    head.next = swapPairs(node.next);
    node.next=head;
    return node;
}
```

## 28

Implement [strStr()](http://www.cplusplus.com/reference/cstring/strstr/).

Return the index of the first occurrence of needle in haystack, or **-1** if needle is not part of haystack.

**Example 1:**

```
Input: haystack = "hello", needle = "ll"
Output: 2
```

**Example 2:**

```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

**Clarification:**

What should we return when `needle` is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when `needle` is an empty string. This is consistent to C's [strStr()](http://www.cplusplus.com/reference/cstring/strstr/) and Java's [indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String).

**Solution:**

手动实现一遍 Java 中的 indexOf：

```java
public int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
        return 0;
    }

    char[] sources = haystack.toCharArray();
    char[] needles = needle.toCharArray();
    int sl = sources.length, nl = needles.length;
    int result;
    for (int i = 0; i < sl; i++) {
        if (sources[i] == needles[0]) {
            int si = i, ni = 0, match = 0; // needle index
            result = i;
            while (si < sl && ni < nl && sources[si] == needles[ni]) {
                match++;
                si++;
                ni++;
            }
            if (match == nl) {
                return result;
            }
        }
    }
    return -1;
}
```

没有任何优化的版本速度当然也是惨不忍睹的。。

调用 API：

```java
public int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
}
```

打败了 100% 的 Java 提交者，没意义 :smile:

## [33 Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/)

> 给定一个旋转后的升序数组，从中查找特定元素。要求时间复杂度 O(log _n_)

既然要求 O(log _n_) 的时间复杂度，并且数组原本是升序的，我们就可以考虑采用二分查找来完成。

设转折点为旋转后数组中升序结束的第一个元素，即数组中最小元素。下面我们考虑二分查找的三种情况：

1. 转折点在 mid 之后
1. 转折点在 mid 之前
1. 转折点在 mid

对于第一种情况，转折点在 mid 之后，则 mid 之前数组为升序，我们可以先判断 target 是否落入其中：如果在，则更新 `right = mid - 1`；如果不在，则更新 `left = mid + 1`。

对于第二种情况，转折点在 mid 之前，则 mid 之后数组为升序，我们可以判断 target 是否落入其中：如果在，则更新 `left = mid + 1`；如果不在，则更新 `right = mid - 1`。

对于第三种情况，mid 为转折点，如果我们在进行三种情况判断前先判断 mid 位置元素是否为 target，那么之后的判断与 mid 是否是转折点无关，我们可以将这种情况并入上面两种情况的一种。而如果转折点在 mid 之后（即第一种情况），我们可以肯定 `nums[mid] > nums[right]`，于是三种情况的区分就变成了上面的比较的结果。

```java
public int search(int[] nums, int target) {
    if (nums.length == 0) {
        return -1;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > nums[right]) {
            // 转折点在 mid 右侧，或者 min 是转折点
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
            // 转折点在 mid 左侧
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    return -1;
}
```

## 38

The count-and-say sequence is the sequence of integers with the first five terms as following:

```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```

`1` is read off as `"one 1"` or `11`.
`11` is read off as `"two 1s"` or `21`.
`21` is read off as `"one 2, then one 1"` or `1211`.

Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

**Example 1:**

```
Input: 1
Output: "1"
```

**Example 2:**

```
Input: 4
Output: "1211"
```

**Solution:**

这题的描述可是相当的不清晰，我也是看了讨论区才真正理解了题义，如果再添一条示例就容易理解多了：

```
6.      312211
```

如果只有一个**不重复的数字**，那么本数列的内容是 `1+该数字`；

每一个 n 的序列都是基于之前一个序列生成的，如果前一个序列有重复的数字，那么本次数列的内容就是 `重复次数+重复的数字`。

这样，用递归就比较简单了

代码：

```java
public static String countAndSay(int n) {
    if (1 == n) {
        return "1";
    }
    String str = countAndSay(n - 1) + ".";
    char[] chars = str.toCharArray();
    int count = 1;
    StringBuilder sb = new StringBuilder();
    for (int i = 0, len = chars.length - 1; i < len; i++) {
        if (chars[i] == chars[i + 1]) {
            count++;
        } else {
            sb.append(count).append(chars[i]);
            count = 1;
        }
    }
    return sb.toString();
}
```

其中，在 str 后加 `"."` 是为了做一个标记，因为 `"."` 不可能跟数列中元素相等，这里表示达到数列结尾

## 39

Given a **set** of candidate numbers (`candidates`) (**without duplicates**) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sums to `target`.

The **same** repeated number may be chosen from `candidates` unlimited number of times.

**Note:**

1. All numbers (including target) will be positive integers.
1. The solution set must not contain duplicate combinations.

**Example 1:**

```
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
```

**Example 2:**

```
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

**Solution:**

分析一下就能看出来，用动态规划状态数组难以更新，状态太多，这时候就要想到用回溯来做。

代码：

```java
public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);    // 排序避免过多费时费力的判断
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> tmp = new ArrayDeque<>();
    dfs(result, tmp, candidates, target, 0);
    return result;
}

private static void dfs(List<List<Integer>> result, Deque<Integer> tmp, int[] candidates, int target, int j) {
    if (target == 0) {
        result.add(new ArrayList<>(tmp));
        return;                 // 符合条件，直接返回
    }
    for (int i = j; i < candidates.length && target >= candidates[i]; i++) {
        tmp.add(candidates[i]);
        dfs(result, tmp, candidates, target - candidates[i], i);
        tmp.pollLast();
    }
}
```

## [40 Combination Sum II](https://leetcode.com/problems/combination-sum-ii/description/)

> 给定一个候选值数组 candidates 和一个目标值 target，找出候选值数组中所有和为 target 的组合

回溯可解。其中需要注意的是重复问题，对于 `candidates=[1,1,7], target=8` 的情况，结果只有一个 `[1,7]`，我们在回溯的时候需要手动跳过第二个 `1` 来避免重复。

```java
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new LinkedList<>();
    combination(candidates, 0, target, new LinkedList<>(), result);
    return result;
}

private void combination(int[] candidates, int current, int target, Deque<Integer> path, List<List<Integer>> result) {
    if (target < 0) return;
    if (target == 0) {
        result.add(new ArrayList<>(path));
        return;
    }
    for (int i = current; i < candidates.length; i++) {
        if (i > current && candidates[i] == candidates[i - 1]) continue;
        path.offer(candidates[i]);
        combination(candidates, i + 1, target - candidates[i], path, result);
        path.pollLast();
    }
}
```

## [41 First Missing Positive](https://leetcode.com/problems/first-missing-positive/description/)

要求找出数组中丢失的最小的整数，例如，对于数组 `[3,4,-1,1]`，丢失的最小整数为 `2`。

这题我们可以用桶排序的思路来做，分析一下边界情况：

1. 数组长度 l，数组中存在大于 l 的数。这种情况最大的丢失整数应为 l+1，可不考虑
1. 数组元素小于 0。我们只需要把正数放到对应位置的桶里，负数与 0 可不考虑
1. 桶里已经有对应的数。因为我们最后统计的时候是依据桶的内容来分析的，所以对于重复出现的正数，只要有一个在正确的桶里即可。

```java
public int firstMissingPositive(int[] nums) {
    if (nums.length == 0) {
        return 1;
    }
    for (int i = 0, len = nums.length; i < len; i++) {
        if (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
            swap(nums, i, nums[i] - 1);
            i -= 1;
        }
    }
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) {
            return i + 1;
        }
    }
    return nums.length + 1;
}

private void swap(int[] numbers, int i, int j) {
    int t = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = t;
}
```

## [49 Group Anagrams](https://leetcode.com/problems/group-anagrams/description/)

将字符串数据按照一定规则分组，规则是任何字母颠倒的字符串分为一组。比如 `"eat"` 与 `"tea"` 以及 `"ate"`，需要分为一组。

看到这题，一上来就想到了用 hash 来做，即将字符串利用一个与字母顺序无关的 `hash` 函数映射为 `int`，然后利用 HashMap 来构建结果。

首先尝试了最简单的 hash :)

```java
private int hash(String str) {
    int hash = 1;
    char[] chars = str.toCharArray();
    for (char aChar : chars) {
        hash *= aChar;
    }
    return hash;
}
```

结果不用说，出现碰撞 Wrong Answer。。

然后就想，有没有一种根据字母来计算 hash，而且碰撞比较少的方法呢？质数！

```java
// 26 prime numbers
private static int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

private int hash(String str) {
    int hash = 1;
    char[] chars = str.toCharArray();
    for (char aChar : chars) {
        hash *= prime[aChar - 'a'];
    }
    return hash;
}

public List<List<String>> groupAnagrams(String[] strs) {
    Map<Integer, List<String>> map = new HashMap<>();
    for (String str : strs) {
        int hash = hash(str);
        List<String> list = map.getOrDefault(hash, new ArrayList<>());
        list.add(str);
        map.put(hash, list);
    }
    return new ArrayList<>(map.values());
}
```

完美！打败了 95% 的 Java 提交者。

当然这种做法是取巧了，在数据量巨大的情况下，必然会发生碰撞从而导致结果出错。LeetCode  给出的两种正统做法如下：

1. 先排序，后比较
1. 通过统计字符串中字符个数判断是否为相同但是颠倒字母的字符串

## [62 Unique Paths](https://leetcode.com/problems/unique-paths/description/)

> 给定一个坐标点，robot 从零点出发，只能往下或者往右走，求可能的路径数。

robot 只能往下或者往右走，那么某个特定位置的可能路径就只取决于其上侧或者左侧节点的可能路径，是一个动态规划问题。

```
dp[i][j] = dp[i-1][j] + dp[i][j-1]
```

对于边界，即 `i=0` 或者 `j=0`，因为 robot 只能往右或者往下走，所以这种情况的路径只有 1 种。

```java
public int uniquePaths(int m, int n) {
    int[][] dp = new int[n][m];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (i == 0 || j == 0)
                dp[i][j]=1;
            else
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
    return dp[n-1][m-1];
}
```

打败了 100% 的提交者。

## [76 Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/description/)

> 给定字符串 S 与 T，找出 S 中最短的包含 T 中所有字符的子串。算法要求是线性时间复杂度。

首先利用 Map 统计 T 中字符出现数量，然后扫描 S，统计 S 中出现 T 中字符的次数，当 T 中所有字符都出现的时候，我们认为，已经找到了一个子串。

但是这个子串有可能不是最短的，我们需要从左侧将无用字符剔除。在剔除的过程中，如果遇到了一个出现在 T 中的字符，我们将其剔除，同时**根据 S 当前停的地方之前是否再次出现该字符决定是否终止剔除过程**。如果出现，则继续剔除，如果没有出现，则停止剔除过程，继续扫描 S。

我们使用实例来描述上述算法。假设给定 `S = "ADOBECODEBANC", T = "ABC"`。初始，利用 Map 来统计 T 中字符数：

```
A -> 1
B -> 1
C -> 1
```

然后扫描 S，对于 S 中出现在 T 的字符（`map.containsKey`），将其对应 map 中的值 -1，并且利用一个 `match` 变量保存 S 中匹配字符的次数。

当第一个子串出现时：

```
S = "ADOBECODEBANC"
          |
          i

同时 map：
A -> 0
B -> 0
C -> 0
```

这时，我们开始剔除过程。因为第一个字符为 `A` 出现在 T 中，我们将 `A` 剔除并且 `map[A]+=1`。因为 `map[A] > 0`，剔除过程结束，我们记录当前 left 的位置。此时 map：

```
A -> 1
B -> 0
C -> 0
```

然后继续扫描 S。第二次停住的地方是：

```
S = "ADOBECODEBANC"
               |
               i

同时 map：
A -> 0
B -> -1
C -> 0
```

停在 `A` 而不是 `B` 很容易理解，因为第一次 `扫描-剔除` 结束时剔除了 `A`，所以第二次扫描时直到扫到一个 `A` 才会结束。

现在我们开始剔除过程，第一次剔除过程结束时 left 指针指向第二个字符（只剔除了起始的 `A`）。我们依次向后扫描，当 left 指向之后出现的第一个 T 中的字符时：

```
S = "ADOBECODEBANC"
        |
       left
```

我们剔除这个 `B` 并且 `map[B]+=1`，此时 `map[B]` 不大于 0，说明刚才剔除的 `B` 属于重复字符，应当继续剔除过程。之后又遇到了一个 `C`：

```
S = "ADOBECODEBANC"
          |
         left
```

剔除 `C` 并且 `map[C]+=1`，因为此时 `map[C] > 0`，说明此次剔除过程已经结束，继续向后扫描 S。

从上面两次的 扫描-剔除 过程可以看出来，`map` 中的值的含义：

1. 小于等于 0：当前扫描位置之前到剔除起始位置出现的**重复字符**个数
1. 大于 0：期待之后扫描到的字符数 n，也即当前尚未组成要求的子串，仍需要 n 个该字符

我们剔除某个字符后将其对应 map 加 1 也就容易理解了，我们剔除了一个字符，相应的还需要一个字符来组成需要的子串。

```java
public String minWindow(String s, String t) {
    if (s == null || t == null || s.length() < t.length()) {
        return "";
    }
    Map<Character, Integer> map = new HashMap<>();
    int match = 0, min = Integer.MAX_VALUE, left = 0, minLeft = 0;
    for (char c : t.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (int right = 0; right < s.length(); right++) {
        char r = s.charAt(right);
        if (map.containsKey(r)) {
            map.put(r, map.get(r) - 1);
            if (map.get(r) >= 0) {
                match++;
            }
            while (match == t.length()) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    minLeft = left;
                }
                char l = s.charAt(left++);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                    if (map.get(l) > 0) {
                        match--;
                    }
                }
            }
        }
    }
    return min == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + min);
}
```

## [83 Remove Duplicates from Sorted List](83. Remove Duplicates from Sorted List)

给定一个有序链表，要求删除其中多余的重复元素。

直接遍历，判断后一个节点是否与当前节点相同。如果相同，则用后一个节点的后继节点替换后一个节点；如果不同，当前节点指向后一个节点，继续。

```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode node = head;
    while (node.next != null) {
        if (node.val == node.next.val) {
            node.next = node.next.next;
        } else {
            node = node.next;
        }
    }
    return head;
}
```

另一种思路是递归。对于递归到的每一个节点，确保其之后没有与当前节点重复的节点，然后对其后继节点递归调用：

```java
public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
        return head;
    }
    while (head.next != null && head.val == head.next.val) {
        head.next = head.next.next;
    }
    head.next = deleteDuplicates(head.next);
    return head;
}
```

## 100

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

**Example 1:**

```
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
```

**Example 2:**

```
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
```

**Example 3:**

```
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
```

**Solution:**

直接使用递归来做即可：

```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null) {
        return q == null;
    }
    if (q == null) {
        return false;
    }
    if (p.val == q.val) {
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    } else {
        return false;
    }
}
```

## 101

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

But the following `[1,2,2,null,3,null,3]` is not:

```
    1
   / \
  2   2
   \   \
   3    3
```

**Solution:**

使用递归可以很明确的得出结果：

```java
public static boolean isSymmetrix(TreeNode root) {
    if (root == null) {
        return true;
    }
    return treeEqual(root.left, root.right);
}

private static boolean treeEqual(TreeNode tree1, TreeNode tree2) {
    if (tree1 == null && tree2 == null) {
        return true;
    }
    if (tree1 == null || tree2 == null) {
        return false;
    }
    if (tree1.val != tree2.val) {
        return false;
    } else {
        return treeEqual(tree1.left, tree2.right) && treeEqual(tree1.right, tree2.left);
    }
}
```

另一种解法是通过双向队列：

```java
public static boolean deque(TreeNode root) {
    if (root == null) {
        return true;
    }

    TreeNode preNode = null, postNode = null;
    Deque<TreeNode> deque = new LinkedList<>();
    deque.addFirst(root.left);
    deque.addLast(root.right);

    while (!deque.isEmpty()) {
        preNode = deque.pollFirst();
        postNode = deque.pollLast();
        if (preNode == null && postNode == null) {
            continue;
        }
        if (preNode == null || postNode == null) {
            return false;
        }
        if (preNode.val != postNode.val) {
            return false;
        } else {
            deque.addFirst(preNode.right);
            deque.addFirst(preNode.left);
            deque.addLast(postNode.left);
            deque.addLast(postNode.right);
        }
    }
    return true;
}
```

这种方法就是按步照搬的一个一个比较了。

标准答案给了一种使用普通队列的方式：

```java
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) 
            continue;
        if (t1 == null || t2 == null) 
            return false;
        if (t1.val != t2.val) 
            return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}
```

思路与双端队列相同。

## 112

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

**Note:**

A leaf is a node with no children.

**Example:**

Given the below binary tree and `sum = 22`,

```
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
```

return true, as there exist a root-to-leaf path `5->4->11->2` which sum is 22.

**Solution:**

使用递归来做：

```java
public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
        return false;
    }
    if (root.left == null && root.right == null && root.val == sum) {
        return true;
    }

    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
}
```

## 114

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

```
    1
   / \
  2   5
 / \   \
3   4   6
```

The flattened tree should look like:

```
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```

**Solution:**

利用栈做先序遍历，不断把左结点挂在右结点上。

```java
public void flatten(TreeNode root) {
    if (root == null) {
        return;
    }
    LinkedList<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    TreeNode node;
    while (!stack.isEmpty()) {
        node = stack.pop();
        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
        node.left = null;
        if (!stack.isEmpty()) {
            node.right = stack.peek();
        }
    }
}
```

## 120

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

```
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
```

The minimum path sum from top to bottom is `11` (i.e., 2 + 3 + 5 + 1 = 11).

**Solution:**

这题很直观，第一眼就想到了暴力求解。。当然立马就否决了，明显用自底向上的动态规划可解，我们先把数据格式化一下：

```
2
3 4
6 5 7
4 1 8 3
```

状态转移方程：

```
dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + dp[i][j]
```

dp 结束后的数组：

```
11
9 10
7 6 10
4 1 8 3
```

思想就是：求当前行（从倒数第二行开始，最后一行无需计算）的下一行的两个元素中较小的一个然后加上当前行的值（更新 dp）

代码：

```java
public static int minimumTotal(List<List<Integer>> triangle) {
    for (int i = triangle.size() - 2; i >= 0; i--) {
        for (int j = 0, len = triangle.get(i).size(); j < len; j++) {
            triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
        }
    }
    return triangle.get(0).get(0);
}
```

这里就地复用 `triangle`，两重循环结束后，`triangle[0][0]` 的值即为最小和。

## 121

Say you have an array for which the i^th element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

**Example 1:**

```
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
```

**Example 2:**

```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

**Solution:**

利用两个变量 min、max，min初始值设为数组第一个元素，max初始值设置为 0。

迭代一次数组，每次计算当前值和 min 的差值。如果差值大于 max，则将 max 更新为差值。

对于当前值，如果当前值小于 min，说明有更小的，更新 min 为当前值。

总结来说是 min 与 max 同步更新。

```java
public int maxProfit(int[] prices) {
    if (prices.length == 0) {
        return 0;
    }
    int min = prices[0], max = 0, current = 0;
    for (int price : prices) {
        current = price - min;
        if (price < min) {
            min = price;
        }
        if (current > max) {
            max = current;
        }
    }
    return max;
}
```

## 125

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

**Note:** For the purpose of this problem, we define empty string as valid palindrome.

**Example 1:**

```
Input: "A man, a plan, a canal: Panama"
Output: true
```

**Example 2:**

```
Input: "race a car"
Output: false
```

**Solution:**

使用 Stream API 剔除不合法数据，然后将 String 翻转比较即可。

代码：

```java
public static boolean isPalindrome(String s) {
    String f = Arrays.asList(s.split(""))
            .parallelStream()   // 并行流
            .filter(s1 -> s1.matches("[a-zA-Z0-9]"))    // 剔除不合法字段
            .map(String::toLowerCase)                   // 全部转为小写
            .collect(Collectors.joining());             // 收集为 String
    return f.equals(new StringBuilder(f).reverse().toString()); // 跟 Reverse 之后的 String 比较
}
```

## [137 Single Number II](https://leetcode.com/problems/single-number-ii/description/)

给定一个非空整数数组，其中只有一个元素只出现了一次，其他元素均出现 3 次，要求找出只出现一次的元素。

我们可以利用 HashMap 存储每个元素出现的次数，然后扫描 HashMap 得出只出现一次的元素：

```java
public int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue().equals(1)) {
            return entry.getKey();
        }
    }
    return -1;
}
```

## 141

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

**Solution:**

使用快慢指针即可：

```java
public class Solution {
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head.next;
        if (slow == null) {
            return false;
        }
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return false;
    }
}
```

标准答案1 HashSet：

```java
public boolean hasCycle(ListNode head) {
    Set<ListNode> nodesSeen = new HashSet<>();
    while (head != null) {
        if (nodesSeen.contains(head)) {
            return true;
        } else {
            nodesSeen.add(head);
        }
        head = head.next;
    }
    return false;
}
```

因为如果有环，那么一直 `head.next` 移动肯定会移动到同一个节点，只需要判断当前节点是否在 HashSet 即可。

标准答案2 快慢指针：

```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}
```

## 143

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may **not** modify the values in the list's nodes, only nodes itself may be changed.

**Example 1:**

```
Given 1->2->3->4, reorder it to 1->4->2->3.
```

**Example 2:**

```
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
```

**Solution:**

思路是先找到链表的后半部分，记录中间的结点，将后半部分转置，然后归并即可

```java
public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
        return;
    }

    ListNode
            n1 = head,
            n2 = head;
    while (n2.next != null && n2.next.next != null) {
        n1 = n1.next;
        n2 = n2.next.next;
    }

    ListNode nodeMiddle = n1, current = nodeMiddle.next, tmp;
    while (current.next != null) {
        tmp = current.next;
        current.next = tmp.next;
        tmp.next = nodeMiddle.next;
        nodeMiddle.next = tmp;
    }

    n1 = head;
    n2 = nodeMiddle.next;
    while (n1 != nodeMiddle) {
        nodeMiddle.next = n2.next;
        n2.next = n1.next;
        n1.next = n2;
        n1 = n2.next;
        n2 = nodeMiddle.next;
    }
}
```

## 144

Given a binary tree, return the preorder traversal of its nodes' values.

**Example:**

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
```

**Follow up:**

Recursive solution is trivial, could you do it iteratively?

**Solution:**

二叉树的先序遍历，递归解法：

```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ret = new LinkedList<>();
    preorderTraversal(root, ret);
    return ret;
}

private void preorderTraversal(TreeNode root, List<Integer> list) {
    if (root != null) {
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
```

非递归解法：

```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode node = root;

    while (node != null || !stack.isEmpty()) {
        while (node != null) {
            list.add(node.val);
            stack.push(node);
            node = node.left;
        }
        if (!stack.isEmpty()) {
            node = stack.pop();
            node = node.right;
        }
    }

    return list;
}
```

非递归解法主要利用栈，左子结点先入栈，右子节点后入栈。该解法打败了 98% 的提交者。

## 162

A peak element is an element that is greater than its neighbors.

Given an input array `nums`, where `nums[i] ≠ nums[i+1]`, find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that `nums[-1] = nums[n] = -∞`.

**Example 1:**

```
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
```

**Example 2:**

```
Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
```

**Note:**

Your solution should be in logarithmic complexity.

**Solution:**

直接暴力做也可以 AC：

```java
public int findPeakElement(int[] nums) {
    if (nums.length <= 1) {
        return 0;
    }
    if (nums[0] > nums[1]) {
        return 0;
    }
    if (nums[nums.length - 1] > nums[nums.length - 2]) {
        return nums.length - 1;
    }
    for (int i = 1; i < nums.length - 1; i++) {
        if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
            return i;
        }
    }
    return -1;
}
```

根据题意，我们可以知道，数组中任意一个合适元素均可，上面的解法我们求出的始终是第一个合适的元素，做了较多判断。可以从题目特点总结出第二种解法：

```java
public int findPeakElement(int[] nums) {
    if (nums.length == 1)
        return 0;
    for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] > nums[i + 1])
            return i;
    }
    return nums.length - 1;
}
```

但是题目里说了可以在 log 时间复杂度内完成，可以依据二分查找的思想简化算法：

```java
public int findPeakElement(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            r = mid;
        else
            l = mid + 1;
    }
    return l;
}
```

## 165

Compare two version numbers version1 and version2.
If `version1 > version2` return `1`, if `version1 < version2` return `-1`, otherwise return `0`.

You may assume that the version strings are non-empty and contain only digits and the `.` character.
The `.` character does not represent a decimal point and is used to separate number sequences.
For instance, `2.5` is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

```
0.1 < 1.1 < 1.2 < 13.37
```

**Solution:**

根据版本号的规则，从左往右解析匹配即可：

```java
public static int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int len1 = v1.length;
    int len2 = v2.length;
    int max = Math.max(len1, len2);
    for (int i = 0; i < max; i++) {
        int ver1, ver2;
        try {
            ver1 = Integer.parseInt(v1[i]);
        } catch (Exception e) {
            ver1 = 0;
        }
        try {
            ver2 = Integer.parseInt(v2[i]);
        } catch (Exception e) {
            ver2 = 0;
        }
        if (ver1 > ver2) {
            return 1;
        } else if (ver1 < ver2) {
            return -1;
        }
    }
    return 0;
}
```

按照这种方法可能会有索引超出的情况，比如匹配 `1` 和 `1.1`，使用 try-catch 忽略异常并将对应的值设为 0，这种做法相当耗时，所以这题的排名很低。。

## 171

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

```
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
```

**Example 1:**

```
Input: "A"
Output: 1
```

**Example 2:**

```
Input: "AB"
Output: 28
```

**Example 3:**

```
Input: "ZY"
Output: 701
```

**Solution:**

写入一个字母，两个字母，三个字母时的计算规则即可得出规律：

```
1, (s[0]-'A'+1)
2, (s[0]-'A'+1)*26 + (s[1]-'A'+1)
3, (s[0]-'A'+1)*26*26+(s[1]-'A'+1)*26+(s[3]-'A'+1)
```

代码：

```java
public static int titleToNumber(String s) {
    char[] input = s.toCharArray();
    int len = input.length;
    int ret = 0;
    for (int i = len - 1; i >= 0; i--) {
        ret += (input[i] - 'A' + 1) * Math.pow(26, (len - 1 - i));
    }
    return ret;
}
```

## [182 Duplicate Emails](https://leetcode.com/problems/duplicate-emails/description/)

> SQL 问题，给定一个表 Person(Id, Email)，找出表中重复的 Email

很简单，对 `Email` 进行分组然后利用 having 判断数量大于 1 即可：

```sql
select p.Email from Person as p
group by p.Email
having count(*) > 1;
```

此答案打败了 99.49% 的提交者 :smile:

## 193

Given a text file `file.txt` that contains list of phone numbers (one per line), write a one liner bash script to print all valid phone numbers.

You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)

You may also assume each line in the text file must not contain leading or trailing white spaces.

For example, assume that `file.txt` has the following content:

> 987-123-4567  
> 123 456 7890  
> (123) 456-7890

Your script should output the following valid phone numbers:

> 987-123-4567  
> (123) 456-7890

**Solution:**

只是简单的 grep 和正则表达式用法。

```bash
grep -P '^(\d{3}-|\(\d{3}\)\ )\d{3}-\d{4}$' file.txt
```

## 196

Write a SQL query to delete all duplicate email entries in a table named `Person`, keeping only unique emails based on its smallest **Id**.

Id | Email
---|---
1 | john@example.com
2 | bob@example.com
3 | john@example.com

Id is the primary key column for this table.

For example, after running your query, the above `Person` table should have the following rows:

Id | Email
---|---
1 | john@example.com
2 | bob@example.com

**Solution:**

简单解法：

```sql
DELETE p1 FROM Person p1, Person p2 WHERE p1.Email = p2.Email AND p1.Id > p2.Id
```

更高效的解法：

```sql
DELETE FROM Person WHERE Id NOT IN (SELECT p.Id FROM (SELECT Min(Id) AS Id FROM Person GROUP BY Email) p);
```

思路是先按照 Email 进行分组，然后从分组中选出每一组最小的 Id，最后删除不在最小 Id 表中的 Id。

此答案打败了 100% 的提交者。

## 207

There are a total of n courses you have to take, labeled from `0` to `n-1`.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: `[0,1]`

Given the total number of courses and a list of prerequisite `pairs`, is it possible for you to finish all courses?

**Example 1:**

```
Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
```

**Example 2:**

```
Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
```

**Note:**

1. The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
1. You may assume that there are no duplicate edges in the input prerequisites.

**Hints:**

1. This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
1. Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
1. Topological sort could also be done via BFS.

**Solution:**

根据题意，有一个先驱课程列表，每个列表是某个课程的前驱对，要找出是否能够修完所有课程。考虑不能修完课程的情况，即前驱列表中存在相互依赖（0 依赖 1，同时 1 也依赖 0）。

可以利用拓扑排序来解：

```java
public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];
    Queue<Integer> queue = new LinkedList<>();

    for (int[] prerequisite : prerequisites) {
        inDegree[prerequisite[0]]++;
    }
    for (int i = 0; i < inDegree.length; i++) {
        if (inDegree[i] == 0) {
            queue.add(i);
        }
    }
    int count = queue.size();
    while (!queue.isEmpty()) {
        int t = queue.poll();
        for (int[] prerequisite : prerequisites) {
            if (t == prerequisite[1]) {
                int l = prerequisite[0];
                inDegree[l]--;
                if (inDegree[l] == 0) {
                    queue.add(l);
                    ++count;
                }
            }
        }
    }

    return count == numCourses;
}
```

根据结点的入度（依赖该结点的结点个数）来进行拓扑排序，队列中只放入入度为 0 的结点。

## 215

Find the **k**th largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

**Example 1:**

```
Input: [3,2,1,5,6,4] and k = 2
Output: 5
```

**Example 2:**

```
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
```

**Note:**

You may assume k is always valid, 1 ≤ k ≤ array's length.

**Solution:**

这题一开始我想用快排，快排之后直接取第 num.length - k 个元素即可。 

还有一种做法是用快速选择（[QuickSelect](https://zh.wikipedia.org/wiki/%E5%BF%AB%E9%80%9F%E9%80%89%E6%8B%A9)），快速选择做法同快速排序差不多，但是在进一步的时候只选择关注的一部分，而不是像快速排序一样两个子部分都递归。

```java
public static int findKthLargest(int[] nums, int k) {
    // 传递的参数 k 是数组中第 k 大元素前的元素个数
    // 比如要求第 2 大元素，数组为 [3, 2, 1, 5, 6, 4]，则传递给 quickSelect 的最后一个参数是 5，因为 5 前面共有 5 个元素
    return nums[quickSelect(nums, 0, nums.length - 1, nums.length - k + 1)];
}

/*
* 快排的思路，每次选一个基准值，然后将数组分为 比基准值高 和 比基准值低 两部分
* 快速选择不同于快排的地方是，我们只需要关注特定数量的数字。因为我们是从数列中选第几大的数字，所以我们只需要关注划分后的某一部分（前半部分或者后半部分）
*/
private static int quickSelect(int[] nums, int left, int right, int k) {
    int i = left, j = right, pivot = nums[right];   // 选择最后一个元素作为基准值。更好的算法是取首中尾的中位数作为基准值
    // 循环保证从 left 到 i 的所有数都小于等于 pivot，从 i 到 right-1 所有数都大于 pivot
    while (i < j) {
        if (nums[i++] > pivot) {
            swap(nums, --i, --j);
        }
    }
    swap(nums, i, right);   // 将 pivot 交换到合适位置
    int c = i - left + 1;   // 计算 pivot 前有多少个元素

    if (c == k) {       // 如果元素个数恰好为 k 个，则成功找到需要的元素
        return i;
    } else if (c > k) { // 如果个数比 k 大，说明我们选择的 pivot 过大，则要找的元素应该在左边
        return quickSelect(nums, left, i - 1, k);
    } else {            // 如果个数比 k 小，则说明应该从右边找
        return quickSelect(nums, i + 1, right, k - c);
    }
}

private static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
```

## [217 Contains Duplicate](https://leetcode.com/problems/contains-duplicate/description/)

判断数组中是否出现相同元素，有三种解法：

1. 对每个元素判断其是否在数组中重复出现（低效）
1. 先将数组排序，然后遍历数组，判断当前元素是否等于后一个元素
1. 利用 HashSet，首先判断元素是否在 set 中，不在则添加

```java
public boolean containsDuplicate(int[] nums) {
    // 避免扩容
    Set<Integer> set = new HashSet<>(nums.length);
    for (int num : nums) {
        if (set.contains(num)) {
            return true;
        }
        set.add(num);
    }
    return false;
}
```

## [229 Majority Element II](https://leetcode.com/problems/majority-element-ii/description/)

给定一个有 n 个整数的数组，找出其中出现次数大于 `n/3` 的元素。

用 HashMap 存储元素及其出现次数，然后遍历 HashMap 判断次数是否合适即可：

```java
public List<Integer> majorityElement(int[] nums) {
    List<Integer> result = new ArrayList<>(nums.length);
    Map<Integer, Integer> map = new HashMap<>();
    int frequent = nums.length / 3;

    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() > frequent) {
            result.add(entry.getKey());
        }
    }
    return result;
}
```

## [232 Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/description/)

通过栈实现队列。这题十分简单，利用两个栈，一个作为 pushStack，一个作为 popStack，选择在 `push`、`pop`、`peek` 的时候同步数据即可。同步数据即把 pushStack 的数据全部弹出到 popStack 中，必须是全部弹出，否则会有数据错乱问题。

```java
public class MyQueue {
	private LinkedList<Integer> pushStack;
	private LinkedList<Integer> popStack;

	/**
	 * Initialize your data structure here.
	 */
	public MyQueue() {
		pushStack = new LinkedList<>();
		popStack = new LinkedList<>();
	}

	/**
	 * Push element x to the back of queue.
	 */
	public void push(int x) {
		pushStack.push(x);
	}

	/**
	 * Removes the element from in front of queue and returns that element.
	 */
	public int pop() {
		if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
		return popStack.pop();
	}

	/**
	 * Get the front element.
	 */
	public int peek() {
		if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
		return popStack.peek();
	}

	/**
	 * Returns whether the queue is empty.
	 */
	public boolean empty() {
		return pushStack.isEmpty() && popStack.isEmpty();
	}
}
```

## 235

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to [the definition of LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow **a node to be a descendant of itself**).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

```
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
```

**Example 1:**

```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
```

**Example 2:**

```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
             according to the LCA definition.
```

**Note:**

1. All of the nodes' values will be unique.
1. p and q are different and both values will exist in the BST.

**Solution:**

根据 LCA 的规则我们可以推断出：

1. 如果两个结点在当前结点左右侧，那么 LCA 就是当前节点

由此可以得出解法：

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
        if (root.val < p.val && root.val < q.val) {
            root = root.right;
        } else if (root.val > p.val && root.val > q.val) {
            root = root.left;
        } else {
            break;
        }
    }
    return root;
}
```

## [242 Valid Anagram](https://leetcode.com/problems/valid-anagram/description/)

给定两个字符串，判断是否是相同字母异构词。

解法一，将字符串转换为 char 数组，排序后比对：

```java
public boolean isAnagram(String s, String t) {
    int len1 = s.length(), len2 = t.length();
    if (len1 != len2) {
        return false;
    }
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    Arrays.sort(sChars);
    Arrays.sort(tChars);
    for (int i = 0; i < len1; i++) {
        if (sChars[i] != tChars[i]) {
            return false;
        }
    }
    return true;
}
```

解法二,用一个 int[26] 数组存储 s 中字符出现频率，对于 t 中出现的字符，减去对应的数组值，最后判断数组是否全部为 0：

```java
public boolean isAnagram(String s, String t) {
    int[] frequent = new int[26];
    for (char c : s.toCharArray()) {
        frequent[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
        frequent[c - 'a']--;
    }
    for (int i : frequent) {
        if (i != 0) {
            return false;
        }
    }
    return true;
}
```

此解法战胜了 96% 的 Java 提交者。

## [275 H-Index II](https://leetcode.com/problems/h-index-ii/description/)

一个科学家的 h 指数是指他的 N 篇论文中有 h 篇至少有 h 个引用，并且其他 N-h 篇论文有不多于 h 个引用。

例如对于引用集 `[0,1,3,5,6]`，其 h 指数为 3，因为有 3 篇论文至少有 3 个引用。

注意：如果存在几个可能的 h 值，取最大的 h（贪心）

解法一，直接利用循环：

```java
public int hIndex(int[] citations) {
    int len = citations.length;
    int max = 0;
    for (int i = len; i > 0; i--) {
        if (citations[len - i] >= i) {
            if (max < i) {
                max = i;
            }
        }
    }
    return max;
}
```

`for` 循环中 i 表示可能的 h，算法思路应该很清晰。

解法二，对解法一的优化，因为论文引用数组是升序的，所以可以利用二分来达到 logN 级别的时间复杂度：

```java
public int hIndex(int[] citations) {
    int l = 0, r = citations.length - 1;

    while (l <= r) {
        int mid = (l + r) / 2;
        if (citations.length - mid <= citations[mid]) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return citations.length - l;
}
```

## 279

Given a positive integer n, find the least number of perfect square numbers (for example, `1, 4, 9, 16, ...`) which sum to n.

For example, given n = `12`, return `3` because `12 = 4 + 4 + 4`; given n = `13`, return `2` because `13 = 4 + 9`.

**Solution:**

使用动态规划来解，状态转移方程：

```
dp[i] = min(i, dp[i-k]+1)   // k=[1, ..., j], j <= n
```

代码：

```java
public static int numSquares(int n) {
    if (0 == n) {
        return 0;
    }
    List<Integer> perfectSquares = new LinkedList<>();
    int current = 1, square = 1;
    while ((square = current * current) <= n) {
        perfectSquares.add(square);
        current++;
    }
    int[] dp = new int[n + 1];
    for (int i = 1; i < dp.length; i++) {
        int solutions = i;
        for (Integer perfectSquare : perfectSquares) {
            if (perfectSquare > i)
                break;
            solutions = Math.min(solutions, dp[i - perfectSquare] + 1);
        }
        dp[i] = solutions;
    }
    return dp[n];
}
```

## 284

Given an Iterator class interface with methods: `next()` and `hasNext()`, design and implement a PeekingIterator that support the `peek()` operation -- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: `[1, 2, 3]`.

Call `next()` gets you 1, the first element in the list.

Now you call `peek()` and it returns 2, the next element. Calling `next()` after that still return 2.

You call `next()` the final time and it returns 3, the last element. Calling `hasNext()` after that should return false.

**Solution:**

我使用 Stack 来缓存 next 元素：

```java
package me.xlui.algo.Problem284;

import java.util.Iterator;
import java.util.Stack;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Stack<Integer> nextValue;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.nextValue = new Stack<>();
    }

    public Integer peek() {
        if (this.nextValue.isEmpty()) {
            this.nextValue.push(this.iterator.next());
        }
        return this.nextValue.peek();
    }

    @Override
    public boolean hasNext() {
        return this.nextValue.isEmpty() ? iterator.hasNext() : true;
    }

    @Override
    public Integer next() {
        return this.nextValue.isEmpty() ? this.iterator.next() : this.nextValue.pop();
    }
}
```

但是更快的做法是直接使用 Integer 保存：

```java
class PeekingIterator implements Iterator<Integer> {
    Iterator mIterator;
    Integer next = null; 

    public PeekingIterator(Iterator<Integer> iterator) {
        mIterator = iterator;   
        if (mIterator.hasNext()) {
            next = (Integer)mIterator.next();
        } 
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer res = next;
        next = mIterator.hasNext() ? (Integer)mIterator.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return next!=null;
    }
}
```

## [292 Nim Game](https://leetcode.com/problems/nim-game/description/)

> 有一堆石块，每个人可以从其中取 1~3 个石头，取出最后一个石头的玩家获胜，每个玩家都很聪明，会选择最好的策略来取，判断你能不能赢下这个游戏。

假设玩家 A 取的时候还剩下 x 个石块，则 A 有三种取法 `(x-1), (x-2), (x-3)`，对于 A 之后的玩家 B，也有三种取法。B 取完之后 A 有九种情况：

```
(x-1) B: (x-2), (x-3), (x-4)
(x-2) B: (x-3), (x-4), (x-5)
(x-3) B: (x-4), (x-5), (x-6)
```

如果 A 想要赢下这个游戏，则他需要保证 A 的三种取法存在一种取法使得 A 胜利。而对于 B 的每一种取法，如果 A 要胜利，则 A 必须赢下所有情况。

```
f(x) = (f(x-2)&&f(x-3)&&f(x-4)) || (f(x-3)&&f(x-4)&&f(x-5)) || (f(x-4)&&f(x-5)&&f(x-6))
```

可以看出来，如果 `f(x-4) = false`，则 A 不可能赢。

我们考察 `x = 4/5/6/7/8` 的情况：

```
4: A 取 1/2/3 都不可能获胜
5: A 取 1，获胜
6: A 取 2，获胜
7：A 取 3，获胜
8：A 取 1，B 取 3，A 失败；A 取 2，B 取 2，A 失败；A 取 3，B 取 1，A 失败
```

故得出解法：

```java
public boolean canWinNim(int n) {
    return n % 4 != 0;
}
```

## [300 Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/description/)

> 给定一个未排序的数组，找出其中最长的递增子序列

可以考虑动态规划，建立一个 dp 数组，其中 dp[i] 表示原数组中以 nums[i] 结尾的最长递增子序列长度。这样我们扫描数组，对于数组的每一个元素 i：

```
dp[i] = Math.max(dp[i], dp[j] + 1)    j=0,...,i-1 且 dp[j] < dp[i]
```

```java
public int lengthOfLIS(int[] nums) {
    int max = 0;
    int[] dp = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
        dp[i] = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        max = Math.max(max, dp[i]);
    }
    return max;
}
```

## 303

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

**Example:**

```
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
```

**Note:**

1. You may assume that the array does not change.
1. There are many calls to sumRange function.

**Solution:**

题目很简单，但是肯定会卡数据，这题到我做的时候收获了 184 个赞和 371 个踩，我也点了踩 :)

首先肯定不能直接循环，会超时。我们就要寻求一个思路来快速计算出结果。

以示例为例，观察：

```
i=0, j=1 结果是 nums[0]+nums[1]
i=0, j=2 结果是 nums[0]+nums[1]+nums[2]
i=0, j=3 结果是 nums[0]+nums[1]+nums[2]+nums[3]
```

那我们可不可以把 `nums` 改造一下，让 `nums[k]` 的值就是 `sumRange(0, k)`(subRange 是要提交的调用函数) 呢，让我们来考察一下可行性，如果 `nums[k]` 的值是 `subRange(0, k)`，那么 `subRango(i, j)` 就是：

```
i=0, j=2 结果是 nums[0]+nums[1]+nums[2]
i=1, j=2 结果是 nums[1]+nums[2]
i=0, j=3 结果是 nums[0]+nums[1]+nums[2]+nums[3]
i=1, j=3 结果是 nums[1]+nums[2]+nums[3]
```

就等于 `nums[j]-nums[i-1]`。

代码：

```java
public class NumArray {
    // 1 2 3 4 5
    // 1 3 6 10 15
    private int[] nums;

    public NumArray(int[] nums) {
        for (int i = 1, len = nums.length; i < len; i++) {
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (0 == i) {
            return nums[j];
        }
        return nums[j] - nums[i - 1];
    }
}
```

标准答案1：

利用map缓存

```java
private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

public NumArray(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        int sum = 0;
        for (int j = i; j < nums.length; j++) {
            sum += nums[j];
            map.put(Pair.create(i, j), sum);
        }
    }
}

public int sumRange(int i, int j) {
    return map.get(Pair.create(i, j));
}
```

标准答案2：

更好的缓存策略

```java
private int[] sum;

public NumArray(int[] nums) {
    sum = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
        sum[i + 1] = sum[i] + nums[i];
    }
}

public int sumRange(int i, int j) {
    return sum[j + 1] - sum[i];
}
```

免去了我的解法中的一层判断

## [318 Maximum Product of Word Lengths](https://leetcode.com/problems/maximum-product-of-word-lengths/description/)

> 给定一个字符数组，求出数组中两个字符串长度之积的最大值，要求两个字符串没有任何字符相同。字符串中的字符全部为小写。

问题中重要的是判断两个字符串没有任何字符相交，我们可以将一个字符串转换为 Set，然后循环判断剩余字符串是否符合条件：

```java
public int maxProduct(String[] words) {
    int max = Integer.MIN_VALUE;
    Arrays.sort(words, Comparator.comparing(String::length));
    Set<Character> set = new HashSet<>();
    for (int i = words.length - 1; i >= 0; i--) {
        addAll(set, words[i].toCharArray());
        for (int j = i - 1; j >= 0; j--) {
            if (disjoint(set, words[j].toCharArray())) {
                int t = words[i].length() * words[j].length();
                max = Math.max(max, t);
            }
        }
        set.clear();
    }
    return max == Integer.MIN_VALUE ? 0 : max;
}

private boolean disjoint(Set<Character> set, char[] chars) {
    for (char aChar : chars) {
        if (set.contains(aChar)) {
            return false;
        }
    }
    return true;
}

private void addAll(Set<Character> set, char[] chars) {
    for (char aChar : chars) {
        set.add(aChar);
    }
}
```

解法是可行的，但是显然做了很多额外的工作。

既然要判断两个字符串是否有字符共享，并且字符串中只包含小写字符。我们可以将字符串转换为一个 32 位的整数，其中低 26 位代表了字符串中每一个字符出现与否。这样，判断两个字符串是否共享字符的问题就转换为判断两个字符串对应的整数相**与**是否为 0.

```java
public int maxProduct(String[] words) {
    int max = 0, len = words.length;
    int[] mask = new int[len];
    for (int i = 0; i < len; i++) {
        for (char c : words[i].toCharArray()) {
            mask[i] |= 1 << (c - 'a');
        }
    }
    for (int i = 0; i < len - 1; i++) {
        for (int j = i + 1; j < len; j++) {
            if ((mask[i] & mask[j]) == 0) {
                max = Math.max(max, words[i].length() * words[j].length());
            }
        }
    }
    return max;
}
```

优雅，且高效。

## [322 Coin Change](https://leetcode.com/problems/coin-change/description/)

> 给定一系列不同面值的硬币以及一个总数，要求找出组成总数的最少硬币数。如果不能组成，则返回 -1.

首先想到的解法是：把硬币排序，然后用总数依次减去合适的最大的硬币。但是这种解法经不起推敲。例如对于 `coin=[3,7,8], amount=17`，如果按照上述算法，我们依次选择的 coin 是 `8,8`，然后因为剩余 `1` 无法从 coin 中继续选择硬币而认为无法组成 `17`。但是实际上当选择 `7,7,3` 时我们可以组成 `17`。所以这种解法是错误的。

我们从另一个角度来考察问题。如果存在任意一个 amount，其可以被 `n` 个硬币组成，并且 `n` 是最小的，那么我们可以得出所有 `amount+coin[i], i=0,...n` 的最小组成硬币数：`n+1`。如果某个 `amount+coin[i]` 已经存在一个最小硬币数 `m`，我们只需要将其更新为 `Math.min(m, n+1)`。

根据上面的思路我们可以设计一个 dp 算法，**利用 `dp[i]` 的值来代表 `amount=i` 时所需的最小硬币数 min**，然后逐步增大 i 直到给定的 amount。对于每一个 `i`，我们扫描 coin 数组来获取最小的 `min`，i 必须大于 `coin[j]`，因为如果 i 小于 `coin[j]`，说明 i 无法由 `coin[j]` 组成，也就无需更新。同时 `dp[i-coin[j]] != -1`，因为我们如果要更新 `min`，必须在 amount 取 i，coin 取 coin[j] 时，存在之前一个最小硬币数 `dp[i-coin[j]]`，这样我们才能通过判断更新 min：`min = Math.min(min, dp[i-coin[j]])`。

语言可能有些啰嗦，直接看算法如果能看懂的话就不用看我上面的一大堆话了 :)

```java
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    for (int i = 1; i <= amount; i++) {
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (i >= coin && dp[i - coin] != -1) {
                min = Math.min(min, dp[i - coin]);
            }
        }
        dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
    }
    return dp[amount];
}
```

## 342

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

**Example:**

Given num = 16, return true. Given num = 5, return false.

**Solution:**

根据条件构造 HashSet，函数中直接判断即可：

```java
private final static Set<Integer> set = new HashSet<Integer>() {{
    add(1);
    add(1 << 2);
    add(1 << 4);
    add(1 << 6);
    add(1 << 8);
    add(1 << 10);
    add(1 << 12);
    add(1 << 14);
    add(1 << 16);
    add(1 << 18);
    add(1 << 20);
    add(1 << 22);
    add(1 << 24);
    add(1 << 26);
    add(1 << 28);
    add(1 << 30);
}};

public static boolean isPowerOfFour(int num) {
    return set.contains(num);
}
```

或者直接 switch-case 暴力解：

```java
public boolean isPowerOfFour(int num) {
    switch (num) {
        case 0x00000001:
        case 0x00000004:
        case 0x00000010:
        case 0x00000040:
        case 0x00000100:
        case 0x00000400:
        case 0x00001000:
        case 0x00004000:
        case 0x00010000:
        case 0x00040000:
        case 0x00100000:
        case 0x00400000:
        case 0x01000000:
        case 0x04000000:
        case 0x10000000:
        case 0x40000000:
            return true;
        default:
            return false;
    }
}
```

但是更好的是利用位操作，我也想到了，但是不知道具体怎么做。。

```java
public boolean isPowerOfFour(int num) {
    return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
}
```

思路涉及到一个知识点：**如果一个数 num 是 2 的 N 次方，那么 num & (num - 1) = 0**

这里首先判断 num 是否是 2 的 N 次方，然后判断 1 是否在合适的位置上。

## 350

Given two arrays, write a function to compute their intersection.

**Example:**

Given nums1 = `[1, 2, 2, 1]`, nums2 = `[2, 2]`, return `[2, 2]`.

**Note:**

- Each element in the result should appear as many times as it shows in both arrays.
- The result can be in any order.

**Follow up:**

- What if the given array is already sorted? How would you optimize your algorithm?
- What if nums1's size is small compared to nums2's size? Which algorithm is better?
- What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

**Solution:**

使用 Map 统计其中一个数组每个元素个数，然后用另一个数组进行匹配即可

代码：

```java
public static int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> resultList = new ArrayList<>();
    for (int i : nums1) {
        map.put(i, map.getOrDefault(i, 0) + 1);
    }
    for (int i : nums2) {
        if (map.containsKey(i) && map.get(i) > 0) {
            resultList.add(i);
            map.put(i, map.get(i) - 1);
        }
    }
    int[] result = new int[resultList.size()];
    for (int i = 0, len = resultList.size(); i < len; i++) {
        result[i] = resultList.get(i);
    }
    return result;
}
```

## 357

Given a **non-negative** integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

**Example:**

Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding `[11,22,33,44,55,66,77,88,99]`)

**Solution:**

其实是一个数学问题，分析如下：

n = 1，共 10 个
n = 2，共 10 + 9\*9 = 91 个
n = 3，共 10 + 81 + 9\*9\*8 = 739 个
....

代码：

```java
public static int countNumbersWithUniqueDigits(int n) {
    if (0 == n) {
        return 1;
    }
    int res = 10, base = 9;
    for (int i = 2; i <= n; i++) {
        base = base * (9 - i + 2);
        res += base;
    }
    return res;
}
```

## 367

Given a positive integer num, write a function which returns True if num is a perfect square else False.

**Note:**

Do not use any built-in library function such as `sqrt`.

**Example 1:**

```
Input: 16
Returns: True
```

**Example 2:**

```
Input: 14
Returns: False
```

**Solution:**

一种做法是先求给定数的一半，然后循环判断：

```java
public boolean isPerfectSquare(int num) {
    int middle = num / 2 + 1;
    for (int i = 0; i <= middle; i++) {
        if (num == i * i) {
            return true;
        }
    }
    return false;
}
```

根据此思路的一个优化：

```java
public boolean isPerfectSquare(int num) {
    long l = 1;
    long r = (num / 2) + 1;
    
    while (l <= r) {
        long m = (l + r) / 2;
        
        if (m * m == num) 
            return true;
        else if (m * m < num) 
            l = m + 1;
        else 
            r = m - 1;
    }
    return false;
}
```

减少了很多无用的判断。

## [368 Largest Divisible Subset](https://leetcode.com/problems/largest-divisible-subset/description/)

> 给定一系列不同的正整数，从中找出最大的子集。要求子集中所有 (Si, Sj) 都符合条件 `Si % Sj = 0` 或者 `Sj % Si = 0`。

我们可以先将数组排序，这样判断条件就变为了 `Si % Sj = 0, i > j`。利用动态规划，dp 数组中每个元素代表以原数组对应元素为 i 存在的最大子集数。

仅仅记录最大值是无法得出最终的子集的，所以我们还需要一个 pre 数组，来记录更新 dp 时，当前元素的上一个元素。这样在 dp 完成时，可以根据 pre 数组来得出最大子序列。

```java
public List<Integer> largestDivisibleSubset(int[] nums) {
    int max = 0, index = -1;
    int[] dp = new int[nums.length];
    int[] pre = new int[nums.length];
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
        dp[i] = 1;
        pre[i] = -1;
        for (int j = i - 1; j >= 0; j--) {
            if (nums[i] % nums[j] == 0 && dp[i] < 1 + dp[j]) {
                dp[i] = 1 + dp[j];
                pre[i] = j;
            }
        }
        if (max < dp[i]) {
            max = dp[i];
            index = i;
        }
    }

    List<Integer> list = new LinkedList<>();
    while (index != -1) {
        list.add(nums[index]);
        index = pre[index];
    }
    return list;
}
```

## [374 Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/description/)

猜数字游戏，给定一个位置的数字，要我们从一个范围中找出这个数字。给出了判断准确性的办法，`guess()`。

第一种解法是利用中间值判断，不是中间值的话就根据判断结果增大或者缩小两边边界：

```java
public int guessNumber(int n) {
    int left = 0, right = n;
    if (0 == guess(n)) {
        return n;
    }
    while (true) {
        int middle = (left + right) >>> 1;
        int result = guess(middle);
        if (result > 0) {
            left--;
        } else if (result < 0) {
            right++;
        } else {
            return middle;
        }
    }
}
```

但是这种解法随着给定的数与 n 的接近程度其循环次数也逐渐增大，当给定数就是 n 或者 0 时，时间复杂度是 O(N)，超时。

根据上面算法的思想，我们可以进一步延伸出这题的解法：当判断不是中间值的时候，更新左右边界可以更新的更大一点：

```java
public int guessNumber(int n) {
    int left = 0, right = n;
    if (0 == guess(n)) {
        return n;
    }
    while (true) {
        int middle = (left + right) >>> 1;
        int result = guess(middle);
        if (result > 0) {
            left = middle;
        } else if (result < 0) {
            right = middle;
        } else {
            return middle;
        }
    }
}
```

这个算法在特定情况下会无限循环（n = 1，给定值也是 1），所以在 while 之前加了一层判断。

## 387

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

**Examples:**

```
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
```

**Note:**

 You may assume the string contain only lowercase letters.

**Solution:**

很简单，遍历输入串构建一个字符对应个数数组，根据每个输入字符在输入串中的个数依次填充数组。然后再遍历一次数组，找到第一个在字符对应个数数组中值为 1 的元素，返回其下标；如果没找到，返回 -1.

一共对输入串遍历了两次。

```java
public class Solution {
    public int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            alphabet[aChar - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (alphabet[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input1 = "leetcode";
        String input2 = "loveleetcode";
        // expect -1
        System.out.println(solution.firstUniqChar(""));
        // expect 0
        System.out.println(solution.firstUniqChar(input1));
        // expect 2
        System.out.println(solution.firstUniqChar(input2));
    }
}
```

## 400

Find the n^th digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

**Note:**

n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).

**Example 1:**

> Input:  
> 3
>
> Output:  
> 3

**Example 2:**

> Input:  
> 11
>
> Output:  
> 0
>
> Explanation:  
> The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

**Solution:**

分析位数规律有：

1. 个位数：1-9，一共 9 个，共 1*9 个数字
1. 十位数：10-99，一共 90 个，共 2*90 个数字
1. 百位数：100-999，一共 900 个，共 3*900 个数字
1. 千位数：1000-9999，一共 9000 个，共 4*9000 个数字

依此类推，我们可以先定位出给定 n 对应数字的位数，然后得出其在相应位数的数字中的位置，同时也可以得到 n 对应于数字中的位置。

然后求出数字，得出要求的数字。

```java
public static int findNthDigit(int n) {
    int digitCount = 1; // 整数位数
    long digitNum = 9;   // 该位数情况下整数个数

    // digitCount * digitNum = 该位数情况下，数字个数
    while (n > digitCount * digitNum) {
        n -= digitCount * digitNum;
        ++digitCount;
        digitNum *= 10;
    }

    int position = (n - 1) / digitCount;    // 在该位数情况下，n 的位置
    int index = (n - 1) % digitCount;       // 要求的数字在 n 中的位置

    int number = (int) (Math.pow(10, digitCount - 1) + position);
    return Integer.parseInt(String.valueOf(String.valueOf(number).charAt(index)));
}
```

## 406

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers `(h, k)`, where `h` is the height of the person and `k` is the number of people in front of this person who have a height greater than or equal to `h`. Write an algorithm to reconstruct the queue.

**Note:**

The number of people is less than 1,100.

**Example:**

```
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
```

**Solution:**

一种十分巧妙的解法是：先对 people 进行倒序排序，按照 `h` 排序，如果 `h` 相等则按照 `k` 排序。

然后以 `k` 为索引往一个新的列表中插入。

这种方法利用了排序后的有序性和题目规则限制。

另外，匿名内部类的实现方式执行起来似乎比 lambda 表达式快一点点。

```java
public static int[][] reconstructQueue(int[][] people) {
    // 按身高倒序排列，身高相同的按 k 排列
    Arrays.sort(people, (c1, c2) -> {
        if (c1[0] != c2[0]) {
            return c2[0] - c1[0];
        } else {
            return c1[1] - c2[1];
        }
    });
    List<int[]> ret = new ArrayList<>();
    // 然后将排序好的元素一一插入 List
    for (int[] person : people) {
        ret.add(person[1], person);
    }
    return ret.toArray(new int[people.length][]);
}
```

## 413

A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

> 1, 3, 5, 7, 9  
> 7, 7, 7, 7  
> 3, -1, -5, -9

The following sequence is not arithmetic.

> 1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.(And this means the sequence is at least 3 elements)

The function should return the number of arithmetic slices in the array A.

**Example:**

> A = [1, 2, 3, 4]
>
> return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.

**Solution:**

Find the law from the numbers:

> 1, 2, 3 => 1  
> 1, 2, 3, 4 => 3 = 1 + 2  
> 1, 2, 3, 4, 5 => 6 = 3 + 3 = 1 + 2 + 3  
> 1, 2, 3, 4, 5, 6 => 10 = 6 + 4 = 1 + 2 + 3 + 4  
> 1, 2, 3, 4, 5, 6, 7 => 15 = 10 + 5 = 1 + 2 + 3 + 4 + 5  

And apply the law to another sequences to verify it.

```java
public static int numberOfArithmeticSlices(int[] A) {
    int ret = 0;
    int[] count = new int[A.length];
    Arrays.fill(count, 0);
    for (int i = 2, len = A.length; i < len; i++) {
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            count[i] = count[i - 1] + 1;
        }
        ret += count[i];
    }
    return ret;
}
```

## 417

Given an `m` x `n` matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

**Note:**

1. The order of returned grid coordinates does not matter.
1. Both m and n are less than 150.

**Example:**

> Given the following 5x5 matrix:
>
>  Pacific ~   ~   ~   ~   ~  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~  1   2   2   3  (5) &nbsp;&nbsp;*  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~  3   2   3  (4) (4) *  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~  2   4  (5)  3   1  &nbsp;&nbsp;*  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~ (6) (7)  1   4   5  *  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~ (5)  1   1   2   4  &nbsp;&nbsp;*  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*  &nbsp;*   *   *   * Atlantic
>
> Return:
>
> [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

**Solution:**

我的思路是从海洋边缘开始处理，如果相邻节点的高度高于或者等于当前结点，就将其标记为 true。用两个 Boolean 数组来表示两个海洋，当某一位置对应两个数组的元素同时为 true 的时候就说明符合条件。

```java
private static int[] dx = {0, 0, -1, 1};
private static int[] dy = {1, -1, 0, 0};

public static List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> ret = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return ret;
    }
    int n = matrix.length, m = matrix[0].length;
    boolean[][] pacificVisited = new boolean[n][m];
    boolean[][] atlanticVisited = new boolean[n][m];
    // 从每一行的首尾对每一个元素进行判断，首代表 pacific，尾代表 Atlantic
    for (int i = 0; i < n; i++) {
        flow(pacificVisited, matrix, i, 0, n, m);
        flow(atlanticVisited, matrix, i, m - 1, n, m);
    }
    // 从每一列的首尾对每一个元素进行判断，首代表 pacific，尾代表 Atlantic
    for (int i = 0; i < m; i++) {
        flow(pacificVisited, matrix, 0, i, n, m);
        flow(atlanticVisited, matrix, n - 1, i, n, m);
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                ret.add(new int[]{i, j});
            }
        }
    }
    return ret;
}

// 流向的含义是：当前元素小于或者等于下一个（前后左右）元素，则可以流通
private static void flow(boolean[][] visited, int[][] matrix, int x, int y, int n, int m) {
    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
            if (!visited[nx][ny] && matrix[nx][ny] >= matrix[x][y]) {
                flow(visited, matrix, nx, ny, n, m);
            }
        }
    }
}
```

## 445

You are given two `non-empty` linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Example:**

```
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
```

**Solution:**

将两个链表转置然后归并可解：

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    l1 = reverse(l1);
    l2 = reverse(l2);

    ListNode node = new ListNode(-1), cur = node;
    boolean carry = false;
    while ((l1 != null && l2 != null) || carry) {
        int sum;
        if (carry) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + 1;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        } else {
            sum = l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (sum >= 10) {
            cur.next = new ListNode(sum % 10);
            carry = true;
        } else {
            cur.next = new ListNode(sum);
            carry = false;
        }
        cur = cur.next;
    }
    while (l1 != null) {
        cur.next = new ListNode(l1.val);
        l1 = l1.next;
        cur = cur.next;
    }
    while (l2 != null) {
        cur.next = new ListNode(l2.val);
        l2 = l2.next;
        cur = cur.next;
    }

    return reverse(node.next);
}

private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode ret = null, next = null;
    while (head != null) {
        next = head.next;
        head.next = ret;
        ret = head;
        head = next;
    }
    return ret;
}
```

题中还说了一种不改变链表的情况求解，可以使用栈来做。

## [447 Number of Boomerangs](https://leetcode.com/problems/number-of-boomerangs/description/)

给定 n 个坐标点，要求寻求一个三元组 `(i,j,k)` 使得 i 到 j 的距离与 i 到 k 的距离相等，求所有的三元组的数量。由距离相等可知 

```
(i.x-j.x)^2 + (i.y-j.y)^2 = (i.x-k.x)^2 + (i.y-k.y)^2
```

解法是，遍历数组，对于当前元素，计算其他元素与其距离，然后保存距离出现的次数。在计算完所有的距离后，对于所有出现次数 f 大于等于 2 的距离，则表明对于当前节点存在 f 个节点与其距离相等，则应当在结果数量中加上：

```
f * (f - 1)
```

即从 f 个不同的点中选两个点的可能结果数。

```java
public int numberOfBoomerangs(int[][] points) {
    if (points == null || points.length < 2) {
        return 0;
    }
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0, len = points.length; i < len; i++) {
        for (int j = 0; j < len; j++) {
            if (i == j) {
                continue;
            }
            int distance = distance(points[i], points[j]);
            map.put(distance, map.getOrDefault(distance, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                int t = e.getValue();
                count += t * (t - 1);
            }
        }
        map.clear();
    }
    return count;
}
```

## [450 Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/description/)

> 从 BST 中删除一个节点，如果节点有左右孩子，任选左孩子的最大节点或者右孩子的最小节点进行替换

BST 的删除，很简单。算法：

1. 如果当前节点为空，则返回空
1. 如果当前节点的值比要删除的值大，则递归调用对其左节点的删除
1. 如果当前节点的值比要删除的值小，则递归调用对其右节点的删除
1. 如果当前节点正是要删除的节点，有四种情况需要谈论。

当当前节点是要删除的节点时：

1. 当前节点为空，返回空
1. 当前节点只有左孩子，用左孩子替换当前节点
1. 当前节点只有右孩子，用右孩子替换当前节点
1. 当前节点有左右孩子，用左子树的最大节点或者右子树的最小节点替换当前节点

其实上面 4 中情况的前三种可以融合成一句话：

```
root = (root.left != null) ? root.left : root.right;
```

```java
public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
        return root;
    } else if (root.val > key) {
        root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
    } else {
        if (root.left != null && root.right != null) {
            TreeNode rightMin = root.right;
            while (rightMin.left != null) {
                rightMin = rightMin.left;
            }
            root.val = rightMin.val;
            root.right = deleteNode(root.right, root.val);
        } else {
            root = (root.left != null) ? root.left : root.right;
        }
    }
    return root;
}
```

## 467

Consider the string `s` to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so `s` will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

Now we have another string `p`. Your job is to find out how many unique non-empty substrings of `p` are present in `s`. In particular, your input is the string `p` and you need to output the number of different non-empty substrings of `p` in the string `s`.

**Note:**

`p` consists of only lowercase English letters and the size of p might be over 10000.

**Example 1:**

```
Input: "a"
Output: 1

Explanation: Only the substring "a" of string "a" is in the string s.
```

**Example 2:**

```
Input: "cac"
Output: 2
Explanation: There are two substrings "a", "c" of string "cac" in the string s.
```

**Example 3:**

```
Input: "zab"
Output: 6
Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
```

**Solution:**

判断 p 的非空子串中有多少是 s 的子串，其中 s 是 `"abcd...xyzabcd......"` 形式的无限串。也就是求 p 中非空连续子串的个数，其中 `z` 后是 `a`。

对于这题，我们可以只考虑 26 个字符分别作为子串结尾时的情况。这种考虑的依据是：

1. 以某个字符结尾的最大子串个数等于以该字符结尾的连续子串个数。例如 `abcd`，以 `d` 结尾的最大子串个数是 `4`，分别是 `abcd`, `bcd`, `cd`, `d`。
1. 如果 p 中存在重复字符，我们只需要考虑最长的串。例如 `abcdbcd`，以 `d` 结尾的最大字串是 4，并且由后面 `bcd` 所推导出的所有子串都已经包含在 `abcd` 推导出的子串中了。
1. 不管 `p` 中连续子串有多长，它始终包含在 `s` 中，因为 `s` 无限长。
1. 最后，我们将所有 26 个字符结尾的子串的长度相加，就是我们需要的结果。

```java
public int findSubstringInWraproundString(String p) {
    int[] count = new int[26];
    char[] input = p.toCharArray();
    int tmpMax = 0;
    for (int i = 0; i < input.length; i++) {
        if (i > 0 && (input[i] - input[i - 1] == 1 || input[i - 1] - input[i] == 25)) {
            tmpMax++;
        } else {
            tmpMax = 1;
        }

        int index = input[i] - 'a';
        count[index] = Math.max(count[index], tmpMax);
    }

    return Arrays.stream(count).sum();
}
```

## [482 License Key Formatting](https://leetcode.com/problems/license-key-formatting/description/)

题目要求我们对 License key 进行格式化，保证将给定的 key 格式化为以 `-` 分隔的固定长度 K 的大写字符串，不要求长度为 K 但是必须有至少一个元素（也就是禁止 `-abcd-efgh` 的情况）。

思路是先将 `-` 去除，得到新的字符串 str ，然后在固定位置插入 `-`，按照题目约束，插入 `-` 的位置是确定的，即：str.len() - K, str.len() - 2K, ... str.len() - nK。其中 str.len() - nK > 0。

```java
public String licenseKeyFormatting(String S, int K) {
    StringBuilder sb = new StringBuilder(Arrays.stream(S.split("-"))
            .parallel()
            .map(String::toUpperCase)
            .collect(Collectors.joining())
    );
    for (int i = sb.length() - K; i > 0; i -= K) {
        sb.insert(i, "-");
    }
    return sb.toString();
}
```

但是不知道是 Stream API 还是 Spring#split 方法的原因，该解法运行的十分慢。所以我们有了第二种解法：

```java
public String licenseKeyFormatting(String S, int K) {
    int len = S.length();
    StringBuilder sb = new StringBuilder(len + len / K);
    for (int i = len - 1, j = 0; i >= 0; i--) {
        char c = S.charAt(i);
        if (c == '-') {
            continue;
        } else if (c > 96) {
            c -= 32;
        }
        if (j++ % K == 0) {
            sb.append('-');
        }
        sb.append(c);
    }
    return sb.length() == 0 ? "" : sb.deleteCharAt(0).reverse().toString();
}
```

思路是从后往前，利用 StringBuilder 构建字符串，每经过一个原有的 `-` 就跳过，每添加特定数目的字符后就添加一个 `-`。最后再将多余的第一个 `-` 删除，字符数组倒置即可。

## 492

For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

```
1. The area of the rectangular web page you designed must equal to the given target area.

2. The width W should not be larger than the length L, which means L >= W.

3. The difference between length L and width W should be as small as possible.
```

You need to output the length L and the width W of the web page you designed in sequence.

**Example:**

```
Input: 4
Output: [2, 2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
```

**Note:**

1. The given area won't exceed 10,000,000 and is a positive integer
1. The web page's width and length you designed must be positive integers.

**Solution:**

分析之后十分简单，找到给定数值差距最小的因子，从 `Math.sqrt(n)` 递减找到第一对因子即可。

我的解法稍微直观了点，因为第一遍忘记设置大小顺序本地测试失败就没按照上述思路做：

```java
public static int[] constructRectangle(int area) {
    int div;
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o1[0]-o1[1]) - (o2[0] - o2[1]);
        }
    });

    for (int i = (int) Math.sqrt(area); i > 0; i--) {
        if (area % i == 0) {
            div = area / i;
            if (div > i) {
                priorityQueue.add(new int[]{div, i});
            } else {
                priorityQueue.add(new int[]{i, div});
            }
        }
    }

    return priorityQueue.poll();
}
```

利用优先队列的有序性，最后输出队列头元素即可。实际上在求出第一对元素时直接按照大小位置排好输出即可：

```java
public int[] constructRectangle(int area) {
    int[] res = new int[2]; 
    if (area == 0) {
        return new int[0]; 
    }

    for (int i = (int) Math.sqrt(area); i > 0; i--) {
        if (area % i == 0) {
            res[0] = Math.max(i, area / i); 
            res[1] = Math.min(i, area / i); 
            return res; 
        }
    }

    return res; 
}
```

## 503

Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

**Example 1:**

```
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
```

**Note:**

The length of given array won't exceed 10000.

**Solution:**

这题可以暴力解，对于每个元素，从元素当前位置往后遍历数组两遍，找最大元素，找不到就设置对应返回数组位置值为 -1.

更好的做法是利用栈，遍历两遍数组（题目要求循环数组），通过循环变量对 n 取余取出当前数字。如果栈不为空，并且栈顶元素小于当前数字，说明当前数字是栈顶元素右边的第一个较大数，将结果数组中栈顶元素对应下标的值设置为 当前数字。

然后如果循环变量小于 n，将循环变量压入栈。

```java
public int[] nextGreaterElements(int[] nums) {
    int length = nums.length, current;
    int[] res = new int[length];
    LinkedList<Integer> stack = new LinkedList<>();

    Arrays.fill(res, -1);
    for (int i = 0; i < length * 2; i++) {
        current = nums[i % length];
        while (!stack.isEmpty() && nums[stack.peekLast()] < current) {
            res[stack.peekLast()] = current;
            stack.pollLast();
        }
        if (i < length) {
            stack.addLast(i);
        }
    }
    return res;
}
```

## 515

You need to find the largest value in each row of a binary tree.

**Example:**

```
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
```

**Solution:**

可以使用 BFS 来做，利用队列，每一次添加一层元素进去，然后求最大值加入结果列表，然后循环计算下一层。

我的解法是利用先序遍历（DFS），在遍历的时候比较当前值与结果列表中对应位置的值的大小：

```java
public static List<Integer> largestValues(TreeNode root) {
    List<Integer> list = new ArrayList<>(); // 直接将最大值设置在 list 相应位置上
    getMax(root, list, 0);
    return list;
}

private static void getMax(TreeNode root, List<Integer> list, int depth) {
    if (root == null) {
        return;
    }
    if (depth == list.size()) {
        list.add(root.val); // 第一次到的时候，直接设置当前元素为该 depth 最大值
    } else {
        list.set(depth, Math.max(list.get(depth), root.val)); // 否则，按情况更新
    }
    getMax(root.left, list, depth + 1);
    getMax(root.right, list, depth + 1);
}
```

## 517

You have **n** super washing machines on a line. Initially, each washing machine has some dresses or is empty.

For each **move**, you could choose **any m** (1 ≤ m ≤ n) washing machines, and pass **one dress** of each washing machine to one of its adjacent washing machines **at the same time**.

Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the **minimum number of moves** to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.

**Example 1**

> Input: [1,0,5]
>
> Output: 3
>
> Explanation:   
1st move:    1     0 <-- 5    =>    1     1     4  
2nd move:    1 <-- 1 <-- 4    =>    2     1     3    
3rd move:    2     1 <-- 3    =>    2     2     2   

**Example 2**

> Input: [0,3,0]
>
> Output: 2
>
> Explanation:   
1st move:    0 <-- 3     0    =>    1     2     0    
2nd move:    1     2 --> 0    =>    1     1     1     

**Example 3**

> Input: [0,2,0]
>
> Output: -1
>
> Explanation:  
> It's impossible to make all the three washing machines have the same number of dresses. 

**Note:**

1. The range of n is [1, 10000].
1. The range of dresses number in a super washing machine is [0, 1e5].

**Solution:**

本题使用动态规划来解。

假设有四个洗衣机，初始状态为：[0, 0, 11, 5];

计算可知最终状态会变成 [4, 4, 4, 4]；

将二者做差得到：[-4, -4, 7, 1]，其中负值表示当前洗衣机还需要的衣服数，正值表示当前洗衣机多余的衣服数

我们要做的是将这个差值数组每一项都变为 0；

对于第一个洗衣机，需要四件衣服可以从第二个洗衣机得到，那么就可以把 -4 转移给二号洗衣机，得到 [0, -8, 7, 1]；

此时二号洗衣机需要 8 件衣服，转移给三号：[0, 0, -1, 1]；

三号需要移动一次，从四号处获取剩下的一件；

移动的最大次数就是差值数组中出现的绝对值最大的数字；

```java
public static int findMinMoves(int[] machines) {
    int sum = 0;
    for (int machine : machines) {
        sum += machine;
    }

    if (sum % machines.length != 0) {
        return -1;
    }

    int average = sum / machines.length;
    int reverse = 0, ret = 0;
    for (int machine : machines) {
        reverse += machine - average;
        ret = Math.max(ret, Math.max(Math.abs(reverse), machine - average));
    }
    return ret;
}
```

## 526

Suppose you have **N** integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these **N** numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

1. The number at the ith position is divisible by **i**.
1. **i** is divisible by the number at the ith position.

Now given N, how many beautiful arrangements can you construct?

**Example 1:**

> Input: 2  
> Output: 2  
> Explanation: 
>
> The first beautiful arrangement is [1, 2]:
>
> Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
>
> Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
>
> The second beautiful arrangement is [2, 1]:
>
> Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
>
> Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

**Note:**

1. **N** is a positive integer and will not exceed 15.

**Solution:**

这是标准的应用回溯算法的地方：

```java
public static int countArrangement(int N) {
    if (0 == N)
        return 0;
    boolean[] visited = new boolean[N + 1];
    Arrays.fill(visited, false);
    return backtracking(N, 1, visited);
}

private static int backtracking(int N, int position, boolean[] visited) {
    if (position > N) {
        return 1;
    }
    int count = 0;
    for (int i = 1; i <= N; i++) {
        if (!visited[i] && (position % i == 0 || i % position == 0)) {
            visited[i] = true;
            count += backtracking(N, position + 1, visited);
            visited[i] = false;
        }
    }
    return count;
}
```

但是也有直接暴力穷举：

```java
class Solution {
    public int countArrangement(int N) {
    int[] res = {1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
    return res[N-1];
    }
}
```

## [561 Array Partition I](https://leetcode.com/problems/array-partition-i/description/)

> 给定一个长度为 `2n` 的数组，将其分为 `n` 组：`(a1,b1), (a2,b2),...(an,bn)`，使得 `min(ai,bi)` 的总和最大。

要使得 `min(ai,bi)` 尽可能大，则需要把数组中较大的数分为一组。即对于 `[1,4,3,2]`，只有将 `(3,4)` 分为一组，才能得到较大的一个数。而每次我们都需要将较大的数分为一组，所以我们可以将其排序，然后只取奇数位置的数即可：

```java
public int arrayPairSum(int[] nums) {
    int n = nums.length >> 1;
    int sum = 0;
    Arrays.sort(nums);
    for (int i = 0; i < n; i++) {
        sum += nums[i << 1];
    }
    return sum;
}
```

这种算法的时间复杂度为 `O(NlogN) + O(N) = O(NlogN)`，我们可以看出来时间主要花费在排序算法上了，而对于本体，数组中整数的范围已经给定，我们可以考虑使用桶排序来替换 `Arrays#sort` 的快排，这样整体的时间复杂度就下降为 O(N)，而空间复杂度上升为 O(N)。

```java
public int arrayPairSum(int[] nums) {
    int[] bucket = new int[20001];
    int sum = 0;
    boolean odd = true;
    for (int num : nums) {
        bucket[num + 10000]++;
    }
    for (int i = 0; i < bucket.length; i++) {
        while (bucket[i] > 0) {
            if (odd) {
                sum += i - 10000;
            }
            odd = !odd;
            bucket[i]--;
        }
    }
    return sum;
}
```

## [563 Binary Tree Tilt](https://leetcode.com/problems/binary-tree-tilt/description/)

找出树的倾斜度，树的倾斜度被定义为树上所有节点的倾斜度，一个节点的倾斜度为其左子树的值之和与其右子树的和的差值，叶子节点的倾斜度为 0。

因为涉及到左右子树的值之和，所以只能使用递归来做：

```java
private int sum;

public int findTilt(TreeNode root) {
    System.out.println(helper(root));
    return sum;
}

private int helper(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int left = helper(root.left);
    int right = helper(root.right);
    sum += Math.abs(left - right);
    return left + root.val + right;
}
```

## [565 Array Nesting](https://leetcode.com/problems/array-nesting/description/)

给定一个数组，要求找出最长的 set S，其中 S[i]={A[i], A[A[i]], A[A[A[i]]], ...}。构造 S 的规则为：

> 假定 S 的第一个元素为索引 i 对应的数组元素，那么下一个元素为 A[A[i]]，并且下下个元素 A[A[A[i]]]。直到要添加的下一个元素已经在 S 中出现。

最直观的解法就是直接用一个 Set 保存每一个 i 对应的结果集合，然后判断是否大于 max：

```java
public int arrayNesting(int[] nums) {
    int max = 0;
    Set<Integer> set = new HashSet<>();

    for (int num : nums) {
        int t = num;
        while (!set.contains(t)) {
            set.add(t);
            t = nums[t];
        }
        if (max < set.size()) {
            max = set.size();
        }
        set.clear();
    }
    return max;
}
```

但是 `Time Limit Exceeded`。

我们分析一下原因，根据题目要求，按照规则构建的 set S 一定会出现环，这也是 set 构建的终止条件。对于出现的环：

**无论从环上的哪一个元素出发，最终都会回到当前元素。**

这一点很好理解。据此，我们可以利用一个 visited 数组，将访问过的位置设置为 true，只从之前未访问过的元素开始构建 set。因为从任何访问过的位置出发，最终还是会回到该位置，是不必要的计算。

```java
public int arrayNesting(int[] nums) {
    boolean[] visited = new boolean[nums.length];
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
        if (!visited[i]) {
            int start = nums[i], count = 0;
            do {
                start = nums[start];
                count++;
                visited[start] = true;
            } while (start != nums[i]);
            result = Math.max(result, count);
        }
    }
    return result;
}
```

## [581 Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/)

> 给定一个数组，找出其中最短连续子数组的长度。要求对该子串进行排序后，数组也是有序的（递增）。

最简单的思路是将数组拷贝一份，然后进行排序，将排序后的副本与原来的数组比对，从而确定子数组的起始与终止位置。

```java
public int findUnsortedSubarray(int[] nums) {
    int[] copy = nums.clone();
    Arrays.sort(copy);
    int start = copy.length, end = 0;
    for (int i = 0; i < copy.length; i++) {
        if (copy[i] != nums[i]) {
            start = Math.min(start, i);
            end = Math.max(end, i);
        }
    }
    return end >= start ? end - start + 1 : 0;
}
```

算法的时间复杂度为 O(log N)。

另一种算法是，分别从数组的首尾出发，找到从数组起始位置开始递增子数组的终止位置 i，以及直到数组末尾位置的递增子数组的起始位置 j。然后对 `i,j` 之间的元素求最大值与最小值，分别更新 `i,j` 到合适的位置。

我们用一个实例来演示这个算法，设数组为 `[2, 6, 4, 8, 10, 9, 15]`，当判断出 `i,j` 时：

```
[2, 6, 4, 8, 10, 9, 15]
    |            |
    i            j
```

也就是 `i,j` 分别指向数组首尾递增序列的 终止/起始 位置。现在我们找出 `i,j` 中间数组的最大值 10 与最小值 4。

我们将 `i,j` 指向子数组的外围（即 `i,j` 中间的元素为最终的子数组），如果要所得最小序列排序后整个数组也是有序的，那么子序列的最小值一定不小于 i 所指元素，子序列的最大值一定不大于 j 所指元素。依次更新 `i,j` 的指向即可。

```java
public int findUnsortedSubarray(int[] nums) {
    int start = 0, end = nums.length - 1;
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    while (start < end && nums[start] <= nums[start + 1])
        start++;
    if (start == end) return 0;    // 数组为升序

    // 这一步的时候数组不可能为升序，故不需要 end > 0 的条件
    while (nums[end] >= nums[end - 1])
        end--;

    for (int i = start; i <= end; i++) {
        max = Math.max(max, nums[i]);
        min = Math.min(min, nums[i]);
    }

    while (start >= 0 && min < nums[start])
        start--;
    while (end <= nums.length - 1 && max > nums[end])
        end++;

    // start 多减了 1，end 多加了 1
    return end - start - 1;
}
```

此算法打败了 99.8% 的提交者。

对于上述算法我们可以进行简化，利用两个指针同时移动。`l` 从左往右移动，`r` 从右往左移动。

如果数组是递增的，则 `nums[l] == max`，同时我们更新 max。当 `nums[l] != max` 的时候，说明递增中断了，我们用变量 end 记录 l 的位置。当遍历结束时，我们可以肯定：**end 之后的元素一定是递增的！**

同理，如果数组是递增的，那么从 r 往左走一定是一个递减序列，`nums[r] == min`，我们更新 min。当 `nums[r] != min` 时，说明递增中断了，我们用变量 start 记录此时 r 的位置。当遍历结束时，我们可以肯定：**start 之前的元素一定是递增的！**

据此，我们得出解法三：

```java
public int findUnsortedSubarray(int[] nums) {
    int start = 0, end = -1;
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    for (int l = 0, r = nums.length - 1; r >= 0; l++, r--) {
        max = Math.max(max, nums[l]);
        if (nums[l] != max) end = l;

        min = Math.min(min, nums[r]);
        if (nums[r] != min) start = r;
    }

    return end - start + 1;
}
```

## [599 Minimum Index Sum of Two Lists](https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/)

找出两个字符串数组中相同的字符串，要求两个字符串的索引和最小。如果存在多个索引和相同、字符串相同的情形，将所有字符串加入结果数组。

可以通过将一个字符串数组转换为 Map，key 为字符串，value 为索引，来加速判断过程。

```java
public String[] findRestaurant(String[] list1, String[] list2) {
    int min = Integer.MAX_VALUE;
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < list2.length; i++) {
        map.put(list2[i], i);
    }

    int another;
    Map<Integer, List<Integer>> res = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
        if ((another = map.getOrDefault(list1[i], -1)) != -1) {
            if (min >= i + another) {
                min = i + another;
                List<Integer> list = res.getOrDefault(min, new ArrayList<>());
                list.add(i);
                res.put(min, list);
            }
        }
    }

    List<Integer> list = res.get(min);
    String[] result = new String[list.size()];
    for (int i = 0; i < list.size(); i++) {
        result[i] = list1[list.get(i)];
    }
    return result;
}
```

## 605

Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number `n`, return if `n` new flowers can be planted in it without violating the no-adjacent-flowers rule.

**Example 1:**

> Input: flowerbed = [1,0,0,0,1], n = 1
>
> Output: True

**Example 2:**

> Input: flowerbed = [1,0,0,0,1], n = 2
>
> Output: False

**Note:**

1. The input array won't violate no-adjacent-flowers rule.
1. The input array size is in the range of [1, 20000].
1. `n` is a non-negative integer which won't exceed the input array size.

**Solution:**

分析题义，如果可以将 n 朵花都放进去，就返回 true，且花朵必须两两不相连。

那么要插入的位置只有两种情况：

1. 当前位置之前的元素是 0，当前元素是 0，后续元素也是 0
1. 当前位置之前的元素是 0，当前元素是 0，当前元素是最后一个元素

这样我们可以通过一个 `flag`（true表示前一个元素为 0，false表示前一个元素为 1） 值来判断是否符合条件。对于首个元素的情况，我们可以将 flag 根据第一个元素的不同预设为不同的值（如果首元素为 1，则 flag 预设为 false；如果首元素为 0，则 flag 预设为 true）。

代码：

```java
public class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean flag = flowerbed[0] != 1;

        for (int i = 0, len = flowerbed.length; i < len; i++) {
            if (flag) { // flag 为 true 表示上一位是 0
                if (flowerbed[i] == 0) {
                    if ((i < len - 1 && flowerbed[i + 1] == 0) || i == len - 1) {
                        flowerbed[i] = 1;
                        n--;
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            } else { // 上一位是 1
                if (flowerbed[i] == 0) {
                    flag = true;
                }
            }
        }

        return n <= 0;
    }
}
```

## 617

Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

**Example 1:**

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7

**Note:** The merging process must start from the root nodes of both trees.

**Solution:**

简单的二叉树合并问题，使用递归即可。

```java
TreeNode node = new TreeNode(t1.val + t2.val);
node.left = mergeTrees(t1.left, t2.left);
node.right = mergeTrees(t1.right, t2.right);
return node;
```

以上方法似乎比以下方法运行的更快：

```java
t1.val += t2.val;
t1.left = mergeTrees(t1.left, t2.left);
t1.right = mergeTrees(t1.right, t2.right);
return t1;
```

## 627

Given a table `salary`, such as the one below, that has m=male and f=female values. Swap all f and m values (i.e., change all f values to m and vice versa) with a single update query and no intermediate temp table.

For example:

| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | m   | 2500   |
| 2  | B    | f   | 1500   |
| 3  | C    | m   | 5500   |
| 4  | D    | f   | 500    |

After running your query, the above salary table should have the following rows:

| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | f   | 2500   |
| 2  | B    | m   | 1500   |
| 3  | C    | f   | 5500   |
| 4  | D    | m   | 500    |

**Solution:**

```sql
-- Solution 1
UPDATE `salary` SET sex = (
    CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END
)

-- Solution 2
UPDATE salary SET sex = CHAR(ASCII(sex) ^ 11);
-- OR
UPDATE salary SET sex = CHAR(ASCII('f') ^ ASCII('m') ^ ASCII(sex));
-- Explanation: 
-- ASCII('f') = 109
-- ASCII('m') = 102
-- 109 ^ 102 = 11
-- 11 ^ 109 = 102
-- 11 ^ 102 = 109
```

## 645

The set `S` originally contains numbers from 1 to `n`. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array `nums` representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

**Example 1:**

```
Input: nums = [1,2,2,4]
Output: [2,3]
```

**Note:**

1. The given array size will in the range [2, 10000].
1. The given array's numbers won't have any order.

**Solution:**

将输入依次映射到一个个数数组，数组下标代表输入数组的数，数组元素代表该下标出现的次数。映射完成后扫描该数组即可得出缺的数（元素值为 0）和重复的数（元素值为 2）

```java
public int[] findErrorNums(int[] nums) {
    int[] ret = new int[2];
    int[] store = new int[nums.length + 1];
    for (int num : nums) {
        store[num] = store[num] + 1;
    }
    for (int i = 1; i < nums.length + 1; i++) {
        if (store[i] == 0) {
            ret[1] = i;
        }
        if (store[i] == 2) {
            ret[0] = i;
        }
    }
    return ret;
}
```

此提交打败了 100% 的 java 提交者。

## [648 Replace Words](https://leetcode.com/problems/replace-words/description/)

给定一个前缀数组，从给定的句子中将前缀匹配的单词转换为前缀，如果多个前缀匹配到一个单词，替换为最短的前缀。

可以直接扫描输入句子求解：

```java
public String replaceWords(List<String> dict, String sentence) {
    String[] strings = sentence.split(" ");
    for (int i = 0; i < strings.length; i++) {
        for (String d : dict) {
            if (strings[i].startsWith(d)) {
                strings[i] = d;
            }
        }
    }
    return String.join(" ", strings);
}
```

算法时间复杂度 O（KN），K 为 dict 的长度。

因为是前缀匹配，自然也可以用前缀树来求解：

```java
public String replaceWords(List<String> dict, String sentence) {
    TrieNode root = new TrieNode(" ");
    for (int i = 0; i < dict.size(); i++) {
        root.insert(dict.get(i));
    }
    StringBuilder sb = new StringBuilder();
    for (String word : sentence.split(" ")) {
        String temp = root.search(word);
        if (temp.equals(" ")) {
            sb.append(word);
        }
        else {
            sb.append(temp);
        }
        sb.append(" ");
    }
    return sb.toString().trim();
}

class TrieNode {
    String val;
    TrieNode[] children = new TrieNode[26];

    TrieNode(String val) {
        this.val = val;
    }

    public void insert(String word) {
        TrieNode cur = this;
        for (int i = 0; i < word.length(); i++) {
            int p = word.charAt(i) - 'a';
            if (cur.children[p] == null) {
                cur.children[p] = new TrieNode(" ");
            }
            cur = cur.children[p];
        }
        cur.val = word;
        return;
    }

    public String search(String word) {
        TrieNode cur = this;
        for (int i = 0; i < word.length(); i++) {
            int p = word.charAt(i) - 'a';
            if (cur.children[p] == null) {
                return " ";
            }
            cur = cur.children[p];
            if (cur.val != " ") {
                return cur.val;
            }
        }
        return " ";
    }
}
```

## [659 Split Array into Consecutive Subsequences](https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/)

给定一个可能包含重复数字的升序序列，要求将其划分为数个子序列，每个子序列至少包含 3 个元素并且是**连续递增子序列**。所以对于序列 [1,2,3,4,5]，解法 `[1,2,3,4,5]` 是可行的，这样我们就想到贪心算法。

设置两个 Map，一个保存序列中数字个数（frequent），另一个保存**某个连续递增子序列之后的数字**以及其可能出现的次数（exist）。

遍历序列，对于序列中的每一个数字 x：

1. 如果 frequent(x) = 0，则直接跳过，开始下一轮循环
1. 如果 exist(x) > 0，说明可以把 x 连接到某个连续递增子序列之后，也说明一定存在以 x+1 结尾的子序列（贪心），分别更新 exist(x)、exist(x+1)、frequent(x)
1. 如果 exist(x) <= 0，说明不存在 x 可以连接到的子序列，我们需要判断能否以 x 为开头开启一个子序列，即判断 frequent(x+1) > 0 && frequent(x+2) > 0，如果存在，则更新 frequent(x)、frequent(x+1)、frequent(x+2)、exist(x+3)

```java
public boolean isPossible(int[] nums) {
    Map<Integer, Integer> frequent = new HashMap<>();
    Map<Integer, Integer> exist = new HashMap<>();
    for (int num : nums) {
        frequent.put(num, frequent.getOrDefault(num, 0) + 1);
    }
    for (int num : nums) {
        if (frequent.getOrDefault(num, 0) == 0) {
            continue;
        }
        if (exist.getOrDefault(num, 0) > 0) {
            exist.put(num, exist.get(num) - 1);
            exist.put(num + 1, exist.getOrDefault(num + 1, 0) + 1);
            frequent.put(num, frequent.get(num) - 1);
        } else if (frequent.getOrDefault(num + 1, 0) > 0 && frequent.getOrDefault(num + 2, 0) > 0) {
            frequent.put(num + 1, frequent.get(num + 1) - 1);
            frequent.put(num + 2, frequent.get(num + 2) - 1);
            exist.put(num + 3, exist.getOrDefault(num + 3, 0) + 1);
            frequent.put(num, frequent.get(num) - 1);
        } else {
            return false;
        }
    }
    return true;
}
```

## [671 Second Minimum Node In a Binary Tree](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/)

> 给定一个特殊二叉树，每个节点要么有两个子节点，要么没有子节点。有两个子节点的节点的值是两个子节点中较小的节点的值。求出二叉树中第二小的值，如果没有则返回 -1.

我们可以先将二叉树遍历，得到所有元素，然后找出第二小的值：

```java
public int findSecondMinimumValue(TreeNode root) {
    if (root == null || root.left == null) {
        return -1;
    }
    Set<Integer> set = new HashSet<>();
    dfs(root, set);
    int min = root.val, result = Integer.MAX_VALUE;
    for (Integer integer : set) {
        if (min < integer && result > integer) {
            result = integer;
        }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
}

private void dfs(TreeNode root, Set<Integer> set) {
    if (root != null) {
        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }
}
```

因为题目要求的二叉树中，最小节点一定是根节点，所以我们不用上述算法中那么多的判断，只需要在找第二小节点前将根节点删除即可：

```java
public int findSecondMinimumValue(TreeNode root) {
    Set<Integer> set = new HashSet<>();
    dfs(root, set);
    set.remove(root.val);
    int result = Integer.MAX_VALUE;
    for (Integer integer : set) {
        if (result > integer) {
            result = integer;
        }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
}
```

## [673 Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/)

此题要找最长递增子序列的个数，一般能想到的就是 dp 了。直接对问题分析比较复杂，我们可以从另一个角度来看。考虑以 i 元素为递增子序列最后一个元素的情况，我们用 `length` 数组表示以某元素结尾的递增子序列的最大，用 `numbers` 数组表示对应长度的递增子序列个数。初始两个数组中元素均为 1.

现在我们遍历数组，对于 i 元素，遍历其之前的元素：

1. 如果 nums[j] > nums[i] 则不做考虑，因为不是递增序列。
1. 如果 length[i] < length[j] + 1，表明出现了更长的递增序列，将 length[i] 更新为 length[j] + 1，同时将 numbers[i] 更新为 numbers[j]，因为有了更长的递增子序列，所有原来的 numbers[i] 已经无用
1. 如果 length[i] == length[j] + 1，则表明以 i 结尾，最大长度为 length[i] 的子序列又出现了一个，此时我们需要更新 numbers 数组：numbers[i] = numbers[i] + numbers[j]

解法：

```java
public int findNumberOfLIS(int[] nums) {
    int maxLen = 0, maxNum = 0;
    int[] lengths = new int[nums.length];
    int[] subsequence = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
        lengths[i] = subsequence[i] = 1;
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                if (lengths[i] == lengths[j] + 1) {
                    subsequence[i] += subsequence[j];
                } else if (lengths[i] < lengths[j] + 1) {
                    lengths[i] = lengths[j] + 1;
                    subsequence[i] = subsequence[j];
                }
            }
        }
        if (maxLen == lengths[i]) {
            maxNum += subsequence[i];
        } else if (maxLen < lengths[i]) {
            maxLen = lengths[i];
            maxNum = subsequence[i];
        }
    }
    return maxNum;
}
```

## 676

Implement a magic directory with `buildDict`, and `search` methods.

For the method `buildDict`, you'll be given a list of non-repetitive words to build a dictionary.

For the method `search`, you'll be given a word, and judge whether if you modify **exactly** one character into **another** character in this word, the modified word is in the dictionary you just built.

**Example 1:**

```
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
```

**Note:**

1. You may assume that all the inputs are consist of lowercase letters a-z.
1. For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
1. Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see [here](https://leetcode.com/faq/#different-output) for more details.

**Solution:**

让自己实现一个 MagicDictionary 类，并实现 buildDict 和 search 方法。关于 buildDict 方法没有什么要说的，放进一个 HashSet 即可。关于 search，可以对 word 的每一个字符，分别用 a-z （除去字符本身）来替换，然后判断是否在 HashSet 中：

```java
class MagicDictionary {
    private Set<String> dictSet = new HashSet<>();

    /**
        * Initialize your data structure here.
        */
    public MagicDictionary() {

    }

    /**
        * Build a dictionary through a list of words
        */
    public void buildDict(String[] dict) {
        Collections.addAll(dictSet, dict);
    }

    /**
        * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
        */
    public boolean search(String word) {
        char[] words = word.toCharArray();
        for (int i = 0, len = words.length; i < len; i++) {
            char w = words[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == w) {
                    continue;
                }
                words[i] = j;
                if (dictSet.contains(String.valueOf(words))) {
                    return true;
                }
            }
            words[i] = w;
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        assert !magicDictionary.search("hello");
        assert magicDictionary.search("hhllo");
        assert !magicDictionary.search("hell");
        assert !magicDictionary.search("leetcoded");
        assert !magicDictionary.search("leetcode");
    }
}
```

## [706 Design HashMap](https://leetcode.com/problems/design-hashmap/description/)

设计实现 HashMap，内存存储 (int, int)，很简单，利用链表解决冲突即可。

## 717

We have two special characters. The first character can be represented by one bit `0`. The second character can be represented by two bits (`10` or `11`).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

**Example 1:**

> Input:  
> bits = [1, 0, 0]  
> Output: True  
> Explanation: The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.

**Example 2:**

> Input:  
> bits = [1, 1, 1, 0]  
> Output: False  
> Explanation: The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.

**Note:**

- 1 <= len(bits) <= 1000.
- bits[i] is always 0 or 1.

**Solution:**

通过索引 i 的跳转，遇到 1 跳两步，遇到 0 跳一步。当 while 循环结束的时候，**通过 i 的最终位置来判断**，如果 i 的位置刚好是 bits 数组最后一个元素，则 true；如果 i 的位置跳过了最后一个元素，则 false。

```java
public static boolean isOneBitCharacter(int[] bits) {
    int len = bits.length, i = 0;
    while (i < len - 1) {
        if (0 == bits[i])
            i++;
        else
            i += 2;
    }
    return i == len - 1;
}
```

## 728 Self Dividing Numbers

> 给定上下界，求出所有的 _self-dividing number_。所谓 _self-dividing number_，即一个数字可以被其所有组成数字所整除。例如 128，可以被 `1,2,8` 整除，所以属于 _self-dividing number_。

废话不多说，直接暴力求解：

```java
public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> list = new LinkedList<>();
    List<Integer> digits = new LinkedList<>();
    for (int i = left; i <= right; i++) {
        int n = i;
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        int count = 0;
        for (Integer digit : digits) {
            if (digit == 0 || i % digit != 0) {
                break;
            } else {
                count++;
            }
        }
        if (count == digits.size()) {
            list.add(i);
        }
        digits.clear();
    }
    return list;
}
```

考察上述算法，我们可以将 `digits` 所占的空间以及第二个 `for` 循环所占的时间完全优化掉，只需要在求 digit 的同时判断其是否符合条件即可。

```java
public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> list = new LinkedList<>();
    for (int i = left; i <= right; i++) {
        int n = i;
        boolean meet = true;
        while (n != 0) {
            int digit = n % 10;
            if (digit == 0 || i % digit != 0) {
                meet = false;
            }
            n /= 10;
        }
        if (meet) {
            list.add(i);
        }
    }
    return list;
}
```

## 744

Given a list of sorted characters `letters` containing only lowercase letters, and given a target letter `target`, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is `target = 'z'` and `letters = ['a', 'b']`, the answer is `'a'`.

**Examples:**

```
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
```

**Note:**

1. `letters` has a length in range `[2, 10000]`.
1. `letters` consists of lowercase letters, and contains at least 2 unique letters.
1. `target` is a lowercase letter.

**Solution:**

直接进行查找即可，如果找不到比 target 大的元素，返回第一个元素（Letters also wrap around）。

```java
public char nextGreatestLetter(char[] letters, char target) {
    for (char letter : letters) {
        if (letter > target) {
            return letter;
        }
    }
    return letters[0];
}
```

## 748

Find the minimum length word from a given dictionary `words`, which has all the letters from the string `licensePlate`. Such a word is said to complete the given string `licensePlate`.

Here, for letters we ignore case. For example, `"P"` on the licensePlate still matches `"p"` on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a `licensePlate` of `"PP"`, the word `"pair"` does not complete the `licensePlate`, but the word `"supper"` does.

**Example 1:**

> Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]  
> Output: "steps"  
> Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.

**Example 2:**

> Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]  
> Output: "pest"  
> Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.

**Note:**

1. `licensePlate` will be a string with length in range `[1, 7]`.
1. `licensePlate` will contain digits, spaces, or letters (uppercase or lowercase).
1. `words` will have a length in the range `[10, 1000]`.
1. Every `words[i]` will consist of lowercase letters, and have length in range `[1, 15]`.

**Solution:**

使用 Map 存储 word 和 licensePlate 中各个字符的数量，然后通过比较判断 word 是否合法。之后再寻找合法的 word 中最短的。

```java
public static String shortestCompletingWord(String licensePlate, String[] words) {
    // 对 licensePlate 去重、小写化、排序后，存储为字符列表
    List<String> plate = Arrays.stream(licensePlate.split(""))
            .filter(c -> c.matches("[a-zA-Z]"))
            .map(String::toLowerCase)
            .sorted()
            .collect(Collectors.toList());
    Map<String, Integer> licenseMap = new HashMap<>();
    int min = Integer.MAX_VALUE;
    String ret = "";

    for (String s : plate) {
        licenseMap.put(s, licenseMap.getOrDefault(s, 0) + 1);
    }
    for (String word : words) {
        if (isValid(licenseMap, word)) {
            if (word.length() < min) {
                min = word.length();
                ret = word;
            }
        }
    }
    return ret;
}

// 判断 word 是否合法
private static boolean isValid(Map<String, Integer> licenseMap, String word) {
    Map<String, Integer> wordMap = new HashMap<>();
    for (String s : word.split("")) {
        wordMap.put(s, wordMap.getOrDefault(s, 0) + 1);
    }
    for (String key : licenseMap.keySet()) {
        if (wordMap.getOrDefault(key, 0).compareTo(licenseMap.get(key)) < 0) {
            // 如果 licensePlate 对应的 Map 里有 key，且 key 的数量大于 word 中相应 key 的数量，则返回 false
            return false;
        }
    }
    return true;
}
```

## 783

Given a Binary Search Tree (BST) with the `root` node root, return the minimum difference between the values of any two different nodes in the tree.

**Example:**

```
Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
```

**Note:**

1. The size of the BST will be between 2 and `100`.
1. The BST is always valid, each node's value is an integer, and each node's value is different.

**Solution:**

考虑到这是一个 BST,所以我们可以通过中序遍历来得到有序序列,对这个序列相邻元素求最小值即可得到结果:

```java
public static int minDiffInBST(TreeNode root) {
    int min = Integer.MAX_VALUE, tmp;
    List<Integer> numbers = new LinkedList<>();
    inOrderTraversal(root, numbers);
    for (int i = 1, len = numbers.size(); i < len; i++) {
        tmp = numbers.get(i) - numbers.get(i - 1);
        if (tmp < min) {
            min = tmp;
        }
    }
    return min;
}

private static void inOrderTraversal(TreeNode root, List<Integer> list) {
    if (root != null) {
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
}
```

## [785 Is Graph Bipartite](https://leetcode.com/problems/is-graph-bipartite/description/)

> 给定一个无向图，判断其是否为二分图。二分图：图可以被分为两个不相交的集合 `A,B`，图中所有的边均为一个节点在 A，另一个节点在 B。

我们看二分图的定义，所有的边的两个节点都不在同一集合中。根据这个性质，我们可以将两个集合分别设置为黑色与白色，然后依次给节点染色，例如给当前节点染黑色，所有邻接节点染白色。如果最终成功给所有节点染色，则说明图是二分图；如果存在两个相邻节点（在同一条边上）的颜色相同，则说明图不是二分图。

根据这个思路，我们可以用 DFS 或者 BFS 来完成。

```java
public boolean isBipartite(int[][] graph) {
    // 0(not visited), 1(black), 2(white)
    int[] visited = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
        if (graph[i].length != 0 && visited[i] == 0) {
            visited[i] = 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int c : graph[current]) {
                    if (visited[c] == 0) {
                        visited[c] = (visited[current] == 1) ? 2 : 1;
                        queue.offer(c);
                    } else {
                        if (visited[c] == visited[current])
                            return false;
                    }
                }
            }
        }
    }
    return true;
}
```

## 788

X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number `N`, how many numbers X from `1` to `N` are good?

**Example:**

```
Input: 10
Output: 4
Explanation: 
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
```

**Note:**

- N  will be in range `[1, 10000]`.


**Solution:**

构造一个旋转对应关系的 map，然后对每个数字一位一位进行判断即可。

```java
public class Solution {
    public int rotatedDigits(int N) {
        int ret = 0, tmp;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{
            put(0,0);put(1,1);put(8,8);put(2,5);put(5,2);put(6,9);put(9,6);
        }};
        for (int i = 1; i <= N; i++) {
            int currentNum = i;
            int calcNum = 0;
            int degree = 0;
            boolean isValid = true;
            while (currentNum != 0) {
                tmp = currentNum % 10;
                if (map.containsKey(tmp)) {
                    calcNum += map.get(tmp) * Math.pow(10, degree);
                    currentNum /= 10;
                } else {
                    isValid = false;
                    break;
                }
                degree++;
            }
            if (isValid && calcNum != i) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotatedDigits(10));
        System.out.println(solution.rotatedDigits(857));
    }
}
```

## [792 Number of Matching Subsequences](https://leetcode.com/problems/number-of-matching-subsequences/description/)

> 给定字符串 `S` 以及字符串数组 `words`，找出 `words` 中是 `S` 的子串的字符串的个数。

暴力求解：

```java
public int numMatchingSubseq(String S, String[] words) {
    int match = 0;
    for (String word : words) {
        int iS = 0, iW = 0;
        while (iS < S.length() && iW < word.length()) {
            if (S.charAt(iS) == word.charAt(iW)) {
                iS++;
                iW++;
            } else {
                iS++;
            }
        }
        if (iW == word.length()) {
            match++;
        }
    }
    return match;
}
```

可以将上述判断子串代码摘出来，然后利用 `validSet, invalidSet` 来避免重复判断，但是总体上还是暴力求解。

下面我们思考一种优雅的算法，时间复杂度为 O(N)。我们创建一个 `map: Map<Character, List<String>>`，将 `words` 数组中每个字符串按首字母加入对应 map 中。然后我们按字符遍历 S，对于 map 中对应字符的 List 中的每一个 `word`：如果其长度为 1，则是子序列，总数量 +1；如果长度不为 1，则去掉首字符，将剩余的字符串按首字母重新加入 map。

```java
public int numMatchingSubseq(String S, String[] words) {
    int match = 0;
    Map<Character, Deque<String>> map = new HashMap<>();
    for (char i = 'a'; i <= 'z'; i++) {
        map.put(i, new LinkedList<>());
    }
    for (String word : words) {
        map.get(word.charAt(0)).add(word);
    }
    for (char c : S.toCharArray()) {
        Deque<String> strings = map.get(c);
        int size = strings.size();
        for (int i = 0; i < size; i++) {
            String word = strings.removeFirst();
            if (1 == word.length()) {
                match++;
            } else {
                map.get(word.charAt(1)).add(word.substring(1));
            }
        }
    }
    return match;
}
```

## 806

We are to write the letters of a given string `S`, from left to right into lines. Each line has maximum width 100 units, and if writing a letter would cause the width of the line to exceed 100 units, it is written on the next line. We are given an array `widths`, an array where widths[0] is the width of 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.

Now answer two questions: how many lines have at least one character from `S`, and what is the width used by the last such line? Return your answer as an integer list of length 2.

**Example 1:**

```
Input: 
widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S = "abcdefghijklmnopqrstuvwxyz"
Output: [3, 60]
Explanation: 
All letters have the same length of 10. To write all 26 letters,
we need two full lines and one line with 60 units.
```

**Example 2:**

```
Input: 
widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S = "bbbcccdddaaa"
Output: [2, 4]
Explanation: 
All letters except 'a' have the same length of 10, and 
"bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
For the last 'a', it is written on the second line because
there is only 2 units left in the first line.
So the answer is 2 lines, plus 4 units in the second line.
```

**Note:**

- The length of `S` will be in the range [1, 1000].
- `S` will only contain lowercase letters.
- `widths` is an array of length `26`.
- `widths[i]` will be in the range of `[2, 10]`.

**Solution:**

这题的意思是给定一个字符串和一个 width 数组，其中 width 数组中是每个字符的单位，每一行能放最大 100 单位的字符，要求出最终放好后的行数和最后一行的单位数。

需要注意的是，如果 a 的单位是 4，而一行已经放了 98 单位的情况，这种情况下，a 只能被放入下一行。

直接计算即可：

```java
public static int[] numberOfLines(int[] widths, String S) {
    int total = 0;
    int[] result = new int[2];
    char[] chars = S.toCharArray();
    for (char aChar : chars) {
        total += widths[aChar - 'a'];
        if (total > 100) {
            result[0]++;
            total = widths[aChar - 'a'];    // 对应需要注意的点
        }
    }
    result[0]++;
    result[1] = total;
    return result;
}
```

此答案打败了 100% 的提交者.

## 819

Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

**Example:**

```
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
```

**Note:**

- `1 <= paragraph.length <= 1000`.
- `1 <= banned.length <= 100`.
- `1 <= banned[i].length <= 10`.
- The answer is unique, and written in lowercase (even if its occurrences in `paragraph` may have uppercase symbols, and even if it is a proper noun.)
- `paragraph` only consists of letters, spaces, or the punctuation symbols `!?',;`.
- Different words in `paragraph` are always separated by a space.
- There are no hyphens or hyphenated words.
- Words only consist of letters, never apostrophes or other punctuation symbols.

**Solution:**

使用 StringTokenizer 的构造方法可以很有效的分隔字符，之后利用 map 即可：

```java
public static String mostCommonWord(String paragraph, String[] banned) {
    int count = 0;
    String out = "";
    Map<String, Integer> map = new HashMap<>();
    Set<String> set = new HashSet<>(Arrays.asList(banned));

    StringTokenizer st = new StringTokenizer(paragraph.toLowerCase(), " \t\n\r\f,.:;?![]'");
    while (st.hasMoreTokens()) {
        String word = st.nextToken();
        if (!set.contains(word)) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            if (map.get(word) > count) {
                count = map.get(word);
                out = word;
            }
        }
    }
    return out;
}
```

## [826 Most Profit Assigning Work](https://leetcode.com/problems/most-profit-assigning-work/description/)

给定 difficulty 及与之对应的 profit 数组，另外有 worker 数组，worker 数组元素代表工作者能完成的最大难度，要求计算出最大利润。

可以将 difficulty 与 profit 存为一对，然后对每个 worker 单独进行考虑：

```java
public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int result = 0;
    List<Pair<Integer, Integer>> list = new ArrayList<>();
    for (int i = 0; i < difficulty.length; i++) {
        list.add(new Pair<>(difficulty[i], profit[i]));
    }
    for (int w : worker) {
        int max = 0;
        for (Pair<Integer, Integer> pair : list) {
            if (w >= pair.getKey()) {
                max = Math.max(max, pair.getValue());
            }
        }
        result += max;
    }
    return result;
}
```

但是这种算法是低效的，时间复杂度为 O(M * N)，也无法 AC。

我们考虑优化方法，上面的算法中，对于每一个 worker 都计算一遍能获得的最大 profit，显然有了不必要的计算。不必要的地方在于，假设 worker 与 difficulty 均为有序，worker[i] 对应 difficulty[j] 能取到最大利润。如果 worker[i+1] < difficulty[j+1]，则 worker[i+1] 对应的最大利润与 worker[i] 相同；如果 worker[i+1] >= difficulty[j+1]，则向后继续扫描。

也就是说，我们不需要对每一个 worker 都重新计算最大利润，我们可以将 worker 与 difficulty 进行排序，然后利用一个 max 变量来保存 difficulty[i] 处可以取到的最大利润。对于大于 difficulty[i] 的，继续向后尝试取更大的利润；对于小于等于 difficulty[i] 的，则直接设置最大利润为 max。这样，我们只需要扫描一遍 difficulty 数组即可。

```java
public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int result = 0;
    List<Pair<Integer, Integer>> list = new ArrayList<>();
    for (int i = 0; i < difficulty.length; i++) {
        list.add(new Pair<>(difficulty[i], profit[i]));
    }

    int i = 0, max = 0;
    list.sort(Comparator.comparing(Pair::getKey));
    Arrays.sort(worker);
    for (int w : worker) {
        while (i < difficulty.length && w >= list.get(i).getKey()) {
            max = Math.max(max, list.get(i++).getValue());
        }
        result += max;
    }
    return result;
}
```

算法的时间复杂度为 O(NlogN + QlogQ)，N 为 difficulty 数组长度，Q 为 worker 数组长度。
