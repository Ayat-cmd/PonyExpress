package pro.midev.ponyexpress.ui.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.view_search.view.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.extensions.getColor
import pro.midev.ponyexpress.extensions.show
import pro.midev.supersld.extensions.addSystemTopPadding

class ToolbarSearchView : LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defUtils: Int) : super(
        context,
        attributeSet,
        defUtils
    )

    init {
        inflate(context, R.layout.view_search, this)
        addSystemTopPadding()
        setBackgroundColor(getColor(R.color.colorAccentWhite))
        elevation = 10f
    }

    fun setHint(text: String) {
        etSearch.hint = text
    }

    fun setHint(text: Int) {
        etSearch.setHint(text)
    }

    fun onBack(back: ()->Unit) {
        icClose.show()
        icClose.setOnClickListener {
            back()
        }
    }
}