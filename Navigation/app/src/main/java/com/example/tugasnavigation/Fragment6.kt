package com.example.tugasnavigation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class Fragment6 : Fragment(R.layout.fragment_6) {
    private val args: Fragment6Args by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvMessage = view.findViewById<TextView>(R.id.tv_safeargs_message)
        val btnNext = view.findViewById<Button>(R.id.btn_next)

        tvMessage.text = args.message
        btnNext.setOnClickListener {
            val action = Fragment6Directions.actionFragment6ToFragment7("Halo Fragment 7, ini pesan dari Fragment 6!")
            findNavController().navigate(action)
        }
    }
}