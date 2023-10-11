package com.example.first_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecycleViewActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Spots>
    lateinit var cardImage: Array<Int>
    lateinit var cardTitle: Array<String>
    lateinit var cardBody: Array<String>
    lateinit var cardDistance: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        cardImage = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
        )

        cardTitle = arrayOf(
            "Judul Wisata 1",
            "Judul Wisata 2",
            "Judul Wisata 3",
            "Judul Wisata 4",
            "Judul Wisata 1",
            "Judul Wisata 2",
            "Judul Wisata 3",
            "Judul Wisata 4",
        )

        cardBody = arrayOf(
            "Donec commodo scelerisque consectetur. Donec vitae purus.",
            "Donec commodo scelerisque consectetur. Donec vitae purus.",
            "Donec commodo scelerisque consectetur. Donec vitae purus.",
            "Donec commodo scelerisque consectetur. Donec vitae purus.",
            "Donec commodo scelerisque consectetur. Donec vitae purus.",
            "Donec commodo scelerisque consectetur. Donec vitae purus.",
            "Donec commodo scelerisque consectetur. Donec vitae purus.",
            "Donec commodo scelerisque consectetur. Donec vitae purus.",
        )

        cardDistance = arrayOf(
            "Distance - 400KM",
            "Distance - 400KM",
            "Distance - 400KM",
            "Distance - 400KM",
            "Distance - 400KM",
            "Distance - 400KM",
            "Distance - 400KM",
            "Distance - 400KM",
        )

        newRecyclerView = findViewById(R.id.recyvlerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Spots>()
        getUserData()
    }

    private fun getUserData() {
        for (i in cardImage.indices) {
            val spots = Spots(cardImage[i], cardTitle[i], cardBody[i], cardDistance[i])
            newArrayList.add(spots)
        }
        newRecyclerView.adapter = SpotAdapter(newArrayList)

    }
}