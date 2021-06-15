package disiiy.khaper.distask.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import disiiy.khaper.distask.R
import disiiy.khaper.distask.fragment.HomeFragment
import disiiy.khaper.distask.fragment.NotesFragment
import disiiy.khaper.distask.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        fun getLaunchService (from: Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.navigation_home ->{
                val fragment = HomeFragment.newInstance()
                implementFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_note ->{
                val fragment = NotesFragment()
                implementFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile ->{
                val fragment = ProfileFragment()
                implementFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation_menu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = HomeFragment.newInstance()
        implementFragment(fragment)
        supportActionBar?.hide()
    }

    private fun implementFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.content_main, fragment, fragment.javaClass.simpleName)
                .commit()
    }
}