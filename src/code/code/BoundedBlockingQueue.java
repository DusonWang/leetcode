package code.code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author duson
 * <p>
 * 实现一个拥有如下方法的线程安全有限阻塞队列：
 * <p>
 * BoundedBlockingQueue(int capacity) 构造方法初始化队列，其中capacity代表队列长度上限。
 * void enqueue(int element) 在队首增加一个element. 如果队列满，调用线程被阻塞直到队列非满。
 * int dequeue() 返回队尾元素并从队列中将其删除. 如果队列为空，调用线程被阻塞直到队列非空。
 * int size() 返回当前队列元素个数。
 * 你的实现将会被多线程同时访问进行测试。每一个线程要么是一个只调用enqueue方法的生产者线程，要么是一个只调用dequeue方法的消费者线程。size方法将会在每一个测试用例之后进行调用。
 * <p>
 * 请不要使用内置的有限阻塞队列实现，否则面试将不会通过。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 1
 * 1
 * ["BoundedBlockingQueue","enqueue","dequeue","dequeue","enqueue","enqueue","enqueue","enqueue","dequeue"]
 * [[2],[1],[],[],[0],[2],[3],[4],[]]
 * <p>
 * 输出:
 * [1,0,2,2]
 * <p>
 * 解释:
 * 生产者线程数目 = 1
 * 消费者线程数目 = 1
 * <p>
 * BoundedBlockingQueue queue = new BoundedBlockingQueue(2);   // 使用capacity = 2初始化队列。
 * <p>
 * queue.enqueue(1);   // 生产者线程将1插入队列。
 * queue.dequeue();    // 消费者线程调用dequeue并返回1。
 * queue.dequeue();    // 由于队列为空，消费者线程被阻塞。
 * queue.enqueue(0);   // 生产者线程将0插入队列。消费者线程被解除阻塞同时将0弹出队列并返回。
 * queue.enqueue(2);   // 生产者线程将2插入队列。
 * queue.enqueue(3);   // 生产者线程将3插入队列。
 * queue.enqueue(4);   // 生产者线程由于队列长度已达到上限2而被阻塞。
 * queue.dequeue();    // 消费者线程将2从队列弹出并返回。生产者线程解除阻塞同时将4插入队列。
 * queue.size();       // 队列中还有2个元素。size()方法在每组测试用例最后调用。
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 3
 * 4
 * ["BoundedBlockingQueue","enqueue","enqueue","enqueue","dequeue","dequeue","dequeue","enqueue"]
 * [[3],[1],[0],[2],[],[],[],[3]]
 * <p>
 * 输出:
 * [1,0,2,1]
 * <p>
 * 解释:
 * 生产者线程数目 = 3
 * 消费者线程数目 = 4
 * <p>
 * BoundedBlockingQueue queue = new BoundedBlockingQueue(3);   // 使用capacity = 3初始化队列。
 * <p>
 * queue.enqueue(1);   // 生产者线程P1将1插入队列。
 * queue.enqueue(0);   // 生产者线程P2将0插入队列。
 * queue.enqueue(2);   // 生产者线程P3将2插入队列。
 * queue.dequeue();    // 消费者线程C1调用dequeue。
 * queue.dequeue();    // 消费者线程C2调用dequeue。
 * queue.dequeue();    // 消费者线程C3调用dequeue。
 * queue.enqueue(3);   // 其中一个生产者线程将3插入队列。
 * queue.size();       // 队列中还有1个元素。
 * <p>
 * 由于生产者/消费者线程的数目可能大于1，我们并不知道线程如何被操作系统调度，即使输入看上去隐含了顺序。因此任意一种输出[1,0,2]或[1,2,0]或[0,1,2]或[0,2,1]或[2,0,1]或[2,1,0]都可被接受。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-bounded-blocking-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BoundedBlockingQueue {

    private final LinkedList<Integer> queue;

    private final int capacity;

    private final Lock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();

    private final Condition notEmpty = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                notFull.await();
            }
            queue.add(element);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        int res;
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            res = queue.poll();
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
        return res;
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

}
