package monkey.common;

public interface RedisClient {

    <T> T get(String key, Class<T> clazz);
    <T> void set(String key, T value, int seconds);
    <T> void delete(String key);
}
