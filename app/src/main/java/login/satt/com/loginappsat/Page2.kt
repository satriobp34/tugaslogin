package login.satt.com.loginappsat

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_page2.*

class Page2 : AppCompatActivity() {

    var usernameInput : String = ""
    var passwordInput : String = ""
    var username: String? = null
    var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        btnMasuk.setOnClickListener{
            validasi()
        }
    }

    private fun validasi(){
        usernameInput = edtUsername2.text.toString()
        passwordInput = edtPassword2.text.toString()
        ambilData()

        when{
            usernameInput.isEmpty() -> edtUsername2.error ="username tak boleh kosong sheyeng"
            passwordInput.isEmpty() -> edtPassword2.error ="passwordnya mana sheyeng"


            else -> {
                if (usernameInput.equals(username) && passwordInput.equals(password)) {
                    navigasiPage3()
                }
                else {
                ToastNotif("username atau password salah")

                }
            }
        }
    }

    private fun ambilData(){
        val bundle : Bundle? = intent.extras

        username = bundle?.getString("Username")
        password = bundle?.getString("Password")


        }

    private fun navigasiPage3(){
        val intent = Intent(this,Page3::class.java)

        val bundle = Bundle ()
        bundle.putString("Username", usernameInput)
        bundle.putString("Password", passwordInput)

        intent.putExtras(bundle)

        startActivity(intent)


    }
    private fun ToastNotif(message: String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}
