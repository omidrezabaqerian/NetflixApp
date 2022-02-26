package ir.omidrezabagherian.netflix.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ir.omidrezabagherian.netflix.R
import ir.omidrezabagherian.netflix.databinding.FragmentProfileLoginBinding

class ProfileLoginFragment : Fragment(R.layout.fragment_profile_login) {

    lateinit var profileLoginBinding: FragmentProfileLoginBinding
    private lateinit var profileLoginNavController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        checkLogin()

        profileLoginBinding = FragmentProfileLoginBinding.bind(view)

        val profileLoginNavHostFragment =
            activity!!.supportFragmentManager.findFragmentById(R.id.fragment_container_main) as NavHostFragment

        profileLoginNavController = profileLoginNavHostFragment.navController

        val takePicture =
            registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { result ->
                profileLoginBinding.imageviewUser.setImageBitmap(result)
            }

        val findPicture =
            registerForActivityResult(ActivityResultContracts.GetContent()) { result ->
                profileLoginBinding.imageviewUser.setImageURI(result)
            }

        profileLoginBinding.buttonOpenCamera.setOnClickListener {
            takePicture.launch()
        }

        profileLoginBinding.buttonOpenFile.setOnClickListener {
            findPicture.launch("image/*")
        }

        profileLoginBinding.buttonRegister.setOnClickListener {
            var fullname = ""
            var email = ""
            var username = ""

            if (profileLoginBinding.edittextFullname.text!!.isEmpty())
                profileLoginBinding.edittextFullname.error =
                    "لطفا نام و نام خانوادگی خود را وارد کنید"
            else
                fullname = profileLoginBinding.edittextFullname.text.toString()

            if (profileLoginBinding.edittextEmail.text!!.isEmpty())
                profileLoginBinding.edittextEmail.error =
                    "لطفا ایمیل خود را وارد کنید"
            else
                email = profileLoginBinding.edittextEmail.text.toString()

            if (profileLoginBinding.edittextUsername.text!!.isEmpty())
                profileLoginBinding.edittextUsername.error =
                    "لطفا نام کاربری خود را وارد کنید"
            else
                username = profileLoginBinding.edittextUsername.text.toString()

            if (
                fullname.isNotEmpty() &&
                email.isNotEmpty() &&
                username.isNotEmpty()
            ) {

                val sharedPref =
                    activity!!.getSharedPreferences(
                        SharedPreferences.FILE_NAME,
                        Context.MODE_PRIVATE
                    )

                val sharedPrefEditor = sharedPref.edit()

                sharedPrefEditor.putString(SharedPreferences.FULLNAME_KEY, fullname)
                sharedPrefEditor.putString(SharedPreferences.EMAIL_KEY, email)
                sharedPrefEditor.putString(SharedPreferences.USERNAME_KEY, username)

                sharedPrefEditor.commit()

                val fullname = sharedPref?.getString(SharedPreferences.FULLNAME_KEY, "")
                val email = sharedPref?.getString(SharedPreferences.EMAIL_KEY, "")
                val username = sharedPref?.getString(SharedPreferences.USERNAME_KEY, "")

                Toast.makeText(activity, fullname.toString(), Toast.LENGTH_SHORT).show()
                Toast.makeText(activity, email.toString(), Toast.LENGTH_SHORT).show()
                Toast.makeText(activity, username.toString(), Toast.LENGTH_SHORT).show()

                profileLoginNavController.navigate(R.id.profileInfoFragment)

            }


        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun checkLogin() {
        var sharedPref =
            activity?.getSharedPreferences(SharedPreferences.FILE_NAME, Context.MODE_PRIVATE)

        val profileLoginNavHostFragment =
            activity!!.supportFragmentManager.findFragmentById(R.id.fragment_container_main) as NavHostFragment

        profileLoginNavController = profileLoginNavHostFragment.navController

        val fullname = sharedPref?.getString(SharedPreferences.FULLNAME_KEY, "")
        val email = sharedPref?.getString(SharedPreferences.EMAIL_KEY, "")
        val username = sharedPref?.getString(SharedPreferences.USERNAME_KEY, "")

        try {
            if (
                fullname != "" ||
                email != "" ||
                username != ""
            ) {
                profileLoginNavController.navigate(R.id.profileInfoFragment)
                Toast.makeText(activity, "موفق", Toast.LENGTH_SHORT).show()

                Toast.makeText(activity, fullname.toString(), Toast.LENGTH_SHORT).show()
                Toast.makeText(activity, email.toString(), Toast.LENGTH_SHORT).show()
                Toast.makeText(activity, username.toString(), Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception) {
            Toast.makeText(activity, "نا موفق", Toast.LENGTH_SHORT).show()

            Toast.makeText(activity, fullname.toString(), Toast.LENGTH_SHORT).show()
            Toast.makeText(activity, email.toString(), Toast.LENGTH_SHORT).show()
            Toast.makeText(activity, username.toString(), Toast.LENGTH_SHORT).show()
        }

    }

}