package com.sibedge.compositeitemdecorator.base.item_decorator

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class CompositeItemDecoration(vararg itemDecorations: ItemDecorationDelegate) :
    RecyclerView.ItemDecoration() {

    private val decorations = itemDecorations.toList()

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        parent.children
            .forEach { view ->
                val position = parent.getChildAdapterPosition(view)
                if (position != RecyclerView.NO_POSITION) {
                    findDecoration(position, parent)?.onDraw(position, view, canvas, parent)
                }
            }
    }

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        parent.children
            .forEach { view ->
                val position = parent.getChildAdapterPosition(view)
                if (position != RecyclerView.NO_POSITION) {
                    findDecoration(position, parent)?.onDrawOver(position, view, canvas, parent)
                }
            }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == RecyclerView.NO_POSITION) return

        findDecoration(position, parent)?.getItemOffsets(position, outRect, parent)
    }

    private fun findDecoration(position: Int, parent: RecyclerView): ItemDecorationDelegate? {
        return decorations.find { it.isForItem(position, parent) }
    }
}