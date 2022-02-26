package ir.omidrezabagherian.netflix.fragments

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ir.omidrezabagherian.netflix.R
import ir.omidrezabagherian.netflix.databinding.FragmentProfileInfoBinding


class ProfileInfoFragment : Fragment(R.layout.fragment_profile_info) {

    private lateinit var profileInfoBinding: FragmentProfileInfoBinding
    private lateinit var profileInfoNavController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref =
            activity?.getSharedPreferences(SharedPreferences.FILE_NAME, Context.MODE_PRIVATE)

        profileInfoBinding = FragmentProfileInfoBinding.bind(view)

        val profileInfoNavHostFragment =
            activity!!.supportFragmentManager.findFragmentById(R.id.fragment_container_main) as NavHostFragment

        profileInfoNavController = profileInfoNavHostFragment.navController

        val picture = sharedPref?.getString(SharedPreferences.PICTURE_KEY,"").toString()
        val fullName =
            sharedPref?.getString(SharedPreferences.FULLNAME_KEY, "No FullName").toString()
        val email = sharedPref?.getString(SharedPreferences.EMAIL_KEY, "No Email").toString()
        val userName =
            sharedPref?.getString(SharedPreferences.USERNAME_KEY, "No UserName").toString()

        if (picture.isNotEmpty()){
            val decodedByte = Base64.decode(picture,0)
            val image = BitmapFactory.decodeByteArray(decodedByte,0,decodedByte.size)
            profileInfoBinding.imageviewUser.setImageBitmap(image)
        }

        profileInfoBinding.textviewFullname.text = fullName
        profileInfoBinding.textviewEmail.text = email
        profileInfoBinding.textviewUsername.text = userName

        profileInfoBinding.buttonLogout.setOnClickListener {
            val sharedPrefEditor = sharedPref?.edit()
            sharedPrefEditor?.clear()
            sharedPrefEditor?.apply()

            profileInfoNavController.navigate(R.id.profileLoginFragment)

        }

    }

}
