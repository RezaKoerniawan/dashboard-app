package com.reza.base.presentation.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.reza.base.R
import com.reza.base.core.BaseActivity
import com.reza.base.core.ViewDataBindingOwner
import com.reza.base.databinding.ActivityDashboardBinding
import com.reza.base.presentation.homepage.HomePageFragment
import com.reza.base.presentation.profile.ProfileFragment


/**
 * Created by Reza Kurniawan on 27/03/2019.
 */

class DashboardActivity : BaseActivity(),
        DashboardView,
        ViewDataBindingOwner<ActivityDashboardBinding>,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private var firstTime = true

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, DashboardActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var viewModel: DashboardViewModel
    override lateinit var binding: ActivityDashboardBinding

    override fun getViewLayoutResId(): Int {
        return R.layout.activity_dashboard
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = DashboardViewModel()
        viewModel = binding.vm!!

        binding.navBottom.setOnNavigationItemSelectedListener(this)
        binding.navBottom.selectedItemId = R.id.menu_home

        title = "Home"
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(false)
            it.setHomeButtonEnabled(false)
        }
    }

    private fun getSelectedItem(bottomNavigationView: BottomNavigationView): Int {
        val menu = bottomNavigationView.menu
        for (i in 0 until bottomNavigationView.menu.size()) {
            val menuItem = menu.getItem(i)
            if (menuItem.isChecked) {
                return menuItem.itemId
            }
        }
        return 0
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.menu_home -> {
                if (firstTime || (R.id.menu_home != getSelectedItem(binding.navBottom))) {
                    resetBottomMenuIcon()
                    firstTime = false
                    menuItem.setIcon(R.drawable.ic_dashboard_active)
                    changeMainFragmentContent(HomePageFragment())
                }
            }
            R.id.menu_profile -> {
                if (R.id.menu_profile != getSelectedItem(binding.navBottom)) {
                    resetBottomMenuIcon()
                    menuItem.setIcon(R.drawable.ic_profile_active)
                    changeMainFragmentContent(ProfileFragment())
                }
            }
        }
        return true
    }

    private fun resetBottomMenuIcon() {
        val menu = binding.navBottom.menu
        menu.findItem(R.id.menu_home).setIcon(R.drawable.ic_dashboard)
        menu.findItem(R.id.menu_profile).setIcon(R.drawable.ic_profile)
    }

    fun setActionBarTitle(title: String) {
        binding.titleName.text = title
    }

    private fun changeMainFragmentContent(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }


}