package com.example.intern_anrdoid_2020.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.intern_anrdoid_2020.ArticleList
import com.example.intern_anrdoid_2020.R
import com.example.intern_anrdoid_2020.model.response.QiitaArticleResponse
import kotlinx.android.synthetic.main.fragment_question1_search.view.*
import java.util.ArrayList

class Question1SearchFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appCompatActivity = activity as AppCompatActivity?
        val actionBar = appCompatActivity?.supportActionBar
        actionBar?.setTitle(R.string.search_view_q1)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_question1_search, container, false)
        return setup(v)
    }

    private fun setup(v: View): View {
        val searchButton : Button = v.search_button_q1
        searchButton.setOnClickListener {
            view?.let {
                val searchKey  = it.edit_search_q1.text.toString().trim() // 前後のスペースをトリミング
                if (searchKey.isEmpty()) {
                    val errorTextView = v.findViewById<TextView>(R.id.error_tv)
                    errorTextView.visibility = View.VISIBLE
                } else {
                    val spn = v.findViewById<Spinner>(R.id.spnArticleNumber)
                    val articleNumber = spn.selectedItem.toString().toInt()
                    QiitaListRepository.listArticle(PAGE, articleNumber, searchKey).observe(viewLifecycleOwner, Observer { qiitaListResponse: ArrayList<QiitaArticleResponse> ->
                        val articleList = ArticleList(qiitaListResponse)
                        val action = Question1SearchFragmentDirections.actionQuestion1SearchFragmentToQuestion1QiitaListFragment(articleList)
                        findNavController().navigate(action)
                    })
                }
            }
        }
        return v
    }

    companion object {
        private const val PAGE = 1
        private const val PER_PAGE = 10
    }
}