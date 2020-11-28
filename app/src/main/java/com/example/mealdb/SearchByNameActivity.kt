package com.example.mealdb

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdb.adapter.SearchByLetterAdapter
import com.example.mealdb.adapter.SearchByNameAdapter
import com.example.mealdb.dataSource.ApiDataSource
import com.example.mealdb.model.Meal
import com.example.mealdb.networking.ApiFactory
import com.example.mealdb.viewModel.Factory
import com.example.mealdb.viewModel.ViewModel
import kotlinx.android.synthetic.main.activity_search_by_name.*
import kotlinx.android.synthetic.main.toolbar.*

class SearchByNameActivity : AppCompatActivity() {

    private val viewModel by lazy{
        ViewModelProviders.of(this, Factory(
            ApiDataSource(ApiFactory.getApiClient())
        ))[ViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_by_name)


        setupViews()
        setSupportActionBar(toolbar)
        val displayHomeAsUpEnabled = supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initUi()
        initObservers()
    }

    private fun setupViews(){

        searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.loadSearchByName(s.toString())
            }
        })

        searchView1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.loadSearchByFirstLetter(s.toString())
            }
        })

    }

    private fun initUi(){
        search_list.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
        search_by_letter.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
    }

    private fun initObservers(){
        viewModel.searchByNameLiveData.observe(this@SearchByNameActivity, Observer {
            setupData(it)
        })
        viewModel.searchByFirstLetterLiveData.observe(this@SearchByNameActivity, Observer {
            setupDataSearch(it)
        })
    }

    private fun setupData(category: List<Meal>) {
        search_list!!.adapter =
            SearchByNameAdapter(category as ArrayList<Meal>)
    }

    private fun setupDataSearch(category: List<Meal>) {
        search_by_letter!!.adapter =
            SearchByLetterAdapter(category as ArrayList<Meal>)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_CANCELED)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}

