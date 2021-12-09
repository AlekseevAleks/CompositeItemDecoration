package com.sibedge.compositeitemdecorator.base.item_decorator

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface ItemDecorationDelegate {

    fun onDraw(position: Int, view: View, canvas: Canvas, parent: RecyclerView)

    fun onDrawOver(position: Int, view: View, canvas: Canvas, parent: RecyclerView)

    fun getItemOffsets(position: Int, outRect: Rect, parent: RecyclerView)

    fun isForItem(position: Int, parent: RecyclerView): Boolean
}