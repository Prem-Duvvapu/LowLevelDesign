package ATMLLD;

public enum TransactionType {
    CASH_WITHDRAWL,
    CHECK_BALANCE;

    public static void printTransactionTypes() {
        for (TransactionType type: TransactionType.values())
            System.out.println(type.name());
    }
}
