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
 * 此表无主键，因此可能会存在重复行。此表的每一行都表示某人在某天浏览了某位作者的某篇文章。 请注意，同一人的 author_id 和 viewer_id 是相同的。
 * ?
 * <p>
 * 编写一条 SQL 查询来找出在同一天阅读至少两篇文章的人，结果按照 id 升序排序。
 * <p>
 * 查询结果的格式如下：
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
 * 通过次数1,059提交次数2,431
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/article-views-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArticleViewsII {


    //SELECT DISTINCT viewer_id AS id
    //FROM Views a
    //GROUP BY a.view_date, viewer_id
    //HAVING COUNT(DISTINCT article_id) >= 2
    //ORDER BY viewer_id
}
