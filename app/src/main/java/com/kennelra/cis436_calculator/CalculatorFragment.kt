package com.kennelra.cis436_calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
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

    lateinit var calcInput : TextView

    val ERROR_MSG : String = "ERROR"

    // Track if last key pressed is a number
    var lastBtnPressIsDigit : Boolean = false
    // Track if last key pressed is the decimal point (don't allow 2 in a row)
    var lastBtnPressIsDecimal : Boolean = false
    // Track if calculator is in Error Mode
    var errorState : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_calculator, container, false)

        calcInput = view.findViewById(R.id.screenTextView)

        return view
    }

    companion object {
        fun newInstance() = CalculatorFragment()
    }

}