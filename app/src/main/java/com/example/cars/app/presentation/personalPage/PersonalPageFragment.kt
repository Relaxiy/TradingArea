package com.example.cars.app.presentation.personalPage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cars.CarApplication
import com.example.cars.R
import com.example.cars.app.presentation.userPosts.UserPostsFragment
import com.example.cars.databinding.FragmentPersonalPageBinding
import com.example.cars.utils.ext.appComponent
import com.example.cars.utils.ext.openFragment
import com.google.firebase.firestore.auth.User
import javax.inject.Inject

class PersonalPageFragment : Fragment(R.layout.fragment_personal_page) {

    companion object {
        const val TAG = "PersonalPageFragment"
        fun newInstance() = PersonalPageFragment()
    }

    private val binding: FragmentPersonalPageBinding by viewBinding()

    private val personalPageFragmentViewModel: PersonalPageFragmentViewModel by viewModels {
        requireActivity().appComponent.viewModelsFactory()
    }

    @Inject
    lateinit var userSharedViewModel: UserSharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CarApplication.appComponentWithSharedViewModel.inject(this)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindAccount()
        toUserPosts()
    }

    private fun toUserPosts() {
        binding.userPosts.setOnClickListener {
            requireActivity().openFragment(
                UserPostsFragment.newInstance(),
                UserPostsFragment.TAG,
                R.id.container
            )
        }
    }

    private fun bindAccount() {
        userSharedViewModel.account.observe(viewLifecycleOwner){ account ->
            binding.username.setText(account.username)
            binding.email.setText(account.email)
            binding.birthday.setText(account.birthday)
            binding.createdAt.text = account.createdAt
            binding.phoneNumber.setText(account.phoneNumber)
        }
    }


}