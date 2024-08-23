package app.ito.yomi.album

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ito.yomi.album.databinding.ActivityPreviewBinding

class PreviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val imageId = intent.getIntExtra("image", 0)
        val displayTitle = intent.getStringExtra("title")

        binding.previewImage.setImageResource(imageId)
        binding.titleText.text = displayTitle

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}