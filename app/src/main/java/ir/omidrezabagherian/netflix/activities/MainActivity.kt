package ir.omidrezabagherian.netflix.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import ir.omidrezabagherian.netflix.R
import ir.omidrezabagherian.netflix.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMain = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_main) as NavHostFragment

        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        bindingMain.bottomNavigationMain.setOnItemSelectedListener { result ->
            when (result.itemId) {
                R.id.menu_home -> {
                    navController.popBackStack()
                    navController.navigate(R.id.homeFragment)
                }
                R.id.menu_coming_soon -> {
                    navController.popBackStack()
                    navController.navigate(R.id.comingSoonFragment)
                }
                R.id.menu_favorite -> {
                    navController.popBackStack()
                    navController.navigate(R.id.favoriteFragment)
                }
                R.id.menu_profile -> {
                    navController.popBackStack()
                    navController.navigate(R.id.profileLoginFragment)
                }
            }
            true
        }

        setContentView(bindingMain.root)
    }

    override fun onBackPressed() {
        finish()
    }
}