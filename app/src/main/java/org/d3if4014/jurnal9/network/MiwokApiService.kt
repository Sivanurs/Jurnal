package org.d3if4014.jurnal9.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl("https://api.myjson.com/bins/")
    .build()

//API
interface MiwokService{
    @GET("mge84")
    suspend fun showList():
            List<MiwokData>
}

object MiwokApi {
    val retrofitService = retrofit.create(MiwokService::class.java)
}