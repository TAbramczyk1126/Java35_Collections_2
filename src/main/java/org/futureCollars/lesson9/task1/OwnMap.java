package org.futureCollars.lesson9.task1;

public interface OwnMap {

    boolean put(String key, String value);

    boolean containsKey(String key);

    boolean containsValue(Object value);

    String remove(String key);

    String get(String key);
}
