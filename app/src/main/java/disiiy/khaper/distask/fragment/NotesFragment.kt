package disiiy.khaper.distask.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import disiiy.khaper.distask.R
import disiiy.khaper.distask.activity.AddNoteActivity
import disiiy.khaper.distask.activity.AddTaskActivity
import disiiy.khaper.distask.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment : Fragment(), View.OnClickListener {

    companion object{
        fun getLaunchService (from: Context) = Intent(from, NotesFragment::class.java).apply{
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        fun newInstance() =
            NotesFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fb_add_notes.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.fb_add_notes -> gotoNoteActivity()
        }
    }

    private fun gotoNoteActivity() {
        val intent = Intent(activity, AddNoteActivity::class.java)
        activity?.startActivity(intent)
    }

}