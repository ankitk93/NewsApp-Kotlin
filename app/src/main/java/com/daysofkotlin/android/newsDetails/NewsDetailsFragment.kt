package com.daysofkotlin.android.newsDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.daysofkotlin.android.databinding.FragmentNewDetailsBinding

/**
 * Created by ak93.droid@gmail.com on 04,June,2020
 */
class NewsDetailsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentNewDetailsBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        val application = requireNotNull(activity).application

        val article = NewsDetailsFragmentArgs.fromBundle(arguments!!).selectedArticle

        val viewModelFactory = NewsDetailsViewModelFactory(article, application)

        binding.detailsViewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsDetailsViewModel::class.java)

        return binding.root
    }
}