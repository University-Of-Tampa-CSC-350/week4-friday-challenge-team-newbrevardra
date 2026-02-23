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

class final_frag : Fragment() {
    private val viewModel: MissionViewModel by activityViewModels()
    private val args: final_fragArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_final_frag, container, false)
        
        // Update ViewModel with the latest trust level passed via Safe Args
        viewModel.trustLevel = args.finalTrust
        
        val resultTextView = view.findViewById<TextView>(R.id.resultTextView)
        val buttonReplay = view.findViewById<Button>(R.id.buttonReplay)
        
        val strategy = viewModel.selectedStrategy
        val trust = viewModel.trustLevel
        val helicopter = viewModel.helicopterDismissed
        
        // Task 4: Compute final outcome dynamically
        val outcome = when {
            trust > 15 -> "Success: Daniel surrenders. Emma survives.\nStrategy: $strategy\nHelicopter Dismissed: $helicopter"
            trust > 5 -> "Partial Success: Daniel is neutralized, but Emma survives.\nStrategy: $strategy\nHelicopter Dismissed: $helicopter"
            else -> "Failure: Negotiation collapses. Emma does not survive.\nStrategy: $strategy\nHelicopter Dismissed: $helicopter"
        }
        
        resultTextView.text = outcome
        
        buttonReplay.setOnClickListener {
            // Reset ViewModel state
            viewModel.trustLevel = 0
            viewModel.selectedStrategy = null
            viewModel.helicopterDismissed = false
            findNavController().navigate(R.id.action_final_frag_to_m1_97123)
        }
        
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Task 5: Display Trust Level
        val trustTextView = view.findViewById<TextView>(R.id.trustTextView)
        trustTextView?.text = "Trust Level: ${viewModel.trustLevel}"
    }
}
