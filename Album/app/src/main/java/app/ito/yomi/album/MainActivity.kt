package app.ito.yomi.album

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ito.yomi.album.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val preview = Intent(this, PreviewActivity::class.java)

        binding.albumImage1.setOnClickListener {
            preview.putExtra("image", R.drawable.sea_image)
            preview.putExtra("title", "海")

            startActivity(preview)
        }
        binding.albumImage2.setOnClickListener {
            preview.putExtra("image", R.drawable.cat_image)
            preview.putExtra("title", "猫")

            startActivity(preview)
        }
        binding.albumImage3.setOnClickListener {
            preview.putExtra("image", R.drawable.dog_image)
            preview.putExtra("title", "子犬")

            startActivity(preview)
        }
        binding.albumImage4.setOnClickListener {
            preview.putExtra("image", R.drawable.cake_image)
            preview.putExtra("title", "ケーキ")

            startActivity(preview)
        }
        binding.albumImage5.setOnClickListener {
            preview.putExtra("image", R.drawable.night_image)
            preview.putExtra("title", "夜景")

            startActivity(preview)
        }
        binding.albumImage6.setOnClickListener {
            preview.putExtra("image", R.drawable.flower_image)
            preview.putExtra("title", "花")

            startActivity(preview)
        }
    }
}