package com.dicoding.hololiveen

import android.os.Build
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

        val holoen = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Holoen>(EXTRA_CONTENT, Holoen::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Holoen>(EXTRA_CONTENT)
        }

        if (holoen != null) {
            binding.vtuberName.text = holoen.name
            binding.fullImg.setImageResource(holoen.fullPhoto)
            binding.descriptionContent.text = holoen.description
            binding.unitVtuber.text = holoen.unit

        }
    }
}