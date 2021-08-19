package com.example.stateflowdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MainActivityVM::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCountObserver()
        initView()
    }
    private fun initCountObserver() {

        lifecycleScope.launch {
            viewModel.countState.collect {
                textview_count.text="$it"
            }
        }

        lifecycleScope.launch {
            viewModel.countShared.collect {
                textviewCountShared.text="$it"
            }
        }
    }

    private fun initView() {
        button_plus.setOnClickListener {
            viewModel.incrementCount()
        }
        button_minus.setOnClickListener{
            viewModel.decrementCount()
        }

        button_minus_shared.setOnClickListener {
            viewModel.decrementSharedCount()
        }
        button_plus_shared.setOnClickListener {
            viewModel.incrementSharedCount()
        }
    }
}