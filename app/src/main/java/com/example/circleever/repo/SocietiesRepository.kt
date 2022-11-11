package com.example.circleever.repo

import com.example.circleever.OnError
import com.example.circleever.OnSuccess
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class SocietiesRepository {

    private val firestore = FirebaseFirestore.getInstance()

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getSocietiesDetails() = callbackFlow {

        val collection = firestore.collection("SocietyDetails")
        val snapshotListener = collection.addSnapshotListener{ value, error ->
            val response = if (error == null) {
                OnSuccess(value)
            } else {
                OnError(error)
            }

            trySend(response)

        }

        awaitClose{
            snapshotListener.remove()
        }

    }

}