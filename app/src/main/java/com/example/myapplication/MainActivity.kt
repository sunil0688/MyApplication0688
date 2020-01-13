package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     //   val list = mutableListOf("Hello", "Hello how are you?", "I am fine","How are you","Hello", "Hello how are you?", "I am fine","How are you")

        val list = mutableListOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)

        inflateLayout(list)
        

        btnAddImage.setOnClickListener {
            list.add(R.drawable.amul)
            dummyContainer.removeAllViews()
            inflateLayout(list)
        }



    }

    private fun inflateLayout(list: MutableList<Int>) {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        list.forEachIndexed{index, listItem ->

            val row = inflater.run { inflate(R.layout.dummy_container_child, dummyContainer,false) } as View
            val data = row.findViewById<View>(R.id.textViewChild) as ImageView
            // data.text = listItem
            data.setBackgroundResource(listItem)

            dummyContainer.addView(row)

        }
    }
}
