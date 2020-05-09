package monkey.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MapQueue<K, V> {

    private Map<K, V> cache = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final static Logger logger = LoggerFactory.getLogger(ListQueue.class);

    public void add(K key, V value) {
        lock.writeLock().lock();
        try {
            cache.put(key, value);
        } catch (Exception e) {
            logger.error("写入队列失败: " + ObjectMapper.toJson(value));
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


    public List<V> getAll() {
        List<V> values = new ArrayList<>();

        lock.writeLock().lock();
        try {
            lock.readLock().lock();
            try {
                values = new ArrayList<>(cache.values());
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

        return values;
    }
}
