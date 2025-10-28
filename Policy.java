public class Policy {
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    /** Default constructor */
    public Policy() {
        policyNumber = 0;
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Creates a Policy with all given details.
     * @param policyNumber policy number
     * @param providerName provider name
     * @param firstName first name
     * @param lastName last name
     * @param age age
     * @param smokingStatus smoker or non-smoker
     * @param height height in inches
     * @param weight weight in pounds
     */
    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /** @return policy number */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /** @param policyNumber sets policy number */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    /** @return provider name */
    public String getProviderName() {
        return providerName;
    }

    /** @param providerName sets provider name */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /** @return first name */
    public String getFirstName() {
        return firstName;
    }

    /** @param firstName sets first name */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** @return last name */
    public String getLastName() {
        return lastName;
    }

    /** @param lastName sets last name */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** @return age */
    public int getAge() {
        return age;
    }

    /** @param age sets age */
    public void setAge(int age) {
        this.age = age;
    }

    /** @return smoking status */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /** @param smokingStatus sets smoking status */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    /** @return height in inches */
    public double getHeight() {
        return height;
    }

    /** @param height sets height */
    public void setHeight(double height) {
        this.height = height;
    }

    /** @return weight in pounds */
    public double getWeight() {
        return weight;
    }

    /** @param weight sets weight */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Calculates and returns the BMI.
     * @return BMI value
     */
    public double calculateBMI() {
        if (height == 0) {
            return 0;
        }
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates and returns the total price of the policy.
     * @return policy price
     */
    public double calculatePolicyPrice() {
        double price = 600.0;

        if (age > 50) {
            price += 75.0;
        }

        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20.0;
        }

        return price;
    }
}
