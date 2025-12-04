package com.example.pertemuan9.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan9.repositori.AplikasiSiswa
import com.example.pertemuan9.viewmodel.DetailViewModel
import com.example.pertemuan9.viewmodel.EntryViewModel
import com.example.pertemuan9.viewmodel.HomeViewModel

/**
 * Menyediakan objek [ViewModelProvider.Factory] untuk pembuatan instance [HomeViewModel] dan [EntryViewModel]
 */
object PenyediaViewModel {
    val Factory = viewModelFactory {
        // Initializer untuk HomeViewModel
        initializer {
            HomeViewModel(
                aplikasiSiswa().containerApp.repositoriSiswa
            )
        }
        // Initializer untuk EntryViewModel
        initializer {
            EntryViewModel(
                aplikasiSiswa().containerApp.repositoriSiswa
            )
        }
        initializer {
            DetailViewModel(this.createSavedStateHandle(), aplikasiSiswa().containerApp.repositoriSiswa
            )
        }

    }
}

/**
 * Fungsi ekstensi untuk mendapatkan instance [AplikasiSiswa] dari [CreationExtras]
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)