package code.code;

/**
 * @author duson
 * �и��ں����ʵĳ����ı��ļ������������������ʣ��ҳ�������ļ������������ʵ���̾���(���������)�����Ѱ�ҹ���������ļ��л��ظ���Σ���ÿ��Ѱ�ҵĵ��ʲ�ͬ�����ܶԴ��Ż���?
 * <p>
 * ʾ����
 * <p>
 * ���룺words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * �����1
 * ��ʾ��
 * <p>
 * words.length <= 100000
 * ͨ������2,838�ύ����4,195
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-closest-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindClosest {

    public int findClosest(String[] words, String word1, String word2) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                left = i;
                ans = Math.min(ans, Math.abs(right - left));
            } else if (words[i].equals(word2)) {
                right = i;
                ans = Math.min(ans, Math.abs(right - left));
            }
            if (ans == 1) {
                return 1;
            }
        }
        return ans;
    }
}
