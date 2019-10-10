package com.example.api.service;

import com.example.api.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for message.
 */
@Service
public class ApiService {
    private final List<Message> messageList = new ArrayList<>();

    // The SimpMessagingTemplate is used to send Stomp over WebSocket messages.
    private final SimpMessagingTemplate messagingTemplate;

    /**
     * The constructor for autowired by dependency injection facilities.
     * @param messagingTemplate The messagging template.
     */
    @Autowired
    public ApiService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * Get all message
     * @return list of message
     */
    public List<Message> getAllMessage(){
        return messageList;
    }

    /**
     * Save message to list and send message to active subscriber on channel "/topic/realtime".
     *
     * The message list will be sent when the function is called.
     *
     * @param message The message.
     * @return return true if succes and false if unsuccess.
     */
    public boolean saveMessage(Message message){
        boolean stat = messageList.add(message);
        messagingTemplate.convertAndSend("/topic/realtime", getAllMessage());
        return stat;
    }
}
