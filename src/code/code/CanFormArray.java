package code.code;

/**
 * ����һ���������� arr �������е�ÿ������ ������ͬ ������һ�����������鹹�ɵ����� pieces�����е�����Ҳ ������ͬ �������� ����˳�� ���� pieces �е��������γ� arr �����ǣ������� ��ÿ������ pieces[i] �е�������������
 * <p>
 * ����������� pieces �е������γ� arr ������ true �����򣬷��� false ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = [85], pieces = [[85]]
 * �����true
 * ʾ�� 2��
 * <p>
 * ���룺arr = [15,88], pieces = [[88],[15]]
 * �����true
 * ���ͣ��������� [15] �� [88]
 * ʾ�� 3��
 * <p>
 * ���룺arr = [49,18,16], pieces = [[16,18,49]]
 * �����false
 * ���ͣ��������������Ҳ������������ pieces[0]
 * ʾ�� 4��
 * <p>
 * ���룺arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * �����true
 * ���ͣ��������� [91]��[4,64] �� [78]
 * ʾ�� 5��
 * <p>
 * ���룺arr = [1,3,5,7], pieces = [[2,4,6,8]]
 * �����false
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr �е����� ������ͬ
 * pieces �е����� ������ͬ��Ҳ����˵������� pieces ��ƽ����һά���飬�����е���������������ͬ��
 * ͨ������11,121�ύ����16,425
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-array-formation-through-concatenation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CanFormArray {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] hash = new int[101];
        for (int i = 0; i < pieces.length; i++) {
            hash[pieces[i][0]] = i + 1;
        }
        for (int i = 0; i < arr.length; ) {
            if (hash[arr[i]] > 0) {
                int idx = hash[arr[i]] - 1;
                for (int j = 0; j < pieces[idx].length; j++) {
                    if (arr[i++] != pieces[idx][j]) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
