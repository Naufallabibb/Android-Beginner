package com.dicoding.androidbeginner

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import android.view.Menu
import android.view.MenuItem
import com.dicoding.androidbeginner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvAyaka: RecyclerView
    private val list = ArrayList<Ayaka>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvAyaka = binding.rvAyaka
        rvAyaka.setHasFixedSize(true)

        list.addAll(getListAyaka())
        showRecyclerList()

    }

    @SuppressLint("Recycle")
    private fun getListAyaka(): ArrayList<Ayaka> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listAyaka = ArrayList<Ayaka>()
        for (i in dataName.indices) {
            val ayaka = Ayaka(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listAyaka.add(ayaka)
        }
        return listAyaka
    }

    private fun showRecyclerList() {
        rvAyaka.layoutManager = LinearLayoutManager(this)
        val listAyakaAdapter = ListAyakaAdapter(list)
        rvAyaka.adapter = listAyakaAdapter

        listAyakaAdapter.setOnItemClickCallback(object : ListAyakaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Ayaka) {
                showSelectedAyaka(data)
            }
        })
    }

    private fun showSelectedAyaka(ayaka: Ayaka) {
        Toast.makeText(this, "Kamu memilih " + ayaka.name, Toast.LENGTH_SHORT).show()
        // Memulai aktivitas DetailItem dan mengirimkan data Ayaka melalui intent
        val intent = Intent(this, DetailItem::class.java)
        intent.putExtra(DetailItem.SET, ayaka)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, About::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}


