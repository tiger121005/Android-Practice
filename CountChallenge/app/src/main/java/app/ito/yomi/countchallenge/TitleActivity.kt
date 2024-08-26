package app.ito.yomi.countchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ito.yomi.countchallenge.databinding.ActivityMainBinding
import app.ito.yomi.countchallenge.databinding.ActivityTitleBinding

class TitleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTitleBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val mainIntent: Intent = Intent(this, MainActivity::class.java)

        binding.toMainButton.setOnClickListener {
            startActivity(mainIntent)
        }
    }
}