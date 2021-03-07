package com.sfone095.nalsolution.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.NumberFormat
import java.util.*

@BindingAdapter("numberFormat")
fun TextView.formatNumber(number: Int?) {
    text = NumberFormat.getNumberInstance(Locale.getDefault()).format(number)
}