package com.example.intern_anrdoid_2020.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.intern_anrdoid_2020.R
import com.example.intern_anrdoid_2020.model.response.QiitaArticleResponse
import com.example.intern_anrdoid_2020.view.QiitaListViewAdapter.QiitaListViewHolder
import kotlinx.android.synthetic.main.row_qiita_list.view.*

class QiitaListViewAdapter(private val listData: List<QiitaArticleResponse>?) : RecyclerView.Adapter<QiitaListViewHolder>() {

    lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClickListener(item: QiitaArticleResponse)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class QiitaListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivQiitaImage: ImageView
        val tvQiitaTitle: TextView
        val tvQiitaLgtm: TextView

        init {
            ivQiitaImage = itemView.iv_user_image
            tvQiitaTitle = itemView.tv_qiita_title
            tvQiitaLgtm = itemView.tv_qiita_lgtm_counter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QiitaListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_qiita_list, parent, false)
        return QiitaListViewHolder(v)
    }

    override fun onBindViewHolder(holder: QiitaListViewHolder, position: Int) {
        listData?.let {
            val qiitaArticleResponse = listData[position]
            holder.tvQiitaTitle.text = qiitaArticleResponse.title
            holder.tvQiitaLgtm.text = qiitaArticleResponse.likesCount.toString()
            Glide.with(holder.ivQiitaImage.context).load(qiitaArticleResponse.user?.profileImageUrl).into(holder.ivQiitaImage)
            holder.itemView.setOnClickListener {
                if (position == RecyclerView.NO_POSITION) {
                    return@setOnClickListener
                }
                listener.onItemClickListener(qiitaArticleResponse)
            }
        }
    }

    override fun getItemCount(): Int {
        listData?.let {
            return listData.size
        }
        return 0
    }
}
