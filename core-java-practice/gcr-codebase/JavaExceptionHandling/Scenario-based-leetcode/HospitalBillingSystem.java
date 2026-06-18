// Custom Exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {
    
    public static void processBill(int totalCost, int itemsCount, int[] patientIds, int index, String paymentInput, int paidAmount) {
        try {
            // 1. Division by zero check
            int costPerItem = totalCost / itemsCount;
            System.out.println("Cost per item: ₹" + costPerItem);

            // 2. Array out of bounds check
            int patientId = patientIds[index];
            System.out.println("Processing bill for Patient ID: " + patientId);

            // 3. Number format check
            int parsedPayment = Integer.parseInt(paymentInput);
            System.out.println("Payment amount entered: ₹" + parsedPayment);

            // 4. Custom Insufficient Funds check
            if (paidAmount < totalCost) {
                throw new InsufficientFundsException("Payment failed: Insufficient funds. Required: ₹" + totalCost + ", Provided: ₹" + paidAmount);
            }
            System.out.println("Billing processed successfully!");

        } catch (ArithmeticException e) {
            System.err.println("Billing Error: Cannot calculate cost per item because the bill contains zero items.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Billing Error: Invalid patient index look-up. Accessing record outside the system limits.");
        } catch (NumberFormatException e) {
            System.err.println("Billing Error: Invalid characters detected in payment input field.");
        } catch (InsufficientFundsException e) {
            System.err.println("Billing Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Billing Error: A critical unexpected error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int[] patientIds = {1001, 1002, 1003};
        
        System.out.println("--- Test Case 1: Triggering Division by Zero ---");
        processBill(5000, 0, patientIds, 1, "2000", 5000);
        
        System.out.println("\n--- Test Case 2: Triggering Insufficient Funds ---");
        processBill(5000, 2, patientIds, 1, "5000", 3000);
    }
}