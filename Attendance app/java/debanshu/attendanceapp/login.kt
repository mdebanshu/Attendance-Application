package debanshu.attendanceapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class login : AppCompatActivity() {

     lateinit var auth: FirebaseAuth
     lateinit var spinner_option : Spinner
     lateinit var onLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
     // val database = Firebase.database
      //  var loginpar: Button = findViewById<Button>(R.id.btn_loginpar)
       // var loginadm : Button = findViewById<Button>(R.id.btn_loginadmin)
       // var logincoach : Button = findViewById(R.id.btn_logincoach)
        onLogin = findViewById(R.id.btnlogin)
        spinner_option = findViewById(R.id.sp_option)
      auth = Firebase.auth
        val adapter = ArrayAdapter.createFromResource(this,R.array.UserType,
        R.layout.support_simple_spinner_dropdown_item)
        spinner_option.adapter = adapter
        onLogin.setOnClickListener {
            val item = spinner_option.selectedItem.toString()
            if (item == "Login as Admin") {
                val intent = Intent(this, dashboard_admin::class.java)
                startActivity(intent)
            }else if (item == "Login as Parent/Student"){
                val intent = Intent(this, dashboard_parent::class.java)
                startActivity(intent)
            }else if (item == "Login as Coach"){
                val intent = Intent(this, coach_dashboard::class.java)
                startActivity(intent)
            }
        }

    //  val myRef = database.getReference("test")
          //  myRef.setValue("Debanshu")
        val signup = findViewById<Button>(R.id.btnregister)
        signup.setOnClickListener{
             val intent = Intent(this,register::class.java)
            startActivity(intent)
            finish()
            }
            /*loginpar.setOnClickListener{
                startActivity(Intent(this,dashboard_parent::class.java))
            }
        loginadm.setOnClickListener{
            startActivity(Intent(this,dashboard_admin::class.java))
        }
        logincoach.setOnClickListener{
            startActivity(Intent(this,coach_dashboard::class.java))
        }*/
    }
    }
