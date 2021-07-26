package com.example.harajtask.presentation.post.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.R
import com.example.harajtask.databinding.FragmentPostBinding
import com.example.harajtask.presentation.BaseViewModel
import com.example.harajtask.presentation.util.toast


class PostFragment : Fragment(R.layout.fragment_post) {

    companion object {
        private const val TAG = "PostFragment"
    }

    private val viewModel by activityViewModels<BaseViewModel>()
    private lateinit var binding: FragmentPostBinding
    private val postAdapter by lazy {
        PostAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostBinding.bind(view)
        setHasOptionsMenu(true)
        initRecyclerViews()
        onGetPosts()
    }

    /**
     * function to initialize RecyclerViews
     */
    private fun initRecyclerViews() {
        binding.apply {
            rvPost.apply {

                adapter = postAdapter

                layoutManager = LinearLayoutManager(
                    context
                )

                overScrollMode = RecyclerView.OVER_SCROLL_NEVER

                // onClick listener to make levels expandable
                postAdapter.event.observe(viewLifecycleOwner, Observer {
                    when (it) {
                        is PostItemEvent.OnPostItemClick -> {
                          requireActivity().toast("${it.postItem}")
                        }
                    }
                })
            }
        }
    }

    private fun onGetPosts(){
        viewModel.apply {
            getPosts().observe(viewLifecycleOwner, Observer { list->
                postAdapter.submitList(list)
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.post_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                requireActivity().toast("search")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}