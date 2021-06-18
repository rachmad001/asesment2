package org.d3if4025.assesment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4025.assesment.db.PhDao
import java.lang.IllegalArgumentException

class PhViewModelFactory(private  val db: PhDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhViewModel::class.java)) {
            return PhViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}