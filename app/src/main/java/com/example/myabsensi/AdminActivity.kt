package com.example.myabsensi

import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.myabsensi.databinding.ActivityIntiBinding
import com.example.myabsensi.utils.PrefManager

class AdminActivity : AppCompatActivity() {

    private lateinit var prefManager: PrefManager

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityIntiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarInti.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_inti)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        //masih gagal

        // Initialize prefManager
        prefManager = PrefManager(this)

        // Get username from prefManager and set it to textUserName TextView
        binding.navView.getHeaderView(0).findViewById<TextView>(R.id.textUserName).text = prefManager.getName()

        // Get email from prefManager and set it to textEmail TextView
        binding.navView.getHeaderView(0).findViewById<TextView>(R.id.textUserEmail).text = prefManager.getEmail()


    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_inti)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}