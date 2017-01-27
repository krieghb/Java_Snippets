/**
 * @author:  krido02 - 1/27/2017.
 */

var path = require('path');

var config = {
    context: path.join(__dirname, 'src/js'),
    entry: [
        './main.js',
    ],
    output: {
        path: path.join(__dirname, 'target'),
        filename: 'bundle.js',
    },
    module: {
        loaders: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loaders: ['babel'],
            },
        ],
    },
    resolveLoader: {
        root: [
            path.join(__dirname, 'node_modules'),
        ],
    },
    resolve: {
        root: [
            path.join(__dirname, 'node_modules'),
        ],
    },
};
module.exports = config;