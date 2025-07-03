"""
Weather Station Simulator

This script simulates a weather station and sends weather data to a server.

Usage:
    python main.py

"""

import random
import time
from datetime import datetime
import requests

class WeatherStationSimulator:
    """
    A class that simulates a weather station and sends weather data to a server.
    """

    def __init__(self, station_name, temp_range, humidity_range, wind_speed_range, server_url="http://localhost:5000"):
        """
        Initialize a weather station simulator.

        Args:
            station_name (str): Name of the weather station
            temp_range (tuple): (min_temp, max_temp) in Fahrenheit
            humidity_range (tuple): (min_humidity, max_humidity) as percentage
            wind_speed_range (tuple): (min_wind_speed, max_wind_speed) in km/h
            server_url (str): URL of the weather tracking server
        """
        self.station_name = station_name
        self.temp_range = temp_range
        self.humidity_range = humidity_range
        self.wind_speed_range = wind_speed_range
        self.server_url = server_url
        self.station_id = None

        # Initialize current weather state
        self.current_temperature = random.uniform(temp_range[0], temp_range[1])
        self.current_humidity = random.uniform(humidity_range[0], humidity_range[1])
        self.current_wind_speed = random.uniform(wind_speed_range[0], wind_speed_range[1])

    def register_with_server(self):
        """
        Register this weather station with the server.

        Returns:
            bool: True if registration successful, False otherwise
        """
        try:
            registration_data = {
                "name": self.station_name,
            }

            response = requests.post(
                f"{self.server_url}/register",
                json=registration_data,
                timeout=10
            )
            print(response.status_code)

            if response.status_code == 200:
                self.station_id = response.text
                print(f"Successfully registered with server. Station ID: {self.station_id}")
                return True
            else:
                print(f"Failed to register with server. Status code: {response.status_code}")
                print(f"Response: {response.text}")
                return False

        except requests.exceptions.RequestException as e:
            print(f"Error connecting to server: {e}")
            return False

    def deregister_from_server(self):
        """
        Deregister this weather station from the server.

        Returns:
            bool: True if deregistration successful, False otherwise
        """
        if not self.station_id:
            print("No station ID to deregister")
            return False

        try:
            response = requests.post(
                f"{self.server_url}/deregister/{self.station_id}",
                timeout=10
            )

            if response.status_code == 200:
                print(f"Successfully deregistered station {self.station_id} from server")
                self.station_id = None
                return True
            else:
                print(f"Failed to deregister from server. Status code: {response.status_code}")
                print(f"Response: {response.text}")
                return False

        except requests.exceptions.RequestException as e:
            print(f"Error deregistering from server: {e}")
            return False

    def send_weather_update(self):
        """
        Send current weather data to the server.

        Returns:
            bool: True if update sent successfully, False otherwise
        """
        if not self.station_id:
            print("Cannot send update: Station not registered with server")
            return False

        try:
            weather_data = self.get_current_weather()

            response = requests.post(
                f"{self.server_url}/update/{self.station_id}",
                json=weather_data,
                timeout=10
            )

            if response.status_code == 200:
                return True

            print(f"Failed to send weather update. Status code: {response.status_code}")
            return False

        except requests.exceptions.RequestException as e:
            print(f"Error sending weather update: {e}")
            return False

    def get_station_info(self):
        """Return information about the weather station."""
        return {
            'station_name': self.station_name,
            'temp_range': self.temp_range,
            'humidity_range': self.humidity_range,
            'wind_speed_range': self.wind_speed_range,
            'station_id': self.station_id
        }

    def get_current_weather(self):
        """
        Get the current weather state.

        Returns:
            dict: Current weather reading with temperature, humidity, wind speed, and timestamp
        """
        return {
            'timestamp': datetime.now().strftime('%Y-%m-%d %H:%M:%S'),
            'temperature': round(self.current_temperature, 1),
            'humidity': round(self.current_humidity, 1),
            'wind_speed': round(self.current_wind_speed, 1)
        }

    def update_weather_with_fluctuations(self):
        """
        Update current weather state with small fluctuations.
        """
        # Add small fluctuations to current values
        temp_fluctuation = random.uniform(-2, 2)
        humidity_fluctuation = random.uniform(-5, 5)
        wind_speed_fluctuation = random.uniform(-1, 1)

        # Update current values and ensure they stay within ranges
        self.current_temperature = max(self.temp_range[0],
                                     min(self.temp_range[1],
                                         self.current_temperature + temp_fluctuation))

        self.current_humidity = max(self.humidity_range[0],
                                  min(self.humidity_range[1],
                                      self.current_humidity + humidity_fluctuation))

        self.current_wind_speed = max(self.wind_speed_range[0],
                                    min(self.wind_speed_range[1],
                                        self.current_wind_speed + wind_speed_fluctuation))

    def simulate_continuous_readings(self, duration_minutes=5, interval_seconds=2):
        """
        Simulate continuous weather readings for a specified duration.

        Args:
            duration_minutes (int): How long to simulate (default: 5 minutes)
            interval_seconds (int): Time between readings (default: 2 seconds)
        """
        print("\n=== Starting Weather Simulation ===")
        print(f"Station: {self.station_name}")
        print(f"Station ID: {self.station_id}")
        print(f"Duration: {duration_minutes} minutes")
        print(f"Reading interval: {interval_seconds} seconds")
        print("=" * 50)

        end_time = time.time() + (duration_minutes * 60)

        try:
            while time.time() < end_time:
                # Update weather with fluctuations
                self.update_weather_with_fluctuations()

                # Get current weather reading
                reading = self.get_current_weather()

                # Send update to server
                server_status = "✓" if self.send_weather_update() else "✗"

                print(f"[{reading['timestamp']}] "
                      f"Temp: {reading['temperature']}°F, "
                      f"Humidity: {reading['humidity']}%, "
                      f"Wind: {reading['wind_speed']} km/h "
                      f"[Server: {server_status}]")

                time.sleep(interval_seconds)

        except KeyboardInterrupt:
            print("\nSimulation stopped by user.")

        print("=" * 50)
        print("Simulation completed!")


