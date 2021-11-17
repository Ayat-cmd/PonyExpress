package pro.midev.ponyexpress.ui.main.notifications

import online.jutter.supersld.DifAdapter
import online.jutter.supersld.base.DFBaseHolder
import online.jutter.supersld.base.HolderFactory
import pro.midev.ponyexpress.extensions.fromFormatToFormat
import pro.midev.ponyexpress.models.local.NotificationLocal
import pro.midev.ponyexpress.ui.main.notifications.holders.HeaderNotificationHolder
import pro.midev.ponyexpress.ui.main.notifications.holders.NotificationHolder

class NotificationsAdapter: DifAdapter() {

    companion object {
        const val NOTIFICATION_ITEM = 101
        const val HEADER_ITEM = 102
    }

    private val list = mutableListOf<Pair<Int, Any?>>()

    override fun getItemCount(): Int = list.size
    override fun getItemViewType(position: Int): Int = list[position].first

    override fun initFactory() = HolderFactory(hashMapOf(
        NOTIFICATION_ITEM to NotificationHolder::class.java,
        HEADER_ITEM to HeaderNotificationHolder::class.java
    ))

    override fun onBindViewHolder(holder: DFBaseHolder, position: Int) {
        holder.setSizeAndPosition(itemCount, position)
        holder.bind(list[position].second)
    }

    fun addAll(list: MutableList<NotificationLocal>) {
        this.list.clear()
        var date = "x"
        for (i in list.indices) {
            val currentDate = list[i].date.fromFormatToFormat("dd.MM.yyyy HH:mm", "dd.MM.yyyy")
            if (currentDate != date) {
                date = currentDate
                this.list.add(Pair(HEADER_ITEM, date))
            }
            this.list.add(Pair(NOTIFICATION_ITEM, list[i]))
        }
        notifyDataSetChanged()
    }
}