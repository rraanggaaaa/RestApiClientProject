package com.example.restapiclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.*
import com.example.restapiclientproject.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<FilmResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readFilms()
        createFilm()
    }

    private fun createFilm() {
        RetrofitClient.instance.createFilm(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/npOnzAbLh6VOIu3naU5QaEcTepo.jpg",
            "Pemrograman Mobile",
            "2020",
            "ini adalah mata kuliah yang memusingkan"
        ).enqueue(object  :
            Callback<CreateFilmResponse>{
            override fun onFailure(call: Call<CreateFilmResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Failed to crate data", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<CreateFilmResponse>,
                response: Response<CreateFilmResponse>
            ) {
                Toast.makeText(this@MainActivity, "Data Successfully Created", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun readFilms(){
        rvFilms.setHasFixedSize(true)
        rvFilms.layoutManager =LinearLayoutManager(this)
        RetrofitClient.instance.getFilms().enqueue(object :
            Callback<ArrayList<FilmResponse>>{
            override fun onFailure(call: Call<ArrayList<FilmResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Failed to read data", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<ArrayList<FilmResponse>>,
                response: Response<ArrayList<FilmResponse>>
            ) {
                response.body()?.let {
                    list.addAll(it)
                }

                val adapter = FilmsAdapter(list)
                rvFilms.adapter =adapter
            }
        })
    }
}