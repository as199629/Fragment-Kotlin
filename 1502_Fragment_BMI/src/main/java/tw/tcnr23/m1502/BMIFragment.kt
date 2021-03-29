package tw.tcnr23.m1502

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class BMIFragment : Fragment() {
    private var txtHeight: EditText? = null
    private var txtWeight: EditText? = null
    private var button: Button? = null
    var activityCallback: BMIListener? = null

    // 父活動實作的介面宣告
    interface BMIListener {
        fun onButtonClick(bmi: Double)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityCallback = try {  // 取得父活動物件
            context as BMIListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString() +
                        "需實作BMIListener"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bmi, container, false)
        txtHeight = view.findViewById<View>(R.id.txtHeight) as EditText
        txtWeight = view.findViewById<View>(R.id.txtWeight) as EditText
        button = view.findViewById<View>(R.id.button) as Button
        // 建立Button按鈕的事件處理
        button!!.setOnClickListener { v -> buttonClicked(v) }
        return view
    }

    fun buttonClicked(view: View?) {
        var height: Double
        val weight: Double
        val bmi: Double
        // 取得輸入值
        if (txtHeight!!.text.toString()
                .trim { it <= ' ' }.length == 0 || txtWeight!!.text.toString()
                .trim { it <= ' ' }.length == 0
        ) {
            bmi = 0.0
        } else {
            height = txtHeight!!.text.toString().toDouble()
            weight = txtWeight!!.text.toString().toDouble()
            // 計算BMI
            height = height / 100.00
            bmi = weight / (height * height)
        }
        // 呼叫父活動的介面方法
        activityCallback!!.onButtonClick(bmi)
    }
}