package com.migulyaev.baseapplication.presentation.base.mvvm

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment

abstract class BaseMvvmFragment<V: BaseViewModel>(
    layoutId: Int
): Fragment(layoutId) {

    protected abstract val viewModel: V

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.observeErrors().observe(viewLifecycleOwner) {
            it?.tryGetValue()?.let(::showError)
        }
    }

    protected open fun showError(string: String) {
        Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show()
    }

}