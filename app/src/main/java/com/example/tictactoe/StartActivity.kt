package com.example.tictactoe

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class StartActivity : AppCompatActivity() {
    lateinit var clMain: LinearLayout
    lateinit var ivHome:ImageView
    lateinit var ivStart:TextView
    lateinit var tvXOGame:TextView
    lateinit var llEditText:LinearLayout
    lateinit var llPlayer12:LinearLayout
    lateinit var etPlayer1:EditText
    lateinit var etPlayer2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        clMain = findViewById(R.id.clMain)
        ivHome=findViewById(R.id.ivHome)
        ivStart=findViewById(R.id.ivStart)
        tvXOGame=findViewById(R.id.tvXOGame)
        llEditText=findViewById(R.id.llEditText)
        llPlayer12=findViewById(R.id.llPlayer12)
        etPlayer1=findViewById(R.id.etPlayer1)
        etPlayer2=findViewById(R.id.etPlayer2)

        ivHome.setOnClickListener {
            val intent= Intent(this,StartActivity::class.java)
            startActivity(intent)
        }
        ivStart.setOnClickListener {
            if(ivStart.text=="Start"){
                tvXOGame.visibility= View.GONE
                llPlayer12.visibility=View.VISIBLE
               llEditText.visibility=View.VISIBLE
                ivStart.text="Play"
            }else if (ivStart.text=="Play"){
                val player1Name=etPlayer1.text.toString()
                val player2Name=etPlayer2.text.toString()
                if(player1Name.isNotEmpty()&&player2Name.isNotEmpty()){
                    val intent= Intent(this,MainActivity::class.java)
                    intent.putExtra("player1",player1Name)
                    intent.putExtra("player2",player2Name)
                    startActivity(intent)
                }

            }

        }

        var animationDrawable  = clMain.getBackground() as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()
    }
}