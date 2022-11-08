package com.example.myapplication

import android.content.ContentValues
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.database.AdminSQLiteOpenHelper


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ingresar()
        registrar()


    }

    fun ingresar(){
        val email2 = findViewById<EditText>(R.id.emailL)
        val pass2 = findViewById<EditText>(R.id.passwordL)
        val btn2 = findViewById<Button>(R.id.buttonL)
        btn2.setOnClickListener {
            val emailCamp2: String = email2.text.toString().trim()
            val passCamp2: String = pass2.text.toString().trim()
            if (emailCamp2.isEmpty() || passCamp2.isEmpty()){
                Toast.makeText(this,"Debes ingresar email y contraseña",Toast.LENGTH_SHORT).show()
            }else {
                validacion()
            }

        }
    }

    fun registrar(){
        val email = findViewById<EditText>(R.id.emailR)
        val pass = findViewById<EditText>(R.id.passwordR)
        val btn1 = findViewById<Button>(R.id.buttonR)
        btn1.setOnClickListener {
            val emailCamp: String = email.text.toString().trim()
            val passCamp: String = pass.text.toString().trim()
            if (emailCamp.isEmpty() || passCamp.isEmpty()){
                Toast.makeText(this,"Debes ingresar email y contraseñal",Toast.LENGTH_SHORT).show()
            }else {
                database()
            }

        }
    }

    fun database(){
        val email = findViewById<EditText>(R.id.emailR)
        val pass = findViewById<EditText>(R.id.passwordR)
        val admin = AdminSQLiteOpenHelper(this,"Registros.sqlite",null,1)
        val p0 = admin.writableDatabase
        val registro = ContentValues()
        registro.put("email",email.text.toString().trim())
        registro.put("password",pass.text.toString().trim())
        p0.insert("usuarios",null,registro)
        p0.close()
        email.setText("")
        pass.setText("")
    }

    fun validacion(){
        val email2 = findViewById<EditText>(R.id.emailL)
        val pass2 = findViewById<EditText>(R.id.passwordL)
            val emailCamp = email2.text.toString().trim()
            val passCamp = pass2.text.toString().trim()
            val admin = AdminSQLiteOpenHelper(this,"Registros.sqlite",null,1)
            val read = admin.readableDatabase
            read.execSQL("SELECT * FROM usuarios WHERE email = ")
            if (read != null){
                val intent = Intent(this,Crud::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show()
            }


    }


}




