package tw.tcnr23.m1501

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment // 空建構
    : Fragment() {
    private var msg: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) { // 如果有參數
            // 取出參數內容
            msg = arguments!!.getString(MESSAGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 片段元件內容
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        // 取得TextView元件
        val output = view.findViewById<View>(R.id.lblOutput) as TextView
        output.text = msg // 指定TextView元件內容
        return view
    }

    companion object {
        private const val MESSAGE = "MESSAGE"

        // 類別方法來建立SecondFragment物件
        fun newInstance(msg: String?): SecondFragment {
            val fragment = SecondFragment()
            val args = Bundle() //  新增參數
            args.putString(MESSAGE, msg)
            fragment.arguments = args
            return fragment
        }
    }
}