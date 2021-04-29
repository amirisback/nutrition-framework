## About This Project
General Framework for Application Development Around Nutrition Using the Android Platform, Skripsi S1 Muhammad Faisal Amir from Telkom University

## Version Release
This Is Latest Release

    $version_release = * Coming Soon *

What's New??

    * Coming Soon *

## Documentation
- Guide [Click Here](https://github.com/amirisback/general-framework/tree/master/docs/guide)
- Journal [Click Here](https://github.com/amirisback/general-framework/tree/master/docs/journal)
- Theory [Click Here](https://github.com/amirisback/general-framework/tree/master/docs/theory)
- Proposal [Click Here](https://github.com/amirisback/general-framework/tree/master/docs)
- Slide [Click Here](https://docs.google.com/presentation/d/1TbJjrjXdieSdqo_dSz0N_umAgeT6euGOWp-nYOHS3g8/edit?usp=sharing)
- Design, Flowchart on Figma [Click Here](https://www.figma.com/file/Ons8XY0YvxecwC71Aa92Qj/TA?node-id=0%3A1)

## Telkom University Lecturers
- Dana Sulistyo Kusumo, S.T., M.T., PhD.
- Shinta Yulia Puspitasari, S.T., M.T.

## Problem
Membuat beberapa aplikasi tentang beberapa nutrisi. <br>
- Self assesment (Penyakit bawaan / tidak, profiling orang untuk aplikasi,
- Kategori (Contoh : Vitamin D, sehat perlu suplemen)
- Rekomendasi makanan / obat, rekomendasi penangan
- 1 Aplikasi bisa di edit / customize dengan berbagai macam keluhan
- Jika di website yaitu bootstrap

## Android Library Version (build.gradle)
- ext.kotlin_version = '1.4.32'
- classpath 'com.android.tools.build:gradle:4.1.3'
- compileSdkVersion 30
- buildToolsVersion "30.0.2"
- minSdkVersion 21
- targetSdkVersion 30

## Architecture
-   Pattern  [Model-View-ViewModel](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel)  (MVVM) facilitating a [separation](https://en.wikipedia.org/wiki/Separation_of_concerns) of development of the graphical user interface.
-   [S.O.L.I.D](https://en.wikipedia.org/wiki/SOLID)  design principles intended to make software designs more understandable, flexible and maintainable.

## Tech-stack
Min API level is set to 21, so the presented approach is suitable for over 94% of devices running Android. This project takes advantage of many popular libraries and tools of the Android ecosystem. Most of the libraries are in the stable version unless there is a good reason to use non-stable dependency.
-   [Jetpack](https://developer.android.com/jetpack):
    -   [Android KTX](https://developer.android.com/kotlin/ktx.html)  - provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    -   [AndroidX](https://developer.android.com/jetpack/androidx)  - major improvement to the original Android  [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    -   [View Binding](https://developer.android.com/topic/libraries/view-binding)  - allows you to more easily write code that interacts with views/
    -   [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)  - perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    -   [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)  - lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
    -   [Navigation](https://developer.android.com/guide/navigation/)  - helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.
    -   [Room](https://developer.android.com/topic/libraries/architecture/room)  - persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
    -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)  - designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
-   [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)  - managing background threads with simplified code and reducing needs for callbacks.
-   [Coroutines Flow](https://kotlinlang.org/docs/reference/coroutines-overview.html)  - cold asynchronous data stream that sequentially emits values and completes normally or with an exception
-   [Dagger2](https://dagger.dev/)  - dependency injector for replacement all Factory classes.
-   [Retrofit](https://square.github.io/retrofit/)  - type-safe HTTP client.
-   [Glide](https://github.com/bumptech/glide)  - image loading and caching library

## My own library
- Admob Sample https://github.com/amirisback/admob-helper-implementation
- MVVM Sample https://github.com/amirisback/android-architecture-by-amirisback
- frogo-recycler-view https://github.com/amirisback/frogo-recycler-view
- Awesome API Implemented https://github.com/amirisback/awesome-frogo-consumable-apps
- Kick Start Template https://github.com/amirisback/android-kick-start-project-template

## Attention !!!
- Please enjoy and don't forget fork and give a star
- Don't Forget Follow My Github Account