@file:Suppress("DEPRECATION")

package com.dicoding.androidbeginner

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dicoding.androidbeginner.databinding.ActivityDetailItemBinding

class DetailItem : AppCompatActivity() {
    private lateinit var binding: ActivityDetailItemBinding

    companion object {
        const val SET = "set"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedAyaka = intent.getParcelableExtra<Ayaka>(SET) ?: return

        Log.i("COBA", selectedAyaka.toString())
        binding.tvName.text = selectedAyaka.name
        binding.tvDescription.text = selectedAyaka.description
        Glide.with(this)
            .load(selectedAyaka.photo)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imgPhoto)
    }
}
