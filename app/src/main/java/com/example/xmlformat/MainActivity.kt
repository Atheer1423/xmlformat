package com.example.xmlformat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var Rc: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Rc = findViewById(R.id.rv1)
        var Parser = parser()
        var istream = assets.open("practice.xml")

    b1.setOnClickListener{

        var Students = Parser.parse(istream)
        Rc.adapter = Adapter(this, Students)
        Rc.layoutManager = LinearLayoutManager(this)
    }

    }

}
