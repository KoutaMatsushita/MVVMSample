package com.example.k_matsushita.mvvmsample

import com.google.gson.annotations.SerializedName

/**
 * https://connpass.com/about/api/
 *
 * Created by k-matsushita on 2018/01/19.
 */

data class ConnpassEvent(
        @SerializedName("results_returned")
        val resultsReturned: Long,
        @SerializedName("results_available")
        val resultsAvailable: Long,
        @SerializedName("results_start")
        val resultsStart: Long,
        val events: List<Event>

) {
    data class Event(
            @SerializedName("event_id")
            val eventId: Long,
            val title: String,
            val catch: String,
            val description: String,
            @SerializedName("event_url")
            val eventUrl: String,
            @SerializedName("hash_tag")
            val hashTag: String,
            @SerializedName("started_at")
            val startedAt: String, // TODO Date でパースする
            @SerializedName("ended_at")
            val endedAt: String, // TODO Date でパースする
            val limit: Long,
            @SerializedName("event_type")
            val event_type: String,
            val series: Series,
            val address: String,
            val place: String,
            val lat: Double,
            val lon: Double,
            @SerializedName("owner_id")
            val ownerId: Long,
            @SerializedName("owner_nickname")
            val ownerNickname: String,
            @SerializedName("owner_display_name")
            val ownerDisplayName: String,
            val accepted: Long,
            val waiting: Long,
            @SerializedName("updated_at")
            val updatedAt: String // TODO Date でパースする
    ) {
        data class Series(
                val id: Long,
                val title: String,
                val url: String
        )
    }
}

