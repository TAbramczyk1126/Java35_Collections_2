package org.futureCollars.lesson9.task1;

public class OwnHashMap implements OwnMap {

    private static final int DEFAULT_SIZE = 10;
    private CountryCapitalPair[] table;
    private int size;

    public OwnHashMap() {
        table = new CountryCapitalPair[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public boolean put(String key, String value) {
        int index = hash(key) % table.length;
        for (CountryCapitalPair entry : table) {
            if (entry != null && entry.getCountry().equals(key)) {
                entry.setCapital(value);
                return true;
            }
        }

        table[index] = new CountryCapitalPair(key, value);
        size++;
        return true;
    }

    @Override
    public boolean containsKey(String key) {
        int index = hash(key) % table.length;
        CountryCapitalPair entry = table[index];

        while (entry != null) {
            if (entry.getCountry().equals(key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (CountryCapitalPair entry : table) {
            while (entry != null) {
                if (entry.getCapital().equals(value)) {
                    return true;
                }
                entry = entry.next;
            }
        }
        return false;
    }

    @Override
    public String remove(String key) {
        int index = hash(key) % table.length;
        CountryCapitalPair entry = table[index];
        CountryCapitalPair prev = null;

        while (entry != null) {
            if (entry.getCountry().equals(key)) {
                String removedCapital = entry.getCapital();
                if (prev == null) {
                    table[index] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return removedCapital;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }

    @Override
    public String get(String key) {
        int index = hash(key) % table.length;
        CountryCapitalPair entry = table[index];

        while (entry != null) {
            if (entry.getCountry().equals(key)) {
                return entry.getCapital();
            }
            entry = entry.next;
        }
        return null;
    }

    private int hash(String key) {
        return key.hashCode();
    }
}
