package tw.tcnr23.m1502

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TextFragment : Fragment() {
    private var output: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_text, container, false)
        output = view.findViewById<View>(R.id.lblOutput) as TextView
        return view
    }

    // 活動呼叫的Public方法
    fun changeBMIValue(bmi: Double) {
        var result_bmi: String? = null
        result_bmi = if (bmi == 0.0) {
            getString(R.string.whnull) //體重及身高必須輸入
        } else {
            val Tbmi = getString(R.string.yourbmi) + String.format("%.4f", bmi) //你的BMI值:
            if (bmi > 25) {
                """
     $Tbmi
     
     ${getString(R.string.advice_heavy)}
     """.trimIndent() //你該節食了
            } else if (bmi < 20) {
                """
     $Tbmi
     
     ${getString(R.string.advice_light)}
     """.trimIndent() //你該多吃點
            } else {
                """
     $Tbmi
     
     ${getString(R.string.advice_average)}
     """.trimIndent() //體型很棒喔
            }
        }
        output!!.text = result_bmi
    }
}