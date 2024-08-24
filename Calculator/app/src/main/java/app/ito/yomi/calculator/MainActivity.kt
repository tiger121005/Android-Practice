package app.ito.yomi.calculator

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ito.yomi.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var firstNumber = 0
    var secondNumber = 0
    var totalNumber = 0
    var operator = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
        binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
        binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
        binding.equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))

        binding.plusButton.isEnabled = false
        binding.minusButton.isEnabled = false
        binding.multiplyButton.isEnabled = false
        binding.equalButton.isEnabled = false

        binding.numberText.text = firstNumber.toString()

        binding.numberButton0.setOnClickListener {
            inputText(0)
        }

        binding.numberButton1.setOnClickListener {
            inputText(1)
        }
        binding.numberButton2.setOnClickListener {
            inputText(2)
        }
        binding.numberButton3.setOnClickListener {
            inputText(3)
        }
        binding.numberButton4.setOnClickListener {
            inputText(4)
        }
        binding.numberButton5.setOnClickListener {
            inputText(5)
        }
        binding.numberButton6.setOnClickListener {
            inputText(6)
        }
        binding.numberButton7.setOnClickListener {
            inputText(7)
        }
        binding.numberButton8.setOnClickListener {
            inputText(8)
        }
        binding.numberButton9.setOnClickListener {
            inputText(9)
        }

        binding.plusButton.setOnClickListener {
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(220,0,100))
            binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

            operator = "plus"
            binding.numberText.text = secondNumber.toString()
        }
        binding.minusButton.setOnClickListener {
            binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(220,0,100))
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

            operator = "minus"
            binding.numberText.text = secondNumber.toString()
        }
        binding.multiplyButton.setOnClickListener {
            binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(220,0,100))
            binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

            operator = "multiply"
            binding.numberText.text = secondNumber.toString()
        }

        binding.equalButton.setOnClickListener {
            if (operator == "plus") {
                totalNumber = firstNumber + secondNumber
            } else if (operator == "minus") {
                totalNumber = firstNumber - secondNumber
            } else if (operator == "multiply") {
                totalNumber = firstNumber * secondNumber
            }

            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            binding.equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))

            firstNumber = 0
            secondNumber = 0

            operator = "empty"

            binding.numberText.text = totalNumber.toString()
        }

        binding.clearButton.setOnClickListener {
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            binding.equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))

            firstNumber = 0
            secondNumber = 0
            totalNumber = 0

            operator = "empty"

            binding.numberText.text = totalNumber.toString()
        }
    }

    private fun inputText(number: Int) {
        if (operator == "empty") {
            firstNumber = firstNumber * 10 + number
            binding.numberText.text = firstNumber.toString()

            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,240,0))
            binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,240,0))
            binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,240,0))

            binding.plusButton.isEnabled = true
            binding.minusButton.isEnabled = true
            binding.multiplyButton.isEnabled = true
            binding.equalButton.isEnabled = true
        } else {
            secondNumber = secondNumber * 10 + number
            binding.numberText.text = secondNumber.toString()

            binding.equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(240,240,0))
        }
    }
}