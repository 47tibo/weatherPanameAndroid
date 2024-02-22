# HttpClient library

This library is shipped as an Hilt module.
Bindings are voluntarily unscoped. It's up to the user to scope them to the appropriate Hilt 
component, on usage.

Bindings are :

## `Retrofit.Builder`

A Retrofit factory with :
- GsonConverterFactory
- HttpLoggingInterceptor
