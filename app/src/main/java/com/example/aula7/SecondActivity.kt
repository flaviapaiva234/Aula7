package com.example.aula7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula7.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        val name = intent.getStringExtra("EXTRA_NAME")
//        val age = intent.getIntExtra('EXTRA_AGE', 0)
//        val country = intent.getStringExtra("EXTRA_COUNTRY")
//
//        val personSting = "$name tem age anos de idade e vive no $country"
//
//        binding.tvPerson.text = personSting

        // recuperando a intenção extras (intent)
        val extras = intent.extras //(vai recuperar esse bundle

        //criar novas variáveis
        //incoming é que está vindo = tem que deixar a ? que é para a opção do null,
        // se não, pode acabar dando cresh
        val incomingName = extras?.getString("EXTRA_NAME") // getString => é para trazer a nossa String
        val incomingAge = extras?.getInt("EXTRA_AGE")
        val incomingCountry = extras?.getString("EXTRA_COUNTRY")

        val personSting = "$incomingName tem $incomingAge anos de idade e vive no $incomingCountry"

        //tvPerson => TextViewPerson
        binding.tvPerson.text = personSting // vai vincular ao personString


    }
}