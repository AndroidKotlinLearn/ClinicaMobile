package tk.williamsouza.clinicamobile

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class NewPaciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_paciente)
        populateSpinners()
    }

    fun populateSpinners() {
        val sexSpinner = findViewById<Spinner>(R.id.sex)
        ArrayAdapter.createFromResource(
                this,
                R.array.sex,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sexSpinner.adapter = adapter
        }

        val civilStateSpinner = findViewById<Spinner>(R.id.civilState)
        ArrayAdapter.createFromResource(
                this,
                R.array.civilState,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            civilStateSpinner.adapter = adapter
        }
    }
}
