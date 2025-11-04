# Noti App

Noti App is an Android companion that schedules personal task reminders and synchronizes notifications across devices, including connected smartwatches.

## Android application

The `app` module contains a minimal Compose-based Android application that allows users to schedule a reminder (in minutes). The reminder is delivered with a notification using WorkManager, and the notification channel is configured to cooperate with wearable devices that mirror alerts.

### Building and running

1. Open the project in Android Studio Flamingo or newer.
2. Ensure that the Android Gradle Plugin (AGP) and Kotlin versions requested in the project can be downloaded by your environment.
3. Sync the Gradle project; Android Studio will download dependencies.
4. Connect an Android device or start an emulator running API level 24 or higher.
5. Press **Run** to install the application.

When launching the app on Android 13 or newer, you may be prompted to grant the notification permission. After granting the permission, use the "Schedule Reminder" button to enqueue a WorkManager job that posts a notification when it fires.

See [docs/smartwatch_notifications.md](docs/smartwatch_notifications.md) for the integration design that powers wearable alerts.
