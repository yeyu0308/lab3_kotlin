package com.example.lab2

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var ed_name: EditText? = null
    private var tv_text: TextView? = null
    private var tv_name: TextView? = null
    private var tv_winner: TextView? = null
    private var tv_mmora: TextView? = null
    private var tv_cmora: TextView? = null
    private var btn_scissor: RadioButton? = null
    private var btn_stone: RadioButton? = null
    private var btn_paper: RadioButton? = null
    private var btn_mora: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //連結 xml 的元件
        ed_name = findViewById(R.id.ed_name)
        tv_text = findViewById(R.id.tv_text)
        tv_name = findViewById(R.id.tv_name)
        tv_winner = findViewById(R.id.tv_winner)
        tv_mmora = findViewById(R.id.tv_mmora)
        tv_cmora = findViewById(R.id.tv_cmora)
        btn_scissor = findViewById(R.id.btn_scissor)
        btn_stone = findViewById(R.id.btn_stone)
        btn_paper = findViewById(R.id.btn_paper)
        btn_mora = findViewById(R.id.btn_mora)
        btn_mora!!.setOnClickListener {
            //判斷字串是否是空白來要求輸入姓名
            if (ed_name!!.length() < 1)
                tv_text!!.text = "請輸入玩家姓名"
            else {
                //顯示玩家姓名與我方出拳
                tv_name!!.text = "名字\n" + ed_name!!.text.toString()
                if (btn_scissor!!.isChecked)
                    tv_mmora!!.text = "我方出拳\n 剪刀"
                else if (btn_stone!!.isChecked)
                    tv_mmora!!.text = "我方出拳\n 石頭"
                else
                    tv_mmora!!.text = "我方出拳\n 布"
                //Random()產生介於 0~1 間不含 1 的亂數，乘 3 產生 0~2 當作電腦的出拳
                val computer = (Math.random() * 3).toInt()
                if (computer == 0)
                    tv_cmora!!.text = "電腦出拳\n 剪刀"
                else if (computer == 1)
                    tv_cmora!!.text = "電腦出拳\n 石頭"
                else
                    tv_cmora!!.text = "電腦出拳\n 布"
                //用三個判斷式判斷並顯示猜拳結果
                if (btn_scissor!!.isChecked && computer == 2 ||
                        btn_stone!!.isChecked && computer == 0 ||
                        btn_paper!!.isChecked && computer == 1) {
                    tv_winner!!.text = "勝利者\n" + ed_name!!.text.toString()
                    tv_text!!.text = "恭喜你獲勝了！！！"
                } else if (btn_scissor!!.isChecked && computer == 1 ||
                        btn_stone!!.isChecked && computer == 2 ||
                        btn_paper!!.isChecked && computer == 0) {
                    tv_winner!!.text = "勝利者\n 電腦"
                    tv_text!!.text = "可惜，電腦獲勝了！"
                } else {
                    tv_winner!!.text = "勝利者\n 平手"
                    tv_text!!.text = "平局，請再試一次！"
                }
            }
        }
    }
}







