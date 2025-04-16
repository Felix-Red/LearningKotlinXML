package com.example.simplefragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class SimpleFragment: Fragment() {
    val myString: String = "Hello from simpleFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_layout, container, false)

        val button = view?.findViewById<Button>(R.id.button)

        button?.setOnClickListener({
            Toast.makeText(requireActivity(), myString, Toast.LENGTH_SHORT).show()
        })

        return view
    }
}