package com.example.gridlayout_tablelayout_vers2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    private lateinit var toolbarMain: Toolbar
    private lateinit var input: EditText
    private lateinit var result: TextView
    private lateinit var gridLayout: GridLayout

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var button0: Button
    private lateinit var buttonreset: Button
    private lateinit var buttonresult: Button
    private lateinit var buttonmult: Button
    private lateinit var buttonminus: Button
    private lateinit var buttondiv: Button
    private lateinit var buttonsum: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        toolbarMain = findViewById(R.id.toolbar)
        setSupportActionBar(toolbarMain)
        input = findViewById(R.id.input)
        result = findViewById(R.id.result)
        buttonsum = findViewById(R.id.SumBTN)
        buttondiv = findViewById(R.id.divBTN)
        buttonminus = findViewById(R.id.MinusBTN)
        buttonmult = findViewById(R.id.MultBTN)
        buttonresult = findViewById(R.id.ResultBTN)
        buttonreset = findViewById(R.id.ResetBTN)
        button0 = findViewById(R.id.ZeroBTN)
        button1 = findViewById(R.id.OneBTN)
        button2 = findViewById(R.id.TwoBTN)
        button3 = findViewById(R.id.ThreeBTN)
        button4 = findViewById(R.id.ForeBTN)
        button5 = findViewById(R.id.FiveBTN)
        button6 = findViewById(R.id.SixBTN)
        button7 = findViewById(R.id.SevenBTN)
        button8 = findViewById(R.id.EighttBTN)
        button9 = findViewById(R.id.NineBTN)
        gridLayout = findViewById(R.id.gridlayout)
        input.isEnabled = false

        setupKeyboard()
    }

    private fun setupKeyboard() {
        val keyboard = findViewById<GridLayout>(R.id.gridlayout)
        for (i in 0 until keyboard.childCount) {
            val button = keyboard.getChildAt(i) as Button
            button.setOnClickListener { onKeyboardButtonClick(button.text.toString()) }
        }
    }

    private fun onKeyboardButtonClick(value: String) {
        when (value) {
            "=" -> calculateResult()
            "reset" -> input.text.clear()
                        else -> input.append(value)
        }
    }

    private fun calculateResult() {
        val expression = input.text.toString()
        try {
            val result2 = evaluateExpression(expression)
            result.setText(result2)
        } catch (e: Exception) {
            result.setText("Ошибка")
        }
    }

    private fun evaluateExpression(expression: String): String {
                return expression
    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
                        R.id.action_exit -> {
                finish()
                            Toast.makeText(applicationContext, "Выход", Toast.LENGTH_LONG).show()
            }

        }
        return super.onOptionsItemSelected(item)
    }




}


