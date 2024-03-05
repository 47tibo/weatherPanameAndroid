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

### Code convention

Ktlint via [kotlinter](https://github.com/jeremymailen/kotlinter-gradle).
Personal choices :
- for functions arguments, the default is positional. Indeed Android Studio gives enough intel on arguments.
I use named arguments only for disambiguation, when optional arguments are in the function's signature.
- for abbreviations, I use capitalize case, not screaming case. Eg : Dto, not DTO
- tests files (unit and e2e) use `Test` in their names : as a prefix for _stubs_ and as suffix for _tests classes_
- to avoid conflicts with Compose classes, I use the `Main` prefix (e.g `MainNavHost`)

### Weather data API

Weather data for Paris is retrieved from [OpenWeather](https://openweathermap.org/).
API is autogenerated with [OpenAPI generator](https://openapi-generator.tech/), with all the configuration
and template in `weather` subproject, under `/open_weather_api`.

The `OpenWeather.yaml` file is created by transforming a Postman collection containing an OpenWeather
JSON response to an OpenAPI scheme. This, thanks to [this tool](https://kevinswiber.github.io/postman2openapi/).

Once the proper scheme is created, in order to generate the API, simply run :

```
./gradlew openApiGenerate
```

> Note : The generated DTO fields are all nullable. Instead of a painful configuration of OpenAPI's 
> templates, I've choose to use the not null assertion operator in `WeatherAssembler`.

### Third party artifacts and integration

- Compose Navigation
- Hilt for DI
- Retrofit for network requests
- Ktlint for linting, runs on pre-push
- Kover for code coverage runs on Bitrise (release flavor)

### Application architecture

Based on Robert C. Martin's _Clean Architecture_, more precisely the **package by components** packaging strategy,
proposed by Simon Brown in chapter 24.

The architecture diagram is `components_architecture.drawio` file, at the root of this project.
This file has to be open with [DrawIO](https://app.diagrams.net/) tool (free and really cool).

Separation between abstraction and concrete implementation (especially for remote data sources) is handled via
Hilt Modules bindings.

Specific concepts of Repository, Gateway, DTO & Assembler are extract from Eric Evans & Martin Fowler 
books _Domain Driven Design_ & _PEAA_.

Data flows contain Kotlin's `Result`, which are created on the lowest level (in architectural term), ie
in the network layer implementation. This in order to wrap exceptions as soon as possible, as recommended 
in this [Kotlin Conf talk](https://www.youtube.com/watch?v=pvYAQNT4o0I).

**All the following components are packaged as gradle subprojects.**

### Application components

They strictly follows encapsulation and dependency rule, using `interfaces` to define contracts (and for DIP, when needed).
Libraries are encapsulated using `internal` modifier.

They are under the `com.tibo47.weatherPaname` package.

#### `app` component

This component is at the lower level in the architecture. It bootstrap the main activity & application.
It connects ui component (see bellow) via navigation. It contains material design 3 theme.
Its android test target provides e2e tests.

#### `weather` component

This component is an android library. It contains all the business and data-providing
logic to retrieve and expose data about Paris' weather. It only exposes OpenWeather Retrofit API & uses cases.

#### `weekly-weather-ui` component

This component is an android library. It contains ui components to display the main screen for the
current weather.

### External components

#### `http-client` component

Under `com.tibo47.httpClient` package.

Exposes a Retrofit factory with :
- GsonConverterFactory
- HttpLoggingInterceptor
