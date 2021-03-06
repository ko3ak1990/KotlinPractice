package com.umanets.kotlinpractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var cnt: Int = 0


    var range = 0.rangeTo(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById(R.id.counter_text_view) as TextView
        val button = findViewById(R.id.button) as Button
        textView.text = savedInstanceState?.getInt("counter")?.toString()
                ?: resources.getString(R.string.app_name)
        button.setOnClickListener {
            if (++cnt in range) {
                textView.text = "Counter : $cnt"
            } else {
                textView.text = "Value out of range"
                cnt = 0
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putInt("counter", cnt)
        super.onSaveInstanceState(outState)
    }
}
