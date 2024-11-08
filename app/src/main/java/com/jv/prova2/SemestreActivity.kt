/*package com.jv.prova2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SemestreActivity : AppCompatActivity() {

    private lateinit var anoTextView: TextView
    private lateinit var semestreTextView: TextView
    private lateinit var cpfTextView: TextView
    private lateinit var disponivelParaSaqueTextView: TextView
    private lateinit var creditosNaoLiberadosTextView: TextView
    private lateinit var novoValorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semestre)

        anoTextView = findViewById(R.id.anoTextView)
        semestreTextView = findViewById(R.id.semestreTextView)
        cpfTextView = findViewById(R.id.cpfTextView)
        disponivelParaSaqueTextView = findViewById(R.id.disponivelParaSaqueTextView)
        creditosNaoLiberadosTextView = findViewById(R.id.creditosNaoLiberadosTextView)
        novoValorTextView = findViewById(R.id.novoValorTextView)

        val ano = intent.getIntExtra("ano", 0)
        val semestre = intent.getIntExtra("semestre", 0)
        val cpf = intent.getStringExtra("cpf")
        val disponivelParaSaque = intent.getDoubleExtra("disponivelParaSaque", 0.0)
        val creditosNaoLiberados = intent.getDoubleExtra("creditosNaoLiberados", 0.0)
        val valor = intent.getDoubleExtra("valor", 0.0)

        anoTextView.text = "Ano: $ano"
        semestreTextView.text = "Semestre: $semestre"
        cpfTextView.text = "CPF: $cpf"
        disponivelParaSaqueTextView.text = "Disponível para saque: $disponivelParaSaque"
        creditosNaoLiberadosTextView.text = "Créditos não liberados: $creditosNaoLiberados"

        val novoValor = when (ano) {
            2020 -> valor
            2021 -> valor * 0.9
            2022 -> valor * 0.8
            2023 -> valor * 0.7
            2024 -> valor * 0.6
            else -> 0.0
        }
        novoValorTextView.text = "Novo valor: $novoValor"
    }
}
*/