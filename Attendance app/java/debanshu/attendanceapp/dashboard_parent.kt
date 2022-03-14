package debanshu.attendanceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class dashboard_parent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_parent)
        var info : Button = findViewById<Button>(R.id.btninfochild)
        var report : Button = findViewById<Button>(R.id.btnhistory)
        var logout : Button = findViewById<Button>(R.id.btnlogout)
        info.setOnClickListener {
            startActivity(Intent(this,view_student::class.java))
        }
        report.setOnClickListener {
            startActivity(Intent(this,view_tourhistory::class.java))
        }
        logout.setOnClickListener {
            startActivity(Intent(this,login::class.java))
        }
    }

}