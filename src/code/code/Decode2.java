package code.code;

/**
 * δ֪ �������� arr �� n ���Ǹ�������ɡ�
 * <p>
 * ��������Ϊ����Ϊ n - 1 ����һ���������� encoded ������ encoded[i] = arr[i] XOR arr[i + 1] �����磬arr = [1,0,2,1] �������õ� encoded = [1,2,3] ��
 * <p>
 * ������������� encoded ��ԭ���� arr �ĵ�һ��Ԫ�� first��arr[0]����
 * <p>
 * ����뷵��ԭ���� arr ������֤���𰸴��ڲ�����Ψһ�ġ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺encoded = [1,2,3], first = 1
 * �����[1,0,2,1]
 * ���ͣ��� arr = [1,0,2,1] ����ô first = 1 �� encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * ʾ�� 2��
 * <p>
 * ���룺encoded = [6,2,7,3], first = 4
 * �����[4,2,0,7,4]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 * ͨ������9,557�ύ����11,396
 * ����ʵ�������������������
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/decode-xored-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Decode2 {

    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] ^ encoded[i - 1];
        }
        return result;
    }

}
