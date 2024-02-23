package org.futureCollars.lesson9.task1;

public class OwnHashMap implements OwnMap {

    private static final int DEFAULT_SIZE = 10;
    private CountryAndCapital[] table;
    private int size;

    public OwnHashMap() {
        table = new CountryAndCapital[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public boolean put(String country, String capital) {
        int index = hash(country) % table.length;
        for (CountryAndCapital entry : table) {
            if (entry != null && entry.getCountry().equals(country)) {
                entry.setCapital(capital);
                return true;
            }
        }

        table[index] = new CountryAndCapital(country, capital);
        size++;
        return true;
    }

    @Override
    public boolean containsKey(String country) {
        int index = hash(country) % table.length;
        CountryAndCapital entry = table[index];

        while (entry != null) {
            if (entry.getCountry().equals(country)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object capital) {
        for (CountryAndCapital entry : table) {
            while (entry != null) {
                if (entry.getCapital().equals(capital)) {
                    return true;
                }
                entry = entry.next;
            }
        }
        return false;
    }

    @Override
    public String remove(String country) {
        int index = hash(country) % table.length;
        CountryAndCapital entry = table[index];
        CountryAndCapital prev = null;

        while (entry != null) {
            if (entry.getCountry().equals(country)) {
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
    public String get(String country) {
        int index = hash(country) % table.length;
        CountryAndCapital entry = table[index];

        while (entry != null) {
            if (entry.getCountry().equals(country)) {
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
