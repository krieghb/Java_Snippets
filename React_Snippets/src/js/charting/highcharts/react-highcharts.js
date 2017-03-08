/**
 * @author:  krido02 - 1/30/2017.
 */

'use strict';
const Highcharts = require('highcharts');
const React = require('react');


Highcharts.setOptions ({
    credits: {
        enabled: false
    }
});

let Chart = React.createClass({

    //  When the DOM is ready, create the chart.
    componentDidMount: function () {
        //  Extend the Highcharts
        if (this.props.modules) {
            this.props.modules.forEach(function (module) {
                module(HighCharts);
            });
        }

        //  Set container which the chart should render to.
        this.chart = new Highcharts[this.props.type || "Chart"] (
            this.props.container,
            this.props.options
        );
    },

    // Destroying the chart before unmounting.
    componentWillUnmount: function () {
        this.chart.destroy();
    },

    //  Create the div which the chart will be rendered to.
    render: function () {
        return React.createElement('div', {
            id: this.props.container
        });
    }
});


module.exports = Chart;


