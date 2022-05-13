package com.example.daniwebandroidconcatadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //list of strings
        val textDataSet = alphabet
            .map { "$it" }

        val recycler = findViewById<RecyclerView>(R.id.recycler)
//        recycler.adapter = TextAdapter(textDataSet)
//        recycler.adapter = ImageAdapter()

        //Use ConcatAdapter constructor
/*        recycler.adapter = ConcatAdapter(
            TextAdapter(textDataSet),
            ImageAdapter()
        )*/

        //Dynamically add or more Adapters
        val concatAdapter = ConcatAdapter()
            .apply {
                addAdapter(TextAdapter(textDataSet))
                addAdapter(ImageAdapter())
                addAdapter(TextAdapter(textDataSet))
                addAdapter(ImageAdapter())
            }

        recycler.adapter = concatAdapter
    }

    companion object {
        private val alphabet = CharRange('A', 'Z')
    }
}