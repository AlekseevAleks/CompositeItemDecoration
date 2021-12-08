package com.sibedge.compositeitemdecorator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import com.sibedge.compositeitemdecorator.adapter.*
import com.sibedge.compositeitemdecorator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter = CompositeDelegateAdapter(
        TitleAdapter(),
        PersonalInfoAdapter(),
        AddressAdapter(),
        CheckBoxAdapter(),
        ButtonAdapter(::onButtonClick)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initList()
    }

    private fun initList() {
        binding.list.adapter = adapter
        adapter.swapData(MainViewModel().getItems())
    }

    private fun onButtonClick() {
        Log.d("CompositeLog", "Button clicked")
    }
}