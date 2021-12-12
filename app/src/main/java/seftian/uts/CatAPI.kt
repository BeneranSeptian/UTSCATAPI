package seftian.uts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface CatAPI {
    @Headers("x-api-key: ca3a339f-2931-465b-a028-62aa14544306")
    @GET("breeds")
    fun getPost(
        //@Query("q") breed : String
    ) : Call<ArrayList<CatDetail>>

    @Headers("x-api-key: ca3a339f-2931-465b-a028-62aa14544306")
    @GET("images/search?limit=5")
    fun getImage(
        @Query("breed_id") idbreed : String
    ) : Call<ArrayList<CatImage>>
}