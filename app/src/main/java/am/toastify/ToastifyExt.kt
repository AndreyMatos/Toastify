package am.toastify

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