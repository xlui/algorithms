# dive-into-offer

In order to get a job offer, I'm now training myselft through [LeetCode](https://leetcode.com), and I'd like to share my code here.

This project won't stop until I have got a job offer.

## Table of Contents

- [193 Valid Phone Numbers](#193)
- [284 Peeking Iterator](#284)
- [400 Nth Digit](#400)
- [413 Arithmetic Slices](#413)
- [517 Super Washing Machines](#517)
- [526 Beautiful Arrangement](#526)
- [617 Merge Two Binary Trees](#617)
- [627 Swap Salary](#627)
- [717 1-bit and 2-bit Characters](#717)
- [748 Shortest Completing Word](#748)

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
