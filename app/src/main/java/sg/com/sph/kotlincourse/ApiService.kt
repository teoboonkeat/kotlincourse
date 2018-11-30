package sg.com.sph.kotlincourse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("datastore_search?resource_id=52e93430-01b7-4de0-80df-bc83d0afed40")
    fun getResalePriceIndex(@Query("limit") limit: Int): Call<HDBResalePriceIndexSchema>
}

