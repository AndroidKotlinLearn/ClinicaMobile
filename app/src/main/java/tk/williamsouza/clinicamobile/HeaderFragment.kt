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
        newButton.setOnClickListener { view -> openNewFragment(view) }
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

    fun openNewFragment(view : View) {
        val intent = Intent(this.context, NewPaciente::class.java).apply {}
        startActivity(intent)
    }
}