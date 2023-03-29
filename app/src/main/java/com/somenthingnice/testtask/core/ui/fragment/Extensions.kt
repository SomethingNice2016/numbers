package com.somenthingnice.testtask.core.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Parcelable
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

inline fun <LV : LiveData<E>, reified E> Fragment.observe(
    liveData: LV,
    observer: Observer<E>
) = liveData.observe(viewLifecycleOwner, observer)


inline fun <LV : LiveData<E>, reified E> LifecycleOwner.observe(
    liveData: LV,
    observer: Observer<E>
) = liveData.observe(this, observer)

fun Fragment.showShortToast(message: String?) {
    message?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }
}

inline fun <reified E, reified F : Flow<E>> Fragment.collect(
    flow: F,
    crossinline collector: suspend (E) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launchWhenStarted {
        flow.collectLatest {
            collector.invoke(it)
        }
    }
}


fun Fragment.showShortToast(@StringRes message: Int) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showLongToast(message: String?) {
    message?.let {
        Toast.makeText(context, it, Toast.LENGTH_LONG).show()
    }
}


fun Fragment.showLongToast(@StringRes message: Int) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun Fragment.openWebSite(url: String) {
    val formatUrl = if (!url.startsWith("http://") && !url.startsWith("https://"))
        "http://$url"
    else
        url
    startActivity(
        Intent(
            Intent.ACTION_VIEW, Uri.parse(formatUrl)
        )
    )
}

inline fun <reified T : Parcelable> Fragment.navArg(key: String) = lazy {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        requireArguments().getParcelable(key, T::class.java)
    } else {
        requireArguments().getParcelable(key)
    }
}

inline fun <reified T : Parcelable> Fragment.requireNavArg(key: String) = lazy {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        requireArguments().getParcelable(key, T::class.java)!!
    } else {
        requireArguments().getParcelable(key)!!
    }
}