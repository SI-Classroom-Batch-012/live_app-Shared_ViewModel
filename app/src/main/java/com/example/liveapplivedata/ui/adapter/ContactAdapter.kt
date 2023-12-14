package com.example.liveapplivedata.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.liveapplivedata.ContactsViewmodel
import com.example.liveapplivedata.data.model.Contact
import com.example.liveapplivedata.databinding.ListItemBinding
import com.example.liveapplivedata.ui.ContactsFragmentDirections

class ContactAdapter(
    var dataset: List<Contact>,
    val viewmodel: ContactsViewmodel
) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        //Kontakt der in den holder geladen werden soll
        val contact = dataset[position]

        val binding = holder.binding

        //Werte des Kontakts in die einzelnen Views laden
        binding.nameTV.text = contact.name
        binding.numberTV.text = contact.phoneNumber

        binding.contactCV.setOnClickListener {

            viewmodel.selectCurrentContact(contact)

            val navController = holder.itemView.findNavController()
            navController.navigate(ContactsFragmentDirections.actionContactsFragmentToDetailFragment())

        }

    }
}