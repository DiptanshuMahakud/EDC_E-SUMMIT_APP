package com.event.edc

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFireBaseService : FirebaseMessagingService(){

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
    }
}