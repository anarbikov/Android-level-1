package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.customView.changeTextTextView1("Верхняя строчка, настроенная из кода")
        binding.customView.changeTextTextView2("Нижняя строчка, настроенная из кода")
    }
}