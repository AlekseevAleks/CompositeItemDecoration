package com.sibedge.compositeitemdecorator.adapter

import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
import com.sibedge.compositeitemdecorator.R
import com.sibedge.compositeitemdecorator.databinding.LayoutButtonItemBinding
import com.sibedge.compositeitemdecorator.databinding.LayoutCheckboxItemBinding

class ButtonAdapter(
    private val onClickAction: () -> Unit
) : ViewBindingDelegateAdapter<ButtonItem, LayoutButtonItemBinding>(
    LayoutButtonItemBinding::inflate
) {

    override fun isForViewType(item: Any) = item is ButtonItem

    override fun ButtonItem.getItemId() = title

    override fun LayoutButtonItemBinding.onBind(item: ButtonItem) {
        button.text = item.title
        button.setOnClickListener { onClickAction.invoke() }
    }
}