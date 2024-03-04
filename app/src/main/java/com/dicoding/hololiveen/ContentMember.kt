package com.dicoding.hololiveen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.hololiveen.databinding.ActivityContentMemberBinding

class ContentMember : AppCompatActivity() {
    private lateinit var binding: ActivityContentMemberBinding

    companion object{
        const val EXTRA_CONTENT = "extra_content"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_member)

        binding = ActivityContentMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val holoen = intent.getParcelableExtra(EXTRA_CONTENT, Holoen::class.java)

        if (holoen != null) {
            binding.vtuberName.text = holoen.name
            binding.fullImg.setImageResource(holoen.photo)
            binding.descriptionContent.text = holoen.description

        }
    }
}