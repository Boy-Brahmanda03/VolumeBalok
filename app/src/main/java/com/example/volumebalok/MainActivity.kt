package com.example.volumebalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var panjangET:EditText
    private lateinit var lebarET:EditText
    private lateinit var tinggiET:EditText
    private lateinit var btnHasil:Button
    private lateinit var hasilTV:TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        btnHasil.setOnClickListener(this)
        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            hasilTV.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, hasilTV.text.toString())
    }

    fun initComponents() {
        panjangET = findViewById(R.id.panjangEditText)
        lebarET = findViewById(R.id.lebarEditText)
        tinggiET = findViewById(R.id.tinggiEditText)
        btnHasil = findViewById(R.id.btnHitung)
        hasilTV = findViewById(R.id.hasilTextView)
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btnHitung) {
            val p = panjangET.text.toString()
            val l = lebarET.text.toString()
            val t = tinggiET.text.toString()


            var isempty = false

            if (p.isEmpty()){
                isempty = true
                panjangET.error = "Field ini tidak boleh kosong"
            }

            if (l.isEmpty()){
                isempty = true
                lebarET.error = "Field ini tidak boleh kosong"
            }

            if (t.isEmpty()) {
                isempty = true
                tinggiET.error = "Field ini tidak boleh kosong"
            }

            if (!isempty) {
                var hasil = p.toInt() * l.toInt() * t.toInt()
                hasilTV.text = hasil.toString()
            }
        }
    }
}