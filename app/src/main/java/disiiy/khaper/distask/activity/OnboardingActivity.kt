package disiiy.khaper.distask.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import disiiy.khaper.distask.R
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        fun getLaunchService (from: Context) = Intent(from, OnboardingActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        supportActionBar?.hide()
        ib_onboard.setOnClickListener(this)

    }

    override fun onStart() {
        super.onStart()
        val user = FirebaseAuth.getInstance().currentUser
        if(user != null){
            startActivity(MainActivity.getLaunchService(this))
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.ib_onboard -> startActivity(LoginActivity.getLaunchService(this))
        }
    }


}