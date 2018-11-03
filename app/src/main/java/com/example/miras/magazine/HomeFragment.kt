package com.example.miras.magazine

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.widget.SearchView
import android.view.*
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_home.*
import android.widget.TextView



class HomeFragment : Fragment() {

    companion object {
        fun newInstance () : HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setOnClickListener {
            val intent = Intent (activity, SearchActivity::class.java)
            startActivity(intent)
        }

    }


}