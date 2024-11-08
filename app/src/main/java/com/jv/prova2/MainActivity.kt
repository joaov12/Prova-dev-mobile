package com.jv.prova2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var semestreAdapter: SemestreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        semestreAdapter = SemestreAdapter(getSemestres()) { semestre ->
            val intent = Intent(this, NotaActivity::class.java)
            intent.putExtra("cpf", findViewById<EditText>(R.id.cpf).text.toString())
            intent.putExtra("valor", findViewById<EditText>(R.id.valor).text.toString().toDouble())
            intent.putExtra("ano", semestre.ano)
            intent.putExtra("semestre", semestre.semestre)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = semestreAdapter
    }

    private fun getSemestres(): List<Semestre> {
        return (2020..2024).flatMap { ano ->
            listOf(Semestre(ano, "1º semestre"), Semestre(ano, "2º semestre"))
        }
    }
}
