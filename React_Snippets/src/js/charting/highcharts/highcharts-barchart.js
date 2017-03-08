/**
 * @author:  krido02 - 1/30/2017.
 */
'use strict';

const Highcharts = require('react-highcharts');
const Chart = require('./react-highcharts');
const React = require('react');

//
// Highcharts.setOptions({
//     colors: ['#4cc575', '#337ab7', '#53BBD4', '#e34539', '#76777b', '#d9534f', '#F123B0', '#AAA000']
// });

let matchData = [{
    name: 'Scans',
    colorByPoint: true,
    data: [{
        name: 'Completed',
        y: 80.33
    }, {
        name: 'In Progress',
        y: 10.03,
        sliced: true,
        selected: true
    }, {
        name: 'Not Started',
        y: 10.38
    }, {
        name: 'Failed',
        y: 0.5
    }, {
        name: 'Paused',
        y: 0.91
    }, {
        name: 'Canceled',
        y: 0.2
    }, {
        name: "Lost",
        y: 5.02
    }]
}];

let matchCategories = ['Completed', 'In Progress', 'Not Started', 'Failed', 'Paused', 'Canceled', 'Lost'];

// Create and render element
var BarChart = React.createElement(Chart, {
    container: 'react-barchart',
    options: {
        chart: {
            renderTo: 'react-barchart',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'bar'
        },
        title: {
            text: 'Barring it up.'
        },
        legend: {
            // layout: 'horizontal', // default
            itemDistance: 7
        },
        subtitle: {
            text: 'Past 7 days'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        xAxis: {
            categories: matchCategories
        },
        yAxis: {
            title: {
                text: "Number of Matches"
            }
        },

        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true,
                size: '80%'
            }
        },
        series: matchData
    }
});

module.exports = BarChart;