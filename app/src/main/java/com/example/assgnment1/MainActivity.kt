package com.example.assgnment1

import android.R.attr.name
import android.R.attr.phoneNumber
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.OnClickListener
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var myTextView: TextView
    private lateinit var editName: EditText
    private lateinit var editPhoneNumber: EditText
    private lateinit var editAddress: EditText
    private lateinit var submitButton: Button
    private lateinit var closeButton: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.name)
        editPhoneNumber = findViewById(R.id.phoneNumber)
        editAddress = findViewById(R.id.address)
        submitButton = findViewById(R.id.submitButton)
        myTextView = findViewById(R.id.myText)
        closeButton = findViewById(R.id.closeButton)

        submitButton.text = getString(R.string.my_button_text)

        submitButton.setOnClickListener {
            val name = editName.text.toString()
            val phoneNumber = editPhoneNumber.text.toString()
            val address = editAddress.text.toString()


            val userDetails = "Name: $name\n Phone Number: $phoneNumber\n Address: $address"
            myTextView.text = userDetails

            editName.visibility = INVISIBLE
            editPhoneNumber.visibility = INVISIBLE
            editAddress.visibility = INVISIBLE
            submitButton.visibility = INVISIBLE
            closeButton.visibility = VISIBLE
        }

        closeButton.setOnClickListener {
            myTextView.text = ""

            editName.text.clear()
            editPhoneNumber.text.clear()
            editAddress.text.clear()
            editName.visibility = VISIBLE
            editPhoneNumber.visibility = VISIBLE
            editAddress.visibility = VISIBLE
            submitButton.visibility = VISIBLE
            closeButton.visibility = INVISIBLE

        }
    }
}

