package com.example.intern_anrdoid_2020.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.intern_anrdoid_2020.R
import com.example.intern_anrdoid_2020.model.response.QiitaArticleResponse
import kotlinx.android.synthetic.main.fragment_search.view.*
import java.util.*

class SearchFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appCompatActivity = activity as AppCompatActivity?
        val actionBar = appCompatActivity?.supportActionBar
        actionBar?.setTitle(R.string.search_view)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_search, container, false)
        return setup(v)
    }

    private fun setup(v: View): View {
        val searchButton :Button = v.search_button
        searchButton.setOnClickListener {
            view?.let {
                val searchKey  = it.edit_search.text.toString()
                QiitaListRepository.listArticle(PAGE, PER_PAGE, searchKey).observe(viewLifecycleOwner, Observer { qiitaListResponse: ArrayList<QiitaArticleResponse> ->
                    showQiitaListFragment(qiitaListResponse)
                })
            }
        }
        return v
    }

    private fun showQiitaListFragment(qiitaArticleResponse: ArrayList<QiitaArticleResponse>) {
        fragmentManager?.let {
            val fragmentTransaction = it.beginTransaction()
            fragmentTransaction.replace(R.id.search_layout_frame, QiitaListFragment.newInstance(qiitaArticleResponse))
                    .addToBackStack(null)
                    .commit()
        }
    }

    companion object {
        private const val PAGE = 1
        private const val PER_PAGE = 10
    }
}
