import React from 'react';
import { createRoot } from 'react-dom';
import WeatherApp from './components/WeatherApp';

createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <WeatherApp />
    </React.StrictMode>
);
