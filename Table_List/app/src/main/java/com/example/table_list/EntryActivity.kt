package com.example.table_list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.table_list.databinding.ActivityEntryBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class EntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "Realtime"

        //가입 화면-로그인
        var uid: String = ""
        var pwd: String = ""

        binding.btnLogin.setOnClickListener {//로그인 버튼 눌렀을 때
            val loginView: View = View.inflate(this, R.layout.login, null)
            var uidEditText = loginView.findViewById<EditText>(R.id.useridEditText)
            var pwdEditText = loginView.findViewById<EditText>(R.id.passwordEditText)

            if (uid.isNotEmpty())
                uidEditText.setText(uid)
            if (pwd.isNotEmpty())
                pwdEditText.setText(pwd)

            MaterialAlertDialogBuilder(this).apply {
                setTitle("Enter login information")
                setView(loginView)
                setPositiveButton("확인") { _, _ ->
                    val enteredUid = uidEditText.text.toString()
                    val enteredPwd = pwdEditText.text.toString()

                    if (enteredUid.isNotEmpty() && enteredPwd.isNotEmpty()) {
                        // 로그인 성공 시 MainActivity로 이동
                        val intent = Intent(this@EntryActivity, MainActivity::class.java)
                        startActivity(intent)
                    } else if (enteredUid.isEmpty()) {
                        Toast.makeText(this@EntryActivity, "아이디를 입력하세요.", Toast.LENGTH_SHORT)
                            .show()
                    } else if (enteredPwd.isEmpty()) {
                        Toast.makeText(
                            this@EntryActivity,
                            "비밀번호를 입력하세요.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                setNegativeButton("취소") { _, _ ->

                }
                show()
            }
        }

        //가입 화면-회원가입
        binding.btnSignup.setOnClickListener {//로그인 버튼 눌렀을 때
            val signupView: View = View.inflate(this, R.layout.signup, null)
            var uidEditText2 = signupView.findViewById<EditText>(R.id.useridEditText2)
            var pwdEditText2 = signupView.findViewById<EditText>(R.id.passwordEditText2)

            if (uid.isNotEmpty())
                uidEditText2.setText(uid)
            if (pwd.isNotEmpty())
                pwdEditText2.setText(pwd)

            MaterialAlertDialogBuilder(this).apply {
                setTitle("Enter signup information")
                setView(signupView)
                setPositiveButton("확인") { _, _ ->
                    val enteredUid2 = uidEditText2.text.toString()
                    val enteredPwd2 = pwdEditText2.text.toString()

                    if (enteredUid2.isNotEmpty() && enteredPwd2.isNotEmpty()) {
                        // 회원가입 성공 시
                        Toast.makeText(this@EntryActivity, "가입완료 되셨습니다.", Toast.LENGTH_SHORT)
                            .show()
                    } else if (enteredUid2.isEmpty()) {
                        Toast.makeText(this@EntryActivity, "아이디를 입력하세요.", Toast.LENGTH_SHORT)
                            .show()
                    } else if (enteredPwd2.isEmpty()) {
                        Toast.makeText(
                            this@EntryActivity,
                            "비밀번호를 입력하세요.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                setNegativeButton("취소") { _, _ ->

                }
                show()
            }
        }


    }
}