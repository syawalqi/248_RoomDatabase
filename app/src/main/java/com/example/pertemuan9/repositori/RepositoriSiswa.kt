package com.example.pertemuan9.repositori

import com.example.pertemuan9.room.SiswaDao

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>

    suspend fun insertSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(private val siswaDao: SiswaDao
) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = SiswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = SiswaDao.insert(siswa)
}