package edu.vavali.penncourserecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CourseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(CourseViewModel::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.section_list_rv)
        val adapter = SectionAdapter(viewModel.sections)
        recyclerView.adapter = adapter

        val itemDecoration: RecyclerView.ItemDecoration =
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)

        adapter.setOnItemClickListener(object : SectionAdapter.OnItemClickListener {
            override fun onItemClick(itemView: View?, position: Int) {
                val name = viewModel.sections[position].courseTitle
                Toast.makeText(this@MainActivity, "$name was clicked!", Toast.LENGTH_SHORT).show()
            }
        })

    }
}