package disiiy.khaper.distask.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import disiiy.khaper.distask.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private var handler : Handler? = null
    private var progressBarStatus = 0
    private val DELAY : Long = 3000
    var dummy : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler = Handler()
        handler!!.postDelayed(runnable, DELAY)
        supportActionBar?.hide()
    }

    private val runnable : Runnable = Runnable {
        Thread(Runnable{
            while (progressBarStatus < 100){
                try {
                    dummy = dummy + 25
                    Thread.sleep(100)
                } catch (e: InterruptedException){
                    e.printStackTrace()
                }
                progressBarStatus = dummy
                pb_splash.progress = progressBarStatus
                toActivity()
            }
        }).start()
    }

    private fun toActivity() {
        val intent = Intent(this, OnboardingActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        this.finish()
        handler!!.removeCallbacks(runnable)
    }

    override fun onDestroy() {
        if (handler != null){
            handler!!.removeCallbacks(runnable)
        }
        super.onDestroy()
    }
}