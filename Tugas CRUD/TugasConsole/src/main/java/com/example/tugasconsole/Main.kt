package com.example.tugasconsole

import java.util.Scanner

data class DataRecord(val key: String, var value: String)

class Student(idInput: String, nameInput: String) {
    val nim: String = idInput
    var name: String = nameInput
        get() = field.uppercase()
        set(value) {
            field = value.trim()
        }
    var major: String? = null
}

fun main() {
    val input = Scanner(System.`in`)

    val studentList = ArrayList<Student>()
    var isRunning = true
    val programTitle = "SISTEM MANAJEMEN MAHASISWA"

    println("=== $programTitle ===")

    while (isRunning) {
        println("MENU")
        println("1. Tambah Mahasiswa (Create)")
        println("2. Lihat Semua Mahasiswa (Read)")
        println("3. Update Nama Mahasiswa (Update)")
        println("4. Hapus Mahasiwa (Delete)")
        println("5. Tampilkan Statistik")
        println("0. Keluar")
        print("Pilihan: ")

        val option: Int = readLine()?.toIntOrNull() ?: -1

        when (option) {
            1 -> {
                print("Masukkan NIM: ")
                val nim = readLine() ?: ""
                print("Masukkan Nama: ")
                val name = readLine() ?: ""
                val newStudent = Student(nim, name)

                print("Masukkan Prodi (boleh dikosongkan): ")
                val majorInput = readLine()
                newStudent.major = if (majorInput.isNullOrBlank()) null else majorInput

                studentList.add(newStudent)
                println("Mahasiswa berhasil ditambahkan!")
            }
            2 -> {
                println("Daftar Mahasiswa:")
                if (studentList.isEmpty()) {
                    println("Belum ada data.")
                } else {
                    studentList.forEachIndexed { index, student ->
                        val infoMajor = student.major ?: "Belum Diatur"
                        println("${index + 1}. NIM: ${student.nim}, Nama: ${student.name}, Prodi: $infoMajor")
                    }
                }
            }
            3 -> {
                print("Masukkan nomor urut yang akan diubah: ")
                val index = (readLine()?.toIntOrNull() ?: 0) - 1

                if (index in 0 until studentList.size) {
                    print("Masukkan nama baru: ")
                    val newName = readLine() ?: ""
                    studentList[index].name = newName
                    println("Nama mahasiswa berhasil diubah!")
                } else {
                    println("Nomor urut tidak valid.")
                }
            }
            4 -> {
                print("Masukkan nomor urut yang akan dihapus: ")
                val index = (readLine()?.toIntOrNull() ?: 0) - 1

                if (index in 0 until studentList.size) {
                    studentList.removeAt(index)
                    println("Data Mahasiswa berhasil dihapus!")
                } else {
                    println("Nomor urut tidak valid.")
                }
            }
            5 -> {
                println("RINGKASAN DATA")
                for (student in studentList) {
                    val record = DataRecord(student.nim, student.name)
                    println("Record: $record")
                }
            }
            0 -> {
                isRunning = false
                println("Program selesai. Sampai jumpa!")
            }
            else -> {
                println("Pilihan tidak valid. Silakan coba lagi.")
            }

        }
    }
}
