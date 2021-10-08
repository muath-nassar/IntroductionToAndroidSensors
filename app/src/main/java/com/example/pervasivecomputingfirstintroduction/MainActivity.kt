package com.example.pervasivecomputingfirstintroduction

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val tag = "Sensor123"
    private lateinit var sm :SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSensor()

        val sensors = sm.getSensorList(Sensor.TYPE_ALL)
        sensors.forEach { sensor ->
            Log.d(tag,"the sensor name is ${sensor.name}")
        }
        Log.d(tag,"the size of sensors is "+sensors.size)


        // to get a specific sensor
        val sen = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        sen?.let {
            Log.d(tag,"Gyro is found")
        }
    }
    private fun setupSensor(){
        sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }
}