package com.example.interactive_image

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
//Main de la aplicacion interactive image donde el toast muestra un mensaje perzonalizado "¡Chumimi-in!"
//Autor: Joel Matias Choquepata Guarniz
//FechaCreacion: 4/10/2026
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagen = findViewById<ImageView>(R.id.miImagen)

        imagen.setOnClickListener {
            Toast.makeText(this, "¡Chumimi-in!", Toast.LENGTH_SHORT).show()
        }
    }
}