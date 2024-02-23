package org.futureCollars.lesson9.task1;

public class CountryAndCapital {

    private String country;
    private String capital;
    public CountryAndCapital next;

    public CountryAndCapital(String key, String value) {
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
