package code.code;

/**
 * @author duson
 * ���������������� startTime����ʼʱ�䣩�� endTime������ʱ�䣩����ָ��һ������ queryTime ��Ϊ��ѯʱ�䡣
 * <p>
 * ��֪���� i ��ѧ���� startTime[i] ʱ��ʼд��ҵ���� endTime[i] ʱ�����ҵ��
 * <p>
 * �뷵���ڲ�ѯʱ�� queryTime ʱ��������ҵ��ѧ����������ʽ�ϣ������ܹ�ʹ queryTime �������� [startTime[i], endTime[i]]��������ѧ��������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
 * �����1
 * ���ͣ�һ���� 3 ��ѧ����
 * ��һ��ѧ����ʱ�� 1 ��ʼд��ҵ������ʱ�� 3 �����ҵ����ʱ�� 4 û�д�������ҵ��״̬��
 * �ڶ���ѧ����ʱ�� 2 ��ʼд��ҵ������ʱ�� 2 �����ҵ����ʱ�� 4 û�д�������ҵ��״̬��
 * �ڶ���ѧ����ʱ�� 3 ��ʼд��ҵ��Ԥ����ʱ�� 7 �����ҵ��������Ψһһ����ʱ�� 4 ʱ��������ҵ��ѧ����
 * ʾ�� 2��
 * <p>
 * ���룺startTime = [4], endTime = [4], queryTime = 4
 * �����1
 * ���ͣ��ڲ�ѯʱ��ֻ��һ��ѧ��������ҵ��
 * ʾ�� 3��
 * <p>
 * ���룺startTime = [4], endTime = [4], queryTime = 5
 * �����0
 * ʾ�� 4��
 * <p>
 * ���룺startTime = [1,1,1,1], endTime = [1,3,2,4], queryTime = 7
 * �����0
 * ʾ�� 5��
 * <p>
 * ���룺startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10], queryTime = 5
 * �����5
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * startTime.length == endTime.length
 * 1 <= startTime.length <= 100
 * 1 <= startTime[i] <= endTime[i] <= 1000
 * 1 <=?queryTime <= 1000
 * ͨ������4,104�ύ����4,745
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-students-doing-homework-at-a-given-time
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BusyStudent {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }
        return count;
    }
}
