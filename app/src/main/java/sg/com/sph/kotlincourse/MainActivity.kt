package sg.com.sph.kotlincourse

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val testItems = listOf(Record("1.11", "Q1", 0))

    private var rvAdapter: RVAdapter = RVAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Constants.getApi().getResalePriceIndex(15).enqueue(object: Callback<HDBResalePriceIndexSchema>{
            override fun onFailure(call: Call<HDBResalePriceIndexSchema>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Call Failed: ${t.message}", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<HDBResalePriceIndexSchema>,
                                    response: Response<HDBResalePriceIndexSchema>) {
                println("Yeah! ${response.body()?.result?.records}")

                rvAdapter.items = response.body()?.result?.records?:testItems
                rvAdapter.notifyDataSetChanged()
            }

        })

        rvAdapter.items = testItems

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        layoutManager.stackFromEnd = true
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = rvAdapter
    }
}
