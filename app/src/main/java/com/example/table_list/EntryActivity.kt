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
    }
}