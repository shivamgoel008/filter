package com.example.filter.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filter.*
import com.example.filter.Adapters.InterestAdapter1
import com.example.filter.Adapters.InterestAdapter2
import com.example.filter.Adapters.InterestAdapter3
import com.example.filter.Adapters.InterestAdapter4
import kotlinx.android.synthetic.main.activity_interest.*


class InterestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interest)

        val intent = intent

        val result = intent.getStringExtra("key")

        when (result) {
            "Interest1" -> {
                particular_interest_text.text = result
                val interestList1 = particular_interest.apply {
                    layoutManager =
                        LinearLayoutManager(
                            this@InterestActivity,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                    adapter = InterestAdapter1().apply {
                        setHasStableIds(true)
                    }
                    setHasFixedSize(true)
                }
                (interestList1.adapter as InterestAdapter1).interestData = interestImageArray1

            }
            "Interest2" -> {
                particular_interest_text.text = result
                val interestList2 = particular_interest.apply {
                    layoutManager = LinearLayoutManager(
                        this@InterestActivity,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    adapter = InterestAdapter2().apply {
                        setHasStableIds(true)
                    }
                    setHasFixedSize(true)
                }
                (interestList2.adapter as InterestAdapter2).interestData = interestImageArray2

            }
            "Interest3" -> {
                particular_interest_text.text = result
                val interestList3 = particular_interest.apply {
                    layoutManager = LinearLayoutManager(
                        this@InterestActivity,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    adapter = InterestAdapter3().apply {
                        setHasStableIds(true)
                    }
                    setHasFixedSize(true)
                }
                (interestList3.adapter as InterestAdapter3).interestData = interestImageArray3
            }
            "Interest4" -> {
                particular_interest_text.text = result
                val interestList4 = particular_interest.apply {
                    layoutManager = LinearLayoutManager(
                        this@InterestActivity,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    adapter = InterestAdapter4().apply {
                        setHasStableIds(true)
                    }
                    setHasFixedSize(true)
                }
                (interestList4.adapter as InterestAdapter4).interestData = interestImageArray4
            }
        }


        println("Shivam $result")
    }
}