package app.ito.yomi.countchallenge

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ito.yomi.countchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var count = 0

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val sound: MediaPlayer = MediaPlayer.create(this, R.raw.tukkomi)
        prefs = getPreferences(Context.MODE_PRIVATE)

        count = prefs.getInt("COUNT", 0)
        Log.d("debug", count.toString())
        binding.textView.text = count.toString()

        binding.button.setOnClickListener {
            count++
            binding.textView.text = count.toString()

            val editor: SharedPreferences.Editor = prefs.edit()
            editor.putInt("COUNT", count)
            editor.apply()

            when (count%2) {
                0 -> binding.textView.setTextColor(Color.BLUE)
                else -> {
                    binding.textView.setTextColor(Color.RED)
                    sound.seekTo(0)
                    sound.start()
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onDestroy() {
        super.onDestroy()

    }

}