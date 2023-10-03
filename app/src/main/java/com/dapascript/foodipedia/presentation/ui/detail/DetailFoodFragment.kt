package com.dapascript.foodipedia.presentation.ui.detail

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.dapascript.foodipedia.data.source.model.DetailFood
import com.dapascript.foodipedia.databinding.FragmentDetailFoodBinding
import com.dapascript.foodipedia.presentation.viewmodel.DetailViewModel
import com.dapascript.foodipedia.utils.BaseFragment
import com.dapascript.foodipedia.utils.Resource
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFoodFragment : BaseFragment<FragmentDetailFoodBinding>(
    FragmentDetailFoodBinding::inflate
) {

    private val detailViewModel: DetailViewModel by viewModels()

    private lateinit var youTubePlayer: YouTubePlayer
    private var isFullscreen = false
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (isFullscreen) {
                // if the player is in fullscreen, exit fullscreen
                youTubePlayer.toggleFullscreen()
            } else {
                findNavController().popBackStack()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(onBackPressedCallback)

        initUI()
    }

    private fun initUI() {
        detailViewModel.getDetail.observe(viewLifecycleOwner) { response ->
            binding.apply {
                progressBar.isVisible = response is Resource.Loading
                clContent.isVisible = response is Resource.Success

                if (response is Resource.Success) {
                    response.data.forEach { implementResponse(it!!) }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun implementResponse(response: DetailFood) {
        binding.apply {
            with(toolbar) {
                title = response.strMeal
                subtitle = "${response.strCategory} | ${response.strArea}"
                setNavigationOnClickListener { findNavController().popBackStack() }
            }
            Glide.with(requireContext())
                .load(response.strMealThumb)
                .into(ivFood)

            tvInstruction.text = response.strInstructions
            // do looping for response ingredient & measure
            for (i in 1..20) {
                val ingredient = response.getIngredient(i)
                val measure = response.getMeasure(i)

                if (!ingredient?.trim().isNullOrEmpty() && !measure?.trim().isNullOrEmpty()) {
                    tvIngredients.append("\u2022 $ingredient : $measure\n")
                }
            }

            initTrailer(response.strYoutube)
        }
    }

    private fun initTrailer(url: String?) {
        // set player options
        val iFramePlayerOptions = IFramePlayerOptions.Builder()
            .controls(1)
            .fullscreen(1)
            .build()

        binding.apply {
            lifecycle.addObserver(youtubePlayerView)
            youtubePlayerView.enableAutomaticInitialization = false

            // set fullscreen listener
            youtubePlayerView.addFullscreenListener(object : FullscreenListener {
                override fun onEnterFullscreen(
                    fullscreenView: View,
                    exitFullscreen: () -> Unit
                ) {
                    isFullscreen = true

                    youtubePlayerView.visibility = View.GONE
                    fullScreenViewContainer.visibility = View.VISIBLE
                    fullScreenViewContainer.addView(fullscreenView)

                    // request to landscape orientation
                    requireActivity().requestedOrientation =
                        ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                }

                override fun onExitFullscreen() {
                    isFullscreen = false

                    youtubePlayerView.visibility = View.VISIBLE
                    fullScreenViewContainer.visibility = View.GONE
                    fullScreenViewContainer.removeAllViews()

                    // request to portrait orientation
                    requireActivity().requestedOrientation =
                        ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                }
            })

            // set player listener
            val listener: YouTubePlayerListener = object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val id = url?.split("v=")?.get(1)
                    this@DetailFoodFragment.youTubePlayer = youTubePlayer
                    youTubePlayer.loadVideo(id!!, 0f)
                }
            }

            // initialize player
            if (!::youTubePlayer.isInitialized) {
                youtubePlayerView.initialize(listener, iFramePlayerOptions)
            }
        }
    }

    override fun onDestroyView() {
        binding.youtubePlayerView.release()
        onBackPressedCallback.remove()
        super.onDestroyView()
    }
}