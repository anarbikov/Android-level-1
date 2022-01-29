package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var counter = 0

        fun defineView() {
            when (counter) {
                0 -> {
                    binding.centralTextView.text = resources.getString(
                        R.string.centralTextViewDefault
                    )
                    binding.centralTextView.setTextColor(
                        ResourcesCompat.getColor(resources, R.color.green, null)
                    )
                    binding.counterTextView.text = counter.toString()
                    binding.decreasePassengerButton.setBackgroundColor(
                        ResourcesCompat.getColor(resources, R.color.lightGrey, null)
                    )
                    binding.increasePassengerButton.setBackgroundColor(
                        ResourcesCompat.getColor(resources, R.color.green, null)
                    )
                    binding.resetButton.visibility = View.INVISIBLE
                }
                in 1..49 -> {
                    binding.centralTextView.text = "Seats left: ${50-counter}"
                    binding.centralTextView.setTextColor(
                        ResourcesCompat.getColor(
                            resources, R.color.purple_700, null
                        )
                    )
                    binding.counterTextView.text = counter.toString()
                    binding.decreasePassengerButton.setBackgroundColor(
                        ResourcesCompat.getColor(resources, R.color.green, null)
                    )
                    binding.increasePassengerButton.setBackgroundColor(
                        ResourcesCompat.getColor(resources, R.color.green, null)
                    )
                    binding.resetButton.visibility = View.INVISIBLE
                }
                50 -> {
                    binding.centralTextView.text =
                        resources.getString(R.string.centralTextViewExceeds)
                    binding.centralTextView.setTextColor(
                        ResourcesCompat.getColor(resources, R.color.red, null)
                    )
                    binding.counterTextView.text = counter.toString()
                    binding.decreasePassengerButton.setBackgroundColor(
                        ResourcesCompat.getColor(resources, R.color.green, null)
                    )
                    binding.increasePassengerButton.setBackgroundColor(
                        ResourcesCompat.getColor(resources, R.color.lightGrey, null)
                    )
                    binding.resetButton.visibility = View.VISIBLE
                }
            }
        }
        binding.decreasePassengerButton.setOnClickListener {
            when (counter) {
                0 -> defineView()
                in 1..50 -> {
                    counter--
                    defineView()
                }
            }
        }
        binding.increasePassengerButton.setOnClickListener {
            if (counter in 0..49) {
                counter++
                defineView()
            }
        }
        binding.resetButton.setOnClickListener {
            counter = 0
            defineView()
        }
    }
}
