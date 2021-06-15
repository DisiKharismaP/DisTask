package disiiy.khaper.distask.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import disiiy.khaper.distask.R
import kotlinx.android.synthetic.main.activity_forgot.*

class ForgotActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mAuth: FirebaseAuth

    companion object{
        fun getLaunchService (from: Context) = Intent(from, ForgotActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)
        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()
        ib_send_email_forgot.setOnClickListener(this)
        ib_back_forgot.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.ib_send_email_forgot -> forgotPassword()
            R.id.ib_back_forgot -> startActivity(LoginActivity.getLaunchService(this))
        }
    }

    private fun forgotPassword() {
        val email = et_email_forgot.text.toString()
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,getString(R.string.txt_error), Toast.LENGTH_SHORT).show()
        }else{
            mAuth.sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "Check Email to reset password", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(
                        VerificationActivity.getLaunchService(
                            this
                        )
                    ))
                }else{
                    Toast.makeText(this,"Failed to reset password", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}