package com.example.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.basic.Fragments.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.dropdown)
        ArrayAdapter.createFromResource(
            this,
            R.array.menu_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Get the selected item
                val selectedItem = parent.getItemAtPosition(position).toString()
                // Do something with the selected item

                when (selectedItem) {
                    "Home" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main, HomeFragment()).commit()
                    }
                    "Account" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main, AccountFragment()).commit()
                    }
                    "Casting" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main, CastingFragment()).commit()
                    }
                    "News" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main, NewsFragment()).commit()
                    }
                    "Premiers" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main, PremiersFragment()).commit()
                    }
                    "Settings" -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main, SettingsFragment()).commit()
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }


    }
}
