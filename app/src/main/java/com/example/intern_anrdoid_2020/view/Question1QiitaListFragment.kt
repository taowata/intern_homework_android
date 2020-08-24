package com.example.intern_anrdoid_2020.view

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.intern_anrdoid_2020.R
import com.example.intern_anrdoid_2020.model.response.QiitaArticleResponse
import kotlinx.android.synthetic.main.fragment_qiita_list.*
//import sun.jvm.hotspot.utilities.IntArray
import java.util.*


class Question1QiitaListFragment : Fragment() {

    private var qiitaArticles: ArrayList<QiitaArticleResponse>? = ArrayList()
    private val safeArgs: Question1QiitaListFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        qiitaArticles = safeArgs.articleList

        val appCompatActivity = activity as AppCompatActivity?
        val actionBar = appCompatActivity?.supportActionBar
        actionBar?.setTitle(R.string.article_view)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_qiita_list_q1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        view?.let {view ->
            val recyclerView: RecyclerView = rv_menu
            val layoutManager = LinearLayoutManager(view.context)
            recyclerView.layoutManager = layoutManager
            val adapter = QiitaListViewAdapter(qiitaArticles)
            recyclerView.adapter = adapter
            val decorator = DividerItemDecoration(context, layoutManager.orientation)
            recyclerView.addItemDecoration(decorator)

            adapter.setOnItemClickListener(object: QiitaListViewAdapter.OnItemClickListener{
                override fun onItemClickListener(item: QiitaArticleResponse) {
                    val action = item.url?.let { Question1QiitaListFragmentDirections.actionQuestion1QiitaListFragmentToQuestion1WebViewFragment(it) }
                    if (action != null) {
                        findNavController().navigate(action)
                    }
                }
            })
        }
    }
}
