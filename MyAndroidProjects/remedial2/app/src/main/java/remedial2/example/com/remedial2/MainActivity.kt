package remedial2.example.com.remedial2
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import remedial2.example.com.remedial2.Counter.Companion.counter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val elements = ArrayAdapter(this,android.R.layout.simple_list_item_1, Counter.counter.lapHistory)
        listE.adapter = elements


        listE.onItemLongClickListener = AdapterView.OnItemLongClickListener { parent, view, position, long ->
            //If the click is long, deletes the register
            Toast.makeText(applicationContext,"Register deleted.", Toast.LENGTH_SHORT).show()
            Counter.counter.del(position)
            elements.notifyDataSetChanged()
            true
        }
        newCourse.setOnClickListener {
            startActivity(Intent(this, NewCourse::class.java)) //Start new Course
        }
        Historial.setOnClickListener{
            Counter.counter.clear()
            Toast.makeText(applicationContext,"All elements have been deleted.", Toast.LENGTH_SHORT).show()
            val elements = ArrayAdapter(this,android.R.layout.simple_list_item_1, Counter.counter.lapHistory)
            listE.adapter = elements
        }
    }
}
