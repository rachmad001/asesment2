package org.d3if4025.assesment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.d3if4025.assesment.AdapterApi
import org.d3if4025.assesment.data.HasilPh
import org.d3if4025.assesment.databinding.ApiBinding
import org.d3if4025.assesment.network.ApiStatus

class ApiInternet : Fragment() {
    private lateinit var binding: ApiBinding

    private lateinit var myAdapterApi: AdapterApi

    private val viewModel: ApiViewModel by lazy {
        ViewModelProvider(this).get(ApiViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ApiBinding.inflate(layoutInflater, container, false)
        myAdapterApi = AdapterApi()
        with(binding.rvData){
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapterApi
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner) {
            myAdapterApi.updateData(it)
        }

        viewModel.getStatus().observe(viewLifecycleOwner) {
            updateProgress(it)
        }
    }

    private fun updateProgress(status: ApiStatus){
        when (status) {
            ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
            }
            ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }
}