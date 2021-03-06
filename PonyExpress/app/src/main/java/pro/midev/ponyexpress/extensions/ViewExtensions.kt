package pro.midev.ponyexpress.extensions

import android.app.ActionBar
import android.content.Context
import android.text.InputFilter
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.EditText
import androidx.core.content.ContextCompat

/**
 * Установка максимальной длинны на тектовое поле.
 */
fun EditText.limitLength(maxLength: Int) {
    filters = arrayOf(InputFilter.LengthFilter(maxLength))
}

/**
 * Получение цвета.
 */
fun View.getColor(id: Int) = ContextCompat.getColor(context, id)

/**
 * Показываем вью.
 * Просто экономия трех букв на каждом скрытии,
 * но читать код удобнее.
 */
fun View.show() {
    visibility = View.VISIBLE
}

/**
 * Скрываем вью.
 * Просто экономия трех букв на каждом скрытии,
 * но читать код удобнее.
 */
fun View.hide(vType: Int = View.GONE) {
    visibility = vType
}

infix fun View.withVisible(vType: Int) {
    visibility = vType
}

/**
 * Появление View с анимацией сжатия.
 */
fun View.expand() {
    val matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec((this.parent as View).width, View.MeasureSpec.EXACTLY)
    val wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    this.measure(matchParentMeasureSpec, wrapContentMeasureSpec)
    val targetHeight = this.measuredHeight

    // Older versions of android (pre API 21) cancel animations for views with a height of 0.
    this.layoutParams.height = 1
    this.visibility = View.VISIBLE
    val a: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            this@expand.layoutParams.height =
                if (interpolatedTime == 1f) ActionBar.LayoutParams.WRAP_CONTENT else (targetHeight * interpolatedTime).toInt()
            this@expand.requestLayout()
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }

    // Expansion speed of 1dp/ms
    a.duration = (targetHeight / this.context.resources.displayMetrics.density).toLong()
    this.startAnimation(a)
}

/**
 * Скрытие View с анимацией расширения.
 */
fun View.collapse() {
    val initialHeight = this.measuredHeight
    val a: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            if (interpolatedTime == 1f) {
                this@collapse.visibility = View.GONE
            } else {
                this@collapse.layoutParams.height = initialHeight - (initialHeight * interpolatedTime).toInt()
                this@collapse.requestLayout()
            }
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }

    // Collapse speed of 1dp/ms
    a.duration = (initialHeight / this.context.resources.displayMetrics.density).toLong()
    this.startAnimation(a)
}