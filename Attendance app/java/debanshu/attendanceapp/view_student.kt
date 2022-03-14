package debanshu.attendanceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class   view_student : AppCompatActivity() {
    private lateinit var dbref: DatabaseReference
    private lateinit var studentRecyclerview : RecyclerView
    private lateinit var studentArrayList: ArrayList<Studentlist>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)
        studentRecyclerview = findViewById(R.id.vwstudent)
        studentRecyclerview.layoutManager = LinearLayoutManager(this)
        studentRecyclerview.setHasFixedSize(true)

        studentArrayList = arrayListOf<Studentlist>()
        getStudentData()

    }

    private fun getStudentData() {
        dbref = FirebaseDatabase.getInstance().getReference("STUDENTS")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(studentSnapshot in snapshot.children){
                        val suser = studentSnapshot.getValue(Studentlist::class.java)
                        studentArrayList.add(suser!!)
                    }
                    studentRecyclerview.adapter = Studentadapter(studentArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}