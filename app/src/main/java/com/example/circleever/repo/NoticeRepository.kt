package com.example.circleever.NoticeSection

import com.example.circleever.data.Notices
import com.google.firebase.Timestamp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class NoticeRepository {

    fun getUserId(): String = Firebase.auth.currentUser?.uid.orEmpty()
    fun user() = Firebase.auth.currentUser

    private val firestore = FirebaseFirestore.getInstance()

    val noticeRef: CollectionReference = Firebase.firestore.collection("Notices")


    // getNotices fetches all the notices in Notice Board
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

/// --->


    fun getNotice(
        noticeId:String,
        onError:(Throwable?) -> Unit,
        onSuccess: (Notices?) -> Unit
    ){
        noticeRef
            .document(noticeId)
            .get()
            .addOnSuccessListener {
                onSuccess.invoke(it?.toObject(Notices::class.java))
            }
            .addOnFailureListener {result ->
                onError.invoke(result.cause)
            }


    }


    fun addNotice(
        societyName: String,
        noticeId: String,
        noticeTitle: String,
        noticeDetails: String,
        noticeURL: String,
        timestamp: Timestamp,
        onComplete: (Boolean) -> Unit,
    ){
        val noticeId = noticeRef.document().id
        val notices = Notices(
            societyName,
            noticeId = noticeId,
            noticeTitle,
            noticeDetails,
            noticeURL,
            timestamp,
        )
        noticeRef
            .document(noticeId)
            .set(notices)
            .addOnCompleteListener { result ->
                onComplete.invoke(result.isSuccessful)
            }


    }

    fun deleteNotice(noticeId: String,onComplete: (Boolean) -> Unit){
        noticeRef.document(noticeId)
            .delete()
            .addOnCompleteListener {
                onComplete.invoke(it.isSuccessful)
            }
    }



    fun updateNotice(
        noticeTitle: String,
        noticeDetails:String,
        noticeId: String,
        onResult:(Boolean) -> Unit
    ){
        val updateData = hashMapOf<String,Any>(
            "description" to noticeDetails,
            "title" to noticeTitle,
        )

        noticeRef.document(noticeId)
            .update(updateData)
            .addOnCompleteListener {
                onResult(it.isSuccessful)
            }



    }

}