package monkey.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ListQueue<E> {

    private ArrayList<E> cache = new ArrayList<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final static Logger logger = LoggerFactory.getLogger(ListQueue.class);

    public void add(E element) {
        lock.writeLock().lock();
        try {
            cache.add(element);
        } catch (Exception e) {
            logger.error("写入队列失败: " + ObjectMapper.toJson(element));
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean isEmpty() {
        lock.readLock().lock();
        try {
            return cache.isEmpty();
        } catch (Exception e) {
            logger.error("读取队列失败: " + cache.getClass().getName() + "," + e);
        } finally {
            lock.readLock().unlock();
        }

        return true;
    }

    public List<E> getAll() {
        List<E> elements = new ArrayList<>();

        lock.writeLock().lock();
        try {
            lock.readLock().lock();
            try {
                elements = new ArrayList<>(cache);
            } catch (Exception e) {
                logger.error("读取队列失败: " + cache.getClass().getName() + "," + e);
            } finally {
                lock.readLock().unlock();
            }

            cache.clear();

        } catch (Exception e) {
            logger.error("清空队列失败: " + cache.getClass().getName() + "," + e);
        } finally {
            lock.writeLock().unlock();
        }

        return elements;
    }


    public int count() {
        lock.readLock().lock();
        try {
            return cache.size();
        } catch (Exception e) {
            logger.error("读取队列数量失败: " + cache.getClass().getName() + "," + e);
        } finally {
            lock.readLock().unlock();
        }
        return 0;
    }
}
