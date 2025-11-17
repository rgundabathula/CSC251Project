public class Policy {
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;
    private static int policyCount = 0;

    public Policy() {
        policyNumber = 0;
        providerName = "";
        policyHolder = new PolicyHolder();
        policyCount++;
    }

    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = new PolicyHolder(policyHolder);
        policyCount++;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public PolicyHolder getPolicyHolder() {
        return new PolicyHolder(policyHolder);
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = new PolicyHolder(policyHolder);
    }

    public double calculatePolicyPrice() {
        double price = 600.0;

        if (policyHolder.getAge() > 50) {
            price += 75.0;
        }

        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            price += 100.0;
        }

        double bmi = policyHolder.calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20.0;
        }

        return price;
    }

    public static int getPolicyCount() {
        return policyCount;
    }

    public String toString() {
        String s = "";
        s += "Policy Number: " + policyNumber + "\n\n";
        s += "Provider Name: " + providerName + "\n\n";
        s += policyHolder.toString();
        s += "Policy Price: $" + String.format("%.2f", calculatePolicyPrice()) + "\n";
        return s;
    }
}
