package tk.williamsouza.clinicamobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PatientsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Patient> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PatientViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_patients, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PatientViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(patientList: List<Patient>) {
        items = patientList
    }

    class PatientViewHolder(
            itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        val patientName = itemView.findViewById<TextView>(R.id.patientName)

        fun bind(patient: Patient) {
            patientName.setText(patient.name)
        }
    }

}