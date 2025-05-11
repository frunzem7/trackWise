`Model Relationships:`

- `User` ↔ `Habits`: One user can have many habits.
- `Habit` ↔ `Progress`: One habit has multiple progress records.
- `User` ↔ `Notifications`: Users receive multiple notifications.
- `User` ↔ `AIRecommendations`: AI generates insights for each user
______________________________________________________________________________________

1️⃣ User Management
Users need to sign up, log in, and manage their accounts.

✅ Features:

User registration (sign up with email & password);
User login (JWT authentication);
Retrieve user profile;
Update user settings.

🔹 Spring Boot Components:

DTOs: UserDTO;
Entities: User;
Repository: UserRepository;
Service: UserService;
Controller: UserController;
Security: JWT authentication.

______________________________________________________________________________________

2️⃣ Habit Management
Users should be able to create and track habits.

✅ Features:

Create a new habit;
Update habit details (name, frequency, goal);
Delete a habit;
View all habits for a user.

🔹 Spring Boot Components:

DTOs: HabitDTO;
Entities: Habit;
Repository: HabitRepository;
Service: HabitService;
Controller: HabitController.

______________________________________________________________________________________

3️⃣ Habit Progress Tracking
Users need to log habit completions.

✅ Features:

Log daily or weekly habit completion;
View progress history;
Track habit streaks.

🔹 Spring Boot Components:

DTOs: HabitProgressDTO;
Entities: HabitProgress;
Repository: HabitProgressRepository;
Service: HabitProgressService;
Controller: HabitProgressController.

______________________________________________________________________________________

4️⃣ Analytics & AI Features
AI will provide insights and recommendations.

✅ Features:

Show streaks and habit completion trends;
Predict progress trends using AI;
Suggest new habits based on user data.

🔹 Spring Boot Components:

DTOs: AnalyticsDTO;
Entities: Analytics;
Repository: AnalyticsRepository;
Service: AnalyticsService;
Controller: AnalyticsController;
Kafka Topics: habit-progress, ai-recommendations.

______________________________________________________________________________________

5️⃣ Notifications System (Kafka-based)
Users receive habit reminders and motivational messages.

✅ Features:

Send real-time notifications (habit due, missed check-in);
AI-driven motivation (e.g., "You're close to a 10-day streak!");
View notification history.

🔹 Spring Boot Components:

DTOs: NotificationDTO;
Entities: Notification;
Repository: NotificationRepository;
Service: NotificationService;
Controller: NotificationController;
Kafka Topics: notifications.

______________________________________________________________________________________

`TODO:`

Step 1.1: Define Core Features
Write down the key features you want your habit tracker to have. Start simple and expand later.
Example of core features:
User registration and login (authentication).
Create, update, delete, and view habits.
Track habit progress (e.g., daily check-ins or completion percentage).
Generate analytics (e.g., streaks, success rates).
AI-powered habit recommendations or progress predictions (optional for v1).
Deliverable: A list of core features.


Step 1.2: Outline the Database Schema
Sketch out the structure of your database tables.
Example tables:
Users: Stores user information (e.g., ID, username, email, password hash).
Habits: Stores habit details (e.g., habit ID, user ID, title, description, target frequency).
Habit_Progress: Tracks daily or weekly progress for each habit.
(Optional) Notifications: Stores reminders or milestones for habits.
Deliverable: A draft database schema with table names and fields.


Step 1.3: List the AI Features
Decide which AI features you want to include in the first version.
Example AI features:
Habit recommendations based on user behavior.
Streak predictions based on progress patterns.
Sentiment analysis (if users log thoughts).
Deliverable: A prioritized list of AI features.


Step 1.4: Plan the Kafka Topics
Identify events that Kafka will process.
Example topics:
habit-progress: Sends updates whenever a user checks in on a habit.
notifications: Triggers notifications for reminders or milestones.
(Optional) ai-recommendations: Sends data to the AI service for habit insights.
Deliverable: A list of Kafka topics and their purpose.


Step 1.5: Create a Feature Roadmap
Break your features into versions or milestones to avoid being overwhelmed.
Example:
Version 1: User authentication, habit management, basic analytics.
Version 2: Add AI recommendations and notifications.
Version 3: Full analytics and frontend integration.
Deliverable: A roadmap with priorities.
