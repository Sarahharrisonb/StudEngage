package People;

import java.util.regex.Pattern;
import Server.Classroom;

public class User {


    private String name;
    private String username;
    private String password;
    private String email;
    private Classroom classroom;

    public User(){

    }

    public User(String username, String password) {
        createAccount(username, password);
    }

    public void createAccount(String username, String password){
        setUsername(username);
        setPassword(password);
    }
    
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // TODO: need to wait until classroom class is finished 
    public boolean joinClassroom(Classroom classroom){
        return false;
    }

    public void exitClassroom(){
        this.classroom = null;
    }

    public String getUsername(){
        return this.username;
    }

    private void setUsername(String username){
        this.username = username;
    } 

    public String getPassword(){
        return this.password;
    }

    private void setPassword(String password){
        if(validPassword(password)) this.password = password;
    }

    // return if the password fullfill the requirements
    private boolean validPassword(String password){
        Boolean validPassword = true;
        String outputString = "";
        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Pattern specialpPattern = Pattern.compile("\\W");

        if(password.length() < 8) {
            outputString = "Password needs to be at least 8 words";
            validPassword = false;
        }
        if(specialpPattern.matcher(password).find()){
            outputString = "Password should NOT contain special characters";
            validPassword = false;
        }
        if(!uppercasePattern.matcher(password).find()) {
            outputString = "The password required at least one lowercaser Letter";
            validPassword = false;
        }
        if(!lowercasePattern.matcher(password).find()) {
            outputString = "The password required at least one CAPTIACL LETTER";
            validPassword = false;
        }
        if(validPassword) {
            outputString = "Password set suceessfully";
        }

        // TODO: System.out.println() should be replace by some other thing
        System.out.println(outputString);

        return validPassword;
    }
}
