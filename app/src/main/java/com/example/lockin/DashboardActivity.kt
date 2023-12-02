package com.example.lockin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var titleList: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val signout = findViewById(R.id.back) as ImageView
        signout.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val add = findViewById(R.id.add) as ImageView
        add.setOnClickListener(){
            //content
        }

        imageList = arrayOf(
            R.drawable.ic_launcher_background,
        )
        titleList = arrayOf(
            "Sample string",

        )
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf<DataClass>()
        getData()
    }

    private fun getData(){
        for (i in imageList.indices){
            var dataValue = DataClass(imageList[i], titleList[i])
            dataList.add(dataValue)
        }
        recyclerView.adapter = AdapterClass(dataList)
    }
}