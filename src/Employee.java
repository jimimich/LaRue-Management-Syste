public class Employee {

    //NG stands for normal guard, HG stands for head guard 

    private String name;
    private String position;
    private String certified;
    private String wage;
    private String phoneNum;

    public Employee(String name, String position, String certified, String wage, String phoneNum){
        name = this.name;
        position = this.position;
        certified = this.certified;
        wage = this.wage;
        phoneNum = this.phoneNum;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getCertified() {
        return certified;
    }
    public void setCertified(String certified) {
        this.certified = certified;
    }

    public String getWage() {
        return wage;
    }
    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String toString(){
        return "Employee - " + "\n" + "Name: " + getName() +  " - Position: " + getPosition() + " - Certified?: " + getCertified() + " - Wage: " + getWage() + " - Phone Num: " + getPhoneNum();
    }
}
