/**
 * @author:  krido02 - 1/30/2017.
 */
'use strict';

var Highcharts = require('react-highcharts');
var Chart = require('./react-highcharts');
var React = require('react');

// Create and render element
var LineChart = React.createElement(Chart, {
    container: 'react-linechart',
    options: {
        chart: {
            type: 'scatter'
        },
        title: {
            text: 'Matches in past 10 days'
        },
        xAxis: {
            categories: ['Oct 4', 'Oct 5', 'Oct 6', 'Oct 7', 'Oct 8', 'Oct 9', 'Oct 10', 'Oct 11', 'Oct 12' , 'Oct 13']
        },
        yAxis: {
            title: {
                text: 'Matches (Thousands)'
            }
        },
        series: [{
            name: 'Days<br> Selected Classifier: SSN',
            color: '#337ab7',
            data: [10, 12, 8, 5, 9, 13, 16, 18, 7, 8]
        }]
    }
});

module.exports = LineChart;