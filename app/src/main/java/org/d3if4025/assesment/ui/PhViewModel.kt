package org.d3if4025.assesment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4025.assesment.db.PhDao
import org.d3if4025.assesment.db.PhEntity

class PhViewModel(private val db : PhDao) : ViewModel(){
    fun tambah(phEntity: PhEntity){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                db.insert(phEntity)
            }
        }
    }
}