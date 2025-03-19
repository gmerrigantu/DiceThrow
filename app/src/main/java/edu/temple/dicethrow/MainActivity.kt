package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView1, DieFragment.newInstance(6))
                .replace(R.id.fragmentContainerView2, DieFragment.newInstance(6))
                .commit()
        }

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView1) as DieFragment).throwDie()
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as DieFragment).throwDie()
        }
    }
}