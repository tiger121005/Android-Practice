package app.ito.yomi.sound

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ito.yomi.sound.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //setOnTouchListenetに警告が出るので一応追加
    @SuppressLint("ClickableViewAccessibility")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val drumSound: MediaPlayer = MediaPlayer.create(this, R.raw.drum_sound)
        val guitarSound: MediaPlayer = MediaPlayer.create(this, R.raw.guitar_sound)
        val pianoSound: MediaPlayer = MediaPlayer.create(this, R.raw.piano_sound)

        binding.drumImage.setOnTouchListener { v, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                binding.drumImage.setImageResource(R.drawable.drum_playing_image)
                drumSound.seekTo(0)
                drumSound.start()

            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                binding.drumImage.setImageResource(R.drawable.drum_image)
            }
            true
        }
        binding.guitarImage.setOnTouchListener { v, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                binding.guitarImage.setImageResource(R.drawable.guitar_playing_image)
                guitarSound.seekTo(0)
                guitarSound.start()

            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                binding.guitarImage.setImageResource(R.drawable.guitar_image)
            }
            true
        }
        binding.pianoImage.setOnTouchListener { v, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                binding.pianoImage.setImageResource(R.drawable.piano_playing_image)
                pianoSound.seekTo(0)
                pianoSound.start()

            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                binding.pianoImage.setImageResource(R.drawable.piano_image)
            }
            true
        }
    }
}