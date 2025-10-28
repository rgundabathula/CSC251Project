import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // keep decimals like 65.0, 18.30

        ArrayList<Policy> policies = new ArrayList<>();
        String fileName = "PolicyInformation.txt";

        try (Scanner in = new Scanner(new File(fileName))) {
            while (true) {
                // read 8 non-empty lines per policy
                String s1 = nextNonEmpty(in); if (s1 == null) break;
                String s2 = nextNonEmpty(in);
                String s3 = nextNonEmpty(in);
                String s4 = nextNonEmpty(in);
                String s5 = nextNonEmpty(in);
                String s6 = nextNonEmpty(in);
                String s7 = nextNonEmpty(in);
                String s8 = nextNonEmpty(in);

                int policyNumber = Integer.parseInt(s1.trim());
                String providerName = s2.trim();
                String firstName = s3.trim();
                String lastName  = s4.trim();
                int age = Integer.parseInt(s5.trim());
                String smokingStatus = s6.trim();
                double height = Double.parseDouble(s7.trim());
                double weight = Double.parseDouble(s8.trim());

                Policy p = new Policy(policyNumber, providerName, firstName, lastName,
                        age, smokingStatus, height, weight);
                policies.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + fileName + ". Put it next to your .java files.");
            return;
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Step 3 & 4: print all info and count smokers
        int smokers = 0, nonSmokers = 0;

        for (Policy p : policies) {
            System.out.println("Policy Number: " + p.getPolicyNumber());
            System.out.println();
            System.out.println("Provider Name: " + p.getProviderName());
            System.out.println();
            System.out.println("Policyholder's First Name: " + p.getFirstName());
            System.out.println();
            System.out.println("Policyholder's Last Name: " + p.getLastName());
            System.out.println();
            System.out.println("Policyholder's Age: " + p.getAge());
            System.out.println();
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getSmokingStatus());
            System.out.println();
            System.out.printf("Policyholder's Height: %.1f inches%n", p.getHeight());
            System.out.println();
            System.out.printf("Policyholder's Weight: %.1f pounds%n", p.getWeight());
            System.out.println();
            System.out.printf("Policyholder's BMI: %.2f%n", p.calculateBMI());
            System.out.println();
            System.out.printf("Policy Price: $%.2f%n", p.calculatePolicyPrice());
            System.out.println();
            System.out.println();

            if (p.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokers++;
            } else {
                nonSmokers++;
            }
        }

        System.out.println("The number of policies with a smoker is: " + smokers);
        System.out.println();
        System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
    }

    private static String nextNonEmpty(Scanner in) {
        while (in.hasNextLine()) {
            String s = in.nextLine().trim();
            if (!s.isEmpty()) return s;
        }
        return null;
    }
}
