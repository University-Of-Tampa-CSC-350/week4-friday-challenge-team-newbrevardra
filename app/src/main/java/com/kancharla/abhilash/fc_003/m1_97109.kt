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
import androidx.navigation.fragment.navArgs

class m1_97109 : Fragment() {
    private val viewModel: MissionViewModel by activityViewModels()
    private val args: m1_97109Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_m1_97109, container, false)
        
        // Use Safe Args to update ViewModel
        viewModel.trustLevel = args.currentTrust

        view.findViewById<Button>(R.id.button5).setOnClickListener {
            viewModel.selectedStrategy = "SNIPER_SHOT"
            viewModel.trustLevel -= 20
            val action = m1_97109Directions.actionM197109ToFinalFrag(viewModel.trustLevel)
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.button4).setOnClickListener {
            viewModel.selectedStrategy = "REOPEN_COMMUNICATION"
            viewModel.trustLevel += 5
            val action = m1_97109Directions.actionM197109ToM123961(viewModel.trustLevel)
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
        fun newInstance(param1: String, param2: String) = m1_97109()
    }
}
