package com.example.pertemuan9.view.route

import com.example.pertemuan9.R

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "edit_siswa"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}
