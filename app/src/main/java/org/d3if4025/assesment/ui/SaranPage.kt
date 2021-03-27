package org.d3if4025.assesment.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if4025.assesment.R
import org.d3if4025.assesment.databinding.SaranpageBinding

class SaranPage : Fragment() {
    private lateinit var binding: SaranpageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = SaranpageBinding.inflate(layoutInflater, container, false)
        val tanaman = arguments?.getString("jenis")
        val ph = arguments?.getFloat("ph", 0.0f)
        Log.d("tree", tanaman.toString())
        Log.d("ph", ph.toString())
        if (tanaman != null && ph != null) {
                recomended(tanaman, ph)
        }
        return binding.root
    }

    private fun recomended(tanaman: String, ph: Float){
        if (tanaman.equals("brokoli")){
            binding.photo.setImageResource(R.drawable.brokoli)
            binding.detailtv.setText(R.string.brokolidetail)
            var rekomendasi = "ph sekarang : " + "%.2f".format(ph) + "\n"
            rekomendasi = rekomendasi + "rekomendasi : ph 6.0 - 6.8"
            binding.rekomendasi.setText(rekomendasi)
        }
        else if (tanaman.equals("bayam")){
            binding.photo.setImageResource(R.drawable.bayam)
            binding.detailtv.setText(R.string.bayamdetail)
            var rekomendasi = "ph sekarang : " + "%.2f".format(ph) + "\n"
            rekomendasi = rekomendasi + "rekomendasi : ph 6.0 - 7.0"
            binding.rekomendasi.setText(rekomendasi)
        }
        else {
            binding.photo.setImageResource(R.drawable.kubis)
            binding.detailtv.setText(R.string.kubisdetail)
            var rekomendasi = "ph sekarang : " + "%.2f".format(ph) + "\n"
            rekomendasi = rekomendasi + "rekomendasi : ph 6.5 - 7.0"
            binding.rekomendasi.setText(rekomendasi)
        }
    }
}