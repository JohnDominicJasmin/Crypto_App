package com.example.crypto.feature_main_screen.domain.model

import com.example.crypto.feature_main_screen.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId:String,
    val name:String,
    val description:String,
    val symbol:String,
    val rank:Int,
    val team:List<TeamMember>,
    val isActive:Boolean,
    val tags:List<String>
)