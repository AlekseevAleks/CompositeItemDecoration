package com.sibedge.compositeitemdecorator.adapter

import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
import com.sibedge.compositeitemdecorator.databinding.LayoutTitleItemBinding

class TitleAdapter : ViewBindingDelegateAdapter<TitleItem, LayoutTitleItemBinding>(
    LayoutTitleItemBinding::inflate
) {

    override fun isForViewType(item: Any) = item is TitleItem

    override fun TitleItem.getItemId() = title

    override fun LayoutTitleItemBinding.onBind(item: TitleItem) {
        title.text = item.title
    }
}