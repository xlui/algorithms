# Dive Into Offer

[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/xlui/dive-into-offer/blob/master/LICENSE)

In order to get a job offer, I'm now training myself through [LeetCode](https://leetcode.com), and I'd like to share my code here.

This project won't stop until I have got a job offer.

## Table of Contents

- [1. Two Sum](#1)
- [10. Regular Expression Matching](#10)
- [38. Count and Say](#38)
- [39. Combination Sum](#39)
- [100. Same Tree](#100)
- [101. Symmetric Tree](#101)
- [120. Triangle](#120)
- [121. Best Time to Buy and Sell Stock](#121)
- [125. Valid Palindrome](#125)
- [141. Linked List Cycle](#141)
- [143. Reorder List](#143)
- [165. Compare Version Numbers](#165)
- [171. Excel Sheet Column Number](#171)
- [193. Valid Phone Numbers](#193)
- [196. Delete Duplicate Emails](#196)
- [207. Course Schedule](#207)
- [215. Kth Largest Element in an Array](#215)
- [279. Perfect Squares](#279)
- [284. Peeking Iterator](#284)
- [303. Range Sum Query - Immutable](#303)
- [342. Power of Four](#342)
- [350. Intersection of Two Arrays II](#350)
- [357. Count Numbers with Unique Digits](#357)
- [387. First Unique Character in a String](#387)
- [400. Nth Digit](#400)
- [406. Queue Reconstruction by Height](#406)
- [413. Arithmetic Slices](#413)
- [417. Pacific Atlantic Water Flow](#417)
- [492. Construct the Rectangle](#492)
- [503. Next Greater Element II](#503)
- [515. Find Largest Value in Each Tree Row](#515)
- [517. Super Washing Machines](#517)
- [526. Beautiful Arrangement](#526)
- [605. Can Place Flowers](#605)
- [617. Merge Two Binary Trees](#617)
- [627. Swap Salary](#627)
- [717. 1-bit and 2-bit Characters](#717)
- [748. Shortest Completing Word](#748)
- [783. Minimum Distance Between BST Nodes](#783)
- [788. Rotated Digits](#788)
- [806. Number of Lines To Write String](#806)
- [819. Most Common Word](#819)

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
    * 不同于快排的地方是，我们只需要关注特定数量的数字。因为我们是从数列中选第几大的数字，所以我们只需要关注划分后的某一部分（前半部分或者后半部分）
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
