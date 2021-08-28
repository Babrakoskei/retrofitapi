package com.example.retrofitapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileassessment.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
fun fetchPhotos(){
    var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)
    var request=retrofit.getPhotos()
    request.enqueue(object : Callback<List<Images>> {
        override fun onResponse(call: Call<List<Images>>, response: Response<List<Images>>) {
            if (response.isSuccessful){
                var imageList = response.body()
                if (imageList!=null){
                    binding.recycler= PhotosAdapter(imageList)
                }
            }
        }

        override fun onFailure(call: Call<List<Images>>, t: Throwable) {

        }
    })

}
}