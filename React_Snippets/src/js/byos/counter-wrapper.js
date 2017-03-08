/**
 * @author:  krido02 - 1/30/2017.
 */

'use strict';

const React = require('react');
const Counter = require('./counter');

// require('../../style/byos/byos.scss');




let CounterWrapper = React.createClass({
    getInitialState: function() {
        return {
            something: 1
        }
    },

    render: function() {
        let myCount = 5;
        return (
            <div>
                 <div id="counter1" className="counter-app">
                     <p className="counter-app">Counter 1</p>
                     <Counter count={myCount} />
                 </div>
                <div>
                    <br/>
                </div>
                <div id="counter_2" className="counter-app">
                    Counter 2
                    <Counter count={15}/>
                </div>
                <div>
                    Oh Boy
                </div>
                <div id="counter_3" className="counter-app">
                    Counter 3
                    <Counter/>
                </div>
            </div>
        );
    }
});



module.exports = CounterWrapper;