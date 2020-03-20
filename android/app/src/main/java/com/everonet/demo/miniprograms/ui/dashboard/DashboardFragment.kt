package com.everonet.demo.miniprograms.ui.dashboard

import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.everonet.demo.miniprograms.MyReactActivity
import com.everonet.demo.miniprograms.R
import com.everonet.demo.miniprograms.base.BaseFragment
import com.everonet.demo.miniprograms.databinding.FragmentDashboardBinding
import com.everonet.demo.miniprograms.utils.ZipUtils
import java.io.File

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun getLayoutId(): Int = R.layout.fragment_dashboard

    override fun initFragment(view: View, savedInstanceState: Bundle?) {
        mBinding.holder = this
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        dashboardViewModel.text.observe(this, Observer {
            mBinding.textDashboard.text = it
        })
    }

    fun startMiniProgram01(view: View) {
        MyReactActivity.startActivity(activity, "mini01", "NativebaseKitchenSink")
    }

    fun startMiniProgram02(view: View) {
        MyReactActivity.startActivity(activity, "mini02", "TicTacToe")
    }

    fun unzip(view: View) {
        val pathIn = Environment.getExternalStorageDirectory().absolutePath + File.separator + "1/mini01.zip"
        val pathOut =
            Environment.getExternalStorageDirectory().absolutePath + File.separator + "1"
        ZipUtils.unzip(pathIn, pathOut)
    }
}