package com.ngsolutions.ngcurrencyconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var mode = 0;
    private var currency = listOf("INR to CAD","CAD to INR")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //binding variables
        var switchbtn :Button = findViewById(R.id.switchbtn)
        var convbtn :Button = findViewById(R.id.convbtn)
        var upperdeci :EditText = findViewById(R.id.inrindeci)
        var lowerdeci :TextView = findViewById(R.id.cadindeci)
        var uppertext :TextView = findViewById(R.id.uppertext)
        var lowertext :TextView = findViewById(R.id.lowertext)
        //Btn Actions
        switchbtn.setOnClickListener {
            switchcurrency(mode)
            switchUI(mode,uppertext,lowertext,upperdeci,lowerdeci)
        }
        convbtn.setOnClickListener {
            if(upperdeci.text.isEmpty())
                Toast.makeText(applicationContext, "Please Enter Valid input",Toast.LENGTH_SHORT).show()
            else
            {
                try {
                    var upperval= upperdeci.text.toString().toDouble()
                    if(mode==0)
                        lowerdeci.text=String.format("%.2f", upperval*0.017f)
                    else
                        lowerdeci.text=String.format("%.2f", upperval*58.87f)
                }
                catch (e: NumberFormatException)
                {
                    Toast.makeText(applicationContext, "Please Enter Valid input",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun switchUI(
        mode: Int,
        uppertext: TextView,
        lowertext: TextView,
        upperdeci: EditText,
        lowerdeci: TextView
    ) {
        if(mode==0)
        {
            uppertext.text = "Indian Rupees"
            lowertext.text = "Canadian Dollar"
        }
        else
        {
            lowertext.text = "Indian Rupees"
            uppertext.text = "Canadian Dollars"
        }
        upperdeci.text.clear()
        lowerdeci.text=""
    }

    private fun switchcurrency(mode: Int) {
        if(mode==0)
            this.mode =1
        else
            this.mode =0
        Toast.makeText(applicationContext, "Switched to "+currency[mode],Toast.LENGTH_SHORT).show()
    }
}