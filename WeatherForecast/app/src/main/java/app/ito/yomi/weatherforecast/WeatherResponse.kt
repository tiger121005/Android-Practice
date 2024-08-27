package app.ito.yomi.weatherforecast

import com.squareup.moshi.Json

class WeatherResponse (
    val title: String,
    @Json(name = "forecasts") val forecast: List<ForecastResponse>
)

class ForecastResponse(
    @Json(name = "telop") val weather: String,
    @Json(name = "image") val images: ImageResponse,
)

class ImageResponse(
    val title: String,
    val url: String
)