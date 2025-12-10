package com.example.pertemuan9.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan9.repositori.AplikasiSiswa
import com.example.pertemuan9.viewmodel.EntryViewModel
import com.example.pertemuan9.viewmodel.HomeViewModel
import com.example.pertemuan9.viewmodel.DetailViewModel
import com.example.pertemuan9.viewmodel.EditViewModel

object PenyediaViewModel {

    val Factory = viewModelFactory {

        // HomeViewModel
        initializer {
            HomeViewModel(
                aplikasiSiswa().containerApp.repositoriSiswa
            )
        }

        // EntryViewModel
        initializer {
            EntryViewModel(
                aplikasiSiswa().containerApp.repositoriSiswa
            )
        }

        // DetailViewModel
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().containerApp.repositoriSiswa
            )
        }

        // EditViewModel
        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().containerApp.repositoriSiswa
            )
        }
    }
}

/**
 * Mengambil instance AplikasiSiswa dari CreationExtras
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
