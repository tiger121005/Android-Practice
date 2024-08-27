package app.ito.yomi.countchallenge

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ito.yomi.countchallenge.databinding.ActivityMainBinding
import app.ito.yomi.countchallenge.databinding.ActivityTitleBinding

class TitleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTitleBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prefs = getPreferences(Context.MODE_PRIVATE)

        val first = prefs.getBoolean("FIRST", true)

        Log.d("debug", first.toString())

        if (first) {
            val editor: SharedPreferences.Editor = prefs.edit()
            editor.putBoolean("FIRST", false)
            editor.apply()

            Log.d("debug", prefs.getBoolean("FIRST", true).toString())

            val tutorialIntent: Intent = Intent(this, TutorialActivity::class.java)
            startActivity(tutorialIntent)
        }

        binding = ActivityTitleBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val mainIntent: Intent = Intent(this, MainActivity::class.java)

        binding.toMainButton.setOnClickListener {
            startActivity(mainIntent)
        }
    }
}