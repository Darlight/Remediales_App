package remedial2.example.com.remedial2

import android.app.Application

class Counter : LapHistory, Application() {
    companion object {
        val counter:Counter= Counter()
    }
    override val lapHistory: ArrayList<Int> = ArrayList()


    override fun clear() {
        lapHistory.clear()
    }

    override fun add(element: Int) {
        lapHistory.add(element)
    }

    override fun del(elementIndex: Int) {
        lapHistory.removeAt(elementIndex)
    }

}