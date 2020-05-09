package monkey.common;

import java.util.concurrent.ConcurrentHashMap;

public class LocalCache {

    private static ConcurrentHashMap<Object, LocalCacheObjectLoader> objectLoaderMap = new ConcurrentHashMap<>();
    private static LocalCacheMap cacheMap = new LocalCacheMap();

    public static <ObjectType> void addObjectLoader(Class<ObjectType> objectType, LocalCacheObjectLoader objectBuilder) {
        objectLoaderMap.put(objectType, objectBuilder);
    }

    public static  void addObjectLoader(Object objectType, LocalCacheObjectLoader objectBuilder) {
        objectLoaderMap.put(objectType, objectBuilder);
    }

    public static void setObjectValue(Object objectType, Object objectKey, Object objectValue) {
        LocalCacheObjectMap objectMap = getObjectMap(objectType);
        LocalCacheObject object = new LocalCacheObject();
        object.setValue(objectValue);
        objectMap.put(objectKey, object);
    }

    public static <ObjectType> ObjectType getObjectValue(Object objectType, Object objectKey) {
        return getObjectValue(objectType, objectKey, 0);
    }

    public static <ObjectType> ObjectType getObjectValue(Object objectType, Object objectKey, long updateInterval) {
        LocalCacheObjectMap objectMap = getObjectMap(objectType);
        LocalCacheObject object = objectMap.get(objectKey);

        if (object == null || object.isExpired()) {
            object = load(objectType, objectKey, updateInterval, objectMap);
        }

        if (object == null) {
            return null;
        } else {
            return (ObjectType) object.getValue();
        }
    }

    public static <ObjectType> void setObjectValue(Class<ObjectType> objectType, Object objectKey, ObjectType objectValue) {
        setObjectValue(objectType, objectKey, objectValue, 0);
    }

    public static <ObjectType> void setObjectValue(Class<ObjectType> objectType, Object objectKey, ObjectType objectValue, long updateInterval) {
        LocalCacheObjectMap objectMap = getObjectMap(objectType);
        LocalCacheObject object = new LocalCacheObject();
        object.setValue(objectValue);
        object.setUpdateInterval(updateInterval);
        objectMap.put(objectKey, object);
    }

    private static LocalCacheObject load(Object objectType, Object objectKey, long updateInterval, LocalCacheObjectMap objectMap) {
        LocalCacheObjectLoader objectLoader = objectLoaderMap.get(objectType);
        if (objectLoader != null) {
            LocalCacheObject object = new LocalCacheObject();
            Object objectValue = objectLoader.load(objectKey);
            object.setUpdateInterval(updateInterval);
            object.setValue(objectValue);
            objectMap.put(objectKey, object);
            return object;
        }

        return null;
    }

    private static LocalCacheObjectMap getObjectMap(Object objectType) {
        LocalCacheObjectMap objectMap = cacheMap.get(objectType);
        if (objectMap == null) {
            objectMap = new LocalCacheObjectMap();
            cacheMap.put(objectType, objectMap);
        }
        return objectMap;
    }

    public static long getTimeStamp() {
        long now = System.currentTimeMillis();
        return now / 1000;
    }



}
