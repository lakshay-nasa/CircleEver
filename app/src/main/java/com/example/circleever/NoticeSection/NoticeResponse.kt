package com.example.circleever.NoticeSection

import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

sealed class NoticeResponse
data class  OnSuccess(val querySnapshot: QuerySnapshot?): NoticeResponse()
data class  OnError(val exception: FirebaseFirestoreException?): NoticeResponse()

