package org.abubaker.permissionsexample

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
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

                // Inform user that he has already access to the camera permission.
                Toast.makeText(this, "You already have access to the permission", Toast.LENGTH_LONG).show()

            } else {

                // Ask user to allow permission for the requested feature.
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)

            }

        }


    }

    /**
     * Actions to take if Permission is allowed or denied.
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CAMERA_PERMISSION_CODE) {

            // Conditional action
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted for the Camera.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Oops you just denied the permission for camera. You can also allow it from the settings.", Toast.LENGTH_SHORT).show()
            }

        }

    }

    // Data class which JUST contains constants
    companion object {
        private const val CAMERA_PERMISSION_CODE = 1
        // private const val FINE_LOCATION_PERMISSION_CODE = 2
    }


}