package com.example.filter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filter.Adapters.*
import com.example.filter.DataClass.Filter
import com.example.filter.DataClass.Interest
import com.example.filter.R
import com.example.filter.UI.InterestActivity
import kotlinx.android.synthetic.main.activity_main.*


val filterArray = arrayOf(
    Filter("Interest1"),
    Filter("Interest2"),
    Filter("Interest3"),
    Filter("Interest4"),
    Filter("Interest5"),
    Filter("Interest6")
)

val interestImageArray1 = arrayOf(
    Interest(R.drawable.data1),
    Interest(R.drawable.data2),
    Interest(R.drawable.data3),
    Interest(R.drawable.data4),
    Interest(R.drawable.data5)
)

val interestImageArray2 = arrayOf(
    Interest(R.drawable.data6),
    Interest(R.drawable.data7),
    Interest(R.drawable.data8),
    Interest(R.drawable.data9)
)


val interestImageArray3 = arrayOf(
    Interest(R.drawable.data10),
    Interest(R.drawable.data11),
    Interest(R.drawable.data12)
)
val interestImageArray4 = arrayOf(
    Interest(R.drawable.data13),
    Interest(R.drawable.data14),
    Interest(R.drawable.data15),
    Interest(R.drawable.data16),
    Interest(R.drawable.data17)
)


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filterList = filter.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = FilterAdapter {
                Toast.makeText(this@MainActivity, it.filterText, Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MainActivity, InterestActivity::class.java)
                intent.putExtra("key", it.filterText.toString())
                startActivity(intent)

            }.apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)
        }

        (filterList.adapter as FilterAdapter).filterData = filterArray


        val interestList1 = interest1.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = InterestAdapter1().apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)
        }
        (interestList1.adapter as InterestAdapter1).interestData = interestImageArray1


        val interestList2 = interest2.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = InterestAdapter2().apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)
        }
        (interestList2.adapter as InterestAdapter2).interestData = interestImageArray2


        val interestList3 = interest3.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = InterestAdapter3().apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)
        }
        (interestList3.adapter as InterestAdapter3).interestData = interestImageArray3


        val interestList4 = interest4.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = InterestAdapter4().apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)
        }
        (interestList4.adapter as InterestAdapter4).interestData = interestImageArray4
    }

    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}