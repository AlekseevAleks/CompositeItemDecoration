package com.sibedge.compositeitemdecorator.adapter

import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
import com.sibedge.compositeitemdecorator.databinding.LayoutPersonalInfoItemBinding

class PersonalInfoAdapter :
    ViewBindingDelegateAdapter<PersonalInfoItem, LayoutPersonalInfoItemBinding>(
        LayoutPersonalInfoItemBinding::inflate
    ) {

    override fun isForViewType(item: Any) = item is PersonalInfoItem

    override fun PersonalInfoItem.getItemId() = title

    override fun LayoutPersonalInfoItemBinding.onBind(item: PersonalInfoItem) {
        title.text = item.title
        value.text = item.value
    }
}