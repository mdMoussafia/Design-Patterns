# DP-Bank (Design Patterns Demo)

A small **Java 17 / Maven / Spring Boot** project demonstrating three classic **GoF design patterns** in a simple banking domain:

- **Singleton**: one in-memory repository instance shared across the application
- **Builder**: fluent construction of `BankAccount` objects
- **Prototype**: cloning (`clone()`) of domain objects (deep copy for `BankAccount` → `Customer`)

---

## Project structure

```text
src/main/java/net/saadbr
├── DpBankApplication.java              # Demo runner (threads + repository usage)
├── Test.java                           # Prototype (clone) quick test
├── model
│   ├── AccountStatus.java              # enum
│   ├── AccountType.java                # enum
│   ├── BankAccount.java                # Builder + Prototype (clone)
│   ├── BankDirector.java               # Director for Builder
│   └── Customer.java                   # Prototype (clone)
├── repository
│   ├── AccountRepository.java          # CRUD + search contract
│   └── AccountRepositoryImpl.java      # Singleton repository implementation
└── util
    └── JsonSerializer.java             # Jackson pretty JSON helper
```

---

## Requirements

- **Java 17**
- **Maven** (or use the included Maven Wrapper `mvnw` / `mvnw.cmd`)

---

## How to run

### Option A — Maven (recommended)

**Windows**
```bash
mvnw.cmd clean test
mvnw.cmd spring-boot:run
```

**Linux / macOS**
```bash
./mvnw clean test
./mvnw spring-boot:run
```

### Option B — Run from IntelliJ IDEA

Run the main class:
- `net.saadbr.DpBankApplication`

---

## What the application does

`DpBankApplication`:

1. Gets the singleton repository instance:
   - `AccountRepositoryImpl repository = AccountRepositoryImpl.getInstance();`
2. Starts multiple threads calling `repository.populateData()` to add random accounts.
3. Prints all accounts as **pretty JSON** using `JsonSerializer`.
4. Shows `findById(1L)` and a search example:
   - “CURRENT_ACCOUNT and balance > 80000”.

---

## Design patterns

### 1) Singleton — `AccountRepositoryImpl`

**Goal:** ensure only one repository instance exists.

Implementation highlights:
- private constructor
- eager initialization via static block
- access through `getInstance()`

```java
private static final AccountRepositoryImpl accountRepository;
static {
    System.out.println("Singleton instantiation");
    accountRepository = new AccountRepositoryImpl();
}
private AccountRepositoryImpl() {}

public static AccountRepositoryImpl getInstance() {
    return accountRepository;
}
```

Why it matters here:
- the in-memory `Map<Long, BankAccount>` is shared by all threads and callers.

---

### 2) Builder — `BankAccount.AccountBuilder` + `BankDirector`

**Goal:** create complex objects with readable, fluent code (avoid telescoping constructors).

Usage:

```java
BankAccount account = BankDirector.acountBuilder()
    .balance(1000 + Math.random() * 90000)
    .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
    .status(Math.random() > 0.5 ? AccountStatus.ACTIVATED : AccountStatus.CREATED)
    .currency(Math.random() > 0.5 ? "MAD" : "EUR")
    .build();
```

Notes:
- `BankDirector.acountBuilder()` is a simple “director” that returns a new builder instance.

---

### 3) Prototype — `clone()` on `BankAccount` and `Customer`

**Goal:** create new objects by cloning an existing instance.

`BankAccount` implements a **deep-ish clone**:
- it clones itself
- then clones the nested `Customer` to avoid sharing the same customer reference

```java
@Override
public BankAccount clone() throws CloneNotSupportedException {
    BankAccount bankAccount = (BankAccount) super.clone();
    bankAccount.setCustomer(this.customer.clone());
    return bankAccount;
}
```

Quick test is available in `net.saadbr.Test`:

```java
BankAccount acc2 = acc.clone();
```

---

## Notes / tips

- The repository `save()` method is `synchronized` to make ID generation and insertion thread-safe.
- `populateData()` is intentionally used from multiple threads to demonstrate that the singleton instance is shared.
- If you rename the base package (e.g., `net.saadbr`), keep the Spring Boot main class in the **top package** so component scanning keeps working.

---

## Author

Saad EL MABROUK
