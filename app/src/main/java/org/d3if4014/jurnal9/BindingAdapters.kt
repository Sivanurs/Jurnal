package org.d3if4014.jurnal9

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter("toggleLoading")
fun toggleLoading(progressBar: ProgressBar, bool: Boolean) {
    progressBar.bringToFront()
    if (bool == true) {
        progressBar.visibility = View.VISIBLE
    }else {
        progressBar.visibility = View.INVISIBLE
    }
}