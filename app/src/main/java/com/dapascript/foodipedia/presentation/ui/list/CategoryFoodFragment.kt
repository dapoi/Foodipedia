package com.dapascript.foodipedia.presentation.ui.list

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dapascript.foodipedia.databinding.FragmentCategoryFoodBinding
import com.dapascript.foodipedia.presentation.adapter.CategoriesAdapter
import com.dapascript.foodipedia.presentation.viewmodel.CategoriesViewModel
import com.dapascript.foodipedia.utils.BaseFragment
import com.dapascript.foodipedia.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFoodFragment : BaseFragment<FragmentCategoryFoodBinding>(
    FragmentCategoryFoodBinding::inflate
) {

    private val categoryViewModel: CategoriesViewModel by viewModels()
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initUI()
    }

    private fun initAdapter() {
        categoriesAdapter = CategoriesAdapter(
            onClick = {
                val name = it.strCategory.toString()
                findNavController().navigate(
                    CategoryFoodFragmentDirections.actionCategoryFoodFragmentToFoodFragment(name)
                )
            }
        )
        binding.rvCategory.apply {
            adapter = categoriesAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun initUI() {
        categoryViewModel.getFoodCategories.observe(viewLifecycleOwner) { response ->
            binding.apply {
                progressBar.isVisible = response is Resource.Loading
                rvCategory.isVisible = response is Resource.Success

                if (response is Resource.Success) {
                    categoriesAdapter.customList(response.data!!)

                    initSearch()
                }
            }
        }
    }

    private fun initSearch() {
        binding.svSearch.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val imm =
                    requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.svSearch.windowToken, 0)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                categoriesAdapter.filterList(newText)
                return true
            }
        })
    }
}