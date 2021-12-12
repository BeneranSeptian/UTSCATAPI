package seftian.uts

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatClient {

    private const val BASE_URL = "https://api.thecatapi.com/v1/";

    val instance : CatAPI by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(CatAPI::class.java)
    }
}