package domain


data class StationData(
        var stations: Array<Station>,

)

data class Response(
        val stations: Array<Station>?=null,
        val availabilites: Array<Availability>?=null,
        val status : Status?=null
)

data class AvailabilityData(
        var stations: Array<Availability>?
)

data class StatusData(
        val status : Status
)

data class Station(
        val id: String,
        val title: String,
        val number_of_locks: String,
        val center: Coordinate,
        val bounds: Array<Coordinate>
)

data class Coordinate(
        val latitude: Double,
        val longitude: Double
)

data class Availability(
        val id : String,
        val bikes : Int,
        val locks : Int
)

data class Status(
        val all_stations_closed: Boolean,
        val stations_closed : Array<Station>
)


