import React, { useState } from 'react';
import './WeatherApp.css';

const WeatherApp = () => {
    const [service, setService] = useState('');
    const [city, setCity] = useState('');
    const [weather, setWeather] = useState(null);
    const [error, setError] = useState('');

    const fetchWeather = async (e) => {
        e.preventDefault();

        if (!service || !city) {
            setError('Please, fill in both service and city fields.');
            return;
        }

        try {
            const response = await fetch(`/weather/${service}/${city}`);
            if (!response.ok) {
                throw new Error('Failed to fetch weather data.');
            }
            const data = await response.json();
            setWeather(data);
            setError('');
        } catch (error) {
            console.error('Error fetching weather data:', error);
            setError('Error fetching service or city data. Please try again.');
        }
    };

    return (
        <div className="weather-app">
            <form onSubmit={fetchWeather}>
                <input type="text" value={service} onChange={(e) => setService(e.target.value)}
                       placeholder="Enter service" className="input-field" />
                <input type="text" value={city} onChange={(e) => setCity(e.target.value)}
                       placeholder="Enter city" className="input-field" />
                <button type="submit" className="submit-button">Get Weather</button>
            </form>
            {error && <p className="error-message">{error}</p>}
            {weather && (
                <div className="weather-info">
                    <h2>Location: {weather.name || 'Unknown city'}</h2> //sdfsdf
                    <img src={weather.imageUrl} alt="" className="city-image" />
                    <p>Temperature: {weather.main ? weather.main.temp : 0} °C</p>
                    <p>Humidity: {weather.main ? weather.main.humidity : 0}%</p>
                </div>
            )}
        </div>
    );
};

export default WeatherApp;
