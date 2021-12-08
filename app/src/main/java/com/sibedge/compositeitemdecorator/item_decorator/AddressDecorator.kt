package com.sibedge.compositeitemdecorator.item_decorator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sibedge.compositeitemdecorator.R
import com.sibedge.compositeitemdecorator.adapter.TitleItem
import com.sibedge.compositeitemdecorator.base.adapter.BaseCompositeAdapter
import com.sibedge.compositeitemdecorator.base.item_decorator.BaseDecorationDelegate
import com.sibedge.compositeitemdecorator.utils.dpToPx

class TitleDecorator(context: Context) : BaseDecorationDelegate() {

    private val marginHorizontal = 16.dpToPx()
    private val marginVertical = 12.dpToPx()

    private var divider: Drawable =
        requireNotNull(ContextCompat.getDrawable(context, R.drawable.summary_divider))

    override fun onDraw(position: Int, view: View, canvas: Canvas, parent: RecyclerView) {
        if (position == 0) return

        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        val bounds = Rect()
        parent.getDecoratedBoundsWithMargins(view, bounds)
        val top = bounds.top
        val bottom = top + divider.intrinsicHeight
        divider.setBounds(left, top, right, bottom)
        divider.draw(canvas)
    }

    override fun getItemOffsets(position: Int, outRect: Rect, parent: RecyclerView) {
        outRect.top = marginVertical + if (position == 0) 0 else divider.intrinsicHeight
        outRect.bottom = marginVertical
        outRect.right = marginHorizontal
        outRect.left = marginHorizontal
    }

    override fun isForItem(position: Int, parent: RecyclerView): Boolean {
        val adapter = parent.adapter
        if (adapter is BaseCompositeAdapter) {
            return adapter.getItem(position) is TitleItem
        }
        return false
    }
}