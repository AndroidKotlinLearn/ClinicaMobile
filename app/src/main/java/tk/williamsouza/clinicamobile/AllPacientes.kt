package tk.williamsouza.clinicamobile

import android.os.Bundle
import android.provider.BaseColumns
import androidx.appcompat.app.AppCompatActivity

class AllPacientes : AppCompatActivity() {
    private var dbHelper : PatientDbHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_pacientes)
        dbHelper = PatientDbHelper(this)
    }

    fun readFromDb() {
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
    }
}