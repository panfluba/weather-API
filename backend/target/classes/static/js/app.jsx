import React, { useState } from 'react';

const App = () => {
    const [city, setCity] = useState('');
    const [weather, setWeather] = useState(null);

    const fetchWeather = async () => {
        try {
            const response = await fetch(`/weather/${city}`);
            const data = await response.json();
            setWeather(data);
        } catch (error) {
            console.error('Error fetching weather data:', error);
        }
    };

    return (
        <div>
            <input type="text" value={city} onChange={(e) => setCity(e.target.value)} />
            <button onClick={fetchWeather}>Get Weather</button>
            {weather && (
                <div>
                    <h2>{weather.city}</h2>
                    <p>Temperature: {weather.temperature} °C</p>
                    <p>Humidity: {weather.humidity}%</p>
                </div>
            )}
        </div>
    );
};

export default App;
