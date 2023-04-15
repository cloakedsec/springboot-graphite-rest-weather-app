# Example Spring Boot/Graphite App

This is quick and dirty example spring boot applicaiton that ships metrics to Statsd/Graphite. Its purpose it to help validate the proposed [Flagger Graphite metric provider](https://github.com/fluxcd/flagger/issues/911).


## Building/Running

To build and run the app via Docker/Docker Compose:

```
make run
```

Once the app has started you should be able to see the Graphite UI at http://localhost:8080
-------------------------------------------------------------------------------------------
BOOTSTRAP:

https://getbootstrap.com/docs/5.3/getting-started/webpack/


mkdir my-project && cd my-project
npm init -y

npm i --save-dev webpack webpack-cli webpack-dev-server html-webpack-plugin
npm i --save bootstrap @popperjs/core
npm i --save-dev autoprefixer css-loader postcss-loader sass sass-loader style-loader
mkdir {src,src/js,src/scss}
touch src/index.html src/js/main.js src/scss/styles.scss webpack.config.js
my-project/
├── src/
│   ├── js/
│   │   └── main.js
│   ├── scss/
│   │   └── styles.scss
│   └── index.html
├── package-lock.json
├── package.json
└── webpack.config.js
==========
You can then issue request to the demo application to generate metrics:

```
curl --request GET 'http://localhost:8080/echo-get?msg=Test%20Get&latency=0&status=200'

curl --request POST 'http://localhost:8080/echo-post' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'msg=Test Post' \
--data-urlencode 'latency=0' \
--data-urlencode 'status=200'
```

You can adjust the latency parameter by providing a value in milliseconds and you can adjust the returned status code by chaning the status parameter.

