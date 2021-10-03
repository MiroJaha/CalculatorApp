package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var resultView : TextView
    private lateinit var b1 : Button
    private lateinit var b2 : Button
    private lateinit var b3 : Button
    private lateinit var b4 : Button
    private lateinit var b5 : Button
    private lateinit var b6 : Button
    private lateinit var b7 : Button
    private lateinit var b8 : Button
    private lateinit var b9 : Button
    private lateinit var b0 : Button
    private lateinit var division : Button
    private lateinit var multiplication : Button
    private lateinit var subtraction : Button
    private lateinit var addition : Button
    private lateinit var delete : Button
    private lateinit var clear : Button
    private lateinit var decimal : Button
    private lateinit var convert : Button
    private lateinit var equal : Button

    private lateinit var printedResult : String
    private var result: Float = 0f
    private lateinit var number: String
    private lateinit var numbersArray : ArrayList<Float>
    private lateinit var operatorArray : ArrayList<String>

    override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
        outState.putFloat("myNumber", result)
        outState.putString("answer",printedResult)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle){
            super.onRestoreInstanceState(savedInstanceState)
        result = savedInstanceState.getFloat("myNumber", 0f)
        printedResult = savedInstanceState.getString("answer")!!
        resultView.text = printedResult
    }

    private fun check (str : String) : Boolean {
        return when {
            str=="0"-> false
            str.endsWith("*") -> false
            str.endsWith("/") -> false
            str.endsWith("+") -> false
            str.endsWith(".") -> false
            else -> !str.endsWith("-")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.resultView)
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        b0 = findViewById(R.id.b0)
        division = findViewById(R.id.bDevid)
        multiplication = findViewById(R.id.bMulti)
        subtraction = findViewById(R.id.bMines)
        addition = findViewById(R.id.bPlus)
        delete = findViewById(R.id.bDelete)
        clear = findViewById(R.id.bC)
        decimal = findViewById(R.id.bDot)
        convert = findViewById(R.id.bPlusAndMines)
        equal = findViewById(R.id.bEqual)

        printedResult = "0"
        number = ""
        numbersArray = arrayListOf()
        operatorArray = arrayListOf()
        resultView.text = printedResult

        b1.setOnClickListener{
            if(printedResult=="0"){
                printedResult= "1"
            }
            else {
                printedResult += "1"
            }
            number+="1"
            resultView.text = printedResult
        }
        b2.setOnClickListener{
            if(printedResult=="0"){
                printedResult= "2"
            }
            else{
                printedResult+="2"
            }
            number+="2"
            resultView.text = printedResult
        }
        b3.setOnClickListener{
            if(printedResult=="0"){
                printedResult= "3"
            }
            else {
                printedResult += "3"
            }
            number+="3"
            resultView.text = printedResult
        }
        b4.setOnClickListener{
            if(printedResult=="0"){
                printedResult = "4"
            }
            else{
                printedResult += "4"
            }
            number += "4"
            resultView.text = printedResult
        }
        b5.setOnClickListener{
            if(printedResult=="0"){
                printedResult = "5"
            }
            else{
                printedResult += "5"
            }
            number += "5"
            resultView.text = printedResult
        }
        b6.setOnClickListener{
            if(printedResult=="0"){
                printedResult = "6"
            }
            else{
                printedResult += "6"
            }
            number += "6"
            resultView.text = printedResult
        }
        b7.setOnClickListener{
            if(printedResult=="0") {
                printedResult = "7"
            }
            else{
                printedResult += "7"
            }
            number += "7"
            resultView.text = printedResult
        }
        b8.setOnClickListener{
            if(printedResult=="0"){
                printedResult = "8"
            }
            else{
                printedResult += "8"
            }
            number += "8"
            resultView.text = printedResult
        }
        b9.setOnClickListener{
            if(printedResult=="0"){
                printedResult = "9"
            }
            else{
                printedResult += "9"
            }
            number += "9"
            resultView.text = printedResult
        }
        b0.setOnClickListener{
            if(printedResult=="0"){
                printedResult = "0"
            }
            else{
                printedResult += "0"
                number += "0"
            }
            resultView.text = printedResult
        }
        division.setOnClickListener{
            if(check(printedResult)) {
                numbersArray.add(number.toFloat())
                number = ""
                operatorArray.add("/")
                printedResult += "/"
                resultView.text = printedResult
            }
            else
                resultView.text = "Error Please Enter a Number"
        }
        multiplication.setOnClickListener{
            if(check(printedResult)) {
                numbersArray.add(number.toFloat())
                number = ""
                operatorArray.add("*")
                printedResult += "*"
                resultView.text = printedResult
            }
            else
                resultView.text = "Error Please Enter a Number"
        }
        subtraction.setOnClickListener{
            if(check(printedResult)) {
                numbersArray.add(number.toFloat())
                number = ""
                operatorArray.add("-")
                printedResult += "-"
                resultView.text = printedResult
            }
            else
                resultView.text = "Error Please Enter a Number"
        }
        addition.setOnClickListener{
            if(check(printedResult)) {
                numbersArray.add(number.toFloat())
                number = ""
                operatorArray.add("+")
                printedResult += "+"
                resultView.text = printedResult
            }
            else
                resultView.text = "Error Please Enter a Number"
        }
        delete.setOnClickListener{
            if(check(printedResult)) {
                number = number.substring(0, number.length - 1)
                printedResult = printedResult.substring(0, printedResult.length - 1)
                if (printedResult.isBlank())
                    printedResult = "0"
                resultView.text = printedResult
            }
            else if (printedResult.endsWith(".")){
                number = number.substring(0, number.length - 1)
                printedResult = printedResult.substring(0, printedResult.length - 1)
                if (printedResult.isBlank())
                    printedResult = "0"
                resultView.text = printedResult
            }
            else
                resultView.text = "Error Please Enter a Number"
        }
        clear.setOnClickListener{
            numbersArray.clear()
            operatorArray.clear()
            number=""
            printedResult = "0"
            resultView.text = printedResult
        }
        decimal.setOnClickListener{
            if(check(printedResult)) {
                number +="."
                printedResult += "."
                resultView.text = printedResult
            }
            else
                resultView.text = "Error Please Enter a Number"
        }
        convert.setOnClickListener{
            if(printedResult=="0") {
                printedResult = "-"
                number+="-"
            }
            else if (check(printedResult))
                resultView.text = "Error Please Convert Before Entering a Number"
            else{
                number+="-"
                printedResult+="-"
                resultView.text = printedResult
            }
        }
        equal.setOnClickListener{
            if (check(printedResult)&&operatorArray.isNotEmpty()){
                try {
                    numbersArray.add(number.toFloat())
                    number = ""
                    var num1: Float
                    var num2: Float
                    var count = 0
                    result = numbersArray[count++]
                    for (i in operatorArray) {
                        num1 = result
                        num2 = numbersArray[count++]
                        when (i) {
                            "+" -> result = num1 + num2
                            "-" -> result = num1 - num2
                            "/" -> {
                                if (num2!=0f)
                                    result = num1 / num2
                                else {
                                    result = 0f
                                    resultView.text = "Error You Can't Divide by 0"
                                }
                            }
                            else -> result = num1 * num2
                        }
                    }
                    numbersArray.clear()
                    operatorArray.clear()
                    number = result.toString()
                    printedResult = result.toString()
                    resultView.text = printedResult
                }
                catch (e:Exception){
                    resultView.text = "Error You Can't Divide by 0"
                }
            }
        }

    }
}