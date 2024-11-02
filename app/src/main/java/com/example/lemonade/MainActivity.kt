package com.example.lemonade

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var instructionsText: TextView
    private lateinit var lemonadeImage: ImageView

    private var lemonSqueezeCount = 0
    private var currentStep = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instructionsText = findViewById(R.id.text_instructions)
        lemonadeImage = findViewById(R.id.image_lemonade)

        lemonadeImage.setOnClickListener {
            handleImageClick()
        }
    }

    private fun handleImageClick() {
        when (currentStep) {
            0 -> {
                instructionsText.text = getString(R.string.tap_lemon)
                lemonadeImage.setImageResource(R.drawable.lemon_squeeze)
                lemonadeImage.contentDescription = getString(R.string.lemon)
                lemonSqueezeCount = Random.nextInt(2, 5)
                currentStep = 1
            }
            1 -> {
                if (lemonSqueezeCount > 0) {
                    lemonSqueezeCount--
                } else {
                    instructionsText.text = getString(R.string.tap_lemonade)
                    lemonadeImage.setImageResource(R.drawable.lemon_drink)
                    lemonadeImage.contentDescription = getString(R.string.lemonade)
                    currentStep = 2
                }
            }
            2 -> {
                instructionsText.text = getString(R.string.tap_empty_glass)
                lemonadeImage.setImageResource(R.drawable.lemon_restart)
                lemonadeImage.contentDescription = getString(R.string.empty_glass)
                currentStep = 3
            }
            3 -> {
                instructionsText.text = getString(R.string.tap_lemon_tree)
                lemonadeImage.setImageResource(R.drawable.lemon_tree)
                lemonadeImage.contentDescription = getString(R.string.lemon_tree)
                currentStep = 0
            }
        }
    }
}
