package com.kancharla.abhilash.fc_003

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class m1_12385 : Fragment() {
    private val viewModel: MissionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_m1_12385, container, false)
        view.findViewById<Button>(R.id.button5).setOnClickListener {
            // Reset ViewModel state for replay if necessary
            viewModel.trustLevel = 0
            viewModel.selectedStrategy = null
            viewModel.helicopterDismissed = false
            //findNavController().navigate(R.id.action_m1_12385_to_m1_97123)
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = m1_12385()
    }
}
