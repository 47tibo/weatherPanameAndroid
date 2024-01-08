# Weather Paname 🇫🇷 ⛅

## Features

Weather in Paris in a blink !
Hourly detail for the current day, by segment on the next 7 days.
There is more ! You will discover : 
- temperature in celsius
- wind direction
- blowing power

Say bye to bad surprises when leaving the subway (or riding your bike).

## Technical specs

### Weather data API

Weather data for Paris is retrieved from [OpenWeather](https://openweathermap.org/).

### Third party artifacts and integration

- Hilt for DI
- Retrofit for network requests
- Ktlint for linting, runs on pre-push
- Kover for code coverage runs on Bitrise

### Application architecture

Based on Robert C. Martin's _Clean Architecture_, more precisely the **package by components** packaging strategy,
proposed by Simon Brown in chapter 24.

The architecture diagram is `components_architecture.drawio` file, at the root of this project.
This file has to be open with [DrawIO](https://app.diagrams.net/) tool (free and really cool).
