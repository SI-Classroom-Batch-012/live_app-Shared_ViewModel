package com.example.liveapplivedata.data

import com.example.liveapplivedata.data.model.Contact


class ContactDatasource {
    fun loadContacts(): List<Contact> {
        return listOf(
            Contact("John Doe", "123-456-7890"),
            Contact("Jane Smith", "987-654-3210"),
            Contact("Alice Johnson", "555-123-4567"),
            Contact("Bob Simmons", "888-777-6666"),
            Contact("Eva Nolan", "444-555-3333"),
            Contact("Michael Davis", "111-222-3333"),
            Contact("Linda Wilson", "777-888-9999"),
            Contact("David Clark", "555-777-8888"),
            Contact("Sarah Miller", "333-666-9999"),
            Contact("Robert Lee", "222-444-5555")
        )
    }

    val contacts: List<Contact> = listOf(
        Contact("John Doe", "123-456-7890"),
        Contact("Jane Smith", "987-654-3210"),
        Contact("Alice Johnson", "555-123-4567"),
        Contact("Bob Simmons", "888-777-6666"),
        Contact("Eva Nolan", "444-555-3333"),
        Contact("Michael Davis", "111-222-3333"),
        Contact("Linda Wilson", "777-888-9999"),
        Contact("David Clark", "555-777-8888"),
        Contact("Sarah Miller", "333-666-9999"),
        Contact("Robert Lee", "222-444-5555")
    )
}