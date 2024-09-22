package com.example.project1;

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Calculator2Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator2)

        val Hr : TextView = findViewById(R.id.HrValue2)
        val Cr : TextView = findViewById(R.id.CrValue2)
        val Sr : TextView = findViewById(R.id.SrValue2)
        val Or : TextView = findViewById(R.id.OrValue2)
        val Vr : TextView = findViewById(R.id.VrValue2)
        val Wr : TextView = findViewById(R.id.WrValue2)
        val Ar : TextView = findViewById(R.id.ArValue2)
        val Qdafi : TextView = findViewById(R.id.QdafiValue2)

        val Hp : TextView = findViewById(R.id.HpValue2)
        val Cp : TextView = findViewById(R.id.CpValue2)
        val Sp : TextView = findViewById(R.id.SpValue2)
        val Op : TextView = findViewById(R.id.OpValue2)
        val Vp : TextView = findViewById(R.id.VpValue2)
        val Ap : TextView = findViewById(R.id.ApValue2)
        val Qri : TextView = findViewById(R.id.QriValue2)

        val resultButton : Button = findViewById(R.id.calculateButton)
        val backButton : Button = findViewById(R.id.backButton)

        backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        resultButton.setOnClickListener{
            val HrValue = Hr.text.toString().toFloat()
            val CrValue = Cr.text.toString().toFloat()
            val SrValue = Sr.text.toString().toFloat()
            val OrValue = Or.text.toString().toFloat()
            val VrValue = Vr.text.toString().toFloat()
            val WrValue = Wr.text.toString().toFloat()
            val ArValue = Ar.text.toString().toFloat()
            val QdafiValue = Qdafi.text.toString().toFloat()

            val HpValue = HrValue * (100 - WrValue - ArValue) / 100
            val CpValue = CrValue * (100 - WrValue - ArValue) / 100
            val SpValue = SrValue * (100 - WrValue - ArValue) / 100
            val OpValue = OrValue * (100 - WrValue - ArValue) / 100
            val VpValue = VrValue * (100 - WrValue) / 100
            val ApValue = ArValue * (100 - WrValue) / 100
            val QriValue = QdafiValue * ((100 - WrValue - ArValue) / 100) - 0.025 * WrValue

            Hp.text = HpValue.toString()
            Cp.text = CpValue.toString()
            Sp.text = SpValue.toString()
            Op.text = OpValue.toString()
            Vp.text = VpValue.toString()
            Ap.text = ApValue.toString()
            Qri.text = QriValue.toString()
        }
    }
}