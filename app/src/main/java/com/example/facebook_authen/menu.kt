package com.example.facebook_authen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook_authen.MyRecyclerAdapter
import org.json.JSONObject


class menu : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_menu, container, false)
        val jsonString : String = loadJsonFromAsset("Data.json", activity!!.baseContext).toString()
        val json = JSONObject(jsonString)
        val jsonArray = json.getJSONArray("Solar_System")
        val recyclerView: RecyclerView = view.findViewById(R.id.recyview_layout)
        val login: Button = view.findViewById(R.id.chart);
        val fm = fragmentManager
        val transaction : FragmentTransaction = fm!!.beginTransaction()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity!!.baseContext)
        recyclerView.layoutManager = layoutManager
        val adapter = MyRecyclerAdapter(activity!!.baseContext,activity!!.supportFragmentManager,jsonArray)
        recyclerView.adapter = adapter
        login.setOnClickListener {
            val MainChart = MainChart()
            val fm = fragmentManager
            val transaction: FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, MainChart, "MainChart")
            transaction.addToBackStack("MainChart")
            transaction.commit()
        }
        return view
    }

    private fun loadJsonFromAsset(filename: String, context: Context): String? {
        val json: String?

        try {
            val inputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: java.io.IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }
}




