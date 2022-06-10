package com.example.cars.app.presentation.addPost

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cars.R
import com.example.cars.app.presentation.mainPage.MainPageFragment
import com.example.cars.app.presentation.addPost.recycler.HorizontalImageAdapter
import com.example.cars.app.presentation.addPost.actionSelector.CreateUserPostResult.*
import com.example.cars.app.presentation.userPosts.UserPostsFragment
import com.example.cars.databinding.FragmentAddPostBinding
import com.example.cars.utils.ext.appComponent
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.openFragment
import com.example.cars.utils.ext.parsePhoneNumber
import com.example.cars.utils.sharedPrefs.SharedPreferencesManager
import kotlinx.android.synthetic.main.fragment_add_post.*
import javax.inject.Inject

class AddPostFragment : Fragment(R.layout.fragment_add_post) {

    companion object {
        const val TAG = "AddCarFragment"
        fun newInstance() = AddPostFragment()
    }

    private val binding: FragmentAddPostBinding by viewBinding()

    @Inject
    lateinit var sharedPreferences: SharedPreferencesManager

    private val addPostFragmentViewModel: AddPostFragmentViewModel by viewModels {
        requireActivity().appComponent.viewModelsFactory()
    }

    private val recycler by lazy {
        binding.addCarRecycler
    }

    private val adapter by lazy {
        HorizontalImageAdapter(requireActivity().activityResultRegistry)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().appComponent.inject(this)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addPhoneNumber.parsePhoneNumber()
        initRecycler()
        sendPost()
    }


    private fun initRecycler() {
        recycler.adapter = adapter
    }

    private fun sendPost() {
        sendPost.setOnClickListener {
            addPostFragmentViewModel.savePost(
                userId = sharedPreferences.getDocumentPath(),
                images = null,
                title = binding.addTitle.text.toString(),
                description = binding.addDescription.text.toString(),
                price = binding.addPrice.text.toString(),
                personName = binding.addName.text.toString(),
                email = binding.addEmail.text.toString(),
                phoneNumber = binding.addPhoneNumber.text.toString()
            )
        }

        addPostFragmentViewModel.validateUserPostResponse.observe(viewLifecycleOwner) { createUserPostResult ->
            when (createUserPostResult) {
                is PostCreationSuccess -> {
                    Toast.makeText(requireContext(), createUserPostResult.success, Toast.LENGTH_LONG).show()
                    requireActivity().apply {
                        openFragment(
                            UserPostsFragment.newInstance(),
                            UserPostsFragment.TAG,
                            R.id.container
                        )
                    }
                }
                is PostCreationFailed -> {
                    requireActivity().dialog(createUserPostResult.failed)
                }
            }
        }
    }

}