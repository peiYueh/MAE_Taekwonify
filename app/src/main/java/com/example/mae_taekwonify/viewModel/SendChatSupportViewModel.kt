package com.example.mae_taekwonify.viewModel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.mae_taekwonify.models.ChatSuppport
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class SendChatSupportViewModel : ViewModel() {
    fun sendChatToFirebase(
        content:String,
        context: android.content.Context,
        newID: String,
    ): String {
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        val uid = FirebaseAuth.getInstance().currentUser?.uid;
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        val dbUsers: CollectionReference = db.collection("ChatSupport")
        val chatDetails = ChatSuppport(
            uid.toString(), "admin123",newID,content
        )
        if (uid != null) {
            dbUsers.document(newID).set(chatDetails).addOnSuccessListener {
                Toast.makeText(
                    context,
                    "Message Sent!",
                    Toast.LENGTH_SHORT
                ).show()
            }.addOnFailureListener { e ->
                Toast.makeText(context, "Fail to Send \n$e", Toast.LENGTH_SHORT).show()
            }
        }
        return newID
    }
}