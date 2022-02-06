package com.example.myapplication

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dayNightMode(binding)
        seekBar(binding)
        startButton(binding)

    }
}

fun dayNightMode(binding: ActivityMainBinding) {
    binding.nightModeSwitch.setOnCheckedChangeListener { _, _ ->
        if (binding.nightModeSwitch.isChecked) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        } else AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
    }
}

fun seekBar(binding: ActivityMainBinding) {
    binding.seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            binding.counterTextView.text = p1.toString()
            binding.progressBar.max = p1
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {}
        override fun onStopTrackingTouch(p0: SeekBar?) {}
    })
}

fun startButton(binding: ActivityMainBinding) {
    val scope = CoroutineScope(Job() + Dispatchers.Main)
    binding.startButton.setOnClickListener {
        val secLeft = binding.progressBar.max
        if (secLeft > 0) {
            scope.launch {
                binding.seekBar2.isEnabled = false
                binding.progressBar.progress = secLeft
                for (i in 0 until binding.progressBar.max) {
                    delay(1000)
                    binding.progressBar.progress--
                    binding.counterTextView.text = "test"
                }
                binding.seekBar2.isEnabled = true
            }
        }
    }
}
