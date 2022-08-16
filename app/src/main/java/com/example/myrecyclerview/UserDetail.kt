package com.example.myrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myrecyclerview.databinding.UserDetailBinding

class UserDetail : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "EXTRA_DATA"
    }
    private lateinit var detailBinding: UserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = UserDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val hero = intent.getParcelableExtra<Hero>(EXTRA_DATA)

        detailBinding.apply{
            detailName.text = hero?.name
            detailUsername.text = hero?.username
            detailLocation.text = hero?.location
            
            detailRepository.text = hero?.repository
            detailCompany.text = hero?.company
            detailFollowers.text = hero?.followers
            detailFollowing.text = hero?.following
        }
        Glide.with(this)
            .load(hero?.img)
            .apply(RequestOptions.circleCropTransform())
            .into(detailBinding.detailImg)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = hero?.username
            elevation = 0f
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}

