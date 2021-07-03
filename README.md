# Toastify
A kotlin extension to use toast like abilities for all views.

<img src="/media/device-2021-07-02-212708.gif" width="180">

Just copy this extension code, into your project and add the kotlin coroutines to your dependencies 

```implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9'```:

https://github.com/AndreyMatos/Toastify/blob/main/app/src/main/java/am/toastify/ToastifyExt.kt
 ```kotlin
 import android.view.View
import android.widget.Toast
import kotlinx.coroutines.*

fun View.toastify(mDuration: Int = Toast.LENGTH_SHORT) {

    val mTime = if (mDuration == Toast.LENGTH_SHORT) 2000L else 3500L

    suspend fun animate() {
        val initialVisibility = this.visibility
        this.visibility = View.VISIBLE
        this.alpha = 0f
        this.animate().alpha(1f)
        delay(mTime)
        this.animate().alpha(0f)
            .withEndAction {
                this.visibility = initialVisibility
            }
    }

    CoroutineScope(Dispatchers.Main).launch {
        animate()
    }
}
 ```
