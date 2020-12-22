package net.toregard.reactiverjdbcbackend;

import domain.StationData;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

public class TestUrl {
   //https://react-leaflet.js.org/docs/example-layers-control
   //https://data-legacy.urbansharing.com/
   static final String STATIONS_URL =  "https://data-legacy.urbansharing.com/legacy-api/stations.json";
   static final String AVAILABILITY_URL = "https://data-legacy.urbansharing.com/legacy-api/availability.json";
   static final String STATUS_URL = "https://data-legacy.urbansharing.com/legacy-api/status.json";
    @Test
    void callMe() {
        WebClient webClient = WebClient.builder().baseUrl(STATIONS_URL).build();
        StationData stations = webClient.get().retrieve().bodyToMono(StationData.class).block();

    }
}