def get_user_input():
    """Get weather station configuration from user input."""
    print("=== Weather Station Simulator Setup ===")

    # Get station name
    station_name = input("Enter the name of the weather station: ").strip()

    # Get temperature range (in Fahrenheit)
    print("\nTemperature Range (in Fahrenheit):")
    min_temp_f = float(input("Enter minimum temperature (°F): "))
    max_temp_f = float(input("Enter maximum temperature (°F): "))
    temp_range = (min_temp_f, max_temp_f)

    # Get humidity range
    print("\nHumidity Range (as percentage 0-100):")
    min_humidity = float(input("Enter minimum humidity: "))
    max_humidity = float(input("Enter maximum humidity: "))
    humidity_range = (min_humidity, max_humidity)

    # Get wind speed range
    print("\nWind Speed Range (in km/h):")
    min_wind_speed = float(input("Enter minimum wind speed: "))
    max_wind_speed = float(input("Enter maximum wind speed: "))
    wind_speed_range = (min_wind_speed, max_wind_speed)

    return station_name, temp_range, humidity_range, wind_speed_range


def main():
    """Main function to run the weather station simulator."""
    weather_station = None

    try:
        # Get user input
        station_name, temp_range, humidity_range, wind_speed_range = get_user_input()

        # Create weather station simulator
        weather_station = WeatherStationSimulator(
            station_name, temp_range, humidity_range, wind_speed_range, server_url="http://localhost:8000"
        )

        # Register with server
        print("\n=== Registering with Server ===")
        if not weather_station.register_with_server():
            print("Warning: Failed to register with server. Simulation will continue without server updates.")

        # Display station information
        print("\n=== Weather Station Created Successfully ===")
        info = weather_station.get_station_info()
        print(f"Station Name: {info['station_name']}")
        print(f"Station ID: {info['station_id']}")
        print(f"Temperature Range: {info['temp_range'][0]}°F to {info['temp_range'][1]}°F")
        print(f"Humidity Range: {info['humidity_range'][0]}% to {info['humidity_range'][1]}%")
        print(f"Wind Speed Range: {info['wind_speed_range'][0]} km/h to {info['wind_speed_range'][1]} km/h")

        # Show initial weather state
        initial_weather = weather_station.get_current_weather()
        print("\nInitial Weather State:")
        print(f"Temperature: {initial_weather['temperature']}°F")
        print(f"Humidity: {initial_weather['humidity']}%")
        print(f"Wind Speed: {initial_weather['wind_speed']} km/h")

        # Start continuous simulation
        duration = int(input("\nEnter simulation duration in minutes (default 5): ") or "5")
        interval = int(input("Enter reading interval in seconds (default 2): ") or "2")
        weather_station.simulate_continuous_readings(duration, interval)

    except ValueError as e:
        print(f"Error: Please enter valid numeric values. {e}")
    except Exception as e:
        print(f"An error occurred: {e}")
    finally:
        # Ensure deregistration happens even if there's an error
        if weather_station and weather_station.station_id:
            print("\nCleaning up: Deregistering from server...")
            weather_station.deregister_from_server()


if __name__ == "__main__":
    main()
