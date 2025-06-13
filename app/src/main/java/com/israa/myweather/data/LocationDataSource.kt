package com.israa.myweather.data

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class LocationDataSource(
    private val context: Context,
    private val fusedLocationProviderClient: FusedLocationProviderClient,
) {

    @SuppressLint("MissingPermission")
    suspend fun getLastKnownLocation(): Location? {
        return suspendCancellableCoroutine { cont ->
            fusedLocationProviderClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    if (cont.isActive) cont.resume(location)
                }
                .addOnFailureListener { exception ->
                    if (cont.isActive) cont.resumeWithException(exception)
                }
        }
    }
}