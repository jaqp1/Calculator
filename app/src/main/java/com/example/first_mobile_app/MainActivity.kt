package com.example.first_mobile_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        b0ref = findViewById(R.id.button0)
        b1ref = findViewById(R.id.button1)
        b2ref = findViewById(R.id.button2)
        b3ref = findViewById(R.id.button3)
        b4ref = findViewById(R.id.button4)
        b5ref = findViewById(R.id.button5)
        b6ref = findViewById(R.id.button6)
        b7ref = findViewById(R.id.button7)
        b8ref = findViewById(R.id.button8)
        b9ref = findViewById(R.id.button9)
        bplusminref = findViewById(R.id.buttonPlusMinus)
        browref = findViewById(R.id.buttonRow)
        bcref = findViewById(R.id.buttonC)
        bminusref = findViewById(R.id.buttonMin)
        brazyref = findViewById(R.id.buttonRazy)
        bukosref = findViewById(R.id.buttonUkos)
        bplusref = findViewById(R.id.buttonPlus)
        bnawiasref = findViewById(R.id.buttonNawias)
        bprzecref = findViewById(R.id.buttonPrzec)
        bbackref = findViewById(R.id.buttonBack)

        numberFIeld = findViewById(R.id.numberField)

        b0ref.setOnClickListener{
            dodajWartosc(b0ref)
        }
        b1ref.setOnClickListener{
            dodajWartosc(b1ref)
        }
        b2ref.setOnClickListener{
            dodajWartosc(b2ref)
        }
        b3ref.setOnClickListener{
            dodajWartosc(b3ref)
        }
        b3ref.setOnClickListener{
            dodajWartosc(b3ref)
        }
        b4ref.setOnClickListener{
            dodajWartosc(b4ref)
        }
        b5ref.setOnClickListener{
            dodajWartosc(b5ref)
        }
        b6ref.setOnClickListener{
            dodajWartosc(b6ref)
        }
        b7ref.setOnClickListener{
            dodajWartosc(b7ref)
        }
        b8ref.setOnClickListener{
            dodajWartosc(b8ref)
        }
        b9ref.setOnClickListener{
            dodajWartosc(b9ref)
        }
        bplusminref.setOnClickListener{
            plusmin();
        }
        bcref.setOnClickListener{
            clear();
        }

        browref.setOnClickListener{
            eval();
        }

        bminusref.setOnClickListener{
            dodajWartosc(bminusref)
        }
        bplusref.setOnClickListener{
            dodajWartosc(bplusref)
        }
        brazyref.setOnClickListener{
            dodajWartosc(brazyref)
        }
        bukosref.setOnClickListener{
            dodajWartosc(bukosref)
        }
        bnawiasref.setOnClickListener{
            dodajNawias();
        }
        bbackref.setOnClickListener{
            backSpace()
        }



    }

    private lateinit var b0ref: Button;
    private lateinit var b1ref: Button;
    private lateinit var b2ref: Button;
    private lateinit var b3ref: Button;
    private lateinit var b4ref: Button;
    private lateinit var b5ref: Button;
    private lateinit var b6ref: Button;
    private lateinit var b7ref: Button;
    private lateinit var b8ref: Button;
    private lateinit var b9ref: Button;
    private lateinit var bplusminref: Button;
    private lateinit var browref: Button;
    private lateinit var bcref: Button;
    private lateinit var bplusref: Button;
    private lateinit var bminusref: Button;
    private lateinit var brazyref: Button;
    private lateinit var bukosref: Button;
    private lateinit var bnawiasref: Button;
    private lateinit var bprzecref: Button;
    private lateinit var bbackref: Button;

    private lateinit var numberFIeld: TextView;

    private fun dodajWartosc(bt: Button){
        numberFIeld.append(bt.text)
    }
    private fun clear(){
        numberFIeld.setText("");
    }
    private fun eval(){
        try {
            val expression = numberFIeld.text.toString();
            val result = ExpressionBuilder(expression).build().evaluate()
            numberFIeld.setText(result.toString())
        }catch(e: Exception){
            Toast.makeText(this@MainActivity,"Wprowadzono niepoprawne dane",Toast. LENGTH_LONG).show();

        }
    }
    private fun plusmin(){
        var zawartosc: String = numberFIeld.text.toString();
        clear();
        numberFIeld.append("-($zawartosc)");
    }
    private fun dodajNawias(){
        val zawartosc: String = numberFIeld.text.toString();
        var flag: Boolean = false;
        for(i in zawartosc.length-1 downTo 0)
        {
            if(zawartosc[i] == '(') {
                flag = true;
            }else if (zawartosc[i] == ')') {
                flag = false;
            }
        }
        if(flag)
        {
            numberFIeld.append(")")
        }else
        {
            numberFIeld.append("(")
        }

    }
    private fun backSpace(){
        var text: String = numberFIeld.text.toString();
        if(text.isNotEmpty()){
            numberFIeld.text = text.dropLast(1);
        }

    }


}