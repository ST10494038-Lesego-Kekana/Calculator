@file:Suppress("Annotator", "Annotator")

package vcmsa.ci.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.sqrt
import java.math.BigDecimal.ZERO
import java.math.RoundingMode




class MainActivity : AppCompatActivity() {

    private var number1 : EditText? = null
    private var number2 : EditText? = null
    private var answer : TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.editTextNumber)
        number2 = findViewById(R.id.editTextNumber2)
        answer = findViewById(R.id.textView3)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        val btnSq = findViewById<Button>(R.id.btnSq)
        val btnPow = findViewById<Button>(R.id.btnPow)
        val btnStat = findViewById<Button>(R.id.btnStat)

        btnAdd.setOnClickListener()
        {
            add()
        }
        btnSub.setOnClickListener()
        {
            subtract()
        }
        btnMul.setOnClickListener()
        {
            multiply()
        }
        btnDiv.setOnClickListener()
        {
            divide()
        }
        btnSq.setOnClickListener()
        {
            squareRoot()
        }
        btnPow.setOnClickListener()
        {
            power()
        }

        btnStat.setOnClickListener {
            val intent = Intent(this, Stats::class.java)
                startActivity(intent)
            }
        }
    }

    class Stats {

    }

    private fun inputIsNotEmpty(): Boolean
    {
        var b = true
        if (number1?.text.toString().trim().isEmpty())
        {
            number1?.error = "Required"
            answer?.text = "Input required"
            b = false
        }
        if (number2?.text.toString().trim().isEmpty())
        {
            number2?.error = "Required"
            answer?.text = "Input required"
            b = false
        }
        return b
    }

    private fun add()
    {
        if (inputIsNotEmpty())
        {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = "${number1?.text.toString().trim().toBigDecimal()} + ${number2?.text.toString().trim().toBigDecimal()} = ${input1.add(input2)}"
        }
    }

    private fun subtract()
    {
        if (inputIsNotEmpty())
        {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = "${number1?.text.toString().trim().toBigDecimal()} - ${number2?.text.toString().trim().toBigDecimal()} = ${input1.subtract(input2)}"
        }
    }

    private fun multiply() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = "${number1?.text.toString().trim().toBigDecimal()} * ${number2?.text.toString().trim().toBigDecimal()} = ${input1.multiply(input2)}"
        }
    }

    private fun squareRoot() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()

            if (input1 < ZERO) {
                answer?.text = "Sqr(${input1}) = ${sqrt(input1.abs().toDouble())}i and \n Sqr(${input2}) = ${sqrt(input2.toDouble())}"
            }else

                if (input2 < ZERO) {
                    answer?.text =
                        "Sqr(${input1}) = ${sqrt(input1.toDouble())} and \n Sqr(${input2}) = ${sqrt(input2.abs().toDouble())}i"
                }else

                    if (input1 < ZERO&& input2 < ZERO) {
                        answer?.text = "Sqr(${input1}) = ${sqrt(input1.abs().toDouble())}i and \n Sqr(${input2}) = ${sqrt(input2.abs().toDouble())}i"
                    }

            answer?.text =
                "Sqr(${input1}) = ${sqrt(input1.toDouble())} and \n Sqr(${input2}) = ${sqrt(input2.toDouble())}"
        }
    }

    private fun power() {
        if (inputIsNotEmpty()) {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()
            answer?.text = "${number1?.text.toString().trim().toBigDecimal()} ^ ${number2?.text.toString().trim().toBigDecimal()} = ${input1.pow(input2.toInt())}"
        }
    }

    private fun isNotZero(): Boolean {
        var c = true

        if(  number2?.text.toString().trim().toBigDecimal() == ZERO) {
            number2?.error = "Cannot Divide by Zero!"
            answer?.text = "Cannot Divide by Zero!"
            c = false
        }
        return c
    }

    private fun divide(){

        if (inputIsNotEmpty())
        {
            val input1 = number1?.text.toString().trim().toBigDecimal()
            val input2 = number2?.text.toString().trim().toBigDecimal()

            if (isNotZero())
            {
                answer?.text = "${number1?.text.toString().trim().toBigDecimal()} / ${number2?.text.toString().trim().toBigDecimal()} = ${input1.divide(input2, 2,
                    RoundingMode.HALF_UP)}"
            }
        }


        }
    }






