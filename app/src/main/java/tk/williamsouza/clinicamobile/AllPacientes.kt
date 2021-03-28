package tk.williamsouza.clinicamobile

import android.os.Bundle
import android.provider.BaseColumns
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AllPacientes : AppCompatActivity() {
    private var dbHelper : PatientDbHelper? = null
    private lateinit var patientsAdapter: PatientsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_pacientes)
        dbHelper = PatientDbHelper(this)
        initRecyclerView()
        addDataSet()
    }

    fun readFromDb(): List<Patient> {
        val db = dbHelper?.readableDatabase
        val projection = arrayOf(BaseColumns._ID, PatientContract.PatientEntry.COLUMN_NAME_NAME)

        // Filter results WHERE "title" = 'My Title'
        val selection = "${PatientContract.PatientEntry.COLUMN_NAME_NAME} = ?"
        val selectionArgs = arrayOf("*")

        // How you want the results sorted in the resulting Cursor
        val sortOrder = "${BaseColumns._ID} ASC"


        val cursor = db?.query(
                PatientContract.PatientEntry.TABLE_NAME,
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,          // don't group the rows
                null,           // don't filter by row groups
                sortOrder               // The sort order

        )
        val patients = ArrayList<Patient>()
        cursor?.moveToFirst()
        if (cursor != null) {
            while(!cursor.isAfterLast()) {
                patients.add(Patient(cursor.getString(cursor.getColumnIndex("nome"))))
            }
        }

        return patients



    }

    private fun addDataSet() {
        val data = readFromDb()
        patientsAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        val recycler_view = findViewById<RecyclerView>(R.id.patients)
        recycler_view.layoutManager = LinearLayoutManager(this@AllPacientes)
        recycler_view.adapter = patientsAdapter
    }
}