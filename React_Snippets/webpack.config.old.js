/**
 * @author:  krido02 - 1/27/2017.
 */

var path = require('path');
var ExtractTextPlugin = require("extract-text-webpack-plugin");

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
            {
                test: /\.scss$/,
                loader: ExtractTextPlugin.extract("css!sass")
            }
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
    plugins: [
        new ExtractTextPlugin("app.css")
    ]
};
module.exports = config;