# Format train route

## Instructions

Given list of strings representing train station names implement a function which will return passenger friendly
`String`:
- String always starts with `Train is calling at`
- If list contains single train station name, then return `Train is calling at stationName`
- If list contains multiple train station names, then return comma separated station names, but the last two names are separated by `and` word.

## Examples
Koeln', 'Hamburg', 'Frankfurt', 'Berlin
```kotlin
formatTrainRoute(listOf("Koeln")) // "Train is calling at Koeln"

formatTrainRoute(listOf("Koeln", "Hamburg")) // "Train is calling at Koeln and Hamburg"

formatTrainRoute(listOf("Koeln", "Hamburg", "Berlin")) // "Train is calling at Koeln, Hamburg and Berlin"
```
