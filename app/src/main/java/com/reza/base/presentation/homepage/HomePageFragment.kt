package com.reza.base.presentation.homepage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.Constraints.TAG
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.reza.base.R
import com.reza.base.core.BaseFragment
import com.reza.base.core.ViewDataBindingOwner
import com.reza.base.databinding.FragmentHomePageBinding
import com.reza.base.entity.MovieItem
import com.reza.base.network.ApiUtil
import com.reza.base.presentation.dashboard.DashboardActivity
import com.reza.base.presentation.homepage.adapter.HomePageItemListAdapter
import kotlinx.android.synthetic.main.fragment_home_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Reza Kurniawan on 27/03/2019.
 */

class HomePageFragment : BaseFragment(),
        HomePageView,
        ViewDataBindingOwner<FragmentHomePageBinding> {

    private lateinit var viewModel: HomePageViewModel
    override lateinit var binding: FragmentHomePageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as DashboardActivity).setActionBarTitle(getString(R.string.app_name))
        binding.view = this
        binding.vm = HomePageViewModel()
        viewModel = binding.vm!!

        setUI()
        apiGetService()
    }

    private fun setUI() {
        val linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun apiGetService() {
        ApiUtil.serviceClass.allPost.enqueue(object : Callback<List<MovieItem>> {
            override fun onResponse(call: Call<List<MovieItem>>, response: Response<List<MovieItem>>) {
                if (response.isSuccessful) {
                    viewModel.bIsLoading.set(false)
                    val postList: List<MovieItem> = response.body()!!
                    Log.d(TAG, "Returned count " + postList.size)
                    recyclerView?.adapter = HomePageItemListAdapter(context!!, postList)
                }
            }

            override fun onFailure(call: Call<List<MovieItem>>, t: Throwable) {
                //showErrorMessage()
                Log.d(TAG, "error loading from API")
            }
        })
    }
}