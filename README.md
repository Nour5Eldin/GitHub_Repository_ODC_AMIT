
![Logo](https://drive.google.com/file/d/1Xb-XKIdP7vDX4vRMa-EN8eMiEnda9cf3/view?usp=drive_link)
# Github Repository By ODC & AMIT
Github Repository Android Application Building with Latest Technology & Advanced Android Topics at AMIT Learing & Orange Degital Center InternShip.




##  Technology Used

- **Kotlin**: A modern programming language for Android development.
- **Jetpack Compose**: Android’s modern toolkit for building native UI.
- **MVVM Architecture**: Clean architecture pattern to separate business logic from the UI layer.
- **Hilt**: Dependency injection framework for managing app-level dependencies.
- **Retrofit**: Type-safe HTTP client for making API requests.
- **Room**: A persistence library for local data storage.
- DataStore: A simple, modern data storage solution that allows storing key-value pairs or typed objects.
- **Coroutines & Flow**: For asynchronous programming and handling streams of data.
- **Gson**: A library for JSON serialization and deserialization.
- **Coil**: Image loading library for Kotlin that uses Coroutines.
- **Lottie**: For rendering animations from Adobe After Effects.
- **Chucker**: HTTP inspector for debugging network requests.
- **Mockk**: Mocking library for testing Kotlin code.





## Features 
1. **Shimmer Effect For Loading State**:
- The app uses a Shimmer Effect to provide a smooth visual loading state while fetching data from the API.

- When the user navigates to the Repo List Screen, a shimmer animation is displayed, mimicking the layout of the repository items until the data is fully loaded from the API.

2. **Repo List Screen**:
- Fetches a list of repositories from a REST API (e.g., GitHub API) using  Retrofit.
- Each repository is displayed in a list, showing: 
     - Repository Name
     - Owner's Avatar
     - Star Count
     - Fork Count
     - Description

- Tapping on a repository navigates the user to the Repo Details Screen.

3. **Repo Details Screen**:
- Displays detailed information about a selected repository, including:
   - Repository Image: Shows the owner's avatar or repository image.
   - Repository Name: Clearly visible at the top.
   - Stars Count: Total number of stars the repository has received.
   - Forks Count: Total number of times the repository has been forked.
   - Description: Detailed description of the repository.
   - Created Date: The date when the repository was created Also provides a button to navigate to the Repo Issues Screen.

4. **Repo Issues Screen**:
- Lists the issues related to the selected repository:
    - Issue Title
    - Status: Whether the issue is Open or Closed.
    - Created Date: When the issue was created.
    - Closed Date (if applicable): Displays when the issue was closed if it’s resolved.
- Issues are fetched dynamically via an API request using Retrofit and displayed in a list format.
- The screen also supports the Shimmer Effect for loading states while the issue data is fetched.


5. **Error Screen - No WiFi/Network Unavailable**:
- When there is no internet connection, an error screen is displayed indicating that the network is unavailable.
- The app checks for the network status using ConnectivityManager and shows a user-friendly error message when the device is offline.
- A retry button is available, allowing users to attempt reconnecting when the network is restored.
- In the event of no network, the app falls back to cached data using DataStore for the Repo List:
- The last successfully fetched list of repositories is stored and displayed.
- If cached data exists, the app displays the cached repositories so users can still view them while offline.
- If no cached data is available, a message is shown to inform the user that no data is available offline.
## Screenshots

![My Splash Screen](https://drive.google.com/file/d/1RtUaIDNYB9tGoXolnDrHodijiddlw_lU/view?usp=drive_link)

![Shimmer Screen](https://drive.google.com/file/d/188K_M9Sm0cEjTr73bEJQTrDtpas1BT0C/view?usp=drive_link)

![Repository List Screen](https://drive.google.com/file/d/1cAptQk4g5W6aruIt0XJQIru_iMRr4IZf/view?usp=drive_link)

![Repository Details Screen](https://drive.google.com/file/d/12S3_f8qhLMgsNcAP0fSVfoofOoutL3An/view?usp=drive_link)

![Repository Issues Screen](https://drive.google.com/file/d/1n_6J12JpoFBe-0k53XreuT34kwduRV4m/view?usp=drive_link)

![Network Error Screen](https://drive.google.com/file/d/1c7_el-TXTDoGDI7rv9fEsTOt3726PyIh/view?usp=drive_link)

## Installing  project

Clone the project

```bash
git clone   https://github.com/Nour5Eldin/GitHub_Repository_ODC_AMIT.git
```


## License

[MIT](https://img.shields.io/badge/Mit-Licence-mintgreen)

