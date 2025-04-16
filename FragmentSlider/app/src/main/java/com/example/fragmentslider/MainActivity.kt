package com.example.fragmentslider

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.activity.enableEdgeToEdge


class MainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val fragmentList = ArrayList<Fragment>()

        fragmentList.add(SimpleFragment.newInstance("1"))
        fragmentList.add(SimpleFragment.newInstance("2"))
        fragmentList.add(SimpleFragment.newInstance("3"))

        val pageAdapter = SimpleFragmentPagerAdapter(
            supportFragmentManager, fragmentList
        )

        val pager = findViewById<View>(R.id.pager) as ViewPager
        pager.adapter = pageAdapter
    }

    private inner class SimpleFragmentPagerAdapter
    // A constructor to receive a fragment manager
        (fm: FragmentManager,
        // An ArrayList to hold our fragments
         private val fragments: ArrayList<Fragment>)
        : FragmentPagerAdapter(fm) {

        // Just two methods to override to get the current
        // position of the adapter and the size of the List
        override fun getItem(position: Int): Fragment {
            return this.fragments[position]
        }

        override fun getCount(): Int {
            return this.fragments.size
        }
    }
}

