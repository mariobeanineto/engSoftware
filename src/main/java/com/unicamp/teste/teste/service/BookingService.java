package com.unicamp.teste.teste.service;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.HotelOffer;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    public String teste() {
        Amadeus amadeus = Amadeus
                .builder("ZDcUjrQSI5VaBBWP0rNizw7upIYSgSXK", "N5CKGYyYPnHpmaDa")
                .build();

        try {
            HotelOffer[] offers = amadeus.shopping.hotelOffers.get(Params
                    .with("latitude", "41.39715")
                    .and("longitude", "2.160873"));

            for (HotelOffer offer : offers) {
                System.out.println(offer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "ok";
    }
}
