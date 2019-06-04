package example.com.remedial3

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import example.com.remedial3.databinding.ActivityDescripcionLugarBinding

class Descripcion_Lugar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion__lugar)
        val lugar = intent.extras["Place"]
        val binding : ActivityDescripcionLugarBinding = DataBindingUtil.setContentView(this, R.layout.activity_descripcion__lugar)
        binding.run {
            setVariable(BR.Place, lugar)
            executePendingBindings()
        }
    }
    //funcion para regresar al menu principal y mostrar en pantalla un toast del comentarion ingresado
    fun turn_back(view: View) {
        val boton: Button = findViewById<Button>(R.id.back)
        val ingresdo: TextView = findViewById<TextView>(R.id.ComentarioIngresado)
        boton.setOnClickListener {
            Toast.makeText(this, ingresdo.text , Toast.LENGTH_LONG).show()
            val intento: Intent = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }



    }
}
