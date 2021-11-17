package pro.midev.ponyexpress.ui.main.notifications.holders

import android.annotation.SuppressLint
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.item_notification.view.*
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
@HolderLayout(layout = R.layout.item_notification)
class NotificationHolder(itemView: View) : DFBaseHolder(itemView) {
    override fun bind(data: Any?) {
        val notification = data as NotificationLocal
        with(itemView) {
            tvTitle.text = notification.title
            tvTime.text = notification.date.fromFormatToFormat("dd.MM.yyyy HH:mm", "HH:mm")
            tvText.text = notification.text

            tvTitle.setTextColor(
                ContextCompat.getColor(
                    context,
                    when(notification.status) {
                        ERROR -> R.color.colorAccentRed
                        WAITED -> R.color.colorAccentOrange
                        FINISH -> R.color.colorAccentGreen1
                        else -> R.color.colorTextBlack40
                    }
                )
            )

            ivStatusIcon.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    when(notification.status) {
                        ERROR -> R.drawable.ic_notification_error
                        WAITED -> R.drawable.ic_notification_waited
                        FINISH -> R.drawable.ic_notification_finish
                        else -> R.drawable.ic_notification_error
                    }
                )
            )
        }
    }
}