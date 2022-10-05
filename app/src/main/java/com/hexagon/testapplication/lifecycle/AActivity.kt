package com.hexagon.testapplication.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hexagon.testapplication.R

class AActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aactivity)
    }
}