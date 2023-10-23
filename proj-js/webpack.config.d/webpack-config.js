;(function (config) {
    const shouldRunServer = config.mode !== "production"
    const serverUrl = 'http://localhost:8081'

    if (shouldRunServer) {
        config.devServer = config.devServer || {};
        config.devServer.proxy = {
            '/': {
                target: serverUrl,
                secure: false
            }
        }
    }

    // https://youtrack.jetbrains.com/issue/KT-50826
    config.performance = {
        hints: false
    };
})(config);