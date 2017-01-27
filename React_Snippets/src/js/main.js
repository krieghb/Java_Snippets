/**
 * @author:  krido02 - 1/27/2017.
 */

import React from 'react';
import ReactDOM from 'react-dom';
import Counter from './byos/Counter';

console.log('Hello World!');

document.addEventListener('DOMContentLoaded', function() {
    ReactDOM.render(
        React.createElement(Counter),
        document.getElementById('main-container')
    );
});