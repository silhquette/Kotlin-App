package com.example.first_app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.first_app.databinding.ActivityRecycleViewBinding

class RecycleViewActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var newArrayList: ArrayList<Spots>
    private lateinit var spotadapter: SpotAdapter
    lateinit var cardImage: Array<Int>
    lateinit var cardTitle: Array<String>
    lateinit var cardBody: Array<String>
    lateinit var cardDistance: Array<String>
    private lateinit var binding: ActivityRecycleViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecycleViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        binding.recyvlerView.layoutManager = LinearLayoutManager(this)
        binding.recyvlerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Spots>()
        getUserData()

        // clickable items
        spotadapter = SpotAdapter(newArrayList)
        binding.recyvlerView.adapter = spotadapter
        spotadapter.setOnItemClick(object : SpotAdapter.OnItemClick {
            override fun onItemClicked(data: Spots) {
                showSelectedSpot(data)
            }

        })

        // intent implementation
        binding.btnSearch.setOnClickListener(this)

    }

    private fun getUserData() {
        for (i in cardImage.indices) {
            val spots = Spots(cardImage[i], cardTitle[i], cardBody[i], cardDistance[i])
            newArrayList.add(spots)
        }


    }

    override fun onClick(v: View) {
        when (v.id) {

            // button search - pass data with intent
            R.id.btn_search -> {
                val intent = Intent(this@RecycleViewActivity, GetDataActivity::class.java)
                if (binding.etSearch.text.isNotEmpty()) {
                    intent.putExtra("extra_keyword", binding.etSearch.text.toString())
                    startActivity(intent)
                } else {
                    binding.etSearch.error = "field ini tidak boleh kososng"
                }
            }
        }
    }

    private fun showSelectedSpot(spots: Spots) {
        val intent = Intent(this, SpotDetailActivity::class.java)
        intent.putExtra("extra_spot", spots)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_spots, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_grid -> {
                binding.recyvlerView.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_list -> {
                binding.recyvlerView.layoutManager = LinearLayoutManager(this)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}