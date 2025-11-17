import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        ArrayList<Policy> policies = new ArrayList<>();
        String fileName = "PolicyInformation.txt";

        try (Scanner in = new Scanner(new File(fileName))) {
            while (true) {
                String s1 = nextNonEmpty(in);
                if (s1 == null) {
                    break;
                }
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
                String lastName = s4.trim();
                int age = Integer.parseInt(s5.trim());
                String smokingStatus = s6.trim();
                double height = Double.parseDouble(s7.trim());
                double weight = Double.parseDouble(s8.trim());

                PolicyHolder holder = new PolicyHolder(firstName, lastName, age,
                        smokingStatus, height, weight);
                Policy p = new Policy(policyNumber, providerName, holder);
                policies.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + fileName + ". Put it next to your .java files.");
            return;
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        int smokers = 0;
        int nonSmokers = 0;

        for (Policy p : policies) {
            System.out.println(p);
            System.out.println();

            PolicyHolder holder = p.getPolicyHolder();
            if (holder.isSmoker()) {
                smokers++;
            } else {
                nonSmokers++;
            }
        }

        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println();
        System.out.println("The number of policies with a smoker is: " + smokers);
        System.out.println();
        System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
    }

    private static String nextNonEmpty(Scanner in) {
        while (in.hasNextLine()) {
            String s = in.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
        }
        return null;
    }
}
