package debanshu.attendanceapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.firebase.database.FirebaseDatabase
import debanshu.attendanceapp.databinding.ActivityTourhistoryBinding

class AddTourhistory : AppCompatActivity() {

    lateinit var sname : EditText
    lateinit var ccname : EditText
    lateinit var Cname : EditText
    lateinit var cmobileno : EditText
    lateinit var coachaddress : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tourhistory)
        var tadd: Button = findViewById(R.id.addtournament)
        sname = findViewById(R.id.sname)
        ccname = findViewById(R.id.coname)
        Cname = findViewById(R.id.coachName)
        cmobileno = findViewById(R.id.cmobilenumber)
        coachaddress = findViewById(R.id.winner)
        tadd.setOnClickListener{
            val sporname = sname.text.toString().trim()
            val ccordname = ccname.text.toString().trim()
            val coachNAME = Cname.text.toString().trim()
            val cmobileNUMBER = cmobileno.text.toString().trim()
            val TWinner = coachaddress.text.toString().trim()

            /* if(studentname.isEmpty()){
                 sname.error = "Please enter a name"
                 return@setOnClickListener
             }*/
            val ref = FirebaseDatabase.getInstance().getReference("THISTORY")
            val TId = ref.push().key

            val tourHistory = Reportlist2(sporname,ccordname,coachNAME,cmobileNUMBER,TWinner)
            ref.child(TId!!).setValue(tourHistory).addOnCompleteListener{
                Toast.makeText(applicationContext,"TOURNMENT HISTORY added successfully", Toast.LENGTH_LONG).show()
            }
        }

    }
}