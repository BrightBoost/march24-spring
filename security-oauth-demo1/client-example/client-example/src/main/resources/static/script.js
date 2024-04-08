async function callPostEndpoint() {
  const url = 'http://localhost:8080'; // The URL of the endpoint

  try {
    const response = await fetch(url, {
      method: 'POST', // Specify the request method
      headers: {
        // Headers are optional and can be omitted if not needed
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({}), // Sending an empty object as no data is to be sent
    });

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data = await response.json(); // Assuming the response is JSON
    console.log('Success:', data);
  } catch (error) {
    console.error('Error:', error);
  }
}