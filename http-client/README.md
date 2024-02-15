# HttpClient library

This library is shipped as an Hilt module.
Bindings are voluntarily unscoped. It's up to the user to scope them to the appropriate Hilt 
component, on usage.

Bindings are :

## `Retrofit.Builder` "real", with `@RetrofitBuilder` qualifier

A Retrofit factory with :
- GsonConverterFactory
- HttpLoggingInterceptor

## `Retrofit.Builder` "mocked", with `@MockedRetrofitBuilder` qualifier

A Retrofit factory with :
- GsonConverterFactory
- no interceptor
- MockWebServer that proxies http requests to `localhost`

Can be use in end2end testing.
