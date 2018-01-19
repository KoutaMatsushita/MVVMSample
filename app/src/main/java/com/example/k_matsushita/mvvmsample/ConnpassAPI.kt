package com.example.k_matsushita.mvvmsample

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by k-matsushita on 2018/01/19.
 */
interface ConnpassAPI {
    @GET("api/v1/event/")
    fun event(): Observable<ConnpassEvent>
}