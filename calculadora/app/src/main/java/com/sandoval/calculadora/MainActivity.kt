package com.sandoval.calculadora

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        numero_zero.setOnClickListener { acrescentarUmaExpressao("0", true) }
        numero_um.setOnClickListener { acrescentarUmaExpressao("1", true) }
        numero_dois.setOnClickListener { acrescentarUmaExpressao("2", true) }
        numero_treis.setOnClickListener { acrescentarUmaExpressao("3", true) }
        numero_quatro.setOnClickListener { acrescentarUmaExpressao("4", true) }
        numero_cinco.setOnClickListener { acrescentarUmaExpressao("5", true) }
        numero_seis.setOnClickListener { acrescentarUmaExpressao("6", true) }
        numero_sete.setOnClickListener { acrescentarUmaExpressao("7", true) }
        numero_oito.setOnClickListener { acrescentarUmaExpressao("8", true) }
        numero_nove.setOnClickListener { acrescentarUmaExpressao("9", true) }
        ponto.setOnClickListener { acrescentarUmaExpressao(".", true) }


        /*operadores*/
        somar.setOnClickListener { acrescentarUmaExpressao("+", false) }
        subtracao.setOnClickListener { acrescentarUmaExpressao("-", false) }
        multiplicacao.setOnClickListener { acrescentarUmaExpressao("*", false) }
        divisao.setOnClickListener { acrescentarUmaExpressao("/", false) }

        limpar.setOnClickListener {
            expressao.text = ""
            resultado.text = ""
        }
        backspace.setOnClickListener{

            val string = expressao.text.toString()

            if (string.isNotEmpty()) {
                expressao.text = string.substring(0, string.length - 1)
            }
            resultado.text=""
        }

        igual.setOnClickListener {


            try {
                val sentenca =ExpressionBuilder(expressao.text.toString()).build()
                acrescentarUmaExpressao("=", true)
                val calculo=sentenca.evaluate()
                val longResult = calculo.toLong()

                if(calculo==longResult.toDouble())
                    resultado.text=longResult.toString()
                else
                    resultado.text=calculo.toString()

            }catch (ex:Exception ){
                println("Ocorreu um Erro")

            }

        }

    }
    fun acrescentarUmaExpressao(string:String,limpar_dados:Boolean){

        if(resultado.text.isNotEmpty()){
            expressao.text=""
        }
        if(limpar_dados){
            resultado.text=""
            expressao.append(string)
        }else {
            expressao.append(resultado.text)
            expressao.append(string)
            resultado.text = ""
        }
   }
}

