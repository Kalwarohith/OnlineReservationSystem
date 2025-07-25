# 🎫 Online Reservation System 🎉

A **Java console-based application** to manage train ticket reservations with features such as user authentication, booking, cancellation, and viewing reservations.  
All data is stored **in-memory** without any external database.

---

## ⚙️ Features

- 🔐 **User Login Authentication**  
- 🚆 View Available Trains  
- 🎟️ Book Train Tickets  
- ❌ Cancel Booked Tickets  
- 📋 View User Reservations  
- 🖥️ Simple, clean console interface  

---

## 🗂️ Project Structure

🛠️ OnlineReservationSystem/
│
├── main/
│ └── OnlineReservationSystem.java # ▶ Main class with menu-driven interface
├── model/
│ ├── User.java # 👤 User data model
│ └── Reservation.java # 📝 Reservation data model
├── service/
│ ├── AuthService.java # 🔑 User authentication services
│ └── ReservationService.java # 🎯 Booking & cancellation logic
└── util/
└── DataStore.java # 🗄️ Simulated in-memory DB (HashMaps)

text

---

## 🛠️ Prerequisites

- ☕ Java Development Kit (JDK) 17 or newer installed  
- 🖥️ Terminal, Command Prompt, or IDE (like VS Code) configured for Java programming

---

## 🏃 How to Compile & Run

1. **Open your terminal and navigate to project root:**  

   - Windows PowerShell:  
     ```
     cd $HOME\Desktop\OnlineReservationSystem
     ```
   - macOS/Linux Terminal:  
     ```
     cd ~/Desktop/OnlineReservationSystem
     ```

2. **Compile all Java source files:**  
javac main/.java model/.java service/.java util/.java

text

3. **Run the application:**  
java main.OnlineReservationSystem

text

---

## 🎮 Usage Example

✨ === Online Reservation System === ✨
User ID: alice
Password: password1
✅ Login successful.

Main Menu:
1️⃣ Reserve Ticket
2️⃣ Cancel Ticket
3️⃣ Show My Reservations
0️⃣ Exit
Enter choice: 1

Available Trains:
🚄 12345: Express 1
🚂 54321: Mail 2
🚅 33333: Superfast 3

Enter Train Number: 12345
Class Type (First/Second/Sleeper): First
Date of Journey (YYYY-MM-DD): 2025-08-01
From: CityA
To: CityB

🎟️ Reservation successful. Details:
PNR: 1000 | User: alice | Train: Express 1 (12345) | Class: First | Date: 2025-08-01 | From: CityA | To: CityB

text

---

## 📌 Notes

- Default users and trains are **hardcoded** in the `DataStore` class for demo purposes.  
- All data is stored **in-memory**; it **won't persist** when the program exits.  
- You can enhance this system with:  
  - Real database integration (MySQL, SQLite, etc.)  
  - GUI or Web Interfaces  
  - User Registration & Roles  
  - Networking for multi-user support



