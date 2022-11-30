package com.example.algorithmvisualizer.ui.screens

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.algorithmvisualizer.data.Numbers
import com.example.algorithmvisualizer.NumbersAdapter
import com.example.algorithmvisualizer.base.BaseFragment
import com.example.algorithmvisualizer.databinding.FragmentMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val TAG = "misho"
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val mainViewModel: MainViewModel by viewModels()
    private val myAdapter: NumbersAdapter by lazy { NumbersAdapter() }

    val list = mutableListOf<Numbers>()


    override fun viewCreated() {
        setupRecycler()

    }

    override fun listeners() {
        binding.btn.setOnClickListener {
            val choise = binding.etSize.text.toString()

            viewLifecycleOwner.lifecycleScope.launch {
                if (list.isEmpty()){
                    displayFibo(choise)
                }
                else{
                    list.clear()
                    displayFibo(choise)
                }

            }
        }
    }

    private fun setupRecycler() {
        binding.rvNumbers.apply {
            adapter = myAdapter
            layoutManager =
                GridLayoutManager(
                    requireContext(),
                    4,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }
    private suspend fun displayFibo(n:String){
        var f0 = 0
        var f1 = 1

        for (i in 1..n.toInt()){
            val sum = f0 + f1
            f0 = f1
            f1 = sum
            delay(500L)
            list.add(Numbers(f1))
            myAdapter.submitList(list.toList())
        }
    }

}
