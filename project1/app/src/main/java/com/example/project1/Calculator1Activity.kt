package com.example.project1;

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class Calculator1Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator1)

        val Hp : EditText = findViewById(R.id.HpValue)
        val Cp : EditText = findViewById(R.id.CpValue)
        val Sp : EditText = findViewById(R.id.SpValue)
        val Np : EditText = findViewById(R.id.NpValue)
        val Op : EditText = findViewById(R.id.OpValue)
        val Wp : EditText = findViewById(R.id.WpValue)
        val Ap : EditText = findViewById(R.id.ApValue)

        val Kpc : TextView = findViewById(R.id.KpcValue)
        val Kpr : TextView = findViewById(R.id.KprValue)

        val Hc : TextView = findViewById(R.id.HcValue)
        val Cc : TextView = findViewById(R.id.CcValue)
        val Sc : TextView = findViewById(R.id.ScValue)
        val Nc : TextView = findViewById(R.id.NcValue)
        val Oc : TextView = findViewById(R.id.OcValue)
        val Ac : TextView = findViewById(R.id.AcValue)

        val Hr : TextView = findViewById(R.id.HrValue)
        val Cr : TextView = findViewById(R.id.CrValue)
        val Sr : TextView = findViewById(R.id.SrValue)
        val Nr : TextView = findViewById(R.id.NrValue)
        val Or : TextView = findViewById(R.id.OrValue)

        val Qph : TextView = findViewById(R.id.QphValue)
        val Qch : TextView = findViewById(R.id.QchValue)
        val Qrh : TextView = findViewById(R.id.QrhValue)


        val resultButton : Button = findViewById(R.id.calculateButton)
        val backButton : Button = findViewById(R.id.backButton)

        backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        resultButton.setOnClickListener {
            val HpValue = Hp.text.toString().toFloat()
            val CpValue = Cp.text.toString().toFloat()
            val SpValue = Sp.text.toString().toFloat()
            val NpValue = Np.text.toString().toFloat()
            val OpValue = Op.text.toString().toFloat()
            val WpValue = Wp.text.toString().toFloat()
            val ApValue = Ap.text.toString().toFloat()

            val KpcValue = 100 / (100 - WpValue)
            val KpgValue = 100 / (100 - WpValue - ApValue)

            Kpc.text = KpcValue.toString()
            Kpr.text = KpgValue.toString()

            val HcValue = HpValue * KpcValue
            val CcValue = CpValue * KpcValue
            val ScValue = SpValue * KpcValue
            val NcValue = NpValue * KpcValue
            val OcValue = OpValue * KpcValue
            val AcValue = ApValue * KpcValue

            val totalC = HcValue + CcValue + ScValue + NcValue + OcValue + AcValue

            if (String.format(Locale.US, "%.1f", totalC).toFloat() == 100.0.toFloat()) {
                Hc.text = HcValue.toString()
                Cc.text = CcValue.toString()
                Sc.text = ScValue.toString()
                Nc.text = NcValue.toString()
                Oc.text = OcValue.toString()
                Ac.text = AcValue.toString()
            }

            val HgValue = HpValue * KpgValue
            val CgValue = CpValue * KpgValue
            val SgValue = SpValue * KpgValue
            val NgValue = NpValue * KpgValue
            val OgValue = OpValue * KpgValue

            val totalG = HgValue + CgValue + SgValue + NgValue + OgValue

            if (String.format(Locale.US, "%.1f", totalG).toFloat() == 100.0.toFloat()) {
                Hr.text = HgValue.toString()
                Cr.text = CgValue.toString()
                Sr.text = SgValue.toString()
                Nr.text = NgValue.toString()
                Or.text = OgValue.toString()
            }

            val QphValue = (339 * CpValue + 1030 * HpValue - 108.8 * (OpValue - SpValue) - 25 * WpValue) / 1000
            val QchValue = (QphValue + 0.025 * WpValue) * (100 / (100 - WpValue))
            val QghValue = (QphValue + 0.025 * WpValue) * (100 / (100 - WpValue - ApValue))

            Qph.text = QphValue.toString()
            Qch.text = QchValue.toString()
            Qrh.text = QghValue.toString()
        }
    }
}
