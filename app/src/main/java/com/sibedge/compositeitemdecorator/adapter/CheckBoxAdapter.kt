package com.sibedge.compositeitemdecorator.adapter

import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
import com.sibedge.compositeitemdecorator.R
import com.sibedge.compositeitemdecorator.databinding.LayoutCheckboxItemBinding

class CheckBoxAdapter : ViewBindingDelegateAdapter<CheckBoxItem, LayoutCheckboxItemBinding>(
    LayoutCheckboxItemBinding::inflate
) {

    override fun isForViewType(item: Any) = item is CheckBoxItem

    override fun CheckBoxItem.getItemId() = title

    override fun LayoutCheckboxItemBinding.onBind(item: CheckBoxItem) {
        title.text = item.title
        checkIcon.setImageResource(
            if (item.checked) R.drawable.ic_summary_checked else R.drawable.ic_summary_unchecked
        )
    }
}