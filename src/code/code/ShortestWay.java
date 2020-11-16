package code.code;

/**
 * @author duson
 * �����κ��ַ��������ǿ���ͨ��ɾ������һЩ�ַ���Ҳ���ܲ�ɾ������������ַ����������С�
 * <p>
 * ����Դ�ַ���?source ��Ŀ���ַ���?target���ҳ�Դ�ַ�������ͨ�������γ�Ŀ���ַ����������е���С����������޷�ͨ������Դ�ַ����е�������������Ŀ���ַ������򷵻�?-1��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺source = "abc", target = "abcbc"
 * �����2
 * ���ͣ�Ŀ���ַ��� "abcbc" ������ "abc" �� "bc" �γɣ����Ƕ���Դ�ַ��� "abc" �������С�
 * ʾ�� 2��
 * <p>
 * ���룺source = "abc", target = "acdbc"
 * �����-1
 * ���ͣ�����Ŀ���ַ����а����ַ� "d"�������޷���Դ�ַ����������й���Ŀ���ַ�����
 * ʾ�� 3��
 * <p>
 * ���룺source = "xyz", target = "xzyxz"
 * �����3
 * ���ͣ�Ŀ���ַ������԰����·�ʽ������ "xz" + "y" + "xz"��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * source ��?target?�����ַ�����ֻ����?"a"-"z"?��Ӣ��Сд��ĸ��
 * source ��?target?�����ַ����ĳ��Ƚ���?1 ��?1000?֮�䡣
 * ͨ������961�ύ����1,795
 * ����ʵ������������������⣿
 * <p>
 * ��
 * <p>
 * <p>
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shortest-way-to-form-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ShortestWay {

    public int shortestWay(String source, String target) {
        int ans = 0;
        int n = source.length();
        int m = target.length();
        int start = 0;
        for (int i = 0; i < m; ++i) {
            int j = 0;
            while (j < n) {
                int idx = (start + j) % n;
                if (idx == 0) {
                    ++ans;
                }
                if (source.charAt(idx) == target.charAt(i)) {
                    break;
                }
                ++j;
            }
            if (j == n) {
                return -1;
            }
            start = (start + j + 1) % n;
        }
        return ans;
    }
}
