package code.code;

/**
 * ��Ԫ�� ��һ��������������ɵ����顣����һ����ά�������� triplets ������ triplets[i] = [ai, bi, ci] ��ʾ�� i �� ��Ԫ�� ��ͬʱ������һ���������� target = [x, y, z] ����ʾ����Ҫ�õ��� ��Ԫ�� ��
 * <p>
 * Ϊ�˵õ� target ������Ҫ�� triplets ִ������Ĳ��� ����Σ����� �� �Σ���
 * <p>
 * ѡ�������±꣨�±� �� 0 ��ʼ ������i �� j��i != j������ ���� triplets[j] Ϊ [max(ai, aj), max(bi, bj), max(ci, cj)] ��
 * ���磬triplets[i] = [2, 5, 3] �� triplets[j] = [1, 7, 5]��triplets[j] �������Ϊ [max(2, 1), max(5, 7), max(3, 5)] = [2, 7, 5] ��
 * ���ͨ�����ϲ������ǿ���ʹ��Ŀ�� ��Ԫ��target��Ϊtriplets ��һ�� Ԫ�أ��򷵻� true �����򣬷��� false ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺triplets = [[2,5,3],[1,8,4],[1,7,5]], target = [2,7,5]
 * �����true
 * ���ͣ�ִ������������
 * - ѡ���һ�������һ����Ԫ�� [[2,5,3],[1,8,4],[1,7,5]] ���������һ����Ԫ��Ϊ [max(2,1), max(5,7), max(3,5)] = [2,7,5] ��triplets = [[2,5,3],[1,8,4],[2,7,5]]
 * Ŀ����Ԫ�� [2,7,5] ������ triplets ��һ��Ԫ�ء�
 * ʾ�� 2��
 * <p>
 * ���룺triplets = [[1,3,4],[2,5,8]], target = [2,5,8]
 * �����true
 * ���ͣ�Ŀ����Ԫ�� [2,5,8] �Ѿ��� triplets ��һ��Ԫ�ء�
 * ʾ�� 3��
 * <p>
 * ���룺triplets = [[2,5,3],[2,3,4],[1,2,5],[5,2,3]], target = [5,5,5]
 * �����true
 * ���ͣ�ִ������������
 * - ѡ���һ���͵�������Ԫ�� [[2,5,3],[2,3,4],[1,2,5],[5,2,3]] �����µ�������Ԫ��Ϊ [max(2,1), max(5,2), max(3,5)] = [2,5,5] ��triplets = [[2,5,3],[2,3,4],[2,5,5],[5,2,3]] ��
 * - ѡ��������͵��ĸ���Ԫ�� [[2,5,3],[2,3,4],[2,5,5],[5,2,3]] �����µ��ĸ���Ԫ��Ϊ [max(2,5), max(5,2), max(5,3)] = [5,5,5] ��triplets = [[2,5,3],[2,3,4],[2,5,5],[5,5,5]] ��
 * Ŀ����Ԫ�� [5,5,5] ������ triplets ��һ��Ԫ�ء�
 * ʾ�� 4��
 * <p>
 * ���룺triplets = [[3,4,5],[4,5,6]], target = [3,2,5]
 * �����false
 * ���ͣ��޷��õ� [3,2,5] ����Ϊ triplets ���� 2 ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= triplets.length <= 105
 * triplets[i].length == target.length == 3
 * 1 <= ai, bi, ci, x, y, z <= 1000
 * ͨ������2,984�ύ����4,841
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/merge-triplets-to-form-target-triplet
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MergeTriplets {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean a = false;
        boolean b = false;
        boolean c = false;
        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            if (t[0] == target[0]) {
                a = true;
            }
            if (t[1] == target[1]) {
                b = true;
            }
            if (t[2] == target[2]) {
                c = true;
            }
        }
        return a && b && c;
    }
}
