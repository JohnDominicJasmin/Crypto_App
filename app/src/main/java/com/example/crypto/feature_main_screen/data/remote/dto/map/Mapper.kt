package com.example.crypto.feature_main_screen.data.remote.dto.map

interface Mapper<in I, out O> {
    fun I.map(input: I): O
}