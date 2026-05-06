package poe;

import java.util.Random;

public class Messages{

//Declarations 
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;

//Total message counter
private static int totalMessages = 0;

//Constructor for Messages
    public Messages(int messageNumber, String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        totalMessages++;
    }

//Generating a random messageID
    private String generateMessageID(){
        Random rand = new Random();

        //Generates between 0 & 10 billion and formats to 10 digits.
        long number = (long)(rand.nextDouble()  *1_000_000_0000L);
        return String.format("%010d", number);
    }

//Check messageID length
    public boolean checkMessageID(){
        return messageID.length() <= 10;
    }

//Check recipient cell format
    public boolean checkRecipientCell(){
        return recipient.startsWith("+27") && recipient.length() <= 12;
    }

//Message length validation
    public boolean checkMessageText(){
        return messageText.length() <= 250;
    }

//Create message hash (Generated)
    public String createMessageHash(){

        if (messageText == null) || messageText.trim().isEmpty() {
            return "Invalid message text";
        }

        String firstTwo =  messageID.substring(0, 2);
        String [] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return(firstTwo + ":" + messageNumber + ":" + (firstWord + lastWord).toUpperCase());
    }

//Displaying messages in the correct order & format
    public void printMessages(){
        System.out.println("Message ID: " + messageID);
        System.out.println("Message Hash: " + createMessageHash());
        System.out.println("Recipient: " + recipient);
        System.out.println("Message Text: " + messageText);
    }

//Sent message results
public String SentMessage(int option){
    switch(option){
        case 1:
            return "Message sent successfully.";
        case 2:
            return "Message discarded.";
        case 3:
            return "Message stored."
        default:
            return "Invalid option.";
    }
}

//Return for total messages
public static int returnTotalMessages(){
    return totalMessages;
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