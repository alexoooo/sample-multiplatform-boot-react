// wrap is useful, because declaring variables in module can be already declared
// module creates own lexical environment
;(function (config) {
    const serverUrl = 'http://localhost:8081';

    config.devServer = config.devServer || {};

    config.devServer.proxy = {
        '/': {
            target: serverUrl,
            secure: false,
//            bypass: function (req, res, proxyOptions) {
//                if (req.headers.accept.indexOf('.js') !== -1) {
//                    return req.headers.accept;
//                }
//            }
        }
    }
})(config);