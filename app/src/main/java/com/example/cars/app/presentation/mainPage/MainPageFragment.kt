package com.example.cars.app.presentation.mainPage

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.presentation.mainPage.recycler.PostAdapter
import com.example.cars.utils.ext.appComponent
import kotlinx.android.synthetic.main.fragment_main_page.*

class MainPageFragment : Fragment(R.layout.fragment_main_page) {

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = MainPageFragment()
    }
    private val mainPageFragmentViewModel: MainPageFragmentViewModel by viewModels {
        requireActivity().appComponent.viewModelsFactory()
    }

    private val recycler by lazy {
        view?.findViewById<RecyclerView>(R.id.main_recycler)
    }

    private val adapter by lazy {
        PostAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        recycler?.adapter = adapter
        mainPageFragmentViewModel.posts.observe(viewLifecycleOwner) { posts ->
            progress.visibility = ProgressBar.INVISIBLE
            adapter.setItems(posts)
        }
    }

}