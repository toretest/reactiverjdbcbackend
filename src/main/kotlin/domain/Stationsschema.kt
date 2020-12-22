package domain


data class StationData(
        val stations: Array<Station>
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


