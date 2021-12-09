package com.sibedge.compositeitemdecorator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import com.sibedge.compositeitemdecorator.adapter.*
import com.sibedge.compositeitemdecorator.base.adapter.BaseCompositeAdapter
import com.sibedge.compositeitemdecorator.base.item_decorator.CompositeItemDecoration
import com.sibedge.compositeitemdecorator.databinding.ActivityMainBinding
import com.sibedge.compositeitemdecorator.item_decorator.AddressDecorator
import com.sibedge.compositeitemdecorator.item_decorator.CheckBoxItemDecorator
import com.sibedge.compositeitemdecorator.item_decorator.PersonalInfoItemDecorator
import com.sibedge.compositeitemdecorator.item_decorator.TitleDecorator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter = BaseCompositeAdapter(
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
        binding.list.addItemDecoration(
            CompositeItemDecoration(
                TitleDecorator(this),
                PersonalInfoItemDecorator(this),
                AddressDecorator(),
                CheckBoxItemDecorator(this)
            )
        )
        adapter.swapData(MainViewModel().getItems())
    }

    private fun onButtonClick() {
        Log.d("CompositeLog", "Button clicked")
    }
}