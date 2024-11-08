package com.jv.prova2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NotaActivity : AppCompatActivity() {

    private lateinit var cpfTextView: TextView
    private lateinit var valorTextView: TextView
    private lateinit var semestreTextView: TextView
    private lateinit var bancoSpinner: Spinner
    private lateinit var tipoContaSpinner: Spinner
    private lateinit var agenciaEditText: EditText
    private lateinit var contaEditText: EditText
    private lateinit var resultadoTextView: TextView
    private lateinit var processButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

        cpfTextView = findViewById(R.id.cpfTextView)
        valorTextView = findViewById(R.id.valorTextView)
        semestreTextView = findViewById(R.id.semestreTextView)
        bancoSpinner = findViewById(R.id.bancoSpinner)
        tipoContaSpinner = findViewById(R.id.tipoContaSpinner)
        agenciaEditText = findViewById(R.id.agenciaEditText)
        contaEditText = findViewById(R.id.contaEditText)
        resultadoTextView = findViewById(R.id.resultadoTextView)
        processButton = findViewById(R.id.processButton)

        val cpf = intent.getStringExtra("cpf") ?: ""
        val valor = intent.getDoubleExtra("valor", 0.0)
        val ano = intent.getIntExtra("ano", 2024)
        val semestre = intent.getStringExtra("semestre") ?: ""


        cpfTextView.text = "CPF: $cpf" // mudando pra ano o cpf somente pra ver como esta sendo passado
        valorTextView.text = "Valor disponível: $valor"

        semestreTextView.text = "Ano: $ano"

        val bancos = arrayOf("Banco do Brasil", "Banco Inter", "Nubank", "Sicredi", "Itau")
        val bancoAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bancos)
        bancoSpinner.adapter = bancoAdapter

        val tiposConta = arrayOf("Conta Corrente", "Conta Poupança", "Conta Salario")
        val tipoContaAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposConta)
        tipoContaSpinner.adapter = tipoContaAdapter

        processButton.setOnClickListener {
            val bancoSelecionado = bancoSpinner.selectedItem.toString()
            val tipoContaSelecionado = tipoContaSpinner.selectedItem.toString()
            val agencia = agenciaEditText.text.toString()
            val conta = contaEditText.text.toString()

            val saqueValor = calcularValorSaque(valor, ano)

            resultadoTextView.text = """
                Pedido de saque em processamento.
                Banco: $bancoSelecionado
                Tipo de Conta: $tipoContaSelecionado
                Agência: $agencia-1
                Conta: $conta-1
                Valor para saque: $saqueValor
            """.trimIndent()
        }

    }

    private fun calcularValorSaque(valor: Double, ano: Int): Double {
        return when (ano) {
            2020 -> valor
            2021 -> valor * 0.9
            2022 -> valor * 0.8
            2023 -> valor * 0.7
            2024 -> valor * 0.6
            else -> valor * 0.6
        }
    }
}