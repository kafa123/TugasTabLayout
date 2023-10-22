package com.example.tugastablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tugastablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    companion object
    {
        private val TAB_TITLES= intArrayOf(
            R.string.Register,
            R.string.Login
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val sectionPager = FragmentAdapter(this@MainActivity)
            val viewPager: ViewPager2 = findViewById(R.id.view_pager)
            viewPager.adapter=sectionPager
            TabLayoutMediator(TabLayout,viewPager){
                    tab,position->tab.text= resources.getString((TAB_TITLES[position]))
            }.attach()



        }
    }
}