package monkey.common;

public class LocalCacheObject {

    private Object value;
    private long nextUpdateTime = 0;
    private long updateInterval = 0;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
        if (updateInterval > 0) {
            nextUpdateTime = LocalCache.getTimeStamp() + updateInterval;
        }
    }

    public boolean isExpired() {
        if (updateInterval > 0) {
            return nextUpdateTime < LocalCache.getTimeStamp();
        } else {
            return false;
        }
    }

    public void setUpdateInterval(long interval) {
        updateInterval = interval;
    }
}
