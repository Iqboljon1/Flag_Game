package com.example.flaggame

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.example.flaggame.flag.Flag
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    var arrayRandom = ArrayList<Int>()
    var arrayImageView = ArrayList<Flag>()
    var arrayList = ArrayList<Flag>()
    lateinit var dialog: AlertDialog

    var boolean_Answer_button = false
    var boolean_Play = false
    var act = 0
    var countTimer = 60
    var wrong = 0
    var correct = 0

    private var timer = object : CountDownTimer(60000, 1000) {
        @SuppressLint("SetTextI18n")
        override fun onTick(millisUntilFinished: Long) {
            countTimer--
            tv_time.text = "$countTimer second"
            progress_bar.progress = progress_bar.max - countTimer
        }

        override fun onFinish() {
            BuildDialog()
            dialog.show()
            act = 0
            countTimer = 60
            wrong = 0
            correct = 0
            boolean_Answer_button = false
            boolean_Play = true

        }
    }

    private var timerSelect = object : CountDownTimer(250, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            boolean_Answer_button = false
        }

        override fun onFinish() {
            var boolean = false
            var booleanWrong = false
            btn_answer_0.setCardBackgroundColor(Color.WHITE)
            btn_answer_1.setCardBackgroundColor(Color.WHITE)
            btn_answer_2.setCardBackgroundColor(Color.WHITE)
            btn_answer_3.setCardBackgroundColor(Color.WHITE)
            boolean_Answer_button = true
            if (act != 23) {
                act++
            }

            if (wrong == 3){
                tv_answer_0.text = ""
                tv_answer_1.text = ""
                tv_answer_2.text = ""
                tv_answer_3.text = ""
                BuildDialog()
                dialog.show()
                btn_answer_0.isEnabled = true
                btn_answer_1.isEnabled = true
                btn_answer_2.isEnabled = true
                btn_answer_3.isEnabled = true
                booleanWrong = true
            }

            boolean = act >= 24
            if (!boolean) {
                if (!booleanWrong) {
                    Game()
                }
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        boolean_Play = true
        btn_play.setOnClickListener {
            if (boolean_Play) {
                tv_answer_0.text = ""
                tv_answer_1.text = ""
                tv_answer_2.text = ""
                tv_answer_3.text = ""
                progress_bar.progress = 0
                timer.cancel()
                arrayImageView.clear()
                arrayList.clear()
                arrayRandom.clear()
                act = 0
                countTimer = 60
                wrong = 0
                correct = 0
                boolean_Answer_button = false
                boolean_Play = true
                RasmniArraygaJoylash()
                Random_rang()
                RanglarniRandomQilibArraygaJoylash()
                image_flag.visibility = View.GONE
                tv_time.text = countTimer.toString()
                image_favorite_1.visibility = View.VISIBLE
                image_favorite_2.visibility = View.VISIBLE
                image_favorite_3.visibility = View.VISIBLE
                image_flag.visibility = View.VISIBLE
                boolean_Play = false
                boolean_Answer_button = true
                timer.start()
                Game()
            }
        }
        btn_answer_0.setOnClickListener {
            if (boolean_Answer_button) {
                ResumeGame(btn_answer_0, tv_answer_0)
            }
        }

        btn_answer_1.setOnClickListener {
            if (boolean_Answer_button) {
                ResumeGame(btn_answer_1, tv_answer_1)
            }
        }

        btn_answer_2.setOnClickListener {
            if (boolean_Answer_button) {
                ResumeGame(btn_answer_2, tv_answer_2)
            }
        }
        btn_answer_3.setOnClickListener {
            if (boolean_Answer_button) {
                ResumeGame(btn_answer_3, tv_answer_3)
            }
        }
    }

    fun RasmniArraygaJoylash() {
        val America = R.drawable.america
        val Argentina = R.drawable.argentina
        val Armenia = R.drawable.armenia
        val Australia = R.drawable.australia
        val Austria = R.drawable.austria
        val North_korea = R.drawable.north_korea
        val Korea = R.drawable.korea
        val Estonia = R.drawable.estonia
        val Russia = R.drawable.russia
        val Belarus = R.drawable.belarus
        val Brazil = R.drawable.brazil
        val Bulgaria = R.drawable.bulgaria
        val Japan = R.drawable.japan
        val Kazakhstan = R.drawable.kazakhstan
        val Kyrgyzstan = R.drawable.kyrgyzstan
        val Uruguay = R.drawable.uruguay
        val Turkey = R.drawable.turkey
        val Belgium = R.drawable.belgium
        val Uzbekistan = R.drawable.uzbekistan

        arrayImageView.add(Flag(America, "America"))
        arrayImageView.add(Flag(Argentina, "Argentina"))
        arrayImageView.add(Flag(Armenia, "Armenia"))
        arrayImageView.add(Flag(Australia, "Australia"))
        arrayImageView.add(Flag(Austria, "Austria"))
        arrayImageView.add(Flag(North_korea, "North Korea"))
        arrayImageView.add(Flag(Korea, "South Korea"))
        arrayImageView.add(Flag(Estonia, "Estonia"))
        arrayImageView.add(Flag(Russia, "Russia"))
        arrayImageView.add(Flag(Belarus, "Belarus"))
        arrayImageView.add(Flag(Brazil, "Brazil"))
        arrayImageView.add(Flag(Bulgaria, "Bulgaria"))
        arrayImageView.add(Flag(Japan, "Japan"))
        arrayImageView.add(Flag(Kazakhstan, "Kazakhstan"))
        arrayImageView.add(Flag(Kyrgyzstan, "Kyrgyzstan"))
        arrayImageView.add(Flag(Uruguay, "Uruguay"))
        arrayImageView.add(Flag(Turkey, "Turkey"))
        arrayImageView.add(Flag(Belgium, "Belgium"))
        arrayImageView.add(Flag(Uzbekistan, "Uzbekistan"))
    }

    fun Random_rang() {
        val hashSet = HashSet<Int>()
        var a = 0
        while (true) {
            fun Random_numbers() {
                a = (Math.random() * arrayImageView.size).toInt()
            }
            Random_numbers()
            val boolean = hashSet.add(a)
            if (!boolean) {
                Random_numbers()
            } else {
                arrayRandom.add(a)
            }
            if (arrayRandom.size == arrayImageView.size) {
                break
            }
        }
    }

    fun RanglarniRandomQilibArraygaJoylash() {
        arrayList.add(arrayImageView[arrayRandom[0]])
        arrayList.add(arrayImageView[arrayRandom[1]])
        arrayList.add(arrayImageView[arrayRandom[2]])
        arrayList.add(arrayImageView[arrayRandom[3]])
        arrayList.add(arrayImageView[arrayRandom[4]])
        arrayList.add(arrayImageView[arrayRandom[5]])
        arrayList.add(arrayImageView[arrayRandom[6]])
        arrayList.add(arrayImageView[arrayRandom[7]])
        arrayList.add(arrayImageView[arrayRandom[8]])
        arrayList.add(arrayImageView[arrayRandom[9]])
        arrayList.add(arrayImageView[arrayRandom[10]])
        arrayList.add(arrayImageView[arrayRandom[11]])
        arrayList.add(arrayImageView[arrayRandom[12]])
        arrayList.add(arrayImageView[arrayRandom[13]])
        arrayList.add(arrayImageView[arrayRandom[14]])
        arrayList.add(arrayImageView[arrayRandom[15]])
        arrayList.add(arrayImageView[arrayRandom[16]])
        arrayList.add(arrayImageView[arrayRandom[17]])
        arrayList.add(arrayImageView[arrayRandom[18]])
    }

    fun Game() {
        val arrayAnswerFlagName = ArrayList<TextView>()
        image_flag.setImageResource(arrayList[act].id)
        tv_flag_name.text = arrayList[act].name
        fun AnswerRandom() {
            val hashSet = HashSet<Int>()
            var a = 0

            fun Random0() {
                a = (Math.random() * arrayImageView.size).toInt()
                val boolean_0 = hashSet.add(a)
                if (boolean_0 && a != act) {
                    tv_answer_0.text = arrayList[a].name
                } else {
                    Random0()
                }
            }
            Random0()

            fun Random1() {
                a = (Math.random() * arrayImageView.size).toInt()
                val boolean_1 = hashSet.add(a)
                if (boolean_1 && a != act) {
                    tv_answer_1.text = arrayList[a].name
                } else {
                    Random1()
                }
            }
            Random1()

            fun Random2() {
                a = (Math.random() * arrayImageView.size).toInt()
                val boolean_2 = hashSet.add(a)
                if (boolean_2 && a != act) {
                    tv_answer_2.text = arrayList[a].name
                } else {
                    Random2()
                }
            }
            Random2()

            fun Random3() {
                a = (Math.random() * arrayImageView.size).toInt()
                val boolean_3 = hashSet.add(a)
                if (boolean_3 && a != act) {
                    tv_answer_3.text = arrayList[a].name
                } else {
                    Random3()
                }
            }
            Random3()
        }
        AnswerRandom()
        arrayAnswerFlagName.add(tv_answer_0)
        arrayAnswerFlagName.add(tv_answer_1)
        arrayAnswerFlagName.add(tv_answer_2)
        arrayAnswerFlagName.add(tv_answer_3)

        arrayAnswerFlagName[(Math.random() * 4).toInt()].text = arrayList[act].name

    }

    fun ResumeGame(cardView: CardView, textView: TextView) {
        if (textView.text == arrayList[act].name) {
            timerSelect.start()
            cardView.setCardBackgroundColor(Color.parseColor("#FF4CAF50"))
            btn_answer_0.isEnabled = true
            btn_answer_1.isEnabled = true
            btn_answer_2.isEnabled = true
            btn_answer_3.isEnabled = true
            correct++
            if (correct == 24) {
                timer.cancel()
                BuildDialog()
                dialog.show()
            }
        } else {
            cardView.setCardBackgroundColor(Color.parseColor("#FFFF0000"))
            cardView.isEnabled = false
            wrong++
            if (wrong == 1) {
                image_favorite_3.visibility = View.GONE
            }
            if (wrong == 2) {
                image_favorite_2.visibility = View.GONE
            }
            if (wrong == 3) {
                image_favorite_1.visibility = View.GONE
                timerSelect.start()
                timer.start()

            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun BuildDialog() {
        val alertDialog = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog, null)
        val dialog_second = view.findViewById<TextView>(R.id.tv_dialog_second)
        val dialog_congratulations = view.findViewById<TextView>(R.id.congratulations)
        val dialog_seccessfully = view.findViewById<TextView>(R.id.seccessfully)
        val dialog_btn_play_again = view.findViewById<TextView>(R.id.btn_dialog_play_again)

        if (wrong == 3 || correct != 24) {
            dialog_congratulations.text = "Game Over"
            dialog_congratulations.setTextColor(Color.RED)
            dialog_second.text = "and a time of ${60 - countTimer} second"
            dialog_seccessfully.text =
                "You have not been able to successfully customize all the flags"
        } else {
            dialog_second.visibility = View.VISIBLE
            dialog_second.text = "and a time of ${60 - countTimer} second"
            dialog_congratulations.text = "Congratulations!"
            dialog_congratulations.setTextColor(Color.parseColor("#4CAF50"))
            dialog_seccessfully.text = "You have successfully customized all the flags."
        }

        dialog_btn_play_again.setOnClickListener {
            progress_bar.progress = 0
            timer.cancel()
            dialog.cancel()
            arrayImageView.clear()
            arrayList.clear()
            arrayRandom.clear()
            RasmniArraygaJoylash()
            Random_rang()
            RanglarniRandomQilibArraygaJoylash()
            act = 0
            countTimer = 60
            wrong = 0
            correct = 0
            boolean_Answer_button = false
            boolean_Play = true
            image_flag.visibility = View.GONE
            tv_time.text = countTimer.toString()
            btn_answer_0.setCardBackgroundColor(Color.WHITE)
            btn_answer_1.setCardBackgroundColor(Color.WHITE)
            btn_answer_2.setCardBackgroundColor(Color.WHITE)
            btn_answer_3.setCardBackgroundColor(Color.WHITE)

            tv_answer_0.text = ""
            tv_answer_1.text = ""
            tv_answer_2.text = ""
            tv_answer_3.text = ""

            image_favorite_1.visibility = View.VISIBLE
            image_favorite_2.visibility = View.VISIBLE
            image_favorite_3.visibility = View.VISIBLE
        }
        alertDialog.setView(view)
        dialog = alertDialog.create()
        if (!dialog.isShowing){
            progress_bar.progress = 0
            timer.cancel()
            dialog.cancel()
            arrayImageView.clear()
            arrayList.clear()
            arrayRandom.clear()
            RasmniArraygaJoylash()
            Random_rang()
            RanglarniRandomQilibArraygaJoylash()
            act = 0
            countTimer = 60
            wrong = 0
            correct = 0
            boolean_Answer_button = false
            boolean_Play = true
            image_flag.visibility = View.GONE
            tv_time.text = countTimer.toString()
            btn_answer_0.setCardBackgroundColor(Color.WHITE)
            btn_answer_1.setCardBackgroundColor(Color.WHITE)
            btn_answer_2.setCardBackgroundColor(Color.WHITE)
            btn_answer_3.setCardBackgroundColor(Color.WHITE)



            image_favorite_1.visibility = View.VISIBLE
            image_favorite_2.visibility = View.VISIBLE
            image_favorite_3.visibility = View.VISIBLE
        }
        dialog.window!!.attributes.windowAnimations = R.style.MyAnimation
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}