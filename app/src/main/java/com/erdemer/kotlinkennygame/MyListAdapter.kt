package com.erdemer.kotlinkennygame

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyListAdapter (var mContext : Context, var resource : Int, var items : List<Characters>) :
    ArrayAdapter<Characters>(mContext,resource,items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mContext)

        val view : View = layoutInflater.inflate(resource,null)

        val imageView : ImageView = view.findViewById(R.id.icon_img)
        val textView : TextView = view.findViewById(R.id.textViewName)


        var myItems : Characters = items[position]

        imageView.setImageDrawable(mContext.resources.getDrawable(myItems.imageSrcId))
        textView.text = myItems.name


        return view
    }
}