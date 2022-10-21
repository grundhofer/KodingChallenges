package eisenbahnroute

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun formatTrainRoute(stations: List<String>): String {
    val prefix = "Train is calling at "

    if (stations.size == 1) {
        return prefix + stations[0]
    }

    val lastStation = stations.last()

    val followingStations = stations.dropLast(1)
        .joinToString { it }

    return "$prefix$followingStations and $lastStation"
}

private class Test {
    @Test
    fun `formatTrainRoute list 'Koeln'`() {
        formatTrainRoute(listOf("Köln")) shouldBeEqualTo "Train is calling at Köln"
    }

    @Test
    fun `formatTrainRoute list 'Koeln', 'Hamburg'`() {
        formatTrainRoute(listOf("Köln", "Hamburg")) shouldBeEqualTo "Train is calling at Köln and Hamburg"
    }

    @Test
    fun `formatTrainRoute list 'Koeln', 'Hamburg', 'Berlin'`() {
        val list = listOf("Köln", "Hamburg", "Berlin")
        formatTrainRoute(list) shouldBeEqualTo "Train is calling at Köln, Hamburg and Berlin"
    }

    @Test
    fun `formatTrainRoute list 'Koeln', 'Hamburg', 'Frankfurt', 'Berlin'`() {
        val list = listOf("Köln", "Hamburg", "Frankfurt", "Berlin")
        formatTrainRoute(list) shouldBeEqualTo "Train is calling at Köln, Hamburg, Frankfurt and Berlin"
    }
}
