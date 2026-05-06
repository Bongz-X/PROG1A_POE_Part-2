package poe;

import java.util.Random;

public class Messages{

//Declarations 
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;

//Constructor for Messages 
    public Messages(int messageNumber, String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
    }
//Generating a random messageID
    private String generateMessageID(){
        Random rand = new Random();

        //Generates between 0 & 10 billion and formats to 10 digits.
        long number = (long)(rand.nextDouble()  *1_000_000_0000L);
        return String.format("%010d", number);
    }
//Message length validation
    public boolean checkMessageText(){
        return messageText.length() <= 250;
    }
//Message Hash (Generated)
    public String generateHash(){

        String firstTwo =  messageID.substring(0, 2);
        String [] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return(firstTwo + ":" + messageNumber + ":" + (firstWord + lastWord).toUpperCase());
    }
//Displaying messages in the correct order & format
    public void printMessageDetails(){
        System.out.println("Message ID: " + messageID);
        System.out.println("Message Hash: " + generateHash());
        System.out.println("Recipient: " + recipient);
        System.out.println("Message Text: " + messageText);
    }
// Getters for Storing Messages in JSON file
    public String getMessageID(){
        return messageID;
    }

    public int getMessageNumber(){
        return messageNumber;
    }

    public String getRecipient(){
        return recipient;
    }

    public String getMessageText(){
        return messageText;
    }

}