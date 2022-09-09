package com.ersinberkealemdaroglu.week_3_homework_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.ersinberkealemdaroglu.week_3_homework_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var saveTextValue : String

    companion object {
        const val key = "name" // const key to save/read value from bundle
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameSaveText()
        println("oncreate")
    }
    private fun nameSaveText(){
        binding.button.setOnClickListener {
            saveTextValue = binding.editTextTextPersonName.text.toString()
                binding.textView.text = saveTextValue
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(key, binding.editTextTextPersonName.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val name = savedInstanceState.getString(key, binding.editTextTextPersonName.text.toString())
        binding.textView.text = name
    }

    override fun onStart() {
        super.onStart()

        println("start")
    }

    override fun onResume() {
        super.onResume()

        println("onresume")
    }

    override fun onPause() {
        super.onPause()

        println("pause")
    }

    override fun onDestroy() {
        super.onDestroy()

        println("destroy")
    }











}