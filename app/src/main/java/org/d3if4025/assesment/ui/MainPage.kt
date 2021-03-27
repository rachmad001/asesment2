package org.d3if4025.assesment.ui

import android.os.Bundle
import android.view.*
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import org.d3if4025.assesment.R
import org.d3if4025.assesment.databinding.MainPageBinding

class MainPage : Fragment() {
    private lateinit var binding: MainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainPageBinding.inflate(layoutInflater, container, false)
        binding.cek.setOnClickListener { cek() }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun cek(){
        if (binding.jenis.checkedRadioButtonId == -1){
            Toast.makeText(context,"jenis tumbuhan belum dipilih", Toast.LENGTH_SHORT).show()
        }
        else if (binding.ph.text.toString().isEmpty()){
            Toast.makeText(context,"kadar ph kosong", Toast.LENGTH_SHORT).show()
        }
        else {
            var jenis = when {
                binding.bayam.isChecked -> "bayam"
                binding.brokoli.isChecked -> "brokoli"
                else -> "kubis"
            }
            val bundle = Bundle()
            bundle.putString("jenis", jenis)
            bundle.putFloat("ph", binding.ph.text.toString().toFloat())
            findNavController().navigate(R.id.action_mainPage2_to_saranPage, bundle)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about){
            findNavController().navigate(R.id.action_mainPage2_to_aboutPage)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}