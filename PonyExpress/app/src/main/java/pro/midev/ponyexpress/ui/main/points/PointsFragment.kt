package pro.midev.ponyexpress.ui.main.points
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_notifications.vToolbar
import kotlinx.android.synthetic.main.fragment_points.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.ui.main.points.list.ListPointsFragment
import pro.midev.ponyexpress.ui.main.points.map.MapFragment
import pro.midev.ponyexpress.ui.views.ToolbarView
import pro.midev.supersld.common.base.BaseFragment

class PointsFragment : BaseFragment(R.layout.fragment_points), MvpView {

    @InjectPresenter
    lateinit var presenter: PointsPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(vToolbar) {
            setTitle(R.string.points_title)
            setFirstAction(
                ToolbarView.Action(
                    resId = R.drawable.ic_filter,
                    action = {
                        presenter.filterPoint()
                    }
                ))
            setSecondAction(
                ToolbarView.Action(
                    resId = R.drawable.ic_search,
                    action = {
                        presenter.searchPoint()
                    }
                ))
            onBack(this@PointsFragment::onBackPressed)
        }

        initViewPager()
        tabLayout.elevation = vToolbar.elevation
    }

    private fun initViewPager() {
        val fragments : MutableList<Pair<String, Fragment>> = mutableListOf()
        fragments.add(Pair(getString(R.string.points_map), MapFragment()))
        fragments.add(Pair(getString(R.string.points_list), ListPointsFragment()))

        viewPager.adapter = MyPageAdapter(childFragmentManager, fragments)
        tabLayout.setupWithViewPager(viewPager)
    }

    inner class MyPageAdapter(fm: FragmentManager
                              , private val fragments: MutableList<Pair<String, Fragment>>
    ) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position].second
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return fragments[position].first
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}