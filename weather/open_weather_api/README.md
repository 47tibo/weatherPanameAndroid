template generated with `openapi-generator author template -g kotlin -o template`

## modified fields

- open_weather_api/template/libraries/jvm-retrofit2/api.mustache
  - remove : `import {{packageName}}.infrastructure.CollectionFormats.*`
  - add : `internal interface {{classname}} {`
- open_weather_api/template/data_class.mustache
  - mark all data class as `internal`
