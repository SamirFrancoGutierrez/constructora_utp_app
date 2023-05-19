package com.example.constructora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.constructora.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.calculateButton.setOnClickListener {
            val costoBase = binding.costoBaseEditText.text.toString().toDouble()

            var precio = costoBase

            precio += when {
                binding.habitacionesPrincipalesSpinner.selectedItemPosition == 1 && binding.habitacionServicioCheckbox.isChecked -> costoBase * 0.05
                binding.habitacionesPrincipalesSpinner.selectedItemPosition == 2 && binding.habitacionServicioCheckbox.isChecked -> costoBase * 0.2
                binding.habitacionesPrincipalesSpinner.selectedItemPosition == 3 && binding.habitacionServicioCheckbox.isChecked -> costoBase * 0.35
                else -> 0.0
            }

            precio += when (binding.pisoSpinner.selectedItemPosition) {
                0 -> costoBase * 0.3
                1 -> costoBase * 0.24
                2 -> costoBase * 0.16
                3 -> costoBase * 0.08
                else -> 0.0
            }

            precio += if (binding.telefonoCheckbox.isChecked) 100.0 else 0.0
            precio += if (binding.termaCheckbox.isChecked) 800.0 else 0.0
            precio += if (binding.cocheraCheckbox.isChecked) 2500.0 else 0.0

            binding.precioTextView.text = String.format("%.2f", precio)
        }
    }
}