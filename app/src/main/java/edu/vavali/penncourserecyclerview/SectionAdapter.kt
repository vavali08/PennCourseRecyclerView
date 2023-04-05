package edu.vavali.penncourserecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class SectionAdapter (private val sections: MutableList<Section>):
    RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    inner class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sectionCodeText: TextView = itemView.findViewById(R.id.section_code)
        val titleText: TextView = itemView.findViewById(R.id.title)
        val activityText: TextView = itemView.findViewById(R.id.activity_type)
        val semesterText: TextView = itemView.findViewById(R.id.Semester)
        val statusText: TextView = itemView.findViewById(R.id.status)
        val courseLevelImage: ImageView = itemView.findViewById(R.id.course_level_image)
        /*
        init {

            // Setup the click listener
            itemView.setOnClickListener {
                // Triggers click upwards to the adapter on click
                val position = absoluteAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(itemView, position)
                }
            }
        }

         */
    }

    // When the view holder gets created, inflate it with a layout from an XML file using our
    // friendly neighborhood LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            SectionAdapter.SectionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.section_list_item, parent, false)
        return SectionViewHolder(view)
    }

    // Inform the adapter of the number of items to pass to RV
    override fun getItemCount(): Int {
        return sections.size
    }

    // Tell the adapter what to do when binding the viewholder to the item at a certain position
    // in the list
    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val section = sections[position]

        val sectionCode = holder.sectionCodeText
        val sectionTitle = holder.titleText
        val sectionActivity = holder.activityText
        val sectionSemester = holder.semesterText
        val sectionStatus = holder.statusText
        val sectionImage = holder.courseLevelImage

        sectionCode.text = section.sectionId
        sectionTitle.text = section.courseTitle
        sectionActivity.text = when(section.activity) {
            "CLN" -> "Clinic"
            "DIS" -> "Dissertation"
            "IND" -> "Independent Study"
            "LAB" -> "Lab"
            "LEC" -> "Lecture"
            "MST" -> "Masters Thesis"
            "REC" -> "Recitation"
            "SEM" -> "Seminar"
            "SRT" -> "Senior Thesis"
            "STU" -> "Studio"
            "***" -> "Undefined"
            else -> "Undefined Activity"
        }

        try {
            val year = section.semester.substring(0, 4)
            sectionSemester.text = when(section.semester[4]) {
                'A' -> "Spring $year"
                'B' -> "Summer $year"
                'C' -> "Fall $year"
                else -> "Undefined Semester"
            }
        } catch (e: StringIndexOutOfBoundsException) {
            sectionSemester.text = "Undefined Semester"
        }



        //sectionSemester.text = section.semester

        sectionStatus.text = when(section.status) {
            "O" -> "Open"
            "C" -> "Closed"
            "X" -> "Cancelled"
            else -> "Unknown Status"
        }

        try {
            val dashPos = section.sectionId.indexOf("-")
            when(section.sectionId[dashPos + 1]) {
                '1' -> sectionImage.setImageResource(R.drawable.emotion1)
                '2' -> sectionImage.setImageResource(R.drawable.emotion2)
                '3' -> sectionImage.setImageResource(R.drawable.emotion3)
                '4' -> sectionImage.setImageResource(R.drawable.emotion4)
                '5' -> sectionImage.setImageResource(R.drawable.emotion5)
                '6' -> sectionImage.setImageResource(R.drawable.emotion6)
                '7' -> sectionImage.setImageResource(R.drawable.emotion7)
                '8' -> sectionImage.setImageResource(R.drawable.emotion8)
                '9' -> sectionImage.setImageResource(R.drawable.emotion9)
            }

        } catch (e: StringIndexOutOfBoundsException) {
            //do nothing - image is not changed
        }




    }



    // Define the listener interface
    interface OnItemClickListener {
        fun onItemClick(itemView: View?, position: Int)
    }

    // Define listener member variable
    private lateinit var listener: OnItemClickListener

    // Define the method that allows the parent activity or fragment to define the listener
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

}