package code.code;

/**
 * �������������� n �� k���������ַ���? Sn ���γɹ������£�
 * <p>
 * S1?= "0"
 * �� i > 1 ʱ��Si?=?Si-1?+ "1" + reverse(invert(Si-1))
 * ���� + ��ʾ����������reverse(x) ���ط�ת x ��õ����ַ������� invert(x) ��ᷭת x �е�ÿһλ��0 ��Ϊ 1���� 1 ��Ϊ 0����
 * <p>
 * ���磬�����������������е�ǰ 4 ���ַ��������ǣ�
 * <p>
 * S1?= "0"
 * S2?= "011"
 * S3?= "0111001"
 * S4 = "011100110110001"
 * ���㷵��? Sn �� �� k λ�ַ� ����Ŀ���ݱ�֤ k һ���� Sn ���ȷ�Χ���ڡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 3, k = 1
 * �����"0"
 * ���ͣ�S3 Ϊ "0111001"����� 1 λΪ "0" ��
 * ʾ�� 2��
 * <p>
 * ���룺n = 4, k = 11
 * �����"1"
 * ���ͣ�S4 Ϊ "011100110110001"����� 11 λΪ "1" ��
 * ʾ�� 3��
 * <p>
 * ���룺n = 1, k = 1
 * �����"0"
 * ʾ�� 4��
 * <p>
 * ���룺n = 2, k = 3
 * �����"1"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= 2n - 1
 * ͨ������6,869�ύ����12,533
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-kth-bit-in-nth-binary-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindKthBit {

    public char findKthBit3(int n, int k) {
        return (char)((k / (k & -k) >> 1 & 1) ^ (k & 1 ^ 1) + '0');
    }

    public char findKthBit2(int n, int k) {
        int count = 0;
        int l = (1 << n) - 1;
        while (k > 1) {
            if (k == l / 2 + 1) {
                return count % 2 == 0 ? '1' : '0';
            }
            if (k > l / 2) {
                k = l + 1 - k;
                count++;
            }
            l /= 2;
        }
        return count % 2 == 0 ? '0' : '1';
    }

    public char findKthBit(int n, int k) {
        if (k == 1) {
            return '0';
        }
        int mid = 1 << (n - 1);
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            k = mid * 2 - k;
            return invert(findKthBit(n - 1, k));
        }
    }

    public char invert(char bit) {
        return (char) ('0' + '1' - bit);
    }

    public static void main(String[] args) {
        FindKthBit findKthBit = new FindKthBit();
        System.out.println(findKthBit.findKthBit(3, 1));
        System.out.println(findKthBit.findKthBit(4, 11));

    }
}
