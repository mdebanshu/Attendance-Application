package debanshu.attendanceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase


class add_student : AppCompatActivity() {
    lateinit var sname : EditText
    lateinit var fname : EditText
    lateinit var mname : EditText
    lateinit var mno : EditText
    lateinit var saddress : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        val ref = FirebaseDatabase.getInstance().getReference("STUDENTS")
        var studentadd: Button = findViewById(R.id.addStudent)
        sname = findViewById(R.id.sName)
        fname = findViewById(R.id.fName)
        mname = findViewById(R.id.mName)
        mno = findViewById(R.id.mNumber)
        saddress = findViewById(R.id.sAddress)
        studentadd.setOnClickListener{
            val studentname = sname.text.toString().trim()
            val sfathername = fname.text.toString().trim()
            val smothername = mname.text.toString().trim()
            val mnumber = mno.text.toString().trim()
            val stuaddress = saddress.text.toString().trim()

           /* if(studentname.isEmpty()){
                sname.error = "Please enter a name"
                return@setOnClickListener
            }*/

            val studentId = ref.push().key

            val students = Student(studentname,sfathername,smothername,mnumber,stuaddress)
            ref.child(studentId!!).setValue(students).addOnCompleteListener{
                Toast.makeText(applicationContext,"Student added successfully",Toast.LENGTH_LONG).show()
        }
    }


    }


}