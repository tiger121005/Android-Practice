package app.ito.yomi.profile

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import app.ito.yomi.profile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }


        binding.showProfileButton.setOnClickListener {
            binding.profileImage.setImageResource(R.drawable.randy_image)
            binding.profileLabelText.text = "名前"
            binding.profileCommentText.text = "Androidメンターのランディーだよ"
            binding.showProfileButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(0, 180, 220))
            binding.showSportButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150,150))
            binding.showFoodButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150,150))
            binding.showHobbyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150,150))

        }
        binding.showSportButton.setOnClickListener {
            binding.profileImage.setImageResource(R.drawable.baseball_image)
            binding.profileLabelText.text = "スポーツ"
            binding.profileCommentText.text = "野球観戦が好きで、スタジアムに通っている"
            binding.showProfileButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.showSportButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(220, 0,100))
            binding.showFoodButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150,150))
            binding.showHobbyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150,150))
        }
        binding.showFoodButton.setOnClickListener {
            binding.profileImage.setImageResource(R.drawable.donut_image)
            binding.profileLabelText.text = "食べ物"
            binding.profileCommentText.text = "キャンディやドーナツが大好き"
            binding.showProfileButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.showSportButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150,150))
            binding.showFoodButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(0, 180,120))
            binding.showHobbyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150,150))
        }
        binding.showHobbyButton.setOnClickListener {
            binding.profileImage.setImageResource(R.drawable.gadget_image)
            binding.profileLabelText.text = "趣味"
            binding.profileCommentText.text = "ガジェットを集めて動かすこと"
            binding.showProfileButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.showSportButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150,150))
            binding.showFoodButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150,150))
            binding.showHobbyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(220, 100,0))
        }
    }
}