# Android Networking II: OkHttp, Retrofit, Moshi and Picasso

![Java](https://img.shields.io/badge/Java-Android-007396?logo=openjdk&logoColor=white)
![OkHttp](https://img.shields.io/badge/OkHttp-3.9.1-3E4348)
![Retrofit](https://img.shields.io/badge/Retrofit-2.3.0-48B983)
![Moshi](https://img.shields.io/badge/Moshi-1.5.0-6A5ACD)
![Picasso](https://img.shields.io/badge/Picasso-2.5.2-FFB000)
![Status](https://img.shields.io/badge/status-historical%20sample-FFB000)

A Java Android sample showing how OkHttp, Retrofit, Moshi, and Picasso fit
together in a small networking app.

The app uses Retrofit as the type-safe API layer, Moshi as the JSON converter,
OkHttp as the HTTP client underneath Retrofit, and Picasso for image loading and
image transformations.

This repository accompanies the article
[Android Networking II: OkHttp, Retrofit, Moshi and Picasso](https://medium.com/@sotti/android-networking-ii-okhttp-retrofit-moshi-and-picasso-c381f6c0efd8).

## ✨ What It Demonstrates

- A singleton Retrofit client configured with `MoshiConverterFactory`.
- Retrofit service interfaces for JSON object and JSON array requests.
- `Call<T>` wrappers and asynchronous `enqueue()` callbacks.
- Response success/error handling before updating the UI.
- Request cancellation from `onStop()`.
- Picasso image loading into `ImageView` and RecyclerView rows.
- Placeholder and error images for remote image loading.
- A custom Picasso `Transformation` for circular image cropping.
- Data Binding for simple click handlers and screen bindings.

## 🖼️ Demo Screens

| Screen | What It Shows |
| --- | --- |
| `JsonObjectActivity` | Fetch one object with Retrofit and render title/body text. |
| `JsonArrayActivity` | Fetch an array of objects and render multiple parsed items. |
| `ImageLoadingActivity` | Load a scrolling list of remote images with Picasso. |
| `ImageTransformationActivity` | Load one image and apply a circular Picasso transformation. |

## ⚙️ Tech Stack

- Java
- Android Gradle Plugin 3.0.1
- Gradle 4.5.1
- compile SDK 27, target SDK 27, min SDK 16
- Android Support Library 27.0.2
- OkHttp 3.9.1
- Retrofit 2.3.0
- Moshi 1.5.0
- Picasso 2.5.2
- Data Binding
- RecyclerView and ConstraintLayout

## 🚀 Run It

This repo is pinned to 2018 Android tooling. For the least friction, use an
Android Studio/JDK setup compatible with AGP 3.0.1 and Gradle 4.5.1.

```bash
./gradlew :app:assembleLiveDebug
./gradlew :app:installLiveDebug
```

The sample uses old public demo endpoints and image URLs. If any network call no
longer responds, the app still remains useful as a reference for Retrofit,
Moshi, Picasso, callbacks, cancellation, and image transformations.

## 🧪 Verification

No automated test suite is included in this historical sample. The practical
sanity check is to build the debug app:

```bash
./gradlew :app:assembleLiveDebug
```

## 📌 Status

This is a historical sample for an old Android networking article series, not a
modern networking template. Its value today is as a compact reference for how
OkHttp, Retrofit, Moshi, and Picasso were commonly wired together in a
pre-AndroidX Java app.

## 📜 License

The original README declared this repository to be MIT licensed. A standalone
`LICENSE` file is not currently present in the repository.
