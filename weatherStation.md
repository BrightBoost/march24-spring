### Weather Station Streaming Application

**Overview:**
You will create a system that simulates receiving real-time weather data (e.g., temperature, humidity) from multiple "stations" and streams this data to a web client dashboard in real-time using SSE. The system will use Kafka for message passing.

**Skills needed:**

- Kafka topic creation and message production
- Spring WebFlux for reactive programming
- Server-Sent Events for real-time data streaming to the frontend

**Components:**

1. **Kafka Setup:**

   - Create a Kafka topic named `weather-data`.

2. **Spring WebFlux application:**

   - **Weather Data Producer:** Simulate weather station data. Each "station" periodically produces weather data (JSON format with station ID, temperature, and humidity) and sends it to the `weather-data` Kafka topic.
   - **Weather Data Consumer:** Consumes messages from the `weather-data` topic, and pushes them to clients via SSE.

3. **Frontend dashboard (can be in ./resources/static/index.html):**
   - Display real-time weather data from multiple stations as it arrives. Bonus: Allow users to select which stations' data they want to view.

### Exercise step-by-step instructions (in case you need them):

1. **Set Up Kafka topic:**

   - Ensure Kafka and Zookeeper are running.
   - Create a `weather-data` topic.

2. **Implement the Spring WebFlux application:**

   - **Producer Endpoint:** Create a REST endpoint that simulates weather station data submission. This could simply take JSON data for the weather and produce it to the Kafka topic.
   - **Consumer and SSE stream:** Implement a Kafka listener that consumes from the `weather-data` topic and uses a `Sinks.Many` to multicast this data to subscribers via SSE.

3. **Create the frontend dashboard:**

   - Use HTML and JavaScript to subscribe to the SSE endpoint and update the webpage with live weather data. Display each station's data in a separate section or table.

4. **Demonstration and testing:**
   - Produce sample weather data to the Kafka topic either through the REST endpoint or directly using Kafka's command-line tools.
   - Show the live updates on the frontend dashboard as data is produced.

### Challenges for when you're done:

- **Dynamic subscription:** Implement functionality on the frontend allowing users to select which weather stations' data they want to subscribe to. Filter the SSE stream server-side based on user selection.
- **Data visualization:** Integrate a simple charting library (e.g., Chart.js) on the frontend to visualize the temperature and humidity data over time.
- **Station health check:** Simulate a "health check" message for stations and have the dashboard indicate the status of each station (e.g., online, offline) in real-time.
