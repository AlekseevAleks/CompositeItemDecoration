package com.sibedge.compositeitemdecorator.item_decorator

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import com.sibedge.compositeitemdecorator.adapter.AddressItem
import com.sibedge.compositeitemdecorator.base.adapter.BaseCompositeAdapter
import com.sibedge.compositeitemdecorator.base.item_decorator.BaseDecorationDelegate
import com.sibedge.compositeitemdecorator.utils.dpToPx

class AddressDecorator : BaseDecorationDelegate() {

    private val marginMiddle = 8.dpToPx()
    private val marginLast = 16.dpToPx()

    override fun getItemOffsets(position: Int, outRect: Rect, parent: RecyclerView) {
        if (isForItem(position + 1, parent)) {
            outRect.bottom = marginMiddle
        } else {
            outRect.bottom = marginLast
        }
    }

    override fun isForItem(position: Int, parent: RecyclerView): Boolean {
        val adapter = parent.adapter
        if (adapter is BaseCompositeAdapter) {
            return adapter.getItem(position) is AddressItem
        }
        return false
    }
}