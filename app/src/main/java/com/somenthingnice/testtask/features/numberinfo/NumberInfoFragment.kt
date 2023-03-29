package com.somenthingnice.testtask.features.numberinfo

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.somenthingnice.testtask.R
import com.somenthingnice.testtask.core.ui.fragment.collect
import com.somenthingnice.testtask.core.ui.view.gone
import com.somenthingnice.testtask.core.ui.view.visible
import com.somenthingnice.testtask.core.ui.viewBinding.viewBinding
import com.somenthingnice.testtask.databinding.FragmentNumberInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberInfoFragment : Fragment(R.layout.fragment_number_info) {

    private val viewMode: NumberInfoViewModel by viewModels()

    private val binding: FragmentNumberInfoBinding by viewBinding()

    private val args: NumberInfoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewMode.searchNumberInfo(args.number)
    }


    private fun setupObservers() = with(viewMode) {
        collect(state, ::onStateChange)
    }

    private fun onStateChange(state: NumberInfoViewState) {
        when (state) {
            is NumberInfoViewState.Content -> bindContent(state)
            is NumberInfoViewState.Empty -> bindEmpty()
            is NumberInfoViewState.Error -> bindError()
            is NumberInfoViewState.Initial -> Unit
            is NumberInfoViewState.Loading -> bindLoading()
        }
    }

    private fun bindLoading() = with(binding) {
        progressBar.visible()
        errorView.gone()
        emptyView.gone()
        text.gone()
    }

    private fun bindContent(state: NumberInfoViewState.Content) = with(binding) {
        progressBar.gone()
        text.visible()
        errorView.gone()
        emptyView.gone()
        text.text = state.info
    }

    private fun bindEmpty() = with(binding) {
        progressBar.gone()
        text.gone()
        errorView.gone()
        emptyView.visible()
    }

    private fun bindError() = with(binding) {
        progressBar.gone()
        text.gone()
        errorView.visible()
        emptyView.gone()
    }
}