package com.reza.base.presentation.detailpage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.reza.base.R
import com.reza.base.core.BaseActivity
import com.reza.base.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.activity_detail_page.*


/**
 * Created by Reza Kurniawan on 28/03/2019.
 */

class DetailPageActivity : BaseActivity() {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, DetailPageActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(intent)
        }
    }

    override fun getViewLayoutResId(): Int {
        return R.layout.activity_detail_page
    }

    var inflater: LayoutInflater? = null

    private var photo = intArrayOf(R.drawable.photo_1, R.drawable.photo_2, R.drawable.photo_3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view_pager.adapter = ImageAdapter()
        title = "Detail Page"
    }

    internal inner class ImageAdapter : PagerAdapter() {
        var binding: FragmentDetailBinding? = null
        private var viewModel: DetailPageViewModel? = null

        override fun getCount(): Int {
            return photo.size
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            inflater?.let {
                binding = DataBindingUtil.inflate(it, R.layout.fragment_detail, container, false)
                binding?.vm = DetailPageViewModel()
                viewModel = binding?.vm
            }

            binding?.ivPhoto?.setImageResource(photo[position])
            (container as ViewPager).addView(binding?.root, 0)
            return binding?.root!!
        }

        override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
            return arg0 === arg1 as View
        }

        override fun destroyItem(container: ViewGroup, position: Int, objects: Any) {
            (container as ViewPager).removeView(objects as View)
        }
    }


}