package com.example.tugasnavigation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class Fragment5 : Fragment(R.layout.fragment_5) {
    private val args: Fragment5Args by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvMessage = view.findViewById<TextView>(R.id.tv_safeargs_message)
        val btnNext = view.findViewById<Button>(R.id.btn_next)

        tvMessage.text = args.message
        btnNext.setOnClickListener {
            val action = Fragment5Directions.actionFragment5ToFragment6("Halo Fragment 6, ini pesan dari Fragment 5!")
            findNavController().navigate(action)
        }
    }
}