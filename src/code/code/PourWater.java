package code.code;

/**
 * @author duson
 * <p>
 * 给出一个地形高度图， heights[i] 表示该索引处的高度。每个索引的宽度为 1。在 V 个单位的水落在索引 K 处以后，每个索引位置有多少水？
 * <p>
 * 水最先会在索引 K 处下降并且落在该索引位置的最高地形或水面之上。然后按如下方式流动：
 * <p>
 * 如果液滴最终可以通过向左流动而下降，则向左流动。
 * 否则，如果液滴最终可以通过向右流动而下降，则向右流动。
 * 否则，在当前的位置上升。
 * 这里，“最终下降” 的意思是液滴如果按此方向移动的话，最终可以下降到一个较低的水平。而且，“水平”的意思是当前列的地形的高度加上水的高度。
 *  
 * <p>
 * 我们可以假定在数组两侧的边界外有无限高的地形。而且，不能有部分水在多于 1 个的网格块上均匀分布 - 每个单位的水必须要位于一个块中。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：heights = [2,1,1,2,1,2,2], V = 4, K = 3
 * 输出：[2,2,2,3,2,2,2]
 * 解释：
 * #       #
 * #       #
 * ##  # ###
 * #########
 * 0123456    <- 索引
 * <p>
 * 第一个水滴降落在索引 K = 3 上：
 * <p>
 * #       #
 * #   w   #
 * ##  # ###
 * #########
 * 0123456
 * <p>
 * 当向左或向右移动时，水可以移动到相同或更低的高度。When moving left or right, the water can only move to the same level or a lower level.
 * （从水平上看，意思是该列的地形高度加上水的高度）
 * 由于向左移动可以最终下落，因此向左移动。
 * （一个水滴 “下落” 的意思是可以相比之前可以进入更低的高度）
 * <p>
 * #       #
 * #       #
 * ## w# ###
 * #########
 * 0123456
 * <p>
 * 由于向左移动不会使其降落，所以停在该位置上。下一个水滴下落：
 * <p>
 * #       #
 * #   w   #
 * ## w# ###
 * #########
 * 0123456
 * <p>
 * <p>
 * 由于新水滴向左移动可以最终下落，因此向左移动。
 * 注意水滴仍然是优先选择向左移动，
 * 尽管可以向右移动（而且向右移动可以下落更快）
 * <p>
 * <p>
 * #       #
 * #  w    #
 * ## w# ###
 * #########
 * 0123456
 * <p>
 * #       #
 * #       #
 * ##ww# ###
 * #########
 * 0123456
 * <p>
 * 经过刚才的阶段后，第三个水滴下落。
 * 由于向左移动不会最终下落，因此尝试向右移动。
 * 由于向右移动可以最终下落，因此向右移动。
 * <p>
 * <p>
 * #       #
 * #   w   #
 * ##ww# ###
 * #########
 * 0123456
 * <p>
 * #       #
 * #       #
 * ##ww#w###
 * #########
 * 0123456
 * <p>
 * 最终，第四个水滴下落。
 * 由于向左移动不会最终下落，因此尝试向右移动。
 * 由于向右移动不会最终下落，因此停在当前位置：
 * <p>
 * #       #
 * #   w   #
 * ##ww#w###
 * #########
 * 0123456
 * <p>
 * 最终的答案为 [2,2,2,3,2,2,2]:
 * <p>
 * #
 * #######
 * #######
 * 0123456
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：heights = [1,2,3,4], V = 2, K = 2
 * 输出：[2,3,3,4]
 * 解释：
 * 最后的水滴落在索引 1 位置，因为继续向左移动不会使其下降到更低的高度。
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入：heights = [3,1,3], V = 5, K = 1
 * 输出：[4,4,4]
 *  
 * <p>
 * 注：
 * <p>
 *  
 * <p>
 * heights 的长度为 [1, 100] ，并且每个数的范围为[0, 99]。
 * V 的范围 [0, 2000]。
 * K 的范围 [0, heights.length - 1]。
 * 通过次数403提交次数872
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pour-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PourWater {

    public int[] pourWater(int[] heights, int v, int k) {
        if (heights == null || heights.length == 0) {
            return heights;
        }
        for (int i = 0; i < v; i++) {
            int left = findLeft(heights, k);
            if (left < k) {
                heights[left]++;
                continue;
            }
            int right = findRight(heights, k);
            if (right > k) {
                heights[right]++;
                continue;
            }
            heights[k]++;
        }
        return heights;
    }

    private int findLeft(int[] heights, int idx) {
        int i = idx;
        for (int j = idx - 1; j >= 0; ) {
            if (heights[j] > heights[i]) {
                break;
            } else if (heights[j] < heights[i]) {
                i = j;
                j--;
            } else {
                while (j >= 0 && heights[j] == heights[i]) {
                    j--;
                }
            }
        }
        return i;
    }

    private int findRight(int[] heights, int idx) {
        int i = idx;
        for (int j = idx + 1; j < heights.length; ) {
            if (heights[j] > heights[i]) {
                break;
            } else if (heights[j] < heights[i]) {
                i = j;
                j++;
            } else {
                while (j < heights.length && heights[j] == heights[i]) {
                    j++;
                }
            }
        }
        return i;
    }
}
