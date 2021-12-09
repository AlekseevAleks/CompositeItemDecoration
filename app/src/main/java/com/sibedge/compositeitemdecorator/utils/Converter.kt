package com.sibedge.compositeitemdecorator.utils

import android.content.res.Resources

fun Number.pxToDp() = toFloat() / Resources.getSystem().displayMetrics.density

fun Number.dpToPx() = (this.toFloat() * Resources.getSystem().displayMetrics.density).toInt()

fun Number.pxToSp() = toFloat() / Resources.getSystem().displayMetrics.scaledDensity

fun Number.spToPx() = (toFloat() * Resources.getSystem().displayMetrics.scaledDensity).toInt()