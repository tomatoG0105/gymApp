package com.georgegipa.gym.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.georgegipa.gym.R
import com.georgegipa.gym.api.ApiResponses
import com.georgegipa.gym.databinding.FragmentMyProfileBinding
import com.georgegipa.gym.ui.MainActivity
import com.georgegipa.gym.ui.StartActivity
import com.georgegipa.gym.utils.calculateEndDate
import com.georgegipa.gym.utils.clearUserCredentials

class MyProfileFragment : Fragment(R.layout.fragment_my_profile) {
    private var _binding: FragmentMyProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).changeGreetingTitleBar("${ApiResponses.user.name}'s Profile")

        Glide.with(requireContext()).load(ApiResponses.user.image).into(binding.userImage)
        val endDate = "Plan End Date: " + calculateEndDate(
            ApiResponses.user.registeredDate,
            ApiResponses.plans.find { it.id == ApiResponses.user.plan }!!.duration
        )

        val name = ApiResponses.user.name + " " + ApiResponses.user.lastname
        binding.usernameTv.text = name
        binding.emailTv.text = ApiResponses.user.email
        binding.addressTv.text = ApiResponses.user.address
        binding.planEndDateTv.text = endDate

        val userPlan = ApiResponses.plans.find { it.id == ApiResponses.user.plan }!!

        Glide.with(requireContext()).load(userPlan.image).into(binding.planIv)
        binding.planNameTv.text = userPlan.name

        binding.logoutBtn.setOnClickListener {
            requireContext().clearUserCredentials()
            startActivity(Intent(requireContext(), StartActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
