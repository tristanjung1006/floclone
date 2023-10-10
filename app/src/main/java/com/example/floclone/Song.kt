package com.example.floclone

// title: 음악이름, singer: 가수이름,
// second: 현재 재생중인 시간, playTime: 총 시간, isPlaying: 현재 음악 재생 상태값
data class Song(
    val title : String = "",
    val singer : String = "",
    var second: Int = 0,
    var playTime: Int = 0,
    var isPlaying: Boolean = false
)
