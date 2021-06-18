public class SeasonPatron {

    private String name;
    private int age;
    private String phoneNum;

    public SeasonPatron(String name, int age, String phoneNum){
        name = this.name;
        age = this.age;
        phoneNum = this.phoneNum;
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

    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String toString(){
        return "Patron - " + "\n" + "Name: " + getName() + " - Age: " + getAge() +  " - Phone Number: " + getPhoneNum();
    }
    
}
