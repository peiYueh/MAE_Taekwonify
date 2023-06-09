package com.example.mae_taekwonify.viewModel

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.mae_taekwonify.models.Following
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.random.Random

class FollowUnfollowViewModel : ViewModel() {
    fun addFollowingToFirebase(
        Following:String,
        context: android.content.Context
    ): String {
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        var randomID = (1..20)
            .map { Random.nextInt(0, charPool.size).let { charPool[it] } }
            .joinToString("")
        val uid = FirebaseAuth.getInstance().currentUser?.uid;
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        val dbUsers: CollectionReference = db.collection("FollowingFollowers")
        val followingDetails = Following(uid.toString(),Following, randomID)

        if (uid != null) {
            dbUsers.document(randomID).set(followingDetails).addOnSuccessListener {
                Toast.makeText(
                    context,
                    "Followed!",
                    Toast.LENGTH_SHORT
                ).show()

            }.addOnFailureListener { e ->

                Toast.makeText(context, "Fail to follow \n$e", Toast.LENGTH_SHORT).show()
            }
        }
        return randomID
    }

    fun deleteFollowingFromFirebase(
        followID:String,
        context: android.content.Context
    ){
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        db.collection("FollowingFollowers").document(followID)
            .delete()
            .addOnSuccessListener {
                Toast.makeText(
                    context,
                    "Followed!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener { e -> Log.w(TAG, "Error unfollowing account", e) }
    }
}