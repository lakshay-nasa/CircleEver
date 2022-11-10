package com.example.circleever

import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

sealed class SocietiesResponse
data class  OnSuccess(val querySnapshot: QuerySnapshot?): SocietiesResponse()
data class  OnError(val exception: FirebaseFirestoreException?): SocietiesResponse()
