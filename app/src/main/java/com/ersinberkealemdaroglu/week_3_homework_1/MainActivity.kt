package com.ersinberkealemdaroglu.week_3_homework_1

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.ersinberkealemdaroglu.week_3_homework_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        var countValue: Int = 0
        const val key = "counter" // const key to save/read value from bundle
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        plusButtonCounter()
        minusButtonCounter()

        println("onCreate")
    }

    private fun plusButtonCounter() {
        binding.plusButton.setOnClickListener {
            countValue++
            binding.counterText.text = countValue.toString()
        }
    }

    private fun minusButtonCounter() {
        binding.minusButton.setOnClickListener {
            if (countValue >= 1) {
                countValue--
                binding.counterText.text = countValue.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(key, countValue)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getInt(key, countValue)
        binding.counterText.text = "$countValue"
    }

    override fun onStart() {
        super.onStart()

        println("onStart")
    }

    override fun onResume() {
        super.onResume()

        println("onResume")
    }

    override fun onPause() {
        super.onPause()

        println("onPause")
    }

    override fun onDestroy() {
        super.onDestroy()

        println("onDestroy")
    }


}