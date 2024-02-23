package org.futureCollars.lesson9.task1;

public class CountryAndCapital {

    private String country;
    private String capital;
    public CountryAndCapital next;

    public CountryAndCapital(String country, String capital) {
        this.country = country;
        this.capital = capital;
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
