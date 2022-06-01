package com.example.aula7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //para a activi main aparecer aqui, tem que inflar o layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //como ativou binding(baynd)
        //pode colocar o botão

        binding.btnApply.setOnClickListener {

            val name = binding.etNome.text.toString()
            val age = binding.etAge.text.toString().toInt()
            val country = binding.etCountry.text.toString()

            //intent, intenção de navergar de uma pagina para a outra
            //O intente tem que ser importado Alt+Enter
            Intent(this, SecondActivity::class.java).also {
              // it.putExtra("EXTRA_NAME", name)  // ("CHAVE", valor)
              // it.putExtra("EXTRA_AGE", age)
              // it.putExtra("EXTRA_COUNTRY", country)

                //o it vai ser a intent e vai navegar de uma activity para a outra

                //Abrindo a caixinha
                val bundle = Bundle() // também é um pacote igual ao it.putExtra
                bundle.putString("EXTRA_NAME", name) // ("CHAVE", valor)
                bundle.putInt("EXTRA_AGE", age)
                bundle.putString("EXTRA_COUNTRY", country)
                it.putExtras(bundle) //fechando a caixinha
                // tem que passar o bunble que foi criado no val bundle = Bundle()
                // tem que recuperar o bundle no SecondActivity.kt. Tem que ir lá na SecondActivity.kt
                // Esse it.putExtras(bundle) serve para fechar o val bundle = Bundle() que foi iniciado

                startActivity(it)  // inicia uma ação

            }
        }
     }
    }
// O que cada um desses parametrosrepresenta?

// O intent precisa saber do contexto do qual ele está partindo
//(entende-se, neste caso, contexto como sendo a activity que é
// o ponto de partida da navegação a ser realizada) e o destino da transição.

//A activity de destino é o segundo argumento passado em seu construtor - no caso,
//SecondActivity, que é uma activity de destino qualquer.
//Esse código seria o equivalente a dizer: "Intent, favor navegar desta
//activity (this) para a outra activity (SecondActiviy)"

// Contudo o intent, por si só, não é capaz de realizar a trasição.
// É necessário o uso de uma função nativa que dá um  "empurrãozinho"
// para a "intenção"(intent) realmente se torne uma ação.
// Trata-se da ação startActivity().