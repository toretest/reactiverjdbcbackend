package net.toregard.reactiverjdbcbackend

import domain.StationData
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.reactive.function.client.WebClient

/**
 * https://stackoverflow.com/questions/50203875/how-to-use-spring-webclient-to-make-multiple-calls-simultaneously
 * https://spring.io/blog/2019/04/12/going-reactive-with-spring-coroutines-and-kotlin-flow
 */
class StationTest {
    var logger: Logger = LoggerFactory.getLogger(StationTest::class.java)

    @Test
    fun testMe() : Unit{
        val webClientStation = WebClient.builder().baseUrl(TestUrl.STATIONS_URL).build()
        val webClientAvailability = WebClient.builder().baseUrl(TestUrl.AVAILABILITY_URL).build()
        val webClientStatus = WebClient.builder().baseUrl(TestUrl.STATUS_URL).build()
        val stationsDataA = webClientStation
                .get()
                .retrieve()
                .bodyToMono(StationData::class.java)
                .block()
         val stationsData = webClientStation.get().retrieve().bodyToMono(StationData::class.java);
         val availabilityData = webClientAvailability.get().retrieve().bodyToMono(StationData::class.java);
         val statusData = webClientStatus.get().retrieve().bodyToMono(StationData::class.java);



        val s = stationsData.block();
        //assertThat(s?.stations?.size).isEqualTo(250)
        assertThat(s?.stations?.size).isNotNull()
        logger.info("Amount of ${s?.stations?.size}")
    }
}



