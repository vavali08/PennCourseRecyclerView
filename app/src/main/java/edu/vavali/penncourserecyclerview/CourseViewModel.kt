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
            override fun onResponse(call: Call<MutableList<Section>>, response: Response<MutableList<Section>>) {
                _response.value = response.body()
            }
            override fun onFailure(call: Call<MutableList<Section>>, t: Throwable) {
                Log.i("API", "ERROR: " + t.message)
            }

        })
    }

    init{
        getCourses()
        /*
        sections.add(Section("CIS-1100-001", "O", "Intro to Comp Prog", "Spring 2023", "LEC"))
        sections.add(Section("CIS-1100-201", "C", "Intro to Comp Prog", "Spring 2023", "REC"))
        sections.add(Section("CIS-2400-001", "C", "Intro to Comp Systems", "Fall 2022", "LEC"))
        sections.add(Section("CIS-3200-001", "X", "Intro to Algorithms", "Spring 2021", "LEC"))
        sections.add(Section("CIS-4600-001", "C", "Intractive Comp Graphics", "Spring 2023", "LEC"))
        sections.add(Section("CIS-5500-001", "O", "Database & Info Systems", "Spring 2023", "LEC"))
        sections.add(Section("CIS-6600-001", "C", "Adv Tpcs in Comp Graphics", "Spring 2023", "SEM"))
        sections.add(Section("CIS-7980-401", "O", "Explaining Explanation", "Spring 2023", "LEC"))
        sections.add(Section("CIS-8990-076", "C", "PhD Independent Study", "Spring 2023", "IND"))
        sections.add(Section("CIS-9950-001", "O", "Dissertation", "Spring 2023", "DIS"))

         */
    }
}