package poe;

import java.util.Random;

public class Messages{

//Declarations 
    private String messageID;
    private int messageNumber;
    private String reciepient;
    private String messageText;

//Constructor for Messages 
    public Messages(int messageNumber, String reciepient, String messageText) {
        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.reciepient = reciepient;
        this.messageText = messageText;
    }
//Generating a random messageID
    private String generateMessageID(){
        Random rand = new Random();

        //Generates between 0 & 10 billion and formats to 10 digits.
        long number = (long)(rand.nextDouble()  *1_000_000_000L);
        return String.format("%010d", number);
    }
}