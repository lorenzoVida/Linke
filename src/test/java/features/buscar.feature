Feature: Search Pruebas

Scenario: BusquedaIncorrecta
Given Initialize the browser chrome
And Navigate to "https://www.google.com.pe" site
When User writes "pruebaz"
And Click in Search
And Click in Pruebas
Then Verify number of results is greater than 6