# Dive Into Offer

[LeetCode](https://leetcode.com) 解题集 :+1: :sunglasses:。

## 目录

- [193. Valid Phone Numbers](#193)
- [196. Delete Duplicate Emails](#196)
- [284. Peeking Iterator](#284)
- [400. Nth Digit](#400)
- [413. Arithmetic Slices](#413)
- [417. Pacific Atlantic Water Flow](#417)
- [517. Super Washing Machines](#517)
- [526. Beautiful Arrangement](#526)
- [617. Merge Two Binary Trees](#617)
- [627. Swap Salary](#627)
- [717. 1-bit and 2-bit Characters](#717)
- [748. Shortest Completing Word](#748)

## 193

有一个文本文件 `file.txt` 包含着一系列电话号码（一行一个），写出一个一行的 Bash Script 来打印出所有合法的电话号码。

合法的电话号码只会是下面两种格式：

1. (xxx) xxx-xxxx
1. xxx-xxx-xxxx

`x` 代表着数字。

同时，每一行的开始和结束也不会包含空格。

例如，对于文件 `file.txt`：

> 987-123-4567  
> 123 456 7890  
> (123) 456-7890

脚本应该输出：

> 987-123-4567  
> (123) 456-7890

**解法：**

只是简单的 grep 和正则表达式用法。

两种合法格式只有前边不同，可以使用 `|` 来表示不同的情况。

```bash
grep -P '^(\d{3}-|\(\d{3}\)\ )\d{3}-\d{4}$' file.txt
```

## 196

写出一个 SQL 语句来删除 `Person` 表中所有重复的 email 项，只保留重复 email 项中 **Id** 最小的项。

Id | Email
---|---
1 | john@example.com
2 | bob@example.com
3 | john@example.com


Id 是表的主键.

例如，在运行语句后，上述 `Person` 表应该变成以下状态：

Id | Email
---|---
1 | john@example.com
2 | bob@example.com

**解法：**

简单解法：

```sql
DELETE p1 FROM Person p1, Person p2 WHERE p1.Email = p2.Email AND p1.Id > p2.Id
```

更高效的解法：

```sql
DELETE FROM Person WHERE Id NOT IN (SELECT p.Id FROM (SELECT Min(Id) AS Id FROM Person GROUP BY Email) p);
```

思路是先按照 Email 进行分组，并从分组中选出每一组最小的 Id，然后删除不在最小 Id 表中的 Id。

此答案打败了 100% 的提交者。

## 284

给定一个 Iterator 类接口，接口中有方法 `next()` 和 `hasNext()`。设计并实现一个 `PeekingIterator` 类，让它支持 `peek()` 方法 —— 它返回下一次调用 `next()` 方法要返回的值。

例如，假设迭代器被初始化为列表 `[1, 2, 3]` 的开始。

调用 `next()` 方法返回列表的第一个元素 `1`。

现在调用 `peek()` 方法会返回列表的第二个元素 `2`。调用 `next()` 方法也返回 `2`。

最后，调用 `next()` 方法返回最后一个元素 `3`，调用 `hasNext()` 方法返回 `false`。

**解法：**

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

找到无限整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 的第 n 个元素。

**注意：**

n 是整数，并且 n 是 32 位有符号整数（n < 2^31）。

**例一：**

> Input:  
> 3
>
> Output:  
> 3

**例二：**

> Input:  
> 11
>
> Output:  
> 0
>
> 解释:  
> 序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 的第 11 个元素是一个 0，是 10 的一部分。

**解法：**

分析位数规律有：

1. 个位数：1-9，一共 9 个，共 1*9 个数字
1. 十位数：10-99，一共 90 个，共 2*90 个数字
1. 百位数：100-999，一共 900 个，共 3*900 个数字
1. 千位数：1000-9999，一共 9000 个，共 4*9000 个数字

依此类推，我们可以先定位出给定 n 对应数字的位数（个、十、百、千....），然后得出其在相应位数的数字中的位置，同时也可以得到 n 对应于数字中的位置。

然后求出数字，得出要求的数字。

## 413

如果一个序列包含至少三个元素，并且任意两个元素之间的差值相等，那么就称这个序列为 arithmetic。

例如，以下是三个 arithmetic 序列：

> 1, 3, 5, 7, 9  
> 7, 7, 7, 7  
> 3, -1, -5, -9

下面这个序列不是 arithmetic：

> 1, 1, 2, 5, 7

给定一个从 0 开始计数的包含 N 个元素的数组 A。数组的一个切片是一系列整数元素（P, Q），并且 0 <= P < Q < N。

如果数组 A 的切片 （P，Q）满足条件 A[P], A[p + 1], ..., A[Q - 1], A[Q]，那么称这个切片是 arithmetic。特别的说，这意味着 P + 1 < Q（并且该序列至少三个元素）。

函数需要返回数组 A 中所有的 arithmetic 切片的个数

**例子：**

> A = [1, 2, 3, 4]
>
> return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.

**解法：**

找出其中的规律，仔细分析后发现适用于动态规划。

> 1, 2, 3 => 1  
> 1, 2, 3, 4 => 3 = 1 + 2  
> 1, 2, 3, 4, 5 => 6 = 3 + 3 = 1 + 2 + 3  
> 1, 2, 3, 4, 5, 6 => 10 = 6 + 4 = 1 + 2 + 3 + 4  
> 1, 2, 3, 4, 5, 6, 7 => 15 = 10 + 5 = 1 + 2 + 3 + 4 + 5  

## 417

给定一个 `m` * `n` 的非负整数矩阵代表着每一个大陆上一个独特细胞的高度。假设太平洋接着矩阵的左边和顶边，大西洋接着矩阵的矩阵的右边和底边。

水只能通过四个方向（上、下、左、右）从一个细胞流向另一个**高度相等或者更小**的细胞

找到可以同时流向太平洋和大西洋的细胞的坐标。

**注意：**

1. 返回坐标的顺序不重要个
1. m 和 n 的值都小于 150

**示例：**

> 给定以下 5x5 的矩阵:
>
>  Pacific ~   ~   ~   ~   ~  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~  1   2   2   3  (5) &nbsp;&nbsp;*  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~  3   2   3  (4) (4) *  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~  2   4  (5)  3   1  &nbsp;&nbsp;*  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~ (6) (7)  1   4   5  *  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~ (5)  1   1   2   4  &nbsp;&nbsp;*  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*  &nbsp;*   *   *   * Atlantic
>
> 返回:
>
> [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (细胞的坐标).

**解法：**

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

你有 **n** 个超级洗衣机排列一行。初始时，每个洗衣机里有的有一些衣服，有的没有。

对于每一步**移动**，你可以选择**任意 m 个**（1 ≤ m ≤ n）洗衣机，并且**同时**传递**一件衣服**到它相邻的洗衣机里。

给定一个整数数组代表每个洗衣机里衣服的数量，找出**最小移动次数**使得所有的洗衣机里都含有相同数目的衣服。如果不可能，返回 -1。

**例一：**

> 输入: [1,0,5]
>
> 输出: 3
>
> 解释:   
第一次移动:    1     0 <-- 5    =>    1     1     4  
第二次移动:    1 <-- 1 <-- 4    =>    2     1     3    
第三次移动:    2     1 <-- 3    =>    2     2     2   

**例二：**

> 输入: [0,3,0]
>
> 输出: 2
>
> 解释:   
第一次移动:    0 <-- 3     0    =>    1     2     0    
第二次移动:    1     2 --> 0    =>    1     1     1     

**例三：**

> 输入: [0,2,0]
>
> 输出: -1
>
> 解释:  
> 不可能使得所有的洗衣机里含有相同数目的衣服。 

**注意：**

1. n 的范围是 [1, 10000].
1. 洗衣机中衣服的数目范围是 [0, 1e5].

**解法：**

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

假设你有从 1 到 N 共 **N** 个整数。我们定义一个 “beautiful arrangement” 表示着：由这 N 个元素构成的数组的第 i 个元素（1 <= i <= N）满足以下两个条件之一：

1. i 位置元素的值可以被 **i** 整除；
1. **i** 可以被 i 位置元素的值整除。

现在给定 N，返回 “beautiful arrangement” 的个数。

**示例1：**

> 输入: 2  
> 输出: 2  
> 解释: 
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

**注意：**

1. **N** 是整数并且不会超过 15。

**解法：**

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

给定两个二叉树准备进行覆盖，一些结点可能同时出现在两个树，一些可能没有。

你需要把这两颗树合并为一颗新的二叉树。合并的规则是，如果两个结点重复，将它们的和作为新的结点的值。否则，非空结点会被用作新树的结点。

**示例1：**

输入: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7

**注意：** 

合并的过程必须从两棵树的根结点开始。

**解法：**

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

给定一个数据库表 `salary`，其中 m 代表着 male，f 代表着 female。用一条 SQL 语句并且不使用中间表交换其中所有的 f 和 m 的值。（例如，将所有的 f 改为 m，将所有的 m 改为 f）

例如：

| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | m   | 2500   |
| 2  | B    | f   | 1500   |
| 3  | C    | m   | 5500   |
| 4  | D    | f   | 500    |

执行 SQL 语句后：

| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | f   | 2500   |
| 2  | B    | m   | 1500   |
| 3  | C    | f   | 5500   |
| 4  | D    | m   | 500    |

**解法：**

使用 CASE WHEN：

```sql
-- Solution 1
UPDATE `salary` SET sex = (
    CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END
)

使用按位与：

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
