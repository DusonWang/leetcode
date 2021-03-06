package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * 设计一个最大栈，支持 push、pop、top、peekMax 和 popMax 操作。
 * <p>
 *  
 * <p>
 * push(x) -- 将元素 x 压入栈中。
 * pop() -- 移除栈顶元素并返回这个值。
 * top() -- 返回栈顶元素。
 * peekMax() -- 返回栈中最大元素。
 * popMax() -- 返回栈中最大的元素，并将其删除。如果有多个最大元素，只要删除最靠近栈顶的那个。
 *  
 * <p>
 * 样例 1:
 * <p>
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 *  
 * <p>
 * 注释:
 * <p>
 * -1e7 <= x <= 1e7
 * 操作次数不会超过 10000。
 * 当栈为空的时候不会出现后四个操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxStack {

    private List<Integer> stack;
    private int maxIndex;

    public MaxStack() {
        stack = new ArrayList<>();
        maxIndex = 0;
    }

    public void push(int x) {
        stack.add(x);
        if (x >= stack.get(maxIndex)) {
            maxIndex = stack.size() - 1;
        }
    }

    public int pop() {
        int rnt = top();
        int index = stack.size() - 1;
        stack.remove(index);
        if (index == maxIndex) {
            maxIndex = findMaxIndex();
        }
        return rnt;
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int peekMax() {
        return stack.get(maxIndex);
    }

    public int popMax() {
        int rnt = peekMax();
        stack.remove(maxIndex);
        maxIndex = findMaxIndex();
        return rnt;
    }

    private int findMaxIndex() {
        int index = 0;
        for (int i = 1; i < stack.size(); i++) {
            if (stack.get(i) >= stack.get(index)) {
                index = i;
            }
        }
        return index;
    }
}
