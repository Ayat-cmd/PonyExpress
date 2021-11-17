package pro.midev.ponyexpress.ui.main.notifications.holders

import android.annotation.SuppressLint
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.item_notification.view.*
import kotlinx.android.synthetic.main.item_notification.view.tvTitle
import kotlinx.android.synthetic.main.item_notification_header.view.*
import online.jutter.supersld.base.DFBaseHolder
import online.jutter.supersld.base.HolderLayout
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.extensions.fromFormatToFormat
import pro.midev.ponyexpress.extensions.getColor
import pro.midev.ponyexpress.models.local.NotificationLocal
import pro.midev.ponyexpress.models.local.NotificationLocal.Companion.ERROR
import pro.midev.ponyexpress.models.local.NotificationLocal.Companion.FINISH
import pro.midev.ponyexpress.models.local.NotificationLocal.Companion.WAITED

@SuppressLint("NonConstantResourceId")
@HolderLayout(layout = R.layout.item_notification_header)
class HeaderNotificationHolder(itemView: View) : DFBaseHolder(itemView) {
    override fun bind(data: Any?) {
        val date = data as String
        with(itemView) {
            tvTitle.text = date
        }
    }
}