package org.d3if4025.assesment.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.d3if4025.assesment.data.HasilPh
import org.d3if4025.assesment.network.ApiStatus
import org.d3if4025.assesment.network.PhApi

class ApiViewModel: ViewModel() {
    private val data = MutableLiveData<List<HasilPh>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData(){
        viewModelScope.launch {
            status.value = ApiStatus.LOADING
            try {
                data.value = PhApi.service.getPh()
                status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {
                Log.d("MainApiViewModel", "failure: ${e.message}")
                status.value = ApiStatus.FAILED
            }
        }
    }

    fun getData(): LiveData<List<HasilPh>> = data
    fun getStatus(): LiveData<ApiStatus> = status
}