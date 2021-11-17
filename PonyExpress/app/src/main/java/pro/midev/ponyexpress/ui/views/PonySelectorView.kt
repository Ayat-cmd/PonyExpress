package pro.midev.ponyexpress.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_pony_selector.view.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.extensions.getColor
import pro.midev.ponyexpress.extensions.hide

class PonySelectorView : RelativeLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defUtils: Int) : super(
        context,
        attributeSet,
        defUtils
    )

    init {
        View.inflate(context, R.layout.view_pony_selector, this)
        setValue(null)
    }

    fun setTitle(title: String) {
        tvSub.text = title
    }

    fun setTitle(title: Int) {
        tvSub.setText(title)
    }

    fun setValue(value: String?) {
        if (value == null) {
            tvValue.text = "Не выбрано"
            tvValue.setTextColor(getColor(R.color.colorTextBlack40))
        } else {
            tvValue.text = value
            tvValue.setTextColor(getColor(R.color.colorTextBlack))
        }
    }

    fun hideDivider() {
        vDivider.hide()
    }
}