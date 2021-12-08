package com.sibedge.compositeitemdecorator

import com.sibedge.compositeitemdecorator.adapter.*

class MainViewModel {

    fun getItems() : List<SummaryItem> {
        return listOf(
            TitleItem("Персональная информация"),
            PersonalInfoItem("Фамилия", "Иванов"),
            PersonalInfoItem("Имя", "Петр"),
            PersonalInfoItem("Отчество", "Васильевич"),
            PersonalInfoItem("Дата рождения", "01.01.1991"),
            TitleItem("Адреса"),
            AddressItem("г. Москва\nул.Ленина д.1"),
            AddressItem("г. Томск\nул.Томская\nд.14"),
            CheckBoxItem("Адрес регистрации совпадает", true),
            CheckBoxItem("Имеете недвижимость загрницей", false),
            TitleItem("Извещения"),
            CheckBoxItem("SMS", true),
            CheckBoxItem("E-mail", true),
            CheckBoxItem("Звонки", false),
            ButtonItem("Сохранить")
        )
    }
}