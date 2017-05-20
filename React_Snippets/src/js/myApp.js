/**
 * @author:  krido02 - 1/30/2017.
 */
'use strict';

const React = require('react');

// const Highcharts = require('react-highcharts');
const chartjsLine = require('./charting/chartjs/chartjs-linechart');
var bs = require('react-bootstrap');

const piechart = require('./charting/highcharts/highcharts-piechart');
const barchart = require('./charting/highcharts/highcharts-barchart');
const linechart = require('./charting/highcharts/highcharts-linechart');
const CounterWrapper = require('./byos/counter-wrapper');

const BasicLineClass = require('./charting/react-highcharts/basic-line-class');


let App = React.createClass({



    getInitialState: function() {
        return ({
            myConfig: {
                chart: {
                    type: "bar"
                },
                xAxis: {
                    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May']
                },
                series: [{
                    data: [29.9, 71.5, 106.4, 129.2, 144.0]
                }]
            }
        });
    },

    buttonClicked2: function(e) {
        let self = this;
        self.setState({
            myConfig: {
                chart: {
                    type: "bar"
                },
                xAxis: {
                    categories: ['Nov', 'Dec']
                },
                series: [{
                    data: [10.2, 1000]
                }]
            }
        });
        // chart.xAxis[0].setCategories(['Jan', 'Feb', 'Mar', 'Apr', 'May'],true)
        // chart.series.addPoint({x: 10, y: 12});
        // chart.series.setData([29.9, 71.5, 106.4, 129.2, 144.0],true)
    },

    buttonClicked: function(e) {
        // e.preventDefault();


        this.setState({
            myConfig: {
                chart: {
                    type: "bar"
                },title: {
                    text: "Matches in the past 199 months."
                },
                xAxis: {
                    categories: ['Jun', 'Jul', 'Aug', 'Sep', 'Oct']
                },
                yAxis: {
                    title: {
                        text: "These are the matches"
                    }
                },
                series: [{
                    name: "Number of Elvis sightings.",
                    color: "#32AAA9",
                    data: [144.0, 129.2, 106.4, 71.5, 29.9]
                }]
            }
        })

    },

    //  Hi
    toConsole:  function() {

        console.debug("HI");
    },


    render: function () {
        return (
            <div id="main-app">
                <div id="counter-wrapper" className="counter-app">
                    <CounterWrapper  />
                </div>
                <div id="react-piechart" className="charting">
                    {piechart}
                </div>
                <div id="react-barchart" className="charting">
                    {barchart}
                </div>
                <div id="react-linechart" className="charting">
                    {linechart}
                </div>
                <div id="chartjs-linechart">
                    <chartjsLine />
                </div>
                <div>
                    {this.toConsole()}
                </div>

                <div id="react_basic_line" className="charting">
                    <BasicLineClass config={this.state.myConfig} />
                </div>
                <div>
                    <bs.Button bsStyle='primary' className='myButton'  id="react-basic-line-button" onClick={this.buttonClicked}>Hi Everybody!</bs.Button>
                    <bs.Button bsStyle='primary' className='myButton'  id="react-basic-line-button2" onClick={this.buttonClicked2}>Bye!!!</bs.Button>
                </div>
            </div>
        );
    }
});

module.exports = App;