package aguilar.cristina.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lblResultado : TextView =findViewById(R.id.tvResultado)
        var lblEstado : TextView =findViewById(R.id.tvEstado)

        var txtEstatura: EditText =findViewById(R.id.etEstatura)
        var txtPeso: EditText =findViewById(R.id.etPeso)
        var btnCalcula: Button =findViewById(R.id.btnCalcula)

        btnCalcula.setOnClickListener {
            if(!txtEstatura.text.isBlank() || !txtPeso.text.isBlank()){
                val imcNum=calcularIMC(txtEstatura.text.toString().toDouble(),
                    txtEstatura.text.toString().toDouble())
                lblResultado.setText(imcNum.toString())

                val estado = this.obtenEstado(imcNum)
                lblEstado.setText(estado)

                when(estado){
                    "Bajo peso" -> lblEstado.setBackgroundResource(R.color.colorBrown)
                    "Saludable" -> lblEstado.setBackgroundResource(R.color.colorGreen)
                    "Sobrepeso" -> lblEstado.setBackgroundResource(R.color.colorGreenish)
                    "Obesidad grado 1" -> lblEstado.setBackgroundResource(R.color.colorYellow)
                    "Obesidad grado 2" -> lblEstado.setBackgroundResource(R.color.colorOrange)
                    "Obesidad grado 3" -> lblEstado.setBackgroundResource(R.color.colorRed)


                }
            }


        }


    }

    fun calcularIMC(altura:Double, peso:Double):Double{
        val imc:Double =(peso/(Math.pow(altura,2.0)))
        return imc
    }

    fun obtenEstado(imc:Double):String{
        when{
            imc < 18.5 -> return "Bajo peso"
            imc >= 18.5 && imc <= 24.9-> return "Saludable"
            imc >= 24.9 && imc <= 29.9-> return "Sobrepeso"
            imc >= 29.9 && imc <= 34.9-> return "Obesidad grado 1"
            imc >= 34.9 && imc <= 40 -> return "Obesidad grado 2"
            imc >= 40 -> return "Obesidad grado 3"
        }
        return "Error"
    }
}