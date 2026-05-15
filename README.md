# NAMMA_VASTRA

NAMMA_VASTRA is an Android-based digital marketplace application developed to connect traditional saree weavers directly with buyers through a modern mobile platform. 
The application enables weavers to register securely, upload saree collections, manage products, and communicate with buyers directly through WhatsApp integration.
The project focuses on supporting local weaving communities by providing digital accessibility and marketplace exposure using modern Android development technologies.
---
# Features

## Buyer Features
- Browse saree collections dynamically
- View saree details and pricing
- Explore different saree categories
- Direct WhatsApp inquiry system
- Responsive marketplace UI

## Weaver Features
- Secure registration and login
- Upload saree details and images
- Edit uploaded sarees
- Delete uploaded sarees
- Ownership-based product management
- Logout and session handling

  **Weaver Registration**: A dedicated onboarding process for weavers,
  collecting essential details like location and contact info, powered by Firebase Auth and Firestore.
  **Trend Board**: Visual inspiration and industry trends gallery with high-quality image support.
  **Business Calculator**: Specialized tool for textile-related calculations.
  **Inquiry Management**: A streamlined system for handling business inquiries.
  **User Profiles**: Role-based access (e.g., "weaver") to manage user data securely.
---

# Technologies Used
## Frontend
- Kotlin
- Jetpack Compose
- Navigation Compose
- Coil Image Loading Library

## Backend & Cloud Services
- Firebase Firestore for  User login and security.
- Firebase Storage for Real-time NoSQL database for user and business data.
- Firebase Authentication for Media and asset hosting.

## Development Tools
- Android Studio
- Firebase Console
- Android Emulator
- GitHub

- UI: [Jetpack Compose](https://developer.android.com/jetpack/compose) (Declarative UI)
- Navigation: Compose Navigation
- Asynchronous Tasks: Kotlin Coroutines
- Image Loading: [Coil](https://coil-kt.github.io/coil/)
- Build System: Kotlin DSL (build.gradle.kts) with Version Catalogs.

---
# Project Architecture
The application follows a modular Android project structure:

- screens/
- components/
- model/
- navigation/
- data/
- repository/

This architecture improves:
- code maintainability
- scalability
- modularity
- debugging efficiency

## Project Structure

- `com.example.namma_vastra.screens`: Contains all the main UI screens (Register, TrendBoard, Calculator, Inquiry).
- `com.example.namma_vastra.components`: Reusable UI components (TrendCard, SectionTitle, HomeButton, etc.).
- `com.example.namma_vastra.model`: Data classes and models (e.g., `User`).

---
# Major Screens

1. Role Selection Screen
2. Login Screen
3. Registration Screen
4. Home Dashboard
5. Loom Gallery Screen
6. Upload Saree Screen
7. Inquiry Screen
8. Edit Saree Screen
9. Price Calculator Screen

---

# Firebase Integration

## Firebase Authentication
Used for:
- Weaver registration
- Login system
- Session management
- Ownership-based access control

## Firebase Firestore
Used for:
- Saree data storage
- Weaver details
- Real-time synchronization

## Firebase Storage
Used for:
- Saree image uploads
- Cloud image management

---

# Saree Upload Workflow

1. Weaver logs in
2. Uploads saree image
3. Adds:
  - saree name
  - category
  - material
  - price
  - weaver details
4. Data stored in Firestore
5. Image uploaded to Firebase Storage
6. Saree displayed in Loom Gallery

---

# Ownership-Based Access

Each saree uploaded stores:
- Firebase User UID
- Weaver information

This ensures:
- only the owner can edit
- only the owner can delete
- secure marketplace functionality

---
# UI/UX Design

The application was designed with:
- responsive layouts
- reusable composable components
- clean navigation flow
- scrollable forms
- organized marketplace cards

Jetpack Compose was used for creating a modern Android user interface.

---
# Challenges Faced

- Firebase Authentication integration
- Firestore real-time synchronization
- Firebase Storage image handling
- Navigation Compose routing
- Ownership-based permissions
- UI responsiveness
- Runtime crash debugging

---
# Learning Outcomes

Through this project, practical experience was gained in:
- Android app development
- Kotlin programming
- Jetpack Compose UI
- Firebase integration
- Cloud storage management
- Real-time database systems
- Authentication systems
- Marketplace application architecture
- Debugging and testing

---
### Prerequisites
- Android Studio Ladybug or newer.
- A Firebase project with `google-services.json` placed in the `app/` folder.

# Future Enhancements

Planned future improvements include:
- Search and filtering
- Wishlist/Favorites
- Online payment integration
- AI-based recommendations
- Notifications
- Order management
- Advanced analytics
- Multi-language support

---
# Conclusion
NAMMA_VASTRA successfully demonstrates a modern Android marketplace platform supporting traditional 
saree weaving communities through digital transformation. The project combines cloud technologies, 
secure authentication systems, real-time data handling, and modern UI development to create a scalable
and socially impactful mobile application.
---
Developed by:
Kavana R
1CR22EC115
Internship Project:
MindMatrix VTU Internship Program



