public class Patron {

    private String name;
    private int age;
    private String timeSignedIn;
    private String phoneNum;
    private String passType;

    public Patron(String name, int age, String timeSignedIn, String phoneNum, String passType){
        name = this.name;
        age = this.age;
        timeSignedIn = this.timeSignedIn;
        phoneNum = this.phoneNum;
        passType = this.passType;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getTimeSignedIn() {
        return timeSignedIn;
    }
    public void setTimeSignedIn(String timeSignedIn) {
        this.timeSignedIn = timeSignedIn;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public String getPassType() {
        return passType;
    }
    public void setPassType(String passType) {
        this.passType = passType;
    }

    public String toString(){
        return "Patron - " + "\n" + "Name: " + getName() + " - Age: " + getAge() + " - Time Signed In: " + getTimeSignedIn() + " - Phone Number: " + getPhoneNum() + " - Type of Pass: " + getPassType();
    }

    
    
}
