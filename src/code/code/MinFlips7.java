package code.code;

/**
 * ����һ���������ַ���s������԰�����˳��ִ���������ֲ�������Σ�
 * <p>
 * ���� 1 ��ɾ�� �ַ���s�ĵ�һ���ַ������� ��ӵ��ַ�����β��
 * ���� 2 ��ѡ�� �ַ���s������һ���ַ��������ַ���ת��Ҳ�������ֵΪ'0'����ת�õ�'1'����֮��Ȼ��
 * ���㷵��ʹ s��� ���� �ַ�����ǰ���£����� 2�� ���ٲ���������
 * <p>
 * ���ǳ�һ���ַ����� ����ģ���Ҫ�������������ַ�����ͬ��
 * <p>
 * �ȷ�˵���ַ���"010" ��"1010"���ǽ���ģ������ַ���"0100"���ǡ�
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "111000"
 * �����2
 * ���ͣ�ִ�е�һ�ֲ������Σ��õ� s = "100011" ��
 * Ȼ��Ե������͵������ַ�ִ�еڶ��ֲ������õ� s = "101010" ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "010"
 * �����0
 * ���ͣ��ַ����Ѿ��ǽ���ġ�
 * ʾ�� 3��
 * <p>
 * ���룺s = "1110"
 * �����1
 * ���ͣ��Եڶ����ַ�ִ�еڶ��ֲ������õ� s = "1010" ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= s.length <= 105
 * s[i]Ҫô��'0'��Ҫô��'1'��
 * ͨ������2,437�ύ����7,915
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinFlips7 {

    /**
     * 1. ��������
     * ��1��˼·
     * �Բ��� 1������һ���ַ��ƶ����ַ�����β����Ч���Ƚ� s ��β��ӹ���һ������Ϊ 2 * len ���ַ�������ͨ������Ϊ len �Ļ�������ȡ��Сֵ��
     * ��Ϊ���յõ��Ľ����ַ���ֻ������ ��0101010���� �� ��1010101���� 2 ����������� 2 ��״̬�ֱ��������Ĳ����������ɡ�
     *
     *
     * public int minFlips(String s) {
     *         String ss = s + s;//�Ƚ�s��β��ӹ���һ������Ϊ2*len���ַ�������ͨ������Ϊlen�Ļ�������ȡ��Сֵ
     *         char[] str = ss.toCharArray();
     *         int len = s.length(), n = str.length, ans = Integer.MAX_VALUE;
     *         int[] op1 = new int[n + 1], op2 = new int[n + 1];//op1[i]��op2[i]��ʾ����õ�"01010..."��"10101..."ǰiλ�Ĳ�������
     *         op1[0] = 0;
     *         op2[0] = 0;
     *         for (int i = 0; i < n; i++) {
     *             if ((i & 1) == (int)(str[i] - '0')) {//����λΪ1��ż��λΪ0
     *                 op1[i + 1] = op1[i];
     *                 op2[i + 1] = op2[i] + 1;
     *             } else {//����λΪ0��ż��λΪ1
     *                 op1[i + 1] = op1[i] + 1;
     *                 op2[i + 1] = op2[i];
     *             }
     *         }
     *         for (int i = len; i <= n; i++) {//�ƶ�����Ϊlen�Ļ������ڣ�ȡ��С��������
     *             ans = Math.min(ans, op1[i] - op1[i - len]);
     *             ans = Math.min(ans, op2[i] - op2[i - len]);
     *         }
     *         return ans;
     *     }
     *
     * */


    public int minFlips(String s) {
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            count += (s.charAt(i) - '0' + (i & 1)) & 1;
        }
        int ans = Math.min(count, len - count);
        if ((len & 1) == 0) {
            return ans;
        }
        for (int i = 0; i < len; i++) {
            int n = (s.charAt(i) - '0' + (i & 1)) & 1;
            count -= n;
            count += 1 - n;
            ans = Math.min(ans, Math.min(count, len - count));
        }
        return ans;
    }

    public static void main(String[] args) {
        MinFlips7 minFlips7 = new MinFlips7();
        System.out.println(minFlips7.minFlips("010"));
        System.out.println(minFlips7.minFlips("1110"));
        System.out.println(minFlips7.minFlips("111000"));
    }
}
