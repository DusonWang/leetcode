package code.code;

/**
 * ĳ���ŵ��ݳ����ؿ����� num * num �Ķ�ά���� grid�����Ͻ�����Ϊ [0,0])��ÿ��λ��վ��һλ��Ա�����Ź��� 9 ���������������Ϊ 1~9��ÿλ��Ա���� 1 ��������
 * <p>
 * Ϊ��֤���ֻ��Ч������Ավλ����Ϊ���� grid ���Ͻǿ�ʼ˳ʱ������������ѭ���� 1��2��...��9 ѭ���ظ����С����統 num = 5 ʱ��վλ��ͼ��ʾ
 * <p>
 * <p>
 * <p>
 * �뷵��λ�ڳ������� [Xpos,Ypos] �ĳ�Ա����������š�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺num = 3, Xpos = 0, Ypos = 2
 * <p>
 * �����3
 * <p>
 * ���ͣ�
 * <p>
 * <p>
 * ʾ�� 2��
 * <p>
 * ���룺num = 4, Xpos = 1, Ypos = 2
 * <p>
 * �����5
 * <p>
 * ���ͣ�
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= num <= 10^9
 * 0 <= Xpos, Ypos < num
 * ͨ������3,012�ύ����20,168
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/SNJvJP
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class OrchestraLayout {

    public int orchestraLayout(int num, int xPos, int yPos) {
        long i = xPos + 1, j = yPos + 1, n = num;
        long mi = Math.min(i, Math.min(j, Math.min(n - i + 1, n - j + 1))), ans;
        if (i <= j) {
            ans = mi * (4 * n - 4 * mi) + 6 * mi - 4 * n - 3 + i + j;
        } else {
            ans = mi * (4 * n - 4 * mi) + 2 * mi + 1 - i - j;
        }
        return (int)(ans % 9 == 0 ? 9 : ans % 9);
    }
}
