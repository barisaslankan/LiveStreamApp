package com.barisaslankan.livestreamapp.data.remote.dto

import com.barisaslankan.livestreamapp.domain.model.Webcam

data class WebcamDTO(
    val categories: List<Category>,
    val images: İmages,
    val lastUpdatedOn: String,
    val location: Location,
    val player: Player,
    val status: String,
    val title: String,
    val urls: Urls,
    val viewCount: Int,
    val webcamId: Int
)
fun mapWebcamDTOToWebcam(dto: WebcamDTO): Webcam {
    val location = "${dto.location.city}, ${dto.location.country}"
    val liveStreamUrl = dto.player.live

    return Webcam(
        title = dto.title,
        location = location,
        liveStreamUrl = liveStreamUrl,
        lastUpdatedOn = dto.lastUpdatedOn,
        viewCount = dto.viewCount
    )
}
