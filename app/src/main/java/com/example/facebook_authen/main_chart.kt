package com.example.facebook_authen


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.ColorTemplate

/**
 * A simple [Fragment] subclass.
 */
class MainChart : Fragment() {

    lateinit var Bar_id : BarChart

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main_chart, container, false)

        Bar_id = view.findViewById(R.id.Bar_id)

        Bar_Chart(Bar_id)

        return view
    }

    fun Bar_Chart( chart : BarChart ){

        chart.description.isEnabled = false
        val listStudent = Student.getSampleStudentData()
        val entries: ArrayList<BarEntry> = ArrayList()
        var index : Float = 0F
        for (student in listStudent) {
            entries.add(BarEntry(index, student.score))
            index++
        }
        val dataset = BarDataSet(entries, "อุณหภูมิ")
        dataset.valueTextSize = 10F
        dataset.setColors(*ColorTemplate.VORDIPLOM_COLORS)

        val dataSets = ArrayList<IBarDataSet>()
        dataSets.add(dataset)

        val data = BarData(dataSets)
        chart.setData(data)
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM)
        chart.getXAxis().setLabelRotationAngle(80F)

        val xAxis = chart.xAxis
        xAxis.setTextSize(10F)
        xAxis.granularity = 1f
        xAxis.setValueFormatter(object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String? {
//                if( value < 0 || value >= listStudent.size ){
//                    return ""
//                }
//                else{
                    return listStudent[value.toInt()].name
//                }
            }
        })

        val leftAxis = chart.axisLeft
        leftAxis.setLabelCount(8, false)
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        leftAxis.spaceTop = 15f
        leftAxis.axisMinimum = 0f

        val rightAxis = chart.axisRight
        rightAxis.setEnabled(false)

        chart.animateY(3000)

    }


}


