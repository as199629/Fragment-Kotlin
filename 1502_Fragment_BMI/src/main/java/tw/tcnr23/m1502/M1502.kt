package tw.tcnr23.m1502

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import tw.tcnr23.m1502.BMIFragment.BMIListener

class M1502 : AppCompatActivity(), BMIListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m1502)
    }

    // 實作BMIListener介面方法
    override fun onButtonClick(bmi: Double) {
        val fm = supportFragmentManager
        val tf = fm.findFragmentById(R.id.fragment2) as TextFragment?
        //  呼叫TextFragment物件的方法
        tf!!.changeBMIValue(bmi)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}