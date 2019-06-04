package remedial2.example.com.remedial2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new_course.*

class NewCourse : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_course)
        val valor: ArrayList<Int> = arrayListOf<Int>(1,3,5,10)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,valor)
        list.adapter = adapter
        list.setOnItemClickListener  {parent, view, position : Int, id: Long ->
            val item = list.selectedItem
            counterr.text = list.getItemAtPosition(position).toString()
        }
    }
    fun initiate(view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        //Returns back to Mainactivity
    }

    fun addElements(view: View) {
        Toast.makeText(this, "Register has been saved. ", Toast.LENGTH_LONG).show()
        Counter.counter.add(counterr.text.toString().toInt())
        //Creates that Int value into the counter list
    }

    fun addLoops(view: View) {
        counterr.text = (counterr.text.toString().toInt() + 1).toString()
        //Just adds a number in the counter
    }

    fun subtractLoops(view: View){
        if(counterr.text.toString().toInt() != 0){
            counterr.text = (counterr.text.toString().toInt() - 1).toString(
                //opposite of addLoops, with an extra condition
            )
        }else if((counterr.text.toString().toInt() == 0)) {
            Toast.makeText(this, "You can't go below 0.", Toast.LENGTH_LONG).show()
        }

    }
}
