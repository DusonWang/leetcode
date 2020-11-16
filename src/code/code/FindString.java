package code.code;

/**
 * @author duson
 * ϡ�������������и��ź�����ַ������飬����ɢ����һЩ���ַ�������дһ�ַ������ҳ������ַ�����λ�á�
 * <p>
 * ʾ��1:
 * <p>
 * ����: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * �����-1
 * ˵��: �����ڷ���-1��
 * ʾ��2:
 * <p>
 * ���룺words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * �����4
 * ��ʾ:
 * <p>
 * words�ĳ�����[1, 1000000]֮��
 * ͨ������2,435�ύ����4,128
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sparse-array-search-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindString {

    public int findString(String[] words, String s) {
        if (words == null || words.length == 0) {
            return -1;
        }
        int left = 0, right = words.length - 1;
        while (left <= right) {
            while (left <= right && words[left].length() == 0) {
                left++;
            }
            while (left <= right && words[right].length() == 0) {
                right--;
            }
            int mid = left + (right - left) / 2;
            while (mid < right && words[mid].length() == 0) {
                mid++;
            }
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
