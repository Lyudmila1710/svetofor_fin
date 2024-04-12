package com.example.svetofor_fin_Kosterina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private var currentLight = 0
    private lateinit var lights: Array<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lights = arrayOf(findViewById(R.id.red_light), findViewById(R.id.yellow_light), findViewById(R.id.green_light))

        val changeButton = findViewById<Button>(R.id.change_button)
        changeButton.setOnClickListener {
            changeLight()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("currentLight", currentLight)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        currentLight = savedInstanceState.getInt("currentLight")
        setLightColor(currentLight)
    }

    private fun changeLight() {
        when (currentLight) {
            0 -> {
                lights[currentLight].setBackgroundResource(R.drawable.grey_light)
                currentLight = 1
                lights[currentLight].setBackgroundResource(R.drawable.yellow_light)
            }

            1 -> {
                lights[currentLight].setBackgroundResource(R.drawable.grey_light)
                currentLight = 2
                lights[currentLight].setBackgroundResource(R.drawable.green_light)
            }
            2 -> {
                lights[currentLight].setBackgroundResource(R.drawable.grey_light)
                currentLight = 3
                lights[currentLight-2].setBackgroundResource(R.drawable.yellow_light)
            }
            3 -> {
                lights[currentLight-2].setBackgroundResource(R.drawable.grey_light)
                currentLight = 0
                lights[currentLight].setBackgroundResource(R.drawable.red_light)
            }

        }}
    private fun setLightColor(light: Int) {
        for (i in 0 until lights.size) {
            lights[i].setBackgroundResource(if (i == light) getLightDrawable(i) else R.drawable.grey_light)
        }
    }

    private fun getLightDrawable(light: Int): Int {
        return when (light) {
            0 -> R.drawable.red_light
            1 -> R.drawable.yellow_light
            2 -> R.drawable.green_light
            else -> R.drawable.grey_light
        }
    }
}