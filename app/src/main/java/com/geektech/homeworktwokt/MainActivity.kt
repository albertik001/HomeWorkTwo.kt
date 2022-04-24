package com.geektech.homeworktwokt

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.homeworktwokt.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by viewBinding(ActivityMainBinding::bind)
    private val imageList = arrayListOf<String>()
    private val mimeTypeImageList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addLinkImageList()
        addImageListIncludingMimeType()
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnSumbit.setOnClickListener {
            submitImage()
        }
        binding.btnRandom.setOnClickListener {
            randomImage()
        }
    }

    private fun addImageListIncludingMimeType() {
        mimeTypeImageList.apply {
            add(getString(R.string.mimepng))
            add(getString(R.string.mimesvg))
            add(getString(R.string.mimejpg))
            add(getString(R.string.mimejpeg))
            add(getString(R.string.mimeapng))
            add(getString(R.string.mimeavif))
            add(getString(R.string.mimegif))
            add(getString(R.string.mimeavp))
            add(getString(R.string.mimewebp))
            add(getString(R.string.mimebmp))
            add(getString(R.string.mimeiso))
            add(getString(R.string.mimetiff))
        }
    }

    private fun addLinkImageList() {
        imageList.apply {
            add(getString(R.string.image_one))
            add(getString(R.string.image_two))
            add(getString(R.string.image_three))
            add(getString(R.string.image_fouth))
            add(getString(R.string.image_five))
            add(getString(R.string.image_six))
            add(getString(R.string.image_seven))
            add(getString(R.string.image_eight))
            add(getString(R.string.image_nine))
            add(getString(R.string.image_ten))
        }
    }

    private fun randomImage() {
        val randomImage = Random.nextInt(imageList.size)
        binding.imRandom.setGlideImage(imageList[randomImage])
    }

    private fun submitImage() {
        val imageLink = binding.etUrlImage.text
        val link = submitImage(Uri.parse(imageLink.toString()))
        if (mimeTypeImageList.contains(link)) {
            binding.imRandom.setGlideImage(imageLink.toString())
            imageList.add(imageLink.toString())
        } else {
            Toast.makeText(this, getString(R.string.soso), Toast.LENGTH_SHORT).show()
        }
    }

}

