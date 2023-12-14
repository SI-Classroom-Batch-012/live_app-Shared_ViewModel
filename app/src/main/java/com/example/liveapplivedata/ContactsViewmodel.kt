package com.example.liveapplivedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liveapplivedata.data.ContactDatasource
import com.example.liveapplivedata.data.model.Contact

class ContactsViewmodel: ViewModel() {

    private val datasource = ContactDatasource()
    private val allContacts = datasource.contacts


    private val _filteredContacts: MutableLiveData<List<Contact>> = MutableLiveData(allContacts)
    val filteredContacts: LiveData<List<Contact>>
        get() = _filteredContacts


    //LiveData für das angeklickte Objekt, ist am Anfang leer
    //Wird von DetailFragment observed
    private val _currentContact: MutableLiveData<Contact> = MutableLiveData()
    val currentContact: LiveData<Contact>
        get() = _currentContact

    //UI Event verarbeiten
    //Wird von ContacsFragment aufgerufen
    fun selectCurrentContact(contact: Contact){

        //_currentContact.value = contact
        _currentContact.postValue(contact)

    }



    //Wird einmal ausgeführt wenn das ViewModel erstellt wird
    init {
        Log.d("DatenTest1", allContacts.toString())
    }


    //Funktion die einen String erhält, Alle Kontakte mit diesem String im Namen filtert
    //Und das Ergebnis in die filteredContacs LiveData schreibt
    fun filterContacts(input: String) {

        val filteredList = allContacts.filter {contact ->
            contact.name.contains(input) || contact.phoneNumber.contains(input)
        }

        _filteredContacts.value = filteredList

    }


}