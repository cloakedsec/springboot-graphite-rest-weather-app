$(function() {
    $('#weather-form').submit(function(event) {
        event.preventDefault();

        var city = $('input[name="city"]').val();

        if (city.trim() === '') {
            $('#error-message').text('Please enter a city name');
            return;
        }

        $('#error-message').text('');

        $.ajax({
            url: '/',
            method: 'POST',
            data: { city: city },
            success: function(response) {
                var weather = response.weather;

                if (weather === null) {
                    $('#error-message').text('City not found');
                    return;
                }

                $('#city-name').text(weather.city);
                $('#temperature').text('Temperature: ' + weather.temperature + ' K');
                $('#humidity').text('Humidity: ' + weather.humidity + '%');
                $('#description').text('Description: ' + weather.description);
            }
        });
    });
});