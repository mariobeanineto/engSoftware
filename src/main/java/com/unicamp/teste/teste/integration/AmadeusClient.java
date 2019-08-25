package com.unicamp.teste.teste.integration;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.HotelOffer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AmadeusClient {

    @Value("${integration.amadeus.client.secret}")
    private String clientSecret;

    @Value("${integration.amadeus.client.id}")
    private String clientId;

    public String getHotelOffers(String latitude, String longitude, String checkInDate, String checkOutDate) {
        Amadeus amadeus = getAmadeusBuilder();
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
                System.out.println(offer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    private Amadeus getAmadeusBuilder() {
        return Amadeus
                .builder(clientId, clientSecret)
                .build();
    }
}
