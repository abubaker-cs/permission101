package org.abubaker.permissionsexample

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import org.abubaker.permissionsexample.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    // Binding Object
    private lateinit var binding: ActivityMainBinding

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Inflate XML: activity_main
         */
        // binding = ActivityMainBinding.inflate(layoutInflater)
        // var view = binding.root
        // setContentView(view)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnCameraPermission.setOnClickListener {

            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "You already have access to the permission", Toast.LENGTH_LONG).show()
            } else {

                // Request Permission
                Toast.makeText(this, "You do not have access to the permission", Toast.LENGTH_SHORT).show()

            }

        }


    }

    // Data class which JUST contains constants
    companion object {
        private const val CAMERA_PERMISSION_CODE = 1
        // private const val FINE_LOCATION_PERMISSION_CODE = 2
    }


}