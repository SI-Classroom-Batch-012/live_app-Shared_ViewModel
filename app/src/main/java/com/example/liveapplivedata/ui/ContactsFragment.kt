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
import com.example.liveapplivedata.ui.adapter.ContactAdapter


class ContactsFragment : Fragment() {

    //Im Fragment immer "by activityViewModels()"
    private val viewmodel: ContactsViewmodel by activityViewModels()
    private lateinit var binding: FragmentContactsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentContactsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Wird einmal ausgeführt wenn die App startet UND immer wenn sich die Daten ändern
        viewmodel.filteredContacts.observe(viewLifecycleOwner) { filteredContacts ->

            Log.d("DatenTest3", filteredContacts.toString())

            val adapter = ContactAdapter(filteredContacts, viewmodel)
            binding.contactsRV.adapter = adapter


        }

        //Kurzschreibweise für TextWatcher, benutzt nur "afterTextChanged"
        binding.filterET.addTextChangedListener {
            val input = it.toString()
            viewmodel.filterContacts(input)
        }



        //User Input simulieren
//        val userInput = "a"

        //Dieser Code wäre normalerweise im onTextChangedListener
//        viewmodel.filterContacts(userInput)



    }


}