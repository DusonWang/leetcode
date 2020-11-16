package code.code;

/**
 * @author duson
 * ���ѹ�ϵ�б�?Friendship
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user1_id      | int     |
 * | user2_id      | int     |
 * +---------------+---------+
 * ���ű�������� (user1_id, user2_id)��
 * ���ű��ÿһ�д����� user1_id �� user2_id ֮����������ѹ�ϵ��
 * ?
 * <p>
 * ϲ���б�?Likes
 * <p>
 * +-------------+---------+
 * | Column Name | Type    |
 * +-------------+---------+
 * | user_id     | int     |
 * | page_id     | int     |
 * +-------------+---------+
 * ���ű�������� (user_id, page_id)��
 * ���ű��ÿһ�д����� user_id ϲ�� page_id��
 * ?
 * <p>
 * дһ�� SQL ?��user_id = 1 ���û����Ƽ���������ϲ����ҳ�档��Ҫ�Ƽ����û��Ѿ�ϲ����ҳ�档
 * <p>
 * �㷵�صĽ���в�Ӧ�������ظ��
 * <p>
 * ���ؽ���ĸ�ʽ��������ʾ��
 * <p>
 * Friendship table:
 * +----------+----------+
 * | user1_id | user2_id |
 * +----------+----------+
 * | 1        | 2        |
 * | 1        | 3        |
 * | 1        | 4        |
 * | 2        | 3        |
 * | 2        | 4        |
 * | 2        | 5        |
 * | 6        | 1        |
 * +----------+----------+
 * <p>
 * Likes table:
 * +---------+---------+
 * | user_id | page_id |
 * +---------+---------+
 * | 1       | 88      |
 * | 2       | 23      |
 * | 3       | 24      |
 * | 4       | 56      |
 * | 5       | 11      |
 * | 6       | 33      |
 * | 2       | 77      |
 * | 3       | 77      |
 * | 6       | 88      |
 * +---------+---------+
 * <p>
 * Result table:
 * +------------------+
 * | recommended_page |
 * +------------------+
 * | 23               |
 * | 24               |
 * | 56               |
 * | 33               |
 * | 77               |
 * +------------------+
 * �û�1 ͬ �û�2, 3, 4, 6 �����ѹ�ϵ��
 * �Ƽ�ҳ��Ϊ�� ҳ��23 ������ �û�2, ҳ��24 ������ �û�3, ҳ��56 ������ �û�3 �Լ� ҳ��33 ������ �û�6��
 * ҳ��77 ͬʱ�� �û�2 �� �û�3 �Ƽ���
 * ҳ��88 û�б��Ƽ�����Ϊ �û�1 �Ѿ�ϲ��������
 * ͨ������921�ύ����1,555
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/page-recommendations
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class RecommendedPage {

    //select distinct page_id as recommended_page
    //from Likes
    //where user_id in
    //(
    //    select distinct user2_id id from Friendship where user1_id=1
    //    union
    //    select distinct user1_id id from Friendship where user2_id=1
    //)
    //and page_id not in
    //(select page_id from Likes where user_id=1)
}
