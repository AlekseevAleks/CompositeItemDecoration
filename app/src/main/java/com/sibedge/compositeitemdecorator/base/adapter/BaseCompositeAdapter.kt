package com.sibedge.compositeitemdecorator.base.adapter

import com.livermor.delegateadapter.delegate.CompositeDelegateAdapter
import com.livermor.delegateadapter.delegate.DelegateAdapter

class BaseCompositeAdapter(vararg adapters: DelegateAdapter) : CompositeDelegateAdapter(*adapters) {

    fun getItem(position: Int): Any? {
        return if (position in adapterState.data.indices) adapterState.data[position] else null
    }
}