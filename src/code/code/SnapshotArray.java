package code.code;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author duson
 * 实现支持下列接口的「快照数组」- SnapshotArray：
 * <p>
 * SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
 * void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 * int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
 * int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * 输出：[null,null,0,null,5]
 * 解释：
 * SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
 * snapshotArr.set(0,5);  // 令 array[0] = 5
 * snapshotArr.snap();  // 获取快照，返回 snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= length <= 50000
 * 题目最多进行50000 次set，snap，和 get的调用 。
 * 0 <= index < length
 * 0 <= snap_id < 我们调用 snap() 的总次数
 * 0 <= val <= 10^9
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/snapshot-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SnapshotArray {

    private List<TreeMap<Integer, Integer>> arr;
    private int currId = 0;

    public SnapshotArray(int length) {
        arr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arr.add(i, new TreeMap<>());
            arr.get(i).put(0, 0);
        }
    }

    public void set(int index, int val) {
        arr.get(index).put(currId, val);
    }

    public int snap() {
        return currId++;
    }

    public int get(int index, int snapId) {
        return arr.get(index).floorEntry(snapId).getValue();
    }
}
