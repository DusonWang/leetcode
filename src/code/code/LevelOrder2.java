package code.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author duson
 * ��ʵ��һ����������֮����˳���ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��ҵ����˳���ӡ���������ٰ��մ����ҵ�˳���ӡ���������Դ����ơ�
 * <p>
 * ?
 * <p>
 * ����:
 * ����������:?[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * �������α��������
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * �ڵ����� <= 1000
 * ͨ������12,654�ύ����21,307
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LevelOrder2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> ref;

    public List<List<Integer>> levelOrder(TreeNode root) {
        ref = new ArrayList<>();
        if (root == null) {
            return ref;
        }
        helper(root, 0);
        for (int i = 1; i < ref.size(); i += 2) {
            Collections.reverse(ref.get(i));
        }
        return ref;
    }

    private void helper(TreeNode root, int cnt) {
        if (root == null) {
            return;
        }
        if (ref.size() <= cnt) {
            ref.add(new ArrayList<>());
        }
        ref.get(cnt).add(root.val);
        helper(root.left, cnt + 1);
        helper(root.right, cnt + 1);
    }
}
