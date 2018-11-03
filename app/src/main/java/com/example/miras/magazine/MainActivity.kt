package com.example.miras.magazine

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.miras.magazine.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.navigation_home -> {
                replaceFragment(HomeFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_cart -> {
                replaceFragment(CartFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_profile -> {
                replaceFragment(ProfileFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun replaceFragment (fragment : Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, HomeFragment.newInstance ())
            .commit()
    }
}
