package disiiy.khaper.distask.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import disiiy.khaper.distask.R
import disiiy.khaper.distask.activity.AddNoteActivity.Companion.getLaunchService
import disiiy.khaper.distask.fragment.NotesFragment
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.activity_add_task.*

class AddNoteActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        fun getLaunchService (from: Context) = Intent(from, AddNoteActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        supportActionBar?.hide()
        btn_submit_note.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_submit_note -> startActivity(
                NotesFragment.getLaunchService(
                    this
                )
            )
        }
    }
}