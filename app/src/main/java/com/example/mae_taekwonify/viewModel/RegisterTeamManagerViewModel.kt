package com.example.mae_taekwonify.viewModel

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import androidx.lifecycle.ViewModel
import com.example.mae_taekwonify.models.TeamManagers

class RegisterTeamManagerViewModel(): ViewModel() {
    fun addDataToFirebase(
        name: String,
        teamName: String,
        email: String,
        phone: String,
        context: android.content.Context
    ) {
        val uid = FirebaseAuth.getInstance().currentUser?.uid;

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()


        val dbUsers: CollectionReference = db.collection("Team Managers")

        val userDetails = TeamManagers(name,teamName,email,phone, uid.toString())

        if (uid != null) {
            dbUsers.document(uid).set(userDetails).addOnSuccessListener {

                Toast.makeText(
                    context,
                    "Your data has been added to Firebase Firestore",
                    Toast.LENGTH_SHORT
                ).show()

            }.addOnFailureListener { e ->
                Toast.makeText(context, "Fail to add data \n$e", Toast.LENGTH_SHORT).show()
            }
        }

    }
}