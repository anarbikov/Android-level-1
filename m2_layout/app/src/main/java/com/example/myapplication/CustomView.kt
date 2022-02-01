package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.myapplication.databinding.CustomLayoutBinding

class CustomView
    @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
    ) : LinearLayout(context,attrs,defStyleAttr) {
        private val binding = CustomLayoutBinding.inflate(LayoutInflater.from(context))
    init {
        addView(binding.root)
    }

    fun changeTextTextView1(text:String) {
        binding.textView1.text=text
    }
    fun changeTextTextView2(text:String) {
        binding.textView2.text=text
    }
}




