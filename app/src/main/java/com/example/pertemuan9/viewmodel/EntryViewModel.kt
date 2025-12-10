package com.example.pertemuan9.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pertemuan9.repositori.RepositoriSiswa
import com.example.pertemuan9.room.Siswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa) : ViewModel() {

    /**
     * Berisi status Siswa saat ini
     */
    var uiStateSiswa by mutableStateOf(UiStateSiswa())
        private set

    /**
     * Validasi input data
     */
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UiStateSiswa(
            detailSiswa = detailSiswa,
            isEntryValid = validasiInput(detailSiswa)
        )
    }

    /**
     * Menyimpan data siswa
     */
    suspend fun saveSiswa() {
        if (validasiInput()) {
            repositoriSiswa.insertSiswa(uiStateSiswa.detailSiswa.toSiswa())
        }
    }
}

/**
 * UI State untuk form siswa
 */
data class UiStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

/**
 * Data untuk kebutuhan UI (form)
 */
data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val email: String = "",
    val telpon: String = ""
)

/**
 * Konversi dari UI → Entity
 */
fun DetailSiswa.toSiswa(): Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

/**
 * Konversi dari Entity → UI
 */
fun Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

/**
 * Konversi Entity → UiStateSiswa
 */
fun Siswa.toUiStateSiswa(isEntryValid: Boolean = false): UiStateSiswa =
    UiStateSiswa(
        detailSiswa = this.toDetailSiswa(),
        isEntryValid = isEntryValid
    )
