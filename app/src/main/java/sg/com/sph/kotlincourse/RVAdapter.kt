package sg.com.sph.kotlincourse

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class RVAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = emptyList<Record>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RVViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RVViewHolder).bind(items[position])
    }

}
