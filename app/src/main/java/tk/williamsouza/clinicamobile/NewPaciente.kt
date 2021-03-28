package tk.williamsouza.clinicamobile

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewPaciente : AppCompatActivity() {
    private var dbHelper : PatientDbHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_paciente)
        dbHelper = PatientDbHelper(this)
        populateSpinners()
        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener { writeToDb() }
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

    fun writeToDb() {
        val db = dbHelper?.writableDatabase

        val name = findViewById<TextView>(R.id.textName).text.toString()
        val sex = findViewById<TextView>(R.id.sex).text.toString()
        val birthDate = findViewById<TextView>(R.id.birthDate).text.toString()
        val civilState = findViewById<TextView>(R.id.civilState).text.toString()
        val email = findViewById<TextView>(R.id.email).text.toString()
        val address = findViewById<TextView>(R.id.addressStreet).text.toString()
        val profession = findViewById<TextView>(R.id.profession).text.toString()
        val phoneNumber = findViewById<TextView>(R.id.phoneNumber).text.toString()
        val observation = findViewById<TextView>(R.id.observation).text.toString()
        val evolution = ""


        val values = ContentValues().apply {
            put(PatientContract.PatientEntry.COLUMN_NAME_NAME, name)
            put(PatientContract.PatientEntry.COLUMN_NAME_SEX, sex)
            put(PatientContract.PatientEntry.COLUMN_NAME_BIRTHDATE, birthDate)
            put(PatientContract.PatientEntry.COLUMN_NAME_CIVILSTATE, civilState)
            put(PatientContract.PatientEntry.COLUMN_NAME_EMAIL, email)
            put(PatientContract.PatientEntry.COLUMN_NAME_ADDRESS, address)
            put(PatientContract.PatientEntry.COLUMN_NAME_PROFESSION, profession)
            put(PatientContract.PatientEntry.COLUMN_NAME_PHONENUMBER, phoneNumber)
            put(PatientContract.PatientEntry.COLUMN_NAME_OBSERVATION, observation)
            put(PatientContract.PatientEntry.COLUMN_NAME_EVOLUTION, evolution)
        }

        val newRowId = db?.insert(PatientContract.PatientEntry.TABLE_NAME, null, values)

        val intent = Intent(this, AllPacientes::class.java).apply {  }
        startActivity(intent)
    }
}
