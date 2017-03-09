/**
 * @author:  krido02 - 1/27/2017.
 */
'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const MyApp = require('./myApp');
require('../style/main.scss');




document.addEventListener('DOMContentLoaded', function() {
    ReactDOM.render(
        <MyApp  />,
        document.getElementById('mounts')
    );
});