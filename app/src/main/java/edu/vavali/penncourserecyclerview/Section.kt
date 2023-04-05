package edu.vavali.penncourserecyclerview

import com.squareup.moshi.Json

data class Section(
    @Json(name = "section_id")
    val sectionId : String,
    @Json(name = "status")
    val status : String,
    @Json(name = "course_title")
    val courseTitle : String,
    @Json(name = "semester")
    val semester : String,
    @Json(name = "activity")
    val activity : String)