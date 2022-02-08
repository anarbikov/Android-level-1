package com.example.myapplication

import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
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
    binding.startButton.setOnClickListener {
        val scope = CoroutineScope(Job() + Dispatchers.Main)
        if (binding.progressBar.max > 0) {
            scope.launch {
                binding.seekBar2.isEnabled = false
                binding.progressBar.progress = binding.progressBar.max
                binding.startButton.text =
                    binding.startButton.context.getString(R.string.stop_button)
                binding.startButton.setBackgroundColor(binding.startButton.context.getColor(R.color.teal_200))
                while (binding.progressBar.progress > 0) {
                    binding.startButton.setOnClickListener {
                        toDefault(binding)
                    }
                    delay(1000)
                    binding.progressBar.progress--
                    binding.counterTextView.text = (binding.progressBar.progress).toString()

                }
                toDefault(binding)
//                Toast.makeText("Test toast", Toast.LENGTH_LONG).show()
            }
        }
    }
}

fun toDefault(binding: ActivityMainBinding) {
    binding.seekBar2.isEnabled = true
    binding.seekBar2.progress = 0
    binding.startButton.text = binding.startButton.context.getString(R.string.start_button)
    binding.startButton.setBackgroundColor(binding.startButton.context.getColor(R.color.purple_500))
    binding.progressBar.max = 0
    binding.progressBar.progress = 0
    startButton(binding)
}
