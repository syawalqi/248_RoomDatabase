package com.example.pertemuan9.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan9.repositori.RepositoriSiswa
import com.example.pertemuan9.view.route.DestinasiDetailSiswa
import kotlinx.coroutines.flow.*

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {

    private val idSiswa: Int =
        checkNotNull(savedStateHandle[DestinasiDetailSiswa.itemIdArg])

    val uiDetailState: StateFlow<DetailSiswaUiState> =
        repositoriSiswa.getSiswaStream(idSiswa)
            .filterNotNull()
            .map {
                DetailSiswaUiState(detailSiswa = it.toDetailSiswa())
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailSiswaUiState()
            )

    suspend fun deleteSiswa() {
        repositoriSiswa.deleteSiswa(uiDetailState.value.detailSiswa.toSiswa())
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * UI State untuk Detail Screen
 */
data class DetailSiswaUiState(
    val detailSiswa: DetailSiswa = DetailSiswa()
)
