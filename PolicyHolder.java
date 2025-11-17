public class PolicyHolder {

    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    public PolicyHolder() {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    public PolicyHolder(String firstName, String lastName, int age,
                        String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    public PolicyHolder(PolicyHolder other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.age = other.age;
        this.smokingStatus = other.smokingStatus;
        this.height = other.height;
        this.weight = other.weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateBMI() {
        if (height == 0) {
            return 0.0;
        }
        return (weight * 703) / (height * height);
    }

    public boolean isSmoker() {
        return smokingStatus.equalsIgnoreCase("smoker");
    }

    public String toString() {
        String s = "";
        s += "Policyholder's First Name: " + firstName + "\n\n";
        s += "Policyholder's Last Name: " + lastName + "\n\n";
        s += "Policyholder's Age: " + age + "\n\n";
        s += "Policyholder's Smoking Status (Y/N): " + smokingStatus + "\n\n";
        s += "Policyholder's Height: " + String.format("%.1f", height) + " inches\n\n";
        s += "Policyholder's Weight: " + String.format("%.1f", weight) + " pounds\n\n";
        s += "Policyholder's BMI: " + String.format("%.2f", calculateBMI()) + "\n\n";
        return s;
    }
}
