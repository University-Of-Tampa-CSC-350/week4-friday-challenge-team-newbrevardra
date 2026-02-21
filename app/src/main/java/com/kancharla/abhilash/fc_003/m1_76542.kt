package com.kancharla.abhilash.fc_003

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class m1_76542 : Fragment() {
    private val viewModel: MissionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_m1_76542, container, false)

        view.findViewById<Button>(R.id.button5).setOnClickListener {
            viewModel.selectedStrategy = "ESTABLISH_CONTACT"
            viewModel.trustLevel += 5
            findNavController().navigate(R.id.action_m1_76542_to_final_frag)
        }

        view.findViewById<Button>(R.id.button3).setOnClickListener {
            viewModel.helicopterDismissed = true
            viewModel.trustLevel += 10
            findNavController().navigate(R.id.action_m1_76542_to_final_frag)
        }

        view.findViewById<Button>(R.id.button4).setOnClickListener {
            viewModel.selectedStrategy = "REFUSE_NEGOTIATION"
            viewModel.trustLevel -= 10
            findNavController().navigate(R.id.action_m1_76542_to_final_frag)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = m1_76542()
    }
}
