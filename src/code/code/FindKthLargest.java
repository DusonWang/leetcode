package code.code;

/**
 * @author duson
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
//      PriorityQueue<Integer> pq = new PriorityQueue();
//        for(int i : nums){
//            pq.add(i);
//
//            if(pq.size() > k){
//                pq.poll();
//            }
//        }
//        return pq.peek();

        return findK(nums, k - 1, 0, nums.length - 1);

    }

    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        quickSort(nums, 0, n - 1, target);
        return nums[n - k];
    }

    private void quickSort(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        int pivot = choosePivot(nums[mid], nums[start], nums[end]);
        int i = start;
        int j = end;
        while (i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (nums[i] != nums[j]) {
                    swap(nums, i, j);
                }
                i++;
                j--;
            }
        }
        if (target <= i - 1) {
            quickSort(nums, start, i - 1, target);
        } else {
            quickSort(nums, i, end, target);
        }
    }

    private int choosePivot(int a, int b, int c) {
        if (a > b) {
            if (c > a) {
                return a;
            } else {
                return Math.max(c, b);
            }
        } else {
            if (c > b) {
                return b;
            } else {
                return Math.max(c, a);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findK(int[] nums, int k, int start, int end) {
        int low = start;
        int high = end;
        int pivot = nums[(low + high) / 2];
        while (low <= high) {
            while (nums[high] < pivot) {
                high--;
            }

            while (nums[low] > pivot) {
                low++;
            }

            if (low <= high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }

        }

        if (start < high && k <= high) {
            return findK(nums, k, start, high);
        }
        if (low < end && k >= low) {
            return findK(nums, k, low, end);
        }
        return nums[k];
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 3));
    }
}
