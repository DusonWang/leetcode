package code.code;

/**
 * ����һ���ַ��� s ��һ�� ������ͬ ���������� indices ��
 * <p>
 * �������������ַ��� s �����е� i ���ַ���Ҫ�ƶ��� indices[i] ָʾ��λ�á�
 * <p>
 * �����������к���ַ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * �����"leetcode"
 * ���ͣ���ͼ��ʾ��"codeleet" �������к��Ϊ "leetcode" ��
 * ʾ�� 2��
 * <p>
 * ���룺s = "abc", indices = [0,1,2]
 * �����"abc"
 * ���ͣ��������к�ÿ���ַ���������ԭ����λ���ϡ�
 * ʾ�� 3��
 * <p>
 * ���룺s = "aiohn", indices = [3,1,4,2,0]
 * �����"nihao"
 * ʾ�� 4��
 * <p>
 * ���룺s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
 * �����"arigatou"
 * ʾ�� 5��
 * <p>
 * ���룺s = "art", indices = [1,0,2]
 * �����"rat"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * s.length == indices.length == n
 * 1 <= n <= 100
 * s ������СдӢ����ĸ��
 * 0 <= indices[i] <?n
 * indices �����е�ֵ����Ψһ�ģ�Ҳ����˵��indices ������ 0 �� n - 1 �γɵ�һ�����У���
 * ͨ������25,740�ύ����32,831
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shuffle-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class RestoreString {

    public String restoreString(String s, int[] indices) {
        char[] aa = s.toCharArray();
        char[] result = new char[aa.length];
        for (int i = 0; i < indices.length; i++) {
            result[indices[i]] = aa[i];
        }
        return new String(result);
    }
}
