package pro.midev.ponyexpress.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import pro.midev.ponyexpress.common.enums.BottomSheetDialogType

interface GlobalView: MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun showBottomSheet(type: BottomSheetDialogType, data: Any?)
}