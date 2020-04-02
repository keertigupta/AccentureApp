package com.example.accenturerestapidemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.accenturerestapidemo.R
import com.example.accenturerestapidemo.adapter.DemoListAdapter
import com.example.accenturerestapidemo.databinding.ActivityMainBinding
import com.example.accenturerestapidemo.di.DaggerMyAppComponent
import com.example.accenturerestapidemo.model.ResponseData
import com.example.accenturerestapidemo.model.Rows
import com.example.accenturerestapidemo.util.Utils
import com.example.accenturerestapidemo.viewmodel.MainActivityViewModel

import com.example.wiproassignmentproject.factory.MyViewModelfactory

import java.util.ArrayList
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var mbinding: ActivityMainBinding
    private lateinit var myadapter: DemoListAdapter
    lateinit var   rvView: RecyclerView

    private lateinit var viewModel: MainActivityViewModel

    @Inject
    lateinit var mViewModelFactory: MyViewModelfactory

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  daggerMyAppComponent = DaggerMyAppComponent.builder().build()
        daggerMyAppComponent.inject(this)
        mbinding =  DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        rvView = mbinding.mylistview

        viewModel = ViewModelProviders.of(this,mViewModelFactory).get(MainActivityViewModel::class.java)
        if(Utils.isNetworkAvailable(this)) {


            // getting the data from server by viewmodel using repository
            viewModel.getProjectResponse().observe(this, object : Observer<ResponseData> {
                override fun onChanged(it: ResponseData) {
                    // showing list
                    if (it.rows.isNotEmpty()) {
                        showUi(it.rows,it.title)
                    } else {
                        Toast.makeText(this@MainActivity, "No item from server.", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            })
        }else{
            Toast.makeText(this@MainActivity,"Network Not Available.",Toast.LENGTH_LONG).show()
        }
    }


    fun showUi(list:List<Rows>, _title:String){
        mbinding.myToolbar.title = _title
        myadapter = DemoListAdapter(this,list as ArrayList<Rows>)
        rvView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvView.adapter = myadapter
        //myadapter.notifyDataSetChanged()

    }
}
