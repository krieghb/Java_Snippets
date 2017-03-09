/**
 * @author:  krido02 - 1/30/2017.
 */
'use strict';

const React = require('react');

// const Highcharts = require('react-highcharts');
// const chartjsLine = require('./charting/chartjs/chartjs-linechart');
// var bs = require('react-bootstrap');

// const piechart = require('./charting/highcharts/highcharts-piechart');
// const barchart = require('./charting/highcharts/highcharts-barchart');
// const linechart = require('./charting/highcharts/highcharts-linechart');
// const CounterWrapper = require('./byos/counter-wrapper');
//
// const BasicLineClass = require('./charting/react-highcharts/basic-line-class');


let App = React.createClass({


    //  Hi
    toConsole:  function() {
        if(!window.console){ window.console = {log: function(){} }; }

        console.debug("HI");
    },


    render: function () {
        return (
            <div id="main-app">
                {this.toConsole}
            </div>
        );
    }
});

module.exports = App;