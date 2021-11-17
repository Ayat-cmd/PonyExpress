package pro.midev.ponyexpress.common.base

import com.jakewharton.rxrelay3.PublishRelay
import io.reactivex.rxjava3.core.Observable
import pro.midev.ponyexpress.common.enums.BottomSheetDialogType

class BottomSheetDialogController {
    private val stateRelay = PublishRelay.create<Pair<BottomSheetDialogType, Any?>>()

    val state: Observable<Pair<BottomSheetDialogType, Any?>> = stateRelay
    fun show(type: BottomSheetDialogType, data: Any? = null) = stateRelay.accept(Pair(type, data))
}