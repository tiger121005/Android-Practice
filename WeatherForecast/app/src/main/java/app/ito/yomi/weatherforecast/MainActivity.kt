package app.ito.yomi.weatherforecast

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import app.ito.yomi.weatherforecast.databinding.ActivityMainBinding
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var weatherApi: WeatherApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        setUpWeatherApi()
        setWeather(City.TOKYO.id)

        binding.osakaButton.setOnClickListener {
            setWeather(City.OSAKA.id)
        }
        binding.nagoyaButton.setOnClickListener {
            setWeather(City.NAGOYA.id)
        }
        binding.sapporoButton.setOnClickListener {
            setWeather(City.SAPPORO.id)
        }


    }

    fun setUpWeatherApi() {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val httpLogging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClientBuilder = OkHttpClient.Builder().addInterceptor(httpLogging).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://weather.tsukumijima.net/api/forecast/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(httpClientBuilder)
            .build()

        weatherApi = retrofit.create(WeatherApiService::class.java)
    }

    fun setWeather(cityId: String) {
        val imageLoader = ImageLoader.Builder(this)
            .components{ add(SvgDecoder.Factory())}
            .build()

        lifecycleScope.launch {
            runCatching {
                weatherApi.getCityWeather(cityId)
            }.onSuccess {
                binding.cityTextView.text = it.title
                binding.weatherImageView.load(it.forecast[0].images.url, imageLoader)
            }.onFailure {
                Log.d("error", it.message.toString())
            }
        }
    }
}