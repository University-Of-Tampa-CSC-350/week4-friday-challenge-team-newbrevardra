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

class m1_75628 : Fragment() {
    private val viewModel: MissionViewModel by activityViewModels()
    private val args: m1_75628Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_m1_75628, container, false)
        
        // Use Safe Args to update ViewModel
        viewModel.trustLevel = args.currentTrust

        view.findViewById<Button>(R.id.button5).setOnClickListener {
            viewModel.trustLevel = 0
            viewModel.selectedStrategy = null
            viewModel.helicopterDismissed = false
            findNavController().navigate(R.id.action_m1_75628_to_m1_97123)
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
        fun newInstance(param1: String, param2: String) = m1_75628()
    }
}
