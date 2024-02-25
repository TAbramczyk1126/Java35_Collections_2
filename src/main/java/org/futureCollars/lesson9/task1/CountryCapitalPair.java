package org.futureCollars.lesson9.task1;

public class CountryCapitalPair {

    private String country;
    private String capital;
    public CountryCapitalPair next;

    public CountryCapitalPair(String key, String value) {
        this.country = key;
        this.capital = value;
        this.next = null;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
