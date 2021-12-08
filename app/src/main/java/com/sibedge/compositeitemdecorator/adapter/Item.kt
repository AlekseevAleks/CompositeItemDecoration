package com.sibedge.compositeitemdecorator.adapter

sealed class SummaryItem

data class TitleItem(val title: String) : SummaryItem()

data class PersonalInfoItem(val title: String, val value: String) : SummaryItem()

data class AddressItem(val address: String) : SummaryItem()

data class CheckBoxItem(val title: String, val checked: Boolean) : SummaryItem()

data class ButtonItem(val title: String) : SummaryItem()