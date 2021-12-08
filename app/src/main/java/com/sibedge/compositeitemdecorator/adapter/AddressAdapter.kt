package com.sibedge.compositeitemdecorator.adapter

import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter
import com.sibedge.compositeitemdecorator.databinding.LayoutAddressItemBinding
import com.sibedge.compositeitemdecorator.databinding.LayoutTitleItemBinding

class AddressAdapter : ViewBindingDelegateAdapter<AddressItem, LayoutAddressItemBinding>(
    LayoutAddressItemBinding::inflate
) {

    override fun isForViewType(item: Any) = item is AddressItem

    override fun AddressItem.getItemId() = address

    override fun LayoutAddressItemBinding.onBind(item: AddressItem) {
        address.text = item.address
    }
}