package com.example.k_matsushita.mvvmsample

import android.arch.lifecycle.*
import android.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

/**
 * [MainActivity] の View の状態
 *
 * Created by k-matsushita on 2018/01/19.
 */
class MainViewModel : ViewModel(), LifecycleObserver {

    val events = MutableLiveData<ConnpassEvent>()
    // ロード中かどうか
    val isLoading = ObservableField<Boolean>(false)

    private val disposeBug = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getEventList() {
        NetUtil.connpassAPI.event()
                .doOnSubscribe { isLoading.set(true) }
                .doFinally { isLoading.set(false) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            events.value = it
                        }
                ).addTo(disposeBug)
    }

    override fun onCleared() {
        super.onCleared()
        disposeBug.clear()
    }
}