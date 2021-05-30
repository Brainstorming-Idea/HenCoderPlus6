package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author wangyou
 * @desc:
 * @date :2021/4/12
 */
class MainActivity : AppCompatActivity(), View.OnClickListener{

    private val usernameKey:String = "username"
    private val passwordKey = "password"

    private lateinit var et_username:EditText
    private lateinit var et_password:EditText
    private lateinit var et_code:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)

        val btn_login = findViewById<Button>(R.id.btn_login)
        val img_code = findViewById<CodeView>(R.id.code_view)

        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))

        btn_login.setOnClickListener(this)
        img_code.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v is CodeView){
            var codeView = v
        }else if (v is Button){
            login()
        }
    }

    private fun login() {
        val username = et_username.text.toString()
        val password = et_password.text.toString()
        val code = et_code.text.toString()

        val user = User(username, password,code)
        if (verify(user)){
            CacheUtils.save(usernameKey, username)
            CacheUtils.save(passwordKey, password)
            startActivity(Intent(this, LessonActivity::class.java))
        }

    }

    private fun verify(user:User): Boolean {
        if (user.username != null && user.username!!.length < 4){
            Utils.toastShort("用户名不合法")
            return false
        }
        if (user.password != null && user.password!!.length < 4) {
            Utils.toastShort("密码不合法")
            return false
        }
        if (user.code != null && user.code != code_view.text){
            Utils.toastShort("验证码错误！")
            return false
        }
        return true
    }
}