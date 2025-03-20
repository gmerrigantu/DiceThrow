package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"

    val PREVIOUS_ROLL = "previousroll"

    var currentRoll = 0

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    lateinit var dieViewModel: DieViewModel

    companion object {
        fun newInstance(sides: Int): DieFragment {
            val fragment = DieFragment()
            fragment.dieSides = sides
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dieViewModel = ViewModelProvider(requireActivity())[DieViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        dieViewModel.getCurrentRoll().observe(requireActivity()) {
            dieTextView.text = it.toString()
        }

        if (dieViewModel.getCurrentRoll().value == null) {
            dieViewModel.rollDie()
        }

    }

}