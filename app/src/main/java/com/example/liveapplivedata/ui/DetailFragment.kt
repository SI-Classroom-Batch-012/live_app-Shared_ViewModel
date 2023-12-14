package com.example.liveapplivedata.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.liveapplivedata.ContactsViewmodel
import com.example.liveapplivedata.R
import com.example.liveapplivedata.databinding.FragmentContactsBinding
import com.example.liveapplivedata.databinding.FragmentDetailBinding
import com.example.liveapplivedata.ui.adapter.ContactAdapter


class DetailFragment : Fragment() {

    //Im Fragment immer "by activityViewModels()"
    private val viewmodel: ContactsViewmodel by activityViewModels()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewmodel.currentContact.observe(viewLifecycleOwner) {


            binding.contactNameTV.text = it.name

        }



    }


}