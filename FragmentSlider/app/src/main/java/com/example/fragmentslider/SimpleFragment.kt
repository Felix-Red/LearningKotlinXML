package com.example.fragmentslider


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.fragment.app.Fragment

class SimpleFragment: Fragment() {
    // Our companion object which
    // we call to make a new Fragment

    companion object{
        val messageID = "messageID"

        fun newInstance(message: String):SimpleFragment{
            val fragment = SimpleFragment()

            val bundle = Bundle(1)
            bundle.putString(messageID, message)
            fragment.arguments = bundle
            return fragment
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val message = arguments?.getString(messageID)

        // Inflate the view as normal
        val view = inflater.inflate(
            R.layout.fragment_layout,
            container,
            false)

        // Get a reference to textView
        val messageTextView = view
            .findViewById<View>(R.id.textView)
                as TextView

        // Display the id in the TextView
        messageTextView.text = message


        return view
    }
}