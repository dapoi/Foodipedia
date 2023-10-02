package com.dapascript.foodipedia.presentation.ui.list

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.dapascript.foodipedia.databinding.FragmentFoodBinding
import com.dapascript.foodipedia.presentation.adapter.FoodAdapter
import com.dapascript.foodipedia.presentation.viewmodel.FoodListViewModel
import com.dapascript.foodipedia.utils.BaseFragment
import com.dapascript.foodipedia.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodFragment : BaseFragment<FragmentFoodBinding>(FragmentFoodBinding::inflate) {

    private val foodViewModel: FoodListViewModel by viewModels()
    private val args: FoodFragmentArgs by navArgs()
    private lateinit var foodAdapter: FoodAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initUI()
    }

    private fun initAdapter() {
        foodAdapter = FoodAdapter()
        binding.rvFood.apply {
            adapter = foodAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initUI() {
        binding.toolbar.apply {
            title = args.nameFood
            setNavigationOnClickListener { findNavController().popBackStack() }
        }

        foodViewModel.getFood.observe(viewLifecycleOwner) { response ->
            binding.apply {
                progressBar.isVisible = response is Resource.Loading
                rvFood.isVisible = response is Resource.Success

                if (response is Resource.Success) {
                    foodAdapter.setListFood(response.data)
                }
            }
        }
    }
}