package com.hrk.apps.hrkdev

import android.app.Application
import com.hrk.apps.hrkdev.util.ProfileVerifierLogger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class HRKApplication : Application() {
    @Inject
    lateinit var profileVerifierLogger: ProfileVerifierLogger

    override fun onCreate() {
        super.onCreate()
        profileVerifierLogger()
    }
}
