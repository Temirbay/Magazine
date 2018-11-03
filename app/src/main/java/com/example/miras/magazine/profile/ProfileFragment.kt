package com.example.miras.magazine.profile


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.miras.magazine.R
import com.example.miras.magazine.auth.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.android.ext.android.inject

class ProfileFragment : Fragment(), ProfileContract.ProfileView {

    override val presenter: ProfileContract.ProfilePresenter by inject()


    companion object {
        fun newInstance () : ProfileFragment {

            return ProfileFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        bn_logout.setOnClickListener {
            presenter.logout()
        }
    }

    override fun onLogoutSuccess() {
        val intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)
    }

}