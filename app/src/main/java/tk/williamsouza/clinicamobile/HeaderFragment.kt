package tk.williamsouza.clinicamobile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [HeaderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HeaderFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_header, container, false)
        val newButton = view.findViewById<Button>(R.id.newHeaderButton)
        val searchButton = view.findViewById<Button>(R.id.searchHeaderButton)
        val allButton = view.findViewById<Button>(R.id.listHeaderButton)

        newButton.setOnClickListener { view -> openNewActivity(view) }
        searchButton.setOnClickListener { view -> openHomeActivity(view) }
        allButton.setOnClickListener { view -> openAllActivity(view) }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment HeaderFragment.
         */
        @JvmStatic
        fun newInstance() =
                HeaderFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }

    fun openNewActivity(view : View) {
        val intent = Intent(this.context, NewPaciente::class.java).apply {}
        startActivity(intent)
    }

    fun openHomeActivity(view : View) {
        val intent = Intent(this.context, MainActivity::class.java).apply {}
        startActivity(intent)
    }

    fun openAllActivity(view : View) {
        val intent = Intent(this.context, AllPacientes::class.java).apply {}
        startActivity(intent)
    }



}