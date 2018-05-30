package app.xlui.algo.p215;

public class Solution {
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
}
