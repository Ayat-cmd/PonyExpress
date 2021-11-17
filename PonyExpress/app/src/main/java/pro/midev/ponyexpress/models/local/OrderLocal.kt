package pro.midev.ponyexpress.models.local

import pro.midev.ponyexpress.R

class OrderLocal(
    val id: String,
    val number: String,
    val date: String,
    val address: String
) {
    /**
     * Получение иконки
     * для карточки с отправлением.
     */
    fun getIcon(): Int {
        return R.drawable.ic_l_type
    }
}