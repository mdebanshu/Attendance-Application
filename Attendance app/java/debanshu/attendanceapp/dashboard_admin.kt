package debanshu.attendanceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class dashboard_admin : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_admin)
        //var listview = findViewById<View>(R.id.viewstudent)
        var addstu: Button = findViewById<Button>(R.id.btnaddstudent)
        var addco: Button = findViewById<Button>(R.id.btnaddcoach)
        var vwCoach: Button = findViewById<Button>(R.id.vwcoach)
        var Vwstudent : Button = findViewById<Button>(R.id.vwstudent)
        var Tdetails : Button = findViewById<Button>(R.id.tdetails)
        addstu.setOnClickListener {
            startActivity(Intent(this, add_student::class.java))
        }
        addco.setOnClickListener {
            startActivity(Intent(this, add_coach::class.java))
        }
        vwCoach.setOnClickListener{
            startActivity(Intent(this,view_coach::class.java))
        }
        Vwstudent.setOnClickListener {
            startActivity(Intent(this,view_student::class.java))
        }
        Tdetails.setOnClickListener {
            startActivity(Intent(this,AddTourhistory::class.java))
        }


    }

}
