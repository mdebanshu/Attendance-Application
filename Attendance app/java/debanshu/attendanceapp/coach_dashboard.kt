package debanshu.attendanceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class coach_dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coach_dashboard)
        var addstu: Button = findViewById<Button>(R.id.btnaddstudent)
        var Vwstudent : Button = findViewById<Button>(R.id.vwstudent)
        var logout : Button = findViewById<Button>(R.id.btnlogout)
        addstu.setOnClickListener {
            startActivity(Intent(this, add_student::class.java))
        }
        Vwstudent.setOnClickListener {
            startActivity(Intent(this,view_student::class.java))
        }
        logout.setOnClickListener{
            startActivity(Intent(this,login::class.java))
        }
    }



}