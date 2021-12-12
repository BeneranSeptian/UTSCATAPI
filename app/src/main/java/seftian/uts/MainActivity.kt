package seftian.uts

import android.content.Intent
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.HORIZONTAL
import android.widget.LinearLayout.VISIBLE
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import seftian.uts.databinding.ActivityMainBinding


class MainActivity :AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var catDetail: CatDetail
    private val list = ArrayList<CatDetail>()
    private val listImage = ArrayList<CatImage>()
    private var breeds:List<CatDetail> = ArrayList(list)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.rvKucing.setHasFixedSize(true)
        binding.rvKucing.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false )
        binding.rvKucingMid.setHasFixedSize(true)
        binding.rvKucingMid.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        showCat()


    }

    fun showCat (){
        CatClient.instance.getPost().enqueue(object : Callback<ArrayList<CatDetail>> {
            override fun onResponse(
                call: Call<ArrayList<CatDetail>>,
                response: Response<ArrayList<CatDetail>>
            ) {

                response.body()?.let { list.addAll(it) }
                val adapter = CatAdapter(list,:: catClicked)
                binding.rvKucing.adapter=adapter

            }
            override fun onFailure(call: Call<ArrayList<CatDetail>>, t: Throwable) {
            }

        })


  }

    private fun catClicked(catDetail:CatDetail){
        //Toast.makeText(this, catDetail.id, Toast.LENGTH_SHORT).show()
        val id = catDetail.id
        val breed = catDetail.name
        val country = catDetail.origin
        val temp = catDetail.temperament
        val profile = catDetail.description


        binding.tvBreed.visibility= VISIBLE
        binding.tvNegara.visibility= VISIBLE
        binding.tvSifat.visibility= VISIBLE
        //binding.tvProfil.visibility= VISIBLE
        binding.tvBreed.text=breed
        binding.tvNegara.text=country
        binding.tvSifat.text=temp
        binding.tvProfil.text=profile
        showImage(id)



    }

    private fun imgClicked(catImage: CatImage){


        val intent = Intent(this@MainActivity, TesActivity::class.java)
        val url =catImage.url
        val desc = findViewById<TextView>(R.id.tv_profil).text.toString()
        val breed = findViewById<TextView>(R.id.tv_breed).text.toString()
        intent.putExtra("breed",breed)
        intent.putExtra("url",url)
        intent.putExtra("desc",desc)

        startActivity(intent)


    }

    fun showImage (id: String){
        CatClient.instance.getImage(id).enqueue(object : Callback<ArrayList<CatImage>> {
            override fun onResponse(
                call: Call<ArrayList<CatImage>>,
                response: Response<ArrayList<CatImage>>
            ) {
                if(listImage==null){
                    response.body()?.let { listImage.addAll(it) }
                }
                else{
                    listImage.clear()
                    response.body()?.let { listImage.addAll(it) }
                }

                val adapter = DetailAdapter(listImage,:: imgClicked)
                binding.rvKucingMid.adapter=adapter

            }
            override fun onFailure(call: Call<ArrayList<CatImage>>, t: Throwable) {
            }

        })


    }





}



