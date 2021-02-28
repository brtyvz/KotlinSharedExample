package com.berat.kotlinapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
 lateinit var sharedPreferences:SharedPreferences
var sharedPreferencesAge:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    //val bir daha degistirilemeyen degiskenlerdir
        //var degistirebildigimiz degiskenlerdir;

        //set olsuturursak ayni degeri 1 kere koyabiliriz sadece
        //map olusuturmak deger ve anahtarini koymak {"berat",100}gibi
         sharedPreferences=this.getSharedPreferences("com.berat.kotlinapp", Context.MODE_PRIVATE)
         sharedPreferencesAge=sharedPreferences.getInt("age",0)
        if (sharedPreferencesAge==0){
            text_age.text="Your Age:"
        }
        else{
            text_age.text="Your Age"+sharedPreferencesAge
        }
    }
     fun save(view: View){
         //sharedpreferences degiskenine bir adet shared preferences actik ve isim verdik isim package ismi



         val myAge=plain_age.text.toString().toIntOrNull() //kullanicinin girdigi deger bos ise hata
         if(myAge!=null&&myAge>0){
             text_age.text = "Your Age :"+myAge
             sharedPreferences.edit().putInt("age",myAge) .apply()//shared preferencesa deger ve kelime verdik
         }


     }
fun delete(view: View){
    sharedPreferencesAge=sharedPreferences.getInt("age",0)
    if (sharedPreferencesAge!=null){
        sharedPreferences.edit().remove("age").apply()
        text_age.text="Your Age:"
    }
}

}
