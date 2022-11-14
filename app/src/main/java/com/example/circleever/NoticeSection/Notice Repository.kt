package com.example.circleever.NoticeSection

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class NoticeRepository {

    private val firestore = FirebaseFirestore.getInstance()

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getNotices() = callbackFlow{

        val collection = firestore.collection(
            "Notices"
        )
        val snapshotListener = collection.addSnapshotListener{
            value, error ->
            val response = if (error == null){
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