package com.sibedge.compositeitemdecorator.base.item_decorator

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseDecorationDelegate : ItemDecorationDelegate {

    override fun onDraw(position: Int, view: View, canvas: Canvas, parent: RecyclerView) {}

    override fun onDrawOver(position: Int, view: View, canvas: Canvas, parent: RecyclerView) {}

    override fun getItemOffsets(position: Int, outRect: Rect, parent: RecyclerView) {}

    override fun isForItem(position: Int, parent: RecyclerView) = false
}