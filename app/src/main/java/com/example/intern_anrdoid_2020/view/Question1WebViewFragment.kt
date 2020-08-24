package com.example.intern_anrdoid_2020.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.example.intern_anrdoid_2020.R

class Question1WebViewFragment : Fragment() {

    private val safeArgs: Question1WebViewFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appCompatActivity = activity as AppCompatActivity?
        val actionBar = appCompatActivity?.supportActionBar
        actionBar?.setTitle(R.string.article_detail)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_question1_web_view, container, false)
        val webView = v.findViewById<WebView>(R.id.web_view)
        webView.webViewClient
        webView.loadUrl(safeArgs.url)

        return v
    }
}