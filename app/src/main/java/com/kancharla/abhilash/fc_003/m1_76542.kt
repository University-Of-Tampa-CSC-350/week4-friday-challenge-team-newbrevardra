package com.kancharla.abhilash.fc_003

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
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
            val action = m1_76542Directions.actionM176542ToM123961(viewModel.trustLevel)
            findNavController().navigate(action)
        }
        
        view.findViewById<Button>(R.id.button3).setOnClickListener {
            viewModel.helicopterDismissed = true
            viewModel.trustLevel += 10
            val action = m1_76542Directions.actionM176542ToM139462(viewModel.trustLevel)
            findNavController().navigate(action)
        }
        
        view.findViewById<Button>(R.id.button4).setOnClickListener {
            viewModel.selectedStrategy = "REFUSE_NEGOTIATION"
            viewModel.trustLevel -= 10
            val action = m1_76542Directions.actionM176542ToM197109(viewModel.trustLevel)
            findNavController().navigate(action)
        }
        
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val trustTextView = view.findViewById<TextView>(R.id.trustTextView)
        trustTextView?.text = "Trust Level: ${viewModel.trustLevel}"
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = m1_76542()
    }
}
