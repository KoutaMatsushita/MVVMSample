package com.example.k_matsushita.mvvmsample

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.k_matsushita.mvvmsample.databinding.ActivityMainBinding

/**
 * 初期画面
 */
class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var mainViewModel: MainViewModel
    private val eventListAdapter by lazy { MainRecyclerAdapter(this@MainActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // ViewModel を取得します
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        lifecycle.addObserver(mainViewModel)

        // LiveData を監視し、Lifecycle.Event.ON_DESTROY 以外であればリストを更新します。
        mainViewModel.events.observe(this, Observer { eventListAdapter.events = it?.events })

        binding.viewModel = mainViewModel

        with(binding.eventList) {
            adapter = eventListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}
