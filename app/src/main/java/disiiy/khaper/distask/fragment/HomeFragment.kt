package disiiy.khaper.distask.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import disiiy.khaper.distask.R
import disiiy.khaper.distask.activity.AddTaskActivity
import disiiy.khaper.distask.activity.LoginActivity
import disiiy.khaper.distask.activity.MainActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profile.*

class HomeFragment : Fragment(), View.OnClickListener {

    companion object{
        fun getLaunchService (from: Context) = Intent(from, HomeFragment::class.java).apply{
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iv_ic_task.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.iv_ic_task -> gotoAddTask()
        }
    }

    private fun gotoAddTask() {
        val intent = Intent(activity, AddTaskActivity::class.java)
        activity?.startActivity(intent)
    }

}
