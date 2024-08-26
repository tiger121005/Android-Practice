package app.ito.yomi.countchallenge

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ito.yomi.countchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var count = 0

    var prefs: SharedPreferences = getPreferences(Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val sound: MediaPlayer = MediaPlayer.create(this, R.raw.tukkomi)

        binding.textView.text = count.toString()

        binding.button.setOnClickListener {
            count++
            binding.textView.text = count.toString()

            when (count%2) {
                0 -> binding.textView.setTextColor(resources.getColor(R.color.blue))
                else -> {
                    binding.textView.setTextColor(resources.getColor(R.color.red))
                    sound.seekTo(0)
                    sound.start()
                }
            }
        }
    }



}