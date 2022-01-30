package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners(binding)
    }
}
    private fun setOnClickListeners (binding: ActivityMainBinding) {
        var counter = 0
        binding.decreasePassengerButton.setOnClickListener {
            when (counter) {
                0 -> defineView(binding,counter)
                in 1..50 -> {
                    counter--
                    defineView(binding,counter)
                }
            }
        }
        binding.increasePassengerButton.setOnClickListener {
            if (counter in 0..49) {
                counter++
                defineView(binding,counter)
            }
        }
        binding.resetButton.setOnClickListener {
            counter = 0
            defineView(binding,counter)
        }

    }
    private fun defineView(binding: ActivityMainBinding,counter:Int) {
        when (counter) {
            0 -> {
                binding.centralTextView.text = binding.centralTextView.context.getString(R.string.centralTextViewDefault)
                binding.centralTextView.setTextColor(binding.centralTextView.context.getColor(R.color.green))
                binding.counterTextView.text = counter.toString()
                binding.decreasePassengerButton.setBackgroundColor(binding.decreasePassengerButton.context.getColor(R.color.lightGrey))
                binding.increasePassengerButton.setBackgroundColor(binding.increasePassengerButton.context.getColor(R.color.green.absoluteValue))
                binding.resetButton.visibility = View.INVISIBLE
            }
            in 1..49 -> {
                binding.centralTextView.text = binding.centralTextView.context.getString(R.string.seats_left_string,(50 - counter).toString())
                binding.centralTextView.setTextColor(binding.centralTextView.context.getColor(R.color.purple_700))
                binding.counterTextView.text = counter.toString()
                binding.decreasePassengerButton.setBackgroundColor(binding.decreasePassengerButton.context.getColor(R.color.green))
                binding.increasePassengerButton.setBackgroundColor(binding.increasePassengerButton.context.getColor(R.color.green))
                binding.resetButton.visibility = View.INVISIBLE
            }
            50 -> {
                binding.centralTextView.text = binding.centralTextView.context.getText(R.string.centralTextViewExceeds)
                binding.centralTextView.setTextColor(binding.centralTextView.context.getColor(R.color.red))
                binding.counterTextView.text = counter.toString()
                binding.decreasePassengerButton.setBackgroundColor(binding.decreasePassengerButton.context.getColor(R.color.green))
                binding.increasePassengerButton.setBackgroundColor(binding.increasePassengerButton.context.getColor(R.color.lightGrey))
                binding.resetButton.visibility = View.VISIBLE
            }
        }
    }
