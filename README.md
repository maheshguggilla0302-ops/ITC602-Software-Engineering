# Fashion E-Retail System

A console-based Java application that demonstrates a layered architecture for managing customers, products, orders, and sellers in a fashion e-retail context. The project uses SQLite for persistence and Maven for dependency management.

## 1. Platform & Prerequisites

| Component | Requirement | Notes |
|-----------|-------------|-------|
| Operating System | Windows 10+ or any OS with Java 21 support | Paths/instructions below reference Windows PowerShell; adjust commands for macOS/Linux shells. |
| Java | JDK 21 (Temurin, Oracle, or equivalent) | Confirm with `java -version` and `javac -version`. |
| Build Tool | Apache Maven 3.9+ | Confirm with `mvn -v`. Maven handles dependency resolution (SQLite JDBC driver). |
| Database | SQLite (bundled JDBC) | Database file `fashion_retail.db` is created in the project root at runtime. No external DB install required. |

## 2. Initial Setup

1. **Unzip & Open Project Folder**
   - Download the provided source ZIP.
   - Extract it to a convenient location (e.g., `C:\Projects`).
   - Open PowerShell/terminal in the extracted folder (`Fashion_E-Retail_System`).

2. **Verify Java & Maven**
   ```powershell
   java -version
   javac -version
   mvn -v
   ```

3. **Build Dependencies & Compile**
   ```powershell
   mvn clean compile
   ```
   This downloads the SQLite JDBC driver and compiles the sources to `target/classes`.

## 3. Running the Application

### Option A – Maven Exec Plugin (recommended)
```powershell
mvn exec:java -Dexec.mainClass=org.example.Main
```

### Option B – Java Command (after `mvn package`)
```powershell
mvn package
java -cp "target/Fashion_E-Retail_System-1.0-SNAPSHOT.jar;target/lib/*" org.example.Main
```
*(On macOS/Linux replace `;` with `:` in the classpath.)*

### Option C – IDE Run Configuration
1. Import the Maven project into IntelliJ IDEA / Eclipse / VS Code.
2. Set `org.example.Main` as the main class.
3. Run; the console appears in the IDE.

When the app starts it will:
- Initialize `fashion_retail.db` (create tables if missing).
- Display the main menu with Customer/Seller panels.

## 4. Sample Data & Demo Steps

The database starts empty. Use the built-in panels to seed demo data so markers can exercise all flows.

### 4.1 Seed Products via Seller Panel
1. Launch the app.
2. Choose `2` (Seller Panel).
3. Login with the default credentials:
   - Username: `seller`
   - Password: `seller123`
4. Choose `1` (Add Product) three times to add sample products, e.g.:
   ```
   Name: Denim Jacket
   Description: Classic blue jacket
   Price: 79.99
   Stock: 25

   Name: Cotton T-Shirt
   Description: White crew neck
   Price: 19.99
   Stock: 100

   Name: Leather Boots
   Description: Brown ankle boots
   Price: 129.00
   Stock: 15
   ```

### 4.2 Register & Place an Order (Customer Panel)
1. Return to main menu → choose `1` (Customer Panel).
2. Select `1` (Register) and create a customer (e.g., username `alice`, password `alice123`).
3. Select `2` to log in with the new credentials.
4. Choose `1` to view the products you seeded.
5. Use `3` (Add Product to Cart) to add two items (e.g., jacket qty 1, shirt qty 2).
6. Optionally use `2` (View Cart) to confirm totals.
7. Choose `6` (Checkout), pick a payment method (e.g., `1` for Card Payment). Note the order ID shown.

### 4.3 Review Orders as Seller
1. Switch back to Seller Panel (main menu option `2`, log in again if needed).
2. Choose `5` (View All Orders) to see the pending order.
3. Use `7` (Accept Order) followed by `9` (Update Order Status) to progress it through `PACKED → SHIPPED → DELIVERED`.
4. Optionally select `6` (View Order Details) to verify order items and customer info.

These steps ensure the marker can validate customer registration, product CRUD, cart management, order placement, and seller fulfillment workflows without manual SQL.

## 5. Resetting / Re-running

- Delete `fashion_retail.db` to reset all data. The app recreates it on the next run.
- If schema changes are made, delete the DB file before rerunning to avoid mismatches.

## 6. Troubleshooting

| Issue | Resolution |
|-------|------------|
| `java.lang.UnsupportedClassVersionError` | Confirm JDK/JRE 21 is active (check environment variables or IDE settings). |
| Cannot log in as seller | Ensure credentials `seller / seller123` are entered in lowercase. |
| SQLite database locked | Close other running instances/IDEs and delete `fashion_retail.db` if necessary before rerunning. |
| Maven cannot download dependencies | Check network connectivity or configure a proxy; rerun `mvn clean compile`. |

## 7. Project Structure

```
Fashion_E-Retail_System/
├── pom.xml                       # Maven configuration (Java 21, SQLite JDBC)
├── fashion_retail.db             # SQLite database (auto-created)
├── src/main/java/org/example
│   ├── Main.java                 # Entry point
│   ├── database/DatabaseConnection.java
│   ├── dao/                      # Data Access Objects
│   ├── model/                    # Domain models
│   ├── service/                  # Business logic services
│   └── ui/                       # Console menus/panels
└── target/                       # Build output (generated)
```



