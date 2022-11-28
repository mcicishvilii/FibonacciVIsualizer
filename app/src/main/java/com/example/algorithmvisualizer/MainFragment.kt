package com.example.algorithmvisualizer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.algorithmvisualizer.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val mainViewModel: MainViewModel by viewModels()





    override fun viewCreated() {

        viewLifecycleOwner.lifecycleScope.launch {
            fibo()
        }
    }

    override fun listeners() {

    }

    private suspend fun fibo(){
        val n = 20  
        var f0 = 0
        var f1 = 1

        for (i in 1..n){

            val sum = f0 + f1
            f0 = f1
            f1 = sum
            delay(500L)
            binding.tvText.text = f1.toString()
        }
    }


}
