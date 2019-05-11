package login.satt.com.loginappsat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var usernameInput : String = ""
    var passwordInput : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDaftar.setOnClickListener{
            CekData()
        }

    }

    private fun CekData (){
        usernameInput = edtUsername.text.toString()
        passwordInput = edtPassword.text.toString()

        when{
            usernameInput.isEmpty() -> edtUsername.error ="username tak boleh kosong sheyeng"
            passwordInput.isEmpty() -> edtPassword.error ="passwordnya mana sheyeng"

            else -> {
                ToastNotif("Ok")

                NavigasiPage2()
            }
        }
    }


    private fun NavigasiPage2(){
        val intent = Intent (this,Page2::class.java)

        val bundle = Bundle ()
        bundle.putString("Username", usernameInput)
        bundle.putString("Password", passwordInput)

        intent.putExtras(bundle)

        startActivity(intent)

    }

    private fun ToastNotif(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}
