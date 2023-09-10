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
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var myTextView: TextView
    private lateinit var editName: EditText
    private lateinit var editPhoneNumber: EditText
    private lateinit var editAddress: EditText
    private lateinit var submitButton: Button
    private lateinit var closeButton: Button
    private  lateinit var formLayout:LinearLayout
    private  lateinit var viewLayout:LinearLayout


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        formLayout= findViewById(R.id.l1)
        viewLayout= findViewById(R.id.l2)
        editName = findViewById(R.id.fullName)
        editPhoneNumber = findViewById(R.id.phoneNumber)
        editAddress = findViewById(R.id.address)
        submitButton = findViewById(R.id.submitButton)
        myTextView = findViewById(R.id.myText)
        closeButton = findViewById(R.id.closeButton)

        submitButton.text = getString(R.string.my_button_text)

        submitButton.setOnClickListener {
            val formStatus=isFormValid();
            if(formStatus==true) {
                showDetail()
            }
        }

        closeButton.setOnClickListener {
            showForm()


        }
    }

    fun showForm()
    {
        formLayout.visibility=View.VISIBLE
        viewLayout.visibility=View.GONE
        myTextView.text = ""

        editName.text.clear()
        editPhoneNumber.text.clear()
        editAddress.text.clear()
    }

    fun showDetail()
    {
        formLayout.visibility=View.GONE
        viewLayout.visibility=View.VISIBLE

        val name = editName.text.toString()
        val phoneNumber = editPhoneNumber.text.toString()
        val address = editAddress.text.toString()
        val userDetails = "Name: $name\n Phone Number: $phoneNumber\n Address: $address"
        myTextView.text = userDetails

    }

    fun isFormValid():Boolean{
        if(editName.text.toString().isEmpty())
        {
            showMessage("Please Enter Your Full Name")
            return  false;
        }

        if(editPhoneNumber.text.toString().isEmpty())
        {
            showMessage("Please Enter Your Phone Number")
            return  false;
        }
        if(editAddress.text.toString().isEmpty())
        {
            showMessage("Please Enter Your Address")
            return  false;
        }




        return  true;
    }

    fun showMessage(message:String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

}

