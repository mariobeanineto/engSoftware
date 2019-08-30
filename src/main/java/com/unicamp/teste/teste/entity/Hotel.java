package com.unicamp.teste.teste.entity;

public class Hotel {

    private String name;

    private String rating;

    private String contact;

    private Offer offer;

    private HotelAddress hotelAddress;

    public Hotel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public HotelAddress getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(HotelAddress hotelAddress) {
        this.hotelAddress = hotelAddress;
    }
}
