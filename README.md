Grails Sample Application using External i18n
=============================================

## Demo

```
$ grails run-app

$ curl "http://localhost:8080/hello?lang=en"
{"hello":"Hello, i18n!!"}

$ curl "http://localhost:8080/hello?lang=ja"
{"hello":"こんにちは、i18nさん!!"}

$ echo 'hello=Hi, {0}!!'   > /tmp/my.properties

$ echo 'hello=やあ、{0}!!' > /tmp/my_ja.properties

$ curl "http://localhost:8080/hello?lang=en"
{"hello":"Hi, i18n!!"}

$ curl "http://localhost:8080/hello?lang=ja"
{"hello":"やあ、i18n!!"}
```
