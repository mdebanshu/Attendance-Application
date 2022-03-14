package debanshu.attendanceapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import debanshu.attendanceapp.databinding.ActivityViewTourhistoryBinding

class view_tourhistory : AppCompatActivity() {

    private lateinit var dbtourref: DatabaseReference
    private lateinit var tourRecyclerview : RecyclerView
    private lateinit var tourArrayList: ArrayList<Reportlist>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_tourhistory)
        tourRecyclerview = findViewById(R.id.vwtourhistory)
        tourRecyclerview.layoutManager = LinearLayoutManager(this)
        tourRecyclerview.setHasFixedSize(true)

        tourArrayList = arrayListOf<Reportlist>()
        gettourData()





    }

    private fun gettourData() {
        dbtourref = FirebaseDatabase.getInstance().getReference("THISTORY")

        dbtourref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(coachSnapshot in snapshot.children){
                        val tuser = coachSnapshot.getValue(Reportlist::class.java)
                        tourArrayList.add(tuser!!)
                    }
                    tourRecyclerview.adapter = tourhistory_adapter(tourArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


}