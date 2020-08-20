package com.erdemer.kotlinkennygame

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random
import kotlin.system.exitProcess

class GameActivity : AppCompatActivity() {
    var runnable : Runnable = Runnable {  }
    var handler : Handler = Handler()
    var score = 0
    lateinit var imageArray : ArrayList<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var imageId = intent.getIntExtra("srcId",0)

        imageView.setImageDrawable(this.resources.getDrawable(imageId))
        imageView2.setImageDrawable(this.resources.getDrawable(imageId))
        imageView3.setImageDrawable(this.resources.getDrawable(imageId))
        imageView4.setImageDrawable(this.resources.getDrawable(imageId))
        imageView5.setImageDrawable(this.resources.getDrawable(imageId))
        imageView6.setImageDrawable(this.resources.getDrawable(imageId))
        imageView7.setImageDrawable(this.resources.getDrawable(imageId))
        imageView8.setImageDrawable(this.resources.getDrawable(imageId))
        imageView9.setImageDrawable(this.resources.getDrawable(imageId))



        imageArray = arrayListOf<ImageView>()
        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)

        hideImages()




        object :CountDownTimer(15500,1000){
            override fun onTick(p0: Long) {
              textViewTime.text = "Time : ${p0/1000}"
            }

            override fun onFinish() {
                handler.removeCallbacks(runnable)
                for (image : ImageView in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val alertDialog = AlertDialog.Builder(this@GameActivity)
                alertDialog.setTitle("Game Over\nYour Score : ${score}")
                alertDialog.setMessage("Restart The Game?")
                alertDialog.setPositiveButton("Yes",  { dialogInterface, i ->
                    val intent  = intent
                    finish()
                    startActivity(intent)
                })
                alertDialog.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int ->
                    Toast.makeText(applicationContext,"Game Over !",Toast.LENGTH_SHORT).show()
                    exitProcess(-1)
                })
                alertDialog.show()
            }

        }.start()

    }

    fun hideImages(){

        runnable = object : Runnable {
            override fun run() {
                for (image : ImageView in imageArray){
                    image.visibility = View.INVISIBLE
                }
                var i = Random.nextInt(9)
                imageArray[i].visibility = View.VISIBLE
                handler.postDelayed(this,500)
            }

        }
        handler.post(runnable)

    }
    fun increaseScore(view: View){
        score++
        textViewScore.text = "Score : " + score
    }
}