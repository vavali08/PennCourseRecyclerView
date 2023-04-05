package edu.vavali.penncourserecyclerview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseViewModel: ViewModel() {
    private val _response = MutableLiveData<MutableList<Section>>()
    val response : LiveData<MutableList<Section>>
        get() = _response

    private fun getCourses() {
        CourseApi.retrofitService.getCisCourses().enqueue(object: Callback<MutableList<Section>> {
            override fun onResponse(call: Call<MutableList<Section>>, response:
            Response<MutableList<Section>>) {
                _response.value = response.body()
            }
            override fun onFailure(call: Call<MutableList<Section>>, t: Throwable) {
                Log.i("API", "ERROR: " + t.message)
            }

        })
    }

    init{
        getCourses()

    }
}