package sg.com.sph.kotlincourse

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.list_item.view.*

class RVViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    @SuppressWarnings("SetTextI18n")
    fun bind(item: Record) {
        view.listItemTextView.text = "Quarter: ${item.quarter}, Index:${item.index}"
    }
}