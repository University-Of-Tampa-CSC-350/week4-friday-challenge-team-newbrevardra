package com.kancharla.abhilash.fc_003

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class m1_97109 : Fragment() {
    private val viewModel: MissionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_m1_97109, container, false)

        view.findViewById<Button>(R.id.button5).setOnClickListener {
            viewModel.selectedStrategy = "SNIPER_SHOT"
            viewModel.trustLevel -= 20
            findNavController().navigate(R.id.action_m1_97109_to_m1_12385)
        }

        view.findViewById<Button>(R.id.button4).setOnClickListener {
            viewModel.selectedStrategy = "REOPEN_COMMUNICATION"
            // Logic could lead to different fragments, but for Step 3 we just navigate as per current graph
            if (viewModel.trustLevel < 0) {
                 // In a real app we might navigate to 75628
                 // findNavController().navigate(R.id.action_m1_97109_to_m1_75628)
            }
            findNavController().navigate(R.id.action_m1_97109_to_m1_23961)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = m1_97109()
    }
}
