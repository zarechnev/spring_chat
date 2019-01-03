package org.zarechnev.chat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "message")
    private String message;

    protected ChatMessage(){}

    public ChatMessage(String userName, String message){
        this.userName = userName;
        this.message = message;
    }

    @Override
    public String toString(){
        return String.format("%s: %s", this.userName, this.message);
    }
}
