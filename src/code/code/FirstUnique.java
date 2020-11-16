package code.code;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author duson
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 * <p>
 * Implement the FirstUnique?class:
 * <p>
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique()?returns the value of the?first unique integer of the queue, and returns -1 if there is no such integer.
 * void add(int value)?insert value?to?the queue.
 * ?
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);? ? ? ? ? ? // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);? ? ? ? ? ? // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 * Example 2:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);? ? ? ? ? ? // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);? ? ? ? ? ? // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);? ? ? ? ? ? // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);? ? ? ? ? ?// the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 * Example 3:
 * <p>
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 * ?
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^8
 * 1 <= value <= 10^8
 * At most 50000?calls will be made to showFirstUnique?and add.
 * 通过次数33提交次数67
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUnique {

    private Set<Integer> unique = new LinkedHashSet<>();
    private Set<Integer> all = new HashSet<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        if (unique.isEmpty()) {
            return -1;
        }
        return unique.iterator().next();
    }

    public void add(int value) {
        if (all.add(value)) {
            unique.add(value);
        } else {
            unique.remove(value);
        }
    }
}
