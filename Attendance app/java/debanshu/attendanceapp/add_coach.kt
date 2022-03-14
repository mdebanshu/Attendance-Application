package debanshu.attendanceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase


class add_coach : AppCompatActivity() {
    lateinit var cname : EditText
    lateinit var cfname : EditText
    lateinit var cmname : EditText
    lateinit var cmno : EditText
    lateinit var caddress : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_coach)
        var cadd: Button = findViewById(R.id.addtournament)
        cname = findViewById(R.id.cName)
        cfname = findViewById(R.id.cfName)
        cmname = findViewById(R.id.cmName)
        cmno = findViewById(R.id.cmNumber)
        caddress = findViewById(R.id.cAddress)
        cadd.setOnClickListener{
            val coachname = cname.text.toString().trim()
            val cfathername = cfname.text.toString().trim()
            val cmothername = cmname.text.toString().trim()
            val cmnumber = cmno.text.toString().trim()
            val coaaddress = caddress.text.toString().trim()

            /* if(studentname.isEmpty()){
                 sname.error = "Please enter a name"
                 return@setOnClickListener
             }*/
            val ref = FirebaseDatabase.getInstance().getReference("COACH")
            val coachId = ref.push().key

            val coach = Coach(coachname,cfathername,cmothername,cmnumber,coaaddress)
            ref.child(coachId!!).setValue(coach).addOnCompleteListener{
                Toast.makeText(applicationContext,"coach added successfully",Toast.LENGTH_LONG).show()
            }
        }


    }


}