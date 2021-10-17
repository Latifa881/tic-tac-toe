package com.example.tictactoe


import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    lateinit var iv1: TextView
    lateinit var iv2: TextView
    lateinit var iv3: TextView
    lateinit var iv4: TextView
    lateinit var iv5: TextView
    lateinit var iv6: TextView
    lateinit var iv7: TextView
    lateinit var iv8: TextView
    lateinit var iv9: TextView
    lateinit var tvPlayer1: TextView
    lateinit var tvPlayer2: TextView
    lateinit var clMain: ConstraintLayout
    lateinit var ivHome:ImageView
    var player1Name:String?="Player 1"
    var player2Name:String?="Player 2"
    var isPlayer1 = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv1 = findViewById(R.id.iv1)
        iv2 = findViewById(R.id.iv2)
        iv3 = findViewById(R.id.iv3)
        iv4 = findViewById(R.id.iv4)
        iv5 = findViewById(R.id.iv5)
        iv6 = findViewById(R.id.iv6)
        iv7 = findViewById(R.id.iv7)
        iv8 = findViewById(R.id.iv8)
        iv9 = findViewById(R.id.iv9)
        tvPlayer1 = findViewById(R.id.tvPlayer1)
        tvPlayer2 = findViewById(R.id.tvPlayer2)
        clMain = findViewById(R.id.clMain)
        ivHome=findViewById(R.id.ivHome)
        val intent=getIntent()
        player1Name=intent.getStringExtra("player1")
        player2Name=intent.getStringExtra("player2")
        tvPlayer1.setText(player1Name)
        tvPlayer2.setText(player2Name)
        ivHome.setOnClickListener {
            val intent= Intent(this,StartActivity::class.java)
            startActivity(intent)
        }

       var animationDrawable  = clMain.getBackground() as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()


        resetGame()
        iv1.setOnClickListener {
            play(iv1)

        }
        iv2.setOnClickListener {
            play(iv2)

        }
        iv3.setOnClickListener {
            play(iv3)

        }
        iv4.setOnClickListener {
            play(iv4)

        }
        iv5.setOnClickListener {
            play(iv5)

        }
        iv6.setOnClickListener {
            play(iv6)

        }
        iv7.setOnClickListener {
            play(iv7)

        }
        iv8.setOnClickListener {
            play(iv8)
        }
        iv9.setOnClickListener {
            play(iv9)

        }
    }

    fun play(turn: TextView) {
        if (turn.text.isEmpty()) {
            if (isPlayer1) {
                tvPlayer2.setText(player2Name)
                tvPlayer1.setText("")
                isPlayer1 = false
                turn.setText("X")
                if (checkWin()) {
                    Toast.makeText(this@MainActivity, "Player1 wins!", Toast.LENGTH_SHORT).show()
                    resetGame()
                }
            } else {
                tvPlayer2.setText("")
                tvPlayer1.setText(player1Name)
                isPlayer1 = true
                turn.setText("O")
                if (checkWin()) {
                    Toast.makeText(this@MainActivity, "Player2 wins!", Toast.LENGTH_SHORT).show()
                    resetGame()
                }
            }

        }
    }

    fun checkWin(): Boolean {
        if (iv1.text == iv2.text && iv1.text == iv3.text && iv1.text.isNotEmpty())
            return true
        if (iv4.text == iv5.text && iv4.text == iv6.text && iv4.text.isNotEmpty())
            return true
        if (iv7.text == iv8.text && iv7.text == iv9.text && iv7.text.isNotEmpty())
            return true
        if (iv7.text == iv1.text && iv7.text == iv4.text && iv7.text.isNotEmpty())
            return true
        if (iv2.text == iv5.text && iv2.text == iv8.text && iv2.text.isNotEmpty())
            return true
        if (iv3.text == iv6.text && iv3.text == iv9.text && iv3.text.isNotEmpty())
            return true
        if (iv1.text == iv5.text && iv1.text == iv9.text && iv1.text.isNotEmpty())
            return true
        if (iv3.text == iv5.text && iv3.text == iv7.text && iv3.text.isNotEmpty())
            return true

        return false
    }

    fun resetGame() {
        iv1.setText("")
        iv2.setText("")
        iv3.setText("")
        iv4.setText("")
        iv5.setText("")
        iv6.setText("")
        iv7.setText("")
        iv8.setText("")
        iv9.setText("")
        isPlayer1 = true
        tvPlayer1.setText(player1Name)
        tvPlayer2.setText("")
    }
}