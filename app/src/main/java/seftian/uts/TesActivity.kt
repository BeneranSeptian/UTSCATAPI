package seftian.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import seftian.uts.databinding.ActivityTesBinding

class TesActivity : AppCompatActivity() {

    private var binding: ActivityTesBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTesBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val url = intent.getStringExtra("url")
        val desc = intent.getStringExtra("desc")
        val breed = intent.getStringExtra("breed")
        findViewById<TextView>(R.id.tv_breed_activity).text=breed
        findViewById<TextView>(R.id.tessatu).text=desc
        val img = findViewById<ImageView>(R.id.iv_activity_cat)


        Glide.with(this).load(url).into(img)

    }
}