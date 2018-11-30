package sg.com.sph.kotlincourse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {
    private const val BASE_URL = "https://data.gov.sg/api/action/"

    private var retrofitObject: Retrofit?= null

    private fun getRetrofit(): Retrofit {
        if (retrofitObject == null) {
            retrofitObject = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofitObject!!
    }

    fun getApi(): ApiService = getRetrofit().create(ApiService::class.java)
}