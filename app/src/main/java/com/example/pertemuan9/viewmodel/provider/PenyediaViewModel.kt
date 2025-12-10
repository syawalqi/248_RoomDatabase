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

/**
 * Menyediakan ViewModelProvider.Factory untuk ViewModel (Home, Entry, Detail, Edit)
 */
object PenyediaViewModel {

    val Factory = viewModelFactory {

        // HomeViewModel
        initializer {
            HomeViewModel(
                aplikasiSiswa().container.repoSiswa
            )
        }

        // EntryViewModel
        initializer {
            EntryViewModel(
                aplikasiSiswa().container.repoSiswa
            )
        }

        // DetailViewModel
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().container.repoSiswa
            )
        }

        // EditViewModel
        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().container.repoSiswa
            )
        }
    }
}

/**
 * Mengambil instance AplikasiSiswa dari CreationExtras
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
