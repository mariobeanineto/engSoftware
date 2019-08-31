package com.unicamp.teste.teste.integration;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.HotelOffer;
import com.unicamp.teste.teste.entity.Hotel;
import com.unicamp.teste.teste.entity.HotelAddress;
import com.unicamp.teste.teste.entity.HotelOfferDTO;
import com.unicamp.teste.teste.entity.Offer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmadeusClient {

    @Value("${integration.amadeus.client.secret}")
    private String clientSecret;

    @Value("${integration.amadeus.client.id}")
    private String clientId;

    public List<HotelOfferDTO> getHotelOffers(String latitude, String longitude, String checkInDate, String checkOutDate) {
        Amadeus amadeus = getAmadeusBuilder();

        List<HotelOfferDTO> hotelOfferDTOList = new ArrayList<>();
        try {
            HotelOffer[] offers = amadeus.shopping.hotelOffers.get(Params
                    .with("latitude", latitude)
                    .and("longitude", longitude)
                    .and("radius", "15")
                    .and("radiusUnit", "KM")
                    .and("checkInDate", checkInDate)
                    .and("checkOutDate", checkOutDate)
                    .and("lang", "pt"));

            for (HotelOffer offer : offers) {
                hotelOfferDTOList.add(createHotelOfferDTO(offer, checkInDate, checkOutDate));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelOfferDTOList;
    }

    private HotelOfferDTO createHotelOfferDTO(HotelOffer offerParam, String checkInDate, String checkOutDate) {
        HotelOfferDTO hotelOfferDTO = new HotelOfferDTO();
        hotelOfferDTO.setDateIn(checkInDate);
        hotelOfferDTO.setDateOut(checkOutDate);
        hotelOfferDTO.setIdLat(String.valueOf(offerParam.getHotel().getLatitude()));
        hotelOfferDTO.setIdLong(String.valueOf(offerParam.getHotel().getLongitude()));
        hotelOfferDTO.setHotel(createHotel(offerParam));
        return hotelOfferDTO;
    }

    private Hotel createHotel(HotelOffer offerParam) {
        Hotel hotel = new Hotel();
        hotel.setContact(offerParam.getHotel().getContact().getPhone());
        hotel.setRating(offerParam.getHotel().getRating().toString());
        hotel.setOffer(createOffer(offerParam));
        hotel.setHotelAddress(createHotelAddress(offerParam));
        hotel.setName(offerParam.getHotel().getName());
        return hotel;
    }

    private HotelAddress createHotelAddress(HotelOffer offerParam) {
        HotelAddress hotelAddress = new HotelAddress();
        hotelAddress.setCityName(offerParam.getHotel().getAddress().getCityName());
        hotelAddress.setPostalCode(offerParam.getHotel().getAddress().getPostalCode());
        hotelAddress.setStateCode(offerParam.getHotel().getAddress().getStateCode());
        hotelAddress.setStreet(offerParam.getHotel().getAddress().getLines()[0]);
        return hotelAddress;
    }

    private Offer createOffer(HotelOffer offerParam) {
        Offer offerDto = new Offer();
        offerDto.setId(offerParam.getOffers()[0].getId());
        offerDto.setGuests(offerParam.getOffers()[0].getGuests().getAdults().toString());
        offerDto.setPrice(offerParam.getOffers()[0].getPrice().getTotal());
        offerDto.setRoom(offerParam.getOffers()[0].getRoom().getType());
        return offerDto;
    }

    private Amadeus getAmadeusBuilder() {
        return Amadeus
                .builder(clientId, clientSecret)
                .build();
    }
}
