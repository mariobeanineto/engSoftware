package com.unicamp.teste.teste.entity;

public class HotelOfferDTO {

    private String idLat;

    private String idLong;

    private String dateIn;

    private String dateOut;

    private Hotel hotel;

    public HotelOfferDTO() {
    }

    public String getIdLat() {
        return idLat;
    }

    public void setIdLat(String idLat) {
        this.idLat = idLat;
    }

    public String getIdLong() {
        return idLong;
    }

    public void setIdLong(String idLong) {
        this.idLong = idLong;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
