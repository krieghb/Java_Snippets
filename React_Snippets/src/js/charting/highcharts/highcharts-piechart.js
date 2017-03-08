/**
 * @author:  krido02 - 1/30/2017.
 */
'use strict';

var Highcharts = require('react-highcharts');
var Chart = require('./react-highcharts');
var React = require('react');


// Highcharts.setOptions({
//     colors: ['#4cc575', '#337ab7', '#53BBD4', '#e34539', '#76777b', '#d9534f', '#F123B0']
// });



// Create and render element
var PieChart = React.createElement(Chart, {
    container: 'react-piechart',
    options: {
        chart: {
            renderTo: 'react-piechart',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Chart of Pie',
            style: { "color": "#00FFAA", "fontSize": "18px" }
        },
        legend: {
            // layout: 'horizontal', // default
            itemDistance: 7
        },
        subtitle: {
            text: 'Past 7 days',
            style: { "color": "#ABCDEF" },
            align: "center"
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },

        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true,
                size: '100%'
            }
        },
        series: [{
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
            } ]
        }]
    }
});

module.exports = PieChart;