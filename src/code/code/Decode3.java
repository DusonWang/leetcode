package code.code;

/**
 * ����һ����������?perm?������ǰ?n?�������������У���?n?�Ǹ� ����?��
 * <p>
 * �������ܳ���һ������Ϊ n - 1?����������?encoded?������?encoded[i] = perm[i] XOR perm[i + 1]?���ȷ�˵�����?perm = [1,3,2]?����ô?encoded = [2,1]?��
 * <p>
 * ����?encoded?���飬���㷵��ԭʼ����?perm?����Ŀ��֤�𰸴�����Ψһ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺encoded = [3,1]
 * �����[1,2,3]
 * ���ͣ���� perm = [1,2,3] ����ô encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * ʾ�� 2��
 * <p>
 * ���룺encoded = [6,5,4,6]
 * �����[2,4,1,5,3]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 3 <= n <?105
 * n?��������
 * encoded.length == n - 1
 * ͨ������15,143�ύ����21,834
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/decode-xored-permutation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Decode3 {

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        int odd = 0;
        for (int i = 1; i < n - 1; i += 2) {
            odd ^= encoded[i];
        }
        int[] perm = new int[n];
        perm[0] = total ^ odd;
        for (int i = 0; i < n - 1; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
}
