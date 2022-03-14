package debanshu.attendanceapp

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class register : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val database = Firebase.database
        val myRef = database.getReference("User")
        myRef.setValue("Debanshu")
        //  val auth: FirebaseAuth?\]








        //  auth = Firebase.auth
        val save = findViewById<Button>(R.id.bt_save)

        save.setOnClickListener {
            val auth: FirebaseAuth?

            auth = Firebase.auth
            signUpUser()
            val email = R.id.et_username.toString()
            val pass = R.id.et_password.toString()
            auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(
                            baseContext, "user created.",
                            Toast.LENGTH_SHORT
                        ).show()
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        updateUI(null)
                    }
                }











        }
    }

    private fun signUpUser() {
        val username = findViewById<EditText>(R.id.et_username)
        val password = findViewById<EditText>(R.id.et_password)
        if (username.text.toString().isEmpty()) {
            username.error = "Please enter email"
            username.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(username.text.toString()).matches()) {
            username.error = "Plear enter valid email"
            username.requestFocus()
            return
        }

        if (username.text.toString().isEmpty()) {
            password.error = "Please enter password"
            password.requestFocus()
            return
        }
    }

    private fun updateUI(user: FirebaseUser?) {

    }


}