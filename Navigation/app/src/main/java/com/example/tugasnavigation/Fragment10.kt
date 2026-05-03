package com.example.tugasnavigation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class Fragment10 : Fragment(R.layout.fragment_10) {
    private val args: Fragment10Args by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvMessage = view.findViewById<TextView>(R.id.tv_safeargs_message)
        val btnNext = view.findViewById<Button>(R.id.btn_next)

        tvMessage.text = args.message
        btnNext.setOnClickListener {
            val action = Fragment10Directions.actionFragment10ToFragment1("Halo Yuna ITZY, ini pesan dari Fragment 10!")
            findNavController().navigate(action)
        }
    }
}