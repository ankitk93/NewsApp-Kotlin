package com.daysofkotlin.android.newsOverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.daysofkotlin.android.R
import com.daysofkotlin.android.databinding.FragmentNewsOverviewBinding

/**
 * Created by ak93.droid@gmail.com on 04,June,2020
 */
class NewsOverviewFragment: Fragment() {

    private val overviewViewModel: NewOverviewViewModel by lazy {
        ViewModelProviders.of(this).get(NewOverviewViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentNewsOverviewBinding.inflate(inflater)

        binding.lifecycleOwner =viewLifecycleOwner

        binding.newOverviewViewModel = overviewViewModel

        binding.rvNewsItem.adapter = AllNewsAdapter(AllNewsAdapter.OnClickListener{
            overviewViewModel.displayArticleDetails(it)
        })

        overviewViewModel.navigationToSelectedArticle.observe(this, Observer{
            if (null != it){
                this.findNavController().navigate(NewsOverviewFragmentDirections.actionShowDetail(it))
                overviewViewModel.displayArticleDetailsComplete()
            }
        })

        return binding.root
    }
}