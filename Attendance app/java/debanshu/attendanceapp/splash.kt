package debanshu.attendanceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class splash : AppCompatActivity() {
    lateinit var topAnim: Animation
    lateinit var bottomAnim:Animation
    lateinit var image:ImageView
    lateinit var handler:Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)
        image = findViewById(R.id.imageView)
        image.setAnimation(topAnim)
        handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this,login::class.java))
            finish()
        },5000)

    }
}