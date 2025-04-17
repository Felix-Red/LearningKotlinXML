package com.example.dailogdemo

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment


class MyDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(this.activity)

        builder.setMessage("Make a selection")
            .setPositiveButton("OK", {dialog, id ->
                //nothing happening here
            })
            .setNegativeButton("Cancel", {dialog, id ->
                //nothing happening here either
            })

        return builder.create()
    }

}