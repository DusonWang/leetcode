package code.code;

/**
 * @author duson
 * Table: Views
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | article_id    | int     |
 * | author_id     | int     |
 * | viewer_id     | int     |
 * | view_date     | date    |
 * +---------------+---------+
 * �˱�����������˿��ܻ�����ظ��С��˱��ÿһ�ж���ʾĳ����ĳ�������ĳλ���ߵ�ĳƪ���¡� ��ע�⣬ͬһ�˵� author_id �� viewer_id ����ͬ�ġ�
 * ?
 * <p>
 * ��дһ�� SQL ��ѯ���ҳ���ͬһ���Ķ�������ƪ���µ��ˣ�������� id ��������
 * <p>
 * ��ѯ����ĸ�ʽ���£�
 * <p>
 * Views table:
 * +------------+-----------+-----------+------------+
 * | article_id | author_id | viewer_id | view_date  |
 * +------------+-----------+-----------+------------+
 * | 1          | 3         | 5         | 2019-08-01 |
 * | 3          | 4         | 5         | 2019-08-01 |
 * | 1          | 3         | 6         | 2019-08-02 |
 * | 2          | 7         | 7         | 2019-08-01 |
 * | 2          | 7         | 6         | 2019-08-02 |
 * | 4          | 7         | 1         | 2019-07-22 |
 * | 3          | 4         | 4         | 2019-07-21 |
 * | 3          | 4         | 4         | 2019-07-21 |
 * +------------+-----------+-----------+------------+
 * <p>
 * Result table:
 * +------+
 * | id   |
 * +------+
 * | 5    |
 * | 6    |
 * +------+
 * ͨ������1,059�ύ����2,431
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/article-views-ii
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ArticleViewsII {


    //SELECT DISTINCT viewer_id AS id
    //FROM Views a
    //GROUP BY a.view_date, viewer_id
    //HAVING COUNT(DISTINCT article_id) >= 2
    //ORDER BY viewer_id
}
