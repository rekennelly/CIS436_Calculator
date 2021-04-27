package com.kennelra.cis436_calculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [CalculatorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalculatorFragment : Fragment() {

    lateinit var calcScreen : TextView

    // Track if last key pressed is a number
    var lastBtnPressIsDigit : Boolean = false
    // Track if last key pressed is the decimal point (don't allow 2 in a row)
    var lastBtnPressIsDecimal : Boolean = false
    // Track if calculator is in Error Mode
    var errorState : Boolean = false

    val ERROR_MSG : String = "ERROR"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /* Helper function to call when an number button
    is pressed. (All buttons styled with numberbtn.xml */
    fun onNumberBtnClick(v : View?) {
        with (v as Button) {
            // Get digit from button
            val number: Int = v.text.toString().toInt()

            // Append that digit to the calculator screen
            calcScreen.append(number.toString())

            // Set last button pressed is digit to True
            lastBtnPressIsDigit = true
        }
    }

    /* Helper function to call when an operator button
    is pressed. (All buttons styled with operatorbtn.xml */
    fun operateOperatorButton(v: View) {
        with (v as Button) {
            if (lastBtnPressIsDigit) {
                // Get operator from button
                val operator : String = v.text.toString()

                // Append to screen
                calcScreen.append(operator)

                // Set last button pressed is digit to False
                lastBtnPressIsDigit = false
            } else {
                // Show error message
                calcScreen.text = ERROR_MSG
            }

        }
    }

    /* Helper function to call when a setting btn is pressed (except equals) */

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_calculator, container, false)

        // Initialize the calculator screen
        calcScreen = view.findViewById(R.id.screenTextView)

        /* ------ Button variables -------*/
        // Number buttons
        var oneBtn : Button = view.findViewById(R.id.oneBtn)
        var twoBtn : Button = view.findViewById(R.id.twoBtn)
        var threeBtn : Button = view.findViewById(R.id.threeBtn)
        var fourBtn : Button = view.findViewById(R.id.fourBtn)
        var fiveBtn : Button = view.findViewById(R.id.fiveBtn)
        var sixBtn : Button = view.findViewById(R.id.sixBtn)
        var sevenBtn : Button = view.findViewById(R.id.sevenBtn)
        var eightBtn : Button = view.findViewById(R.id.eightBtn)
        var nineBtn : Button = view.findViewById(R.id.nineBtn)
        var zeroBtn : Button = view.findViewById(R.id.zeroBtn)
        // Operator buttons
        var addBtn : Button = view.findViewById(R.id.addButton)
        var minusBtn : Button = view.findViewById(R.id.minusButton)
        var multiplyBtn : Button = view.findViewById(R.id.multiplyButton)
        var divideBtn : Button = view.findViewById(R.id.divideBtn)
        var modBtn : Button = view.findViewById(R.id.modBtn)
        var sqrtBtn : Button = view.findViewById(R.id.sqrtBtn)
        // Setting buttons
        var plusMinusBtn : Button = view.findViewById(R.id.plusMinusButton)
        var decimalBtn : Button = view.findViewById(R.id.pointBtn)
        var clearBtn : Button = view.findViewById(R.id.clearBtn)
        var equalBtn : Button = view.findViewById(R.id.equalBtn)

        oneBtn.setOnClickListener{view ->
            onNumberBtnClick(view)
        }
        twoBtn.setOnClickListener{view ->
            onNumberBtnClick(view)
        }
        threeBtn.setOnClickListener{view ->
            onNumberBtnClick(view)
        }
        fourBtn.setOnClickListener{view ->
            onNumberBtnClick(view)
        }
        fiveBtn.setOnClickListener{view ->
            onNumberBtnClick(view)
        }
        sixBtn.setOnClickListener{view ->
            onNumberBtnClick(view)
        }
        sevenBtn.setOnClickListener{view ->
            onNumberBtnClick(view)
        }
        eightBtn.setOnClickListener{view ->
            onNumberBtnClick(view)
        }
        nineBtn.setOnClickListener{view ->
            onNumberBtnClick(view)
        }
        zeroBtn.setOnClickListener{view ->
            onNumberBtnClick(view)
        }

        return view
    }

    companion object {
        fun newInstance() = CalculatorFragment()
    }

}