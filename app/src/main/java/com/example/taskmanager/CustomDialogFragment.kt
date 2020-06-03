package com.example.taskmanager

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.taskmanager.databinding.FragmentTodayBinding

/**
 * A simple [Fragment] subclass.
 */
class CustomDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.custom_dialog, container, false)

        val edtName = view.findViewById<View>(R.id.edtName) as EditText
        val edtDescription = view.findViewById<View>(R.id.edtDescription) as EditText

        val btnCancel = view.findViewById<View>(R.id.btnCancel) as Button
        val btnAccept = view.findViewById<View>(R.id.btnAccept) as Button

        btnCancel.setOnClickListener {
            Toast.makeText(activity, "action cancelled", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        btnAccept.setOnClickListener {
            Toast.makeText(activity, "User Accepted Action", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return view
    }

}
