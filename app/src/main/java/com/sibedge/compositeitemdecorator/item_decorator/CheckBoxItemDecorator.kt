package com.sibedge.compositeitemdecorator.item_decorator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sibedge.compositeitemdecorator.R
import com.sibedge.compositeitemdecorator.adapter.CheckBoxItem
import com.sibedge.compositeitemdecorator.adapter.TitleItem
import com.sibedge.compositeitemdecorator.base.adapter.BaseCompositeAdapter
import com.sibedge.compositeitemdecorator.base.item_decorator.BaseDecorationDelegate
import com.sibedge.compositeitemdecorator.utils.dpToPx

class CheckBoxItemDecorator(context: Context) : BaseDecorationDelegate() {

    private var divider: Drawable =
        requireNotNull(ContextCompat.getDrawable(context, R.drawable.summary_divider))

    override fun onDrawOver(position: Int, view: View, canvas: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val bounds = Rect()
        parent.getDecoratedBoundsWithMargins(view, bounds)

        if (!isForItem(position - 1, parent)) {
            drawTopDivider(bounds, left, right, canvas)
        }

        if (isForItem(position + 1, parent)) {
            drawMiddleDivider(view, bounds, left, right, canvas)
        } else if (!isTitleItem(position + 1, parent)) {
            drawBottomDivider(bounds, left, right, canvas)
        }
    }

    override fun isForItem(position: Int, parent: RecyclerView): Boolean {
        val adapter = parent.adapter
        if (adapter is BaseCompositeAdapter) {
            return adapter.getItem(position) is CheckBoxItem
        }
        return false
    }

    private fun drawTopDivider(bounds: Rect, left: Int, right: Int, canvas: Canvas) {
        val top = bounds.top
        val bottom = top + divider.intrinsicHeight
        divider.setBounds(left, top, right, bottom)
        divider.draw(canvas)
    }

    private fun drawMiddleDivider(view: View, bounds: Rect, left: Int, right: Int, canvas: Canvas) {
        val top = bounds.bottom - divider.intrinsicHeight
        val bottom = bounds.bottom
        val leftDivider = left + view.paddingLeft
        divider.setBounds(leftDivider, top, right, bottom)
        divider.draw(canvas)
    }

    private fun drawBottomDivider(bounds: Rect, left: Int, right: Int, canvas: Canvas) {
        val top = bounds.bottom - divider.intrinsicHeight
        val bottom = bounds.bottom
        divider.setBounds(left, top, right, bottom)
        divider.draw(canvas)
    }

    private fun isTitleItem(position: Int, parent: RecyclerView): Boolean {
        val adapter = parent.adapter
        if (adapter is BaseCompositeAdapter) {
            return adapter.getItem(position) is TitleItem
        }
        return false
    }
}