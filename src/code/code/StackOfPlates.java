package code.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * �����ӡ�������һ�����ӣ���̫�߿��ܻᵹ��������ˣ�����ʵ�����У����Ӷѵ�һ���߶�ʱ�����Ǿͻ������һ�����ӡ���ʵ�����ݽṹSetOfStacks��ģ��������Ϊ��SetOfStacksӦ���ɶ��ջ��ɣ�������ǰһ��ջ����ʱ�½�һ��ջ�����⣬SetOfStacks.push()��SetOfStacks.pop()Ӧ������ͨջ�Ĳ���������ͬ��Ҳ����˵��pop()���ص�ֵ��Ӧ�ø�ֻ��һ��ջʱ�����һ������ ���ף�ʵ��һ��popAt(int index)����������ָ������ջ��ִ��pop������
 * <p>
 * ��ĳ��ջΪ��ʱ��Ӧ��ɾ����ջ����ջ��û��Ԫ�ػ򲻴��ڸ�ջʱ��pop��popAt?Ӧ���� -1.
 * <p>
 * ʾ��1:
 * <p>
 * ���룺
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 * �����
 * [null, null, null, 2, 1, -1]
 * ʾ��2:
 * <p>
 * ���룺
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 * �����
 * [null, null, null, null, 2, 1, 3]
 * ͨ������1,320�ύ����3,545
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/stack-of-plates-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 *
 * @author duson
 */
public class StackOfPlates {

    private final List<Stack<Integer>> list;

    private final int cap;

    public StackOfPlates(int cap) {
        this.list = new ArrayList<>();
        this.cap = cap;
    }

    public void push(int val) {
        if (cap <= 0) {
            return;
        }
        if (list.isEmpty()) {
            list.add(new Stack<>());
        }
        if (list.get(list.size() - 1).size() >= cap) {
            list.add(new Stack<>());
        }
        Stack<Integer> stack = list.get(list.size() - 1);
        stack.push(val);
    }

    public int pop() {
        if (list.size() <= 0) {
            return -1;
        }
        Stack<Integer> stack = list.get(list.size() - 1);
        int pop = stack.pop();
        if (stack.isEmpty()) {
            list.remove(list.size() - 1);
        }
        return pop;
    }

    public int popAt(int index) {
        if (list.size() <= 0 || index > list.size() - 1) {
            return -1;
        }
        Stack<Integer> stack = list.get(index);
        int pop = stack.pop();
        if (stack.isEmpty()) {
            list.remove(index);
        }
        return pop;
    }
}
