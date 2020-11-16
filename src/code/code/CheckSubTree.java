package code.code;

/**
 * @author duson
 * ����������������÷ǳ���Ķ�������T1���м�����ڵ㣻T2���м�����ڵ㡣���һ���㷨���ж� T2 �Ƿ�Ϊ T1 ��������
 * <p>
 * ��� T1 ����ôһ���ڵ� n���������� T2 һģһ������ T2 Ϊ T1 ��������Ҳ����˵���ӽڵ� n ���������ϣ��õ������� T2 ��ȫ��ͬ��
 * <p>
 * ʾ��1:
 * <p>
 * ���룺t1 = [1, 2, 3], t2 = [2]
 * �����true
 * ʾ��2:
 * <p>
 * ���룺t1 = [1, null, 2, 4], t2 = [3, 2]
 * �����false
 * ��ʾ��
 * <p>
 * ���Ľڵ���Ŀ��ΧΪ[0, 20000]��
 * ͨ������2,687�ύ����3,772
 * ����ʵ�������������������
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-subtree-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CheckSubTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        return t1.val == t2.val
                && isSame(t1.left, t2.left)
                && isSame(t1.right, t2.right);
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2 == null;
        }
        return isSame(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }
}
