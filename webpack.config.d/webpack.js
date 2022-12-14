let devServer = config.devServer

if (devServer) {

    config.mode = "development"

    // config.devtool = false
    config.devtool = "source-map"

    config.stats = {
        errors: true,
        warnings: true,
    };

    config.infrastructureLogging = {
        // Only warnings and errors
        // level: 'none' disable logging
        // Please read https://webpack.js.org/configuration/other-options/#infrastructurelogginglevel
        level: 'warn',
    }

    // config.plugins = []

    devServer.port = 55001
    devServer.open = true
    devServer.hot = false
}

console.log(config)
