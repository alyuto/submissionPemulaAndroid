package com.dicoding.hololiveen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.hololiveen.ContentMember.Companion.EXTRA_CONTENT
import com.dicoding.hololiveen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvHoloen: RecyclerView
    private val list = ArrayList<Holoen>()



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvHoloen = findViewById(R.id.rv_holoen)
        rvHoloen.setHasFixedSize(true)

        list.addAll(getListHoloen())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvHoloen.layoutManager = LinearLayoutManager(this)
        val listVtuberAdapter = ListVtuberAdapter(list)
        rvHoloen.adapter = listVtuberAdapter

        listVtuberAdapter.setOnItemClickCallback(object : ListVtuberAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Holoen) {
                showSelectedHero(data)
            }
        })
    }

    @SuppressLint("Recycle")
    private fun getListHoloen(): ArrayList<Holoen> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataUnit = resources.getStringArray(R.array.data_unit)
        val listHoloen = ArrayList<Holoen>()
        for (i in dataName.indices) {
            val holoen = Holoen(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataUnit[i])
            listHoloen.add(holoen)
        }
        return listHoloen
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveAbout = Intent(this@MainActivity, aboutMe::class.java)
                startActivity(moveAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedHero(holoen: Holoen) {
//        Toast.makeText(this, "Kamu memilih " + holoen.name, Toast.LENGTH_SHORT).show()

        val intentToDetail = Intent(this@MainActivity, ContentMember::class.java)
        intentToDetail.putExtra(EXTRA_CONTENT, ContentMember)
        startActivity(intentToDetail)
    }
}