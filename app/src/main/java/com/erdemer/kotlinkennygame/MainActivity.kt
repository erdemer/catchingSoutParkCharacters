package com.erdemer.kotlinkennygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById<ListView>(R.id.listView)

        var list = mutableListOf<Characters>()

        list.add(Characters("Kenny McCormick",R.drawable.kenny))
        list.add(Characters("Eric Cartman",R.drawable.eric_cartman))
        list.add(Characters("Stan Marsh",R.drawable.stan_marsh))
        list.add(Characters("Kyle Broflovski",R.drawable.kyle_broflovski))
        list.add(Characters("Wendy Testaburger",R.drawable.wendy_testaburger))
        list.add(Characters("Chef",R.drawable.chef))
        list.add(Characters("Mr Garrison",R.drawable.mrgarrison))

        listView.adapter = MyListAdapter(this,R.layout.row_design,list)

        listView.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->
           var intent = Intent(applicationContext,GameActivity::class.java)
            intent.putExtra("srcId",list[i].imageSrcId)
            startActivity(intent)
            finish()
        })

    }
}


