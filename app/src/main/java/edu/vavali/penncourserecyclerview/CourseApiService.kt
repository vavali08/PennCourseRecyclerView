package edu.vavali.penncourserecyclerview

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://penncoursereview.com/api/base/current/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CourseApiService {
    @GET("search/sections/?search=CIS")
    fun getCisCourses():
            Call<MutableList<Section>>
}

object CourseApi {
    val retrofitService : CourseApiService by lazy {
        retrofit.create(CourseApiService::class.java)
    }
}