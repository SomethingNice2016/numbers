package com.somenthingnice.testtask.features.home

import android.os.Bundle
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.somenthingnice.testtask.R
import com.somenthingnice.testtask.core.ui.fragment.collect
import com.somenthingnice.testtask.core.ui.fragment.showShortToast
import com.somenthingnice.testtask.core.ui.viewBinding.viewBinding
import com.somenthingnice.testtask.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), TextView.OnEditorActionListener {


    private val binding: FragmentHomeBinding by viewBinding()

    private val viewModel: HomeViewModel by viewModels()

    private val navigator by lazy {
        findNavController()
    }

    private val historyAdapter by lazy {
        HistoryAdapter { item ->
            navigator.navigate(HomeFragmentDirections.toInfo(item.number))
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupListeners()
        setupObservers()
    }

    private fun setupUI() = with(binding) {
        numberSearch.filters = arrayOf<InputFilter>(LengthFilter(Long.MAX_VALUE.toString().lastIndex))
        historyList.adapter = historyAdapter
        historyList.layoutManager = LinearLayoutManager(context)
    }

    private fun setupListeners() = with(binding) {
        numberSearch.setOnEditorActionListener(this@HomeFragment)
    }

    private fun setupObservers() = with(viewModel) {
        collect(state, ::onStateChange)
        collect(event, ::onEvent)
    }

    private fun onStateChange(state: HomeViewModel.State) {
        when (state) {
            is HomeViewModel.State.Content -> bindContent(state)
            is HomeViewModel.State.Empty -> bindEmpty()
            is HomeViewModel.State.Idle -> Unit
        }
    }

    //TODO move to string res
    private fun onEvent(event: HomeViewModel.Event) {
        when (event) {
            is HomeViewModel.Event.OnSaveError -> showShortToast("Щось пішло не так")
            is HomeViewModel.Event.OnSaveSuccess -> navigator.navigate(
                HomeFragmentDirections.toInfo(
                    event.number
                )
            )
        }
    }

    private fun bindContent(content: HomeViewModel.State.Content) = with(binding) {
        emptyView.isVisible = false
        historyList.isVisible = true
        historyAdapter.submitList(content.history)
    }

    private fun bindEmpty() = with(binding) {
        emptyView.isVisible = true
        historyList.isVisible = false
    }


    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            viewModel.saveToHistory(binding.numberSearch.text.toString().toLong())
            return true;
        }
        return false;
    }


}