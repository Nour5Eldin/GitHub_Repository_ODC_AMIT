
![Logo](https://github.com/user-attachments/assets/570d5e02-1844-4a34-8977-46dbac9bb242)
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

  
## Screen shots

<div style="display: flex; flex-wrap: wrap; justify-content: space-between; gap: 10px;">
  <!-- Row 1 -->
  <div style="text-align: center; width: 10%; height: 20%">
    <p>My Splash Screen</p>
    <img src="https://github.com/user-attachments/assets/feb13655-ab7f-4bdc-9d4e-3abf22601f44" width="300" height=600" style="object-fit: cover;" />
  </div>

  <div style="text-align: center; width: 10%; height: 20%"">
    <p>Shimmer Screen</p>
    <img src="https://github.com/user-attachments/assets/5cb00164-ee8e-462e-9c10-8db7d024d5da" width="300" height="600" style="object-fit: cover;" />
  </div>

  <div style="text-align: center; width: 10%; height: 20%"">
    <p>Repository List Screen</p>
    <img src="https://github.com/user-attachments/assets/606a9431-7af1-4a7d-96fe-fb37b013be17" width="300" height="600" style="object-fit: cover;" />
  </div>
</div>

<div style="display: flex; flex-wrap: wrap; justify-content: space-between; gap: 10px;">
  <!-- Row 2 -->
  <div style="text-align: center; width: 10%; height: 20%"">
    <p>Repository Details Screen</p>
    <img src="https://github.com/user-attachments/assets/95909c76-5c7f-42d3-80dd-b5fc143bef64" width="300" height="600" style="object-fit: cover;" />
  </div>

  <div style="text-align: center; width: 10%; height: 20%"">
    <p>Repository Issues Screen</p>
    <img src="https://github.com/user-attachments/assets/57812351-8b7f-4ec6-b716-18dfbf8414bf" width="300" height="600" style="object-fit: cover;" />
  </div>

  <div style="text-align: center; width: 10%; height: 20%"">
    <p>Network Error Screen</p>
    <img src="https://github.com/user-attachments/assets/c652fcab-5b1b-48f6-a552-74f324525c41" width="300" height="600" style="object-fit: cover;" />
  </div>
</div>


## Installing  project

Clone the project

```bash
git clone   https://github.com/Nour5Eldin/GitHub_Repository_ODC_AMIT.git
```


## License

[MIT](https://img.shields.io/badge/Mit-Licence-mintgreen)

