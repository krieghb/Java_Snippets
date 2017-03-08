/**
 * @author krido02 - 2/3/2017.
 */
'use strict';

const React = require('react');
const ReactHighcharts = require('react-highcharts');

const Utilities = require('../../utilities/string-utils');


let basicLine = React.createClass({

    getInitialState: function() {
        return ({
            config: {
                chart: {
                    type: "bar"
                },
                xAxis: {
                    categories: []
                },
                series: [{
                    data: []
                }]
            }
        });
    },


    componentDidMount: function() {
        // console.log("Props:  " + Utilities.cyclicStringify(this.props));
        // console.log("Refs:  " + Utilities.cyclicStringify(this.refs));

        let chart = this.refs.react_basic_line.getChart();
        if (this.props.config){
        let self = this;
            self.setState({
                config: self.props.config
            });
        // chart.xAxis[0].setCategories(['Jan', 'Feb', 'Mar', 'Apr', 'May'],true)
        // chart.series.addPoint({x: 10, y: 12});
        // chart.series.setData([29.9, 71.5, 106.4, 129.2, 144.0],true)
        }
        // chart.redraw();
        // chart.config.setData(this.props.config);

    },

    componentWillReceiveProps: function (nextProps, nextContent) {
        // console.log("Next Props:  " + JSON.stringify(nextProps));
        let self = this;
        self.setState({
          config: nextProps.config,
        });

        // let chart = this.refs.react_basic_line.getChart();
        // console.log("Chart refs:  " + Utilities.cyclicStringify(chart));
        // chart.series.setData(this.props.config, true);
        // chart.series.addData(201);


    },

    render: function() {
        return (
            <div id="basic-line">
                <ReactHighcharts config={this.state.config} ref="react_basic_line"/>
            </div>
        )
    }
});

module.exports = basicLine;




