package tk.williamsouza.clinicamobile

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

object PatientContract {
    object PatientEntry : BaseColumns {
        const val TABLE_NAME = "patients"
        const val COLUMN_NAME_NAME = "nome"
        const val COLUMN_NAME_SEX = "sexo"
        const val COLUMN_NAME_CIVILSTATE = "estadocivil"
        const val COLUMN_NAME_BIRTHDATE = "nascimento"
        const val COLUMN_NAME_EMAIL = "email"
        const val COLUMN_NAME_ADDRESS = "endereco"
        const val COLUMN_NAME_PROFESSION = "profissao"
        const val COLUMN_NAME_PHONENUMBER = "telefone"
        const val COLUMN_NAME_OBSERVATION = "observacao"
        const val COLUMN_NAME_EVOLUTION = "evolucao"
    }
}

private const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${PatientContract.PatientEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${PatientContract.PatientEntry.COLUMN_NAME_NAME} TEXT," +
                "${PatientContract.PatientEntry.COLUMN_NAME_SEX} TEXT," +
                "${PatientContract.PatientEntry.COLUMN_NAME_CIVILSTATE} TEXT," +
                "${PatientContract.PatientEntry.COLUMN_NAME_BIRTHDATE} TEXT," +
                "${PatientContract.PatientEntry.COLUMN_NAME_EMAIL} TEXT," +
                "${PatientContract.PatientEntry.COLUMN_NAME_ADDRESS} TEXT," +
                "${PatientContract.PatientEntry.COLUMN_NAME_PROFESSION} TEXT," +
                "${PatientContract.PatientEntry.COLUMN_NAME_PHONENUMBER} TEXT," +
                "${PatientContract.PatientEntry.COLUMN_NAME_OBSERVATION} TEXT," +
                "${PatientContract.PatientEntry.COLUMN_NAME_EVOLUTION} TEXT)"

private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${PatientContract.PatientEntry.TABLE_NAME}"

class PatientDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "Patients.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}