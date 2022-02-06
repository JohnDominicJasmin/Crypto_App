package com.example.crypto.feature_coin.domain.model

import com.example.crypto.feature_coin.data.remote.dto.TeamMember

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