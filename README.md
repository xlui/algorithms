# Dive Into Offer

In order to get a job offer, I'm now training myself through [LeetCode](https://leetcode.com), and I'd like to share my code here.

This project won't stop until I have got a job offer.

## Table of Contents

- [中文](readme_zh_CN.md)
- [10. Regular Expression Matching](#10)
- [101. Symmetric Tree](#101)
- [125. Valid Palindrome](#125)
- [141. Linked List Cycle](#141)
- [165. Compare Version Numbers](#165)
- [171. Excel Sheet Column Number](#171)
- [193. Valid Phone Numbers](#193)
- [196. Delete Duplicate Emails](#196)
- [284. Peeking Iterator](#284)
- [303. Range Sum Query - Immutable](#303)
- [400. Nth Digit](#400)
- [406. Queue Reconstruction by Height](#406)
- [413. Arithmetic Slices](#413)
- [417. Pacific Atlantic Water Flow](#417)
- [517. Super Washing Machines](#517)
- [526. Beautiful Arrangement](#526)
- [605. Can Place Flowers](#605)
- [617. Merge Two Binary Trees](#617)
- [627. Swap Salary](#627)
- [717. 1-bit and 2-bit Characters](#717)
- [748. Shortest Completing Word](#748)
- [783. Minimum Distance Between BST Nodes](#783)

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

这道题使用动态规划来解。令 `dp[i][j]` 表示 `s[0, i]` 与 `p[0, j]` 的匹配情况。

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
