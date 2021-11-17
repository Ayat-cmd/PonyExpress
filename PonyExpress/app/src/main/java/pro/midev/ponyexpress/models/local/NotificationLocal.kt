package pro.midev.ponyexpress.models.local

import pro.midev.ponyexpress.R

class NotificationLocal(
    val id: String,
    val date: String,
    val title: String,
    val text: String,
    val status: String
) {
    companion object {
        const val ERROR = "error"
        const val WAITED = "waited"
        const val FINISH = "finish"
    }
}