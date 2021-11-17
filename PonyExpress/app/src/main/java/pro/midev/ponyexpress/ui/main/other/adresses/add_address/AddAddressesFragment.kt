package pro.midev.ponyexpress.ui.main.other.adresses.add_address
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_address_add.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.ui.views.PonyInputView
import pro.midev.supersld.common.base.BaseFragment
import pro.midev.supersld.extensions.addSystemBottomPadding

class AddAddressesFragment : BaseFragment(R.layout.fragment_address_add), MvpView {

    @InjectPresenter
    lateinit var presenter: AddAddressesPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(vToolbar) {
            setTitle("Дом")
            onBack(this@AddAddressesFragment::onBackPressed)
        }

        with(ivAddressName) {
            setHint(R.string.settings_addresses_add_address_name)
        }

        with(vCity) {
            setTitle("Город")
        }
        with(vStreet) {
            setTitle("Улица")
        }
        with(vHouse) {
            setTitle("Дом")
        }

        with(ivNumber) {
            setHint("Номер квартиры")
        }
        with(ivIndex) {
            setHint("Индекс")
        }

        with(ivPhone) {
            showTitle("Телефон*")
            setActionDone(EditorInfo.IME_ACTION_SEARCH)
            setMaxLines(1)
            setPrefix("+7")
            setDigits("0123456789-() ")
            setTextMask("([000]) [000]-[00]-[00]")
            addStartAction(PonyInputView.Action(
                iconId = R.drawable.ic_store_phone,
                action = {

                }
            ))
        }
        with(ivFio) {
            showTitle("ФИО*")
            setHint("ФИО")
        }

        nested.addSystemBottomPadding()
    }

    override fun onBackPressed() {
        presenter.back()
    }
}