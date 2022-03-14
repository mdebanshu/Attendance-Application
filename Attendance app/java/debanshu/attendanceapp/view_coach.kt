package debanshu.attendanceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class view_coach : AppCompatActivity() {
    private lateinit var dbcoachref: DatabaseReference
    private lateinit var coachRecyclerview : RecyclerView
    private lateinit var coachArrayList: ArrayList<Coachlist>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_coach)
        coachRecyclerview = findViewById(R.id.vwCoach)
        coachRecyclerview.layoutManager = LinearLayoutManager(this)
        coachRecyclerview.setHasFixedSize(true)

        coachArrayList = arrayListOf<Coachlist>()
        getCoachData()

    }

    private fun getCoachData() {
        dbcoachref = FirebaseDatabase.getInstance().getReference("COACH")

        dbcoachref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(coachSnapshot in snapshot.children){
                        val cuser = coachSnapshot.getValue(Coachlist::class.java)
                        coachArrayList.add(cuser!!)
                    }
                    coachRecyclerview.adapter = Coachadapter(coachArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}