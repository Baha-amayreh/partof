package com.example.finalproject

import android.content.pm.ActivityInfo
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var x:Int=1
    var y:Int=1
    var index:Int=1
    var z:String=""
    var result1:Int=1
    var btnShowResult:Int=1
    var list= arrayListOf<String>("/","*","+","-")
    var correct:Int=0
    var wrong:Int=0
    lateinit var timer2:CountDownTimer
    var sLevel:Int=1
    var eLevel:Int=1
    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LOCKED
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateQuestion()
        setButtonColor()
        getSomeTime(10000)
        btn1.setOnClickListener(){
            var a=Integer.parseInt(btn1.text.toString())
            timer2.cancel()
            if(a==result1){
                correct++
                txtCorrect.text=""+correct
                btn1.setBackgroundColor(Color.GREEN)
                Handler(Looper.getMainLooper()).postDelayed({
                    btn1.setBackgroundColor(Color.BLUE)
                    generateQuestion()
                    getSomeTime(10000)
                }, 1000)
            }else{
                wrong++
                txtWrong.text=""+wrong
                btn1.setBackgroundColor(Color.RED)
                showCorrectButton(btnShowResult)
                Handler(Looper.getMainLooper()).postDelayed({
                    setButtonColor()
                    generateQuestion()
                    getSomeTime(10000)
                }, 1000)
            }
        }
        btn2.setOnClickListener(){
            var a=Integer.parseInt(btn2.text.toString())
            timer2.cancel()
            if(a==result1){
                correct++
                txtCorrect.text=""+correct
                btn2.setBackgroundColor(Color.GREEN)
                Handler(Looper.getMainLooper()).postDelayed({
                    btn2.setBackgroundColor(Color.BLUE)
                    generateQuestion()
                    getSomeTime(10000)
                }, 1000)
            }else{
                wrong++
                txtWrong.text=""+wrong
                btn2.setBackgroundColor(Color.RED)
                showCorrectButton(btnShowResult)
                Handler(Looper.getMainLooper()).postDelayed({
                    setButtonColor()
                    generateQuestion()
                    getSomeTime(10000)
                }, 1000)
            }
        }
        btn3.setOnClickListener(){
            var a=Integer.parseInt(btn3.text.toString())
            timer2.cancel()
            if(a==result1){
                correct++
                txtCorrect.text=""+correct
                btn3.setBackgroundColor(Color.GREEN)
                Handler(Looper.getMainLooper()).postDelayed({
                    btn3.setBackgroundColor(Color.BLUE)
                    generateQuestion()
                    getSomeTime(10000)
                }, 1000)
            }else{
                wrong++
                txtWrong.text=""+wrong
                btn2.setBackgroundColor(Color.RED)
                showCorrectButton(btnShowResult)
                Handler(Looper.getMainLooper()).postDelayed({
                    setButtonColor()
                    generateQuestion()
                    getSomeTime(10000)
                }, 1000)
            }
        }
        btn4.setOnClickListener(){
            var a=Integer.parseInt(btn4.text.toString())
            timer2.cancel()
            if(a==result1){
                correct++
                txtCorrect.text=""+correct
                btn4.setBackgroundColor(Color.GREEN)
                Handler(Looper.getMainLooper()).postDelayed({
                    btn4.setBackgroundColor(Color.BLUE)
                    generateQuestion()
                    getSomeTime(10000)
                }, 1000)
            }else{
                wrong++
                txtWrong.text=""+wrong
                btn4.setBackgroundColor(Color.RED)
                showCorrectButton(btnShowResult)
                Handler(Looper.getMainLooper()).postDelayed({
                    setButtonColor()
                    generateQuestion()
                    getSomeTime(10000)
                }, 1000)
            }
        }
    }
    private fun generateQuestion():Unit{
        index= Random.nextInt(list.size)
        z= list[index].toString()
        x= Random.nextInt(1,10)
        y= Random.nextInt(1,10)
        if(z=="/"){
            while(x%y!=0){
                y= Random.nextInt(1,10)
            }
        }
        txt1.text="$x$z$y="
         result1= when(z){
            "*"->x*y
            "/"->x/y
            "+"->x+y
            "-"->x-y
           else-> 0
        }
        var a1=result1-1
        var a2=Random.nextInt((result1+1),(result1+3))
        var a3=a2+1
        var a4=a2+2
        btn1.text = "$a1"
        btn2.text = "$a2"
        btn3.text = "$a3"
        btn4.text = "$a4"
        btnShowResult=Random.nextInt(1,4)
        when(btnShowResult){
            1->btn1.text="$result1"
            2->btn2.text="$result1"
            3->btn3.text="$result1"
            else->{
                btn4.text="$result1"
            }
        }
    }//end of function

    private fun getSomeTime(x:Long){
        timer2= object : CountDownTimer(x, 1000) {
            override fun onTick(millis: Long) {
                timer1.text =  ""+(millis/1000)
            }
            override fun onFinish() {
                timer1.text = "Time finish!"
                wrong++
                txtWrong.text=""+wrong
                btn4.setBackgroundColor(Color.RED)
                showCorrectButton(btnShowResult)
                Handler(Looper.getMainLooper()).postDelayed({
                    setButtonColor()
                    generateQuestion()
                    getSomeTime(10000)
                }, 1000)
            }
        }
        timer2.start()
    }//end of time function
    private fun setButtonColor(){
        btn1.setBackgroundColor(Color.BLUE)
        btn2.setBackgroundColor(Color.BLUE)
        btn3.setBackgroundColor(Color.BLUE)
        btn4.setBackgroundColor(Color.BLUE)
    }
    private fun showCorrectButton(x:Int){
        when(x){
            1->  btn1.setBackgroundColor(Color.GREEN)
            2->  btn2.setBackgroundColor(Color.GREEN)
            3->  btn3.setBackgroundColor(Color.GREEN)
            4->  btn4.setBackgroundColor(Color.GREEN)
        }
    }
}//end of class