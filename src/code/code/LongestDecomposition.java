package code.code;

/**
 * @author duson
 * ��ʽ���� ��ʵ�� һ����� ���ƣ�ֻ��������С�ĵ�λ�� һ���ַ�?������ ������ĸ��
 * <p>
 * �ٸ����ӣ�����һ����� "abcba" �ǻ��ģ��� "volvo" ���ǣ���������ǰ�?"volvo" ��Ϊ "vo"��"l"��"vo" ���Σ��������Ϊ ��(vo)(l)(vo)�� �Ƕ�ʽ���ģ���Ϊ 3 �Σ���
 * <p>
 * ?
 * <p>
 * ����һ���ַ���?text����ȷ���������ʽ���ĵ�ǰ���£����㷵�� �� ��?�������?k��
 * <p>
 * ����ε��������Ϊ?k����ô������������������?a_1, a_2, ..., a_k��
 * <p>
 * ÿ��?a_i?����һ���ǿ��ַ�����
 * ����Щ�ַ�����λ�����Ľ��?a_1 + a_2 + ... + a_k?��ԭʼ�ַ���?text?��ͬ��
 * ��������1 <= i <= k������?a_i = a_{k+1 - i}��
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺text = "ghiabcdefhelloadamhelloabcdefghi"
 * �����7
 * ���ͣ����ǿ��԰��ַ�����ֳ� "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"��
 * ʾ�� 2��
 * <p>
 * ���룺text = "merchant"
 * �����1
 * ���ͣ����ǿ��԰��ַ�����ֳ� "(merchant)"��
 * ʾ�� 3��
 * <p>
 * ���룺text = "antaprezatepzapreanta"
 * �����11
 * ���ͣ����ǿ��԰��ַ�����ֳ� "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"��
 * ʾ�� 4��
 * <p>
 * ���룺text = "aaa"
 * �����3
 * ���ͣ����ǿ��԰��ַ�����ֳ� "(a)(a)(a)"��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * text?����СдӢ���ַ���ɡ�
 * 1 <= text.length <= 1000
 * ͨ������1,627�ύ����3,122
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/longest-chunked-palindrome-decomposition
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LongestDecomposition {

    public int longestDecomposition(String text) {
        int n = text.length();
        for (int i = 1; i <= n / 2; ++i) {
            if (text.substring(0, i).equals(text.substring(n - i, n))) {
                return 2 + longestDecomposition(text.substring(i, n - i));
            }
        }
        return n == 0 ? 0 : 1;
    }
}
