package com.sibedge.compositeitemdecorator.item_decorator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sibedge.compositeitemdecorator.R
import com.sibedge.compositeitemdecorator.adapter.PersonalInfoItem
import com.sibedge.compositeitemdecorator.base.adapter.BaseCompositeAdapter
import com.sibedge.compositeitemdecorator.base.item_decorator.BaseDecorationDelegate
import com.sibedge.compositeitemdecorator.utils.dpToPx

class PersonalInfoItemDecorator(context: Context) : BaseDecorationDelegate() {

    private val lastItemMargin = 16.dpToPx()

    private var dividerTop: Drawable =
        requireNotNull(ContextCompat.getDrawable(context, R.drawable.summary_info_background_top))

    private var dividerMiddle: Drawable =
        requireNotNull(
            ContextCompat.getDrawable(context, R.drawable.summary_info_background_middle)
        )

    private var dividerBottom: Drawable =
        requireNotNull(
            ContextCompat.getDrawable(context, R.drawable.summary_info_background_bottom)
        )

    override fun onDraw(position: Int, view: View, canvas: Canvas, parent: RecyclerView) {
        val bounds = Rect()
        parent.getDecoratedBoundsWithMargins(view, bounds)
        val params = view.layoutParams as RecyclerView.LayoutParams
        val left = parent.paddingLeft + params.leftMargin
        val right = parent.width - parent.paddingRight - params.rightMargin
        val top = bounds.top
        val bottom = view.bottom

        val divider = selectDivider(position, parent)
        divider.setBounds(left, top, right, bottom)
        divider.draw(canvas)
    }

    override fun getItemOffsets(position: Int, outRect: Rect, parent: RecyclerView) {
        if (!isForItem(position + 1, parent)) {
            outRect.bottom = lastItemMargin
        }
    }

    override fun isForItem(position: Int, parent: RecyclerView): Boolean {
        val adapter = parent.adapter
        if (adapter is BaseCompositeAdapter) {
            return adapter.getItem(position) is PersonalInfoItem
        }
        return false
    }

    private fun selectDivider(position: Int, parent: RecyclerView): Drawable {
        return when {
            !isForItem(position - 1, parent) -> {
                dividerTop
            }
            isForItem(position + 1, parent) -> {
                dividerMiddle
            }
            else -> {
                dividerBottom
            }
        }
    }
}