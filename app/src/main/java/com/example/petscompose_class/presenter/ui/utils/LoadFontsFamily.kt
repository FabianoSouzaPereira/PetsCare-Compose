package com.example.petscompose_class.presenter.ui.utils

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.petscompose_class.R

object LoadFontsFamily {

    val montserratFamily = loadFontFamily(
        R.font.montserrat_light to FontWeight.Light,
        R.font.montserrat_regular to FontWeight.Normal,
        R.font.montserrat_medium to FontWeight.Medium,
        R.font.montserrat_semibold to FontWeight.SemiBold
    )

    val domineFamily = loadFontFamily(
        R.font.domine_regular to FontWeight.Normal,
        R.font.domine_bold to FontWeight.Bold
    )

    val karlaFamily = loadFontFamily(
        R.font.karla_regular to FontWeight.Normal,
        R.font.karla_bold to FontWeight.Bold
    )

    private fun loadFontFamily(vararg fonts: Pair<Int, FontWeight>): FontFamily {
        return FontFamily(*fonts.map { Font(it.first, it.second) }.toTypedArray())
    }
}
