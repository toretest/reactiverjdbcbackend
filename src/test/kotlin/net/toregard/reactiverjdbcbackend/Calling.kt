package net.toregard.reactiverjdbcbackend

import domain.AvailabilityData
import domain.Response
import domain.StationData
import domain.StatusData
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.util.function.Tuple3


/**
 * https://stackoverflow.com/questions/50203875/how-to-use-spring-webclient-to-make-multiple-calls-simultaneously
 * https://spring.io/blog/2019/04/12/going-reactive-with-spring-coroutines-and-kotlin-flow
 *
 * https://dzone.com/articles/using-the-webclient-class-reactive-programming-in
 */
class StationTest {
    var logger: Logger = LoggerFactory.getLogger(StationTest::class.java)

    private fun map(tuple3: Tuple3<StationData, AvailabilityData, StatusData>): Response? {
        val stationData: StationData = tuple3.t1
        val availabilityData: AvailabilityData = tuple3.t2
        val statusData: StatusData = tuple3.t3
        return Response(stationData.stations, availabilityData.stations, statusData.status)
    }

    @Test
    fun testMe(): Unit {
        val webClientStation = WebClient.builder().baseUrl(TestUrl.STATIONS_URL).build()
        val webClientAvailability = WebClient.builder().baseUrl(TestUrl.AVAILABILITY_URL).build()
        val webClientStatus = WebClient.builder().baseUrl(TestUrl.STATUS_URL).build()

        val stations: Mono<StationData> = webClientStation.get().retrieve().bodyToMono(StationData::class.java)
        val availabilities: Mono<AvailabilityData> =
            webClientAvailability.get().retrieve().bodyToMono(AvailabilityData::class.java)
        val status = webClientStatus.get().retrieve().bodyToMono(StatusData::class.java)

        val result = Mono.zip(
            stations,
            availabilities,
            status).map(this::map).block()

        /* val a = Mono.zip(
             stations,
             availabilities,
             {
                     a: StationData,
                     b: AvailabilityData
                 ->
                 {
                     Response(a.stations, b.stations)
                 }
             }).block()*/

        //val result = Mono.zip(stationsData)
        //val s = stationsData.block();
        //assertThat(s?.stations?.size).isEqualTo(250)
        //assertThat(s?.stations?.size).isNotNull()
        //logger.info("Amount of ${s?.stations?.size}")
    }


}



