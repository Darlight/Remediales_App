package example.com.remedial3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Funcion para mostrar, habilitary deshabilitar los texts

    fun mostrarTexto(view: View) {
        //Se llaman y referencian a las partes de mi interfaz
        //Botones, textviews
        val favorite: ImageButton = findViewById<ImageButton>(R.id.BotonEstrella)
        val ingresado: EditText = findViewById(R.id.NombreIngresado)
        val resultado: TextView = findViewById<TextView>(R.id.Resultado)
        val nombre: TextView = findViewById<TextView>(R.id.EtiquetaNombre)
        //Contador para la deshabilitacion de las partes indicadas
        var contador = 1 //contador iniciado en 1 porque los clicks empiezan en 0
        favorite.setOnClickListener {
            //La idea es que cada vez que se toque el boton se va a ir sumando 1 al cotador
            //Si es un numero par o sea, si el residuo de su division con 2 = 0, entonces estará
            //habilitado, de lo contrario se va a deshabilitar
            contador = contador + 1
            if (contador % 2 != 0) {

                //ingresado.setEnabled(true);
                //nombre.isEnabled= true
                nombre.visibility = View.VISIBLE
                ingresado.visibility = View.VISIBLE
                resultado.setText(ingresado.text.toString())
            } else {
                nombre.visibility = View.INVISIBLE
                ingresado.visibility = View.INVISIBLE

                //ingresado.setEnabled(false);
                //nombre.isEnabled= false
                resultado.setText(ingresado.text.toString())
            }

        }
    }

    //https://medium.com/@jencisov/androids-data-binding-with-kotlin-df94a24ffc0f
    fun abrirBotonTikal(view: View) {

        val intento: Intent = Intent(this, Descripcion_Lugar::class.java)
        intento.putExtra(
            "Place",
            Lugar(
                "Tikal",
                "Tikal (o Tik'al, de acuerdo con la ortografía maya moderna) es uno de los mayores yacimientos arqueológicos y centros urbanos de la civilización maya precolombina. Está situado en el municipio de Flores, en el departamento de Petén, en el territorio actual de la República de Guatemala y forma parte del Parque nacional Tikal, que fue declarado Patrimonio de la Humanidad, por Unesco, en 1979.1\u200B Según los glifos encontrados en el yacimiento, su nombre maya habría sido Yax Mutul",
                "El gran Jaguar es considerada una hermosa construcción"
            )
        )
        startActivity(intento)

    }


    fun abrirSemuc(view: View) {
        val intento: Intent = Intent(this, Descripcion_Lugar::class.java)
        intento.putExtra(
            "Place",
            Lugar(
                "Semuc Champey",
                "Semuc Champey (donde el río se esconde bajo las piedras), es un enclave natural localizado próximo al municipio guatemalteco de Lanquín (12 km aprox. al sur de Lanquín), en el departamento de Alta Verapaz, Guatemala. En el mismo, en medio de un espeso bosque tropical se halla un puente natural de piedra caliza de unos 300 metros de largo por el cual fluye el río Cahabón y en cuyos alrededores se encuentran una gran cantidad de pozas de 1 a 3 m de profundidad, cuyo color verde turquesa o color jade cambia a lo largo del año variando con el clima, el sol y otros factores naturales. Al final puede observarse al río Cahabón como se interna en una caverna de piedra caliza, área muy peligrosa para acercarse dentro del río por la fuerza del agua, sólo se permite observar a distancia este fenómeno geográfico natural.",
                "Agua Cristalina"
            )
        )
        startActivity(intento)

    }

    fun abrirAntigua(view: View) {
        val intento: Intent = Intent(this, Descripcion_Lugar::class.java)
        intento.putExtra(
            "Place", Lugar(
                "Antigua Guatemala",
                "La ciudad de Santiago de los Caballeros de Guatemala, cuyo nombre oficial e histórico es Muy Noble y Muy Leal Ciudad de Santiago de los Caballeros de Guatemala y popularmente nombrada en la actualidad como Antigua Guatemala, es cabecera del municipio homónimo y del departamento de Sacatepéquez, Guatemala; se ubica a aproximadamente 25 kilómetros al oeste de la capital de la República de Guatemala, y a una altitud de 1470 msnm.\n" +
                        "\n" +
                        "Durante la época de la colonia era conocida como «Santiago de los Caballeros de Guatemala», y fue la capital de la Capitanía General de Guatemala, entre 1541 y 1776, año en que la capital fue trasladada a la ciudad de Nueva Guatemala de la Asunción luego que los terremotos de Santa Marta arruinaran la ciudad por tercera ocasión en el mismo siglo3\u200B y las autoridades civiles utilizaran eso como excusa para debilitar a las autoridades eclesiásticas —siguiendo las recomendaciones de las Reformas Borbónicas emprendidas por la corona española en la segunda mitad del siglo xviii—4\u200B obligando a las órdenes regulares a trasladarse de sus majestuosos conventos a frágiles estructuras temporales en la nueva ciudad",
                "Antigua capital de la ciudad de Guatemala"
            )
        )
        startActivity(intento)
    }
    //Funcion para que el boton de regresar muestre un Toast con el comentario
    //Escrito e en editText
    fun backear(view: View) {
        val boton: Button = findViewById<Button>(R.id.back)
        val ingresdo: TextView = findViewById<TextView>(R.id.ComentarioIngresado)
        boton.setOnClickListener {
            // your code to perform when the user clicks on the button
            Toast.makeText(this, "No puede disminuir abajo de cero", Toast.LENGTH_LONG).show()
            val intento: Intent = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }



    }
}
