/**
 * @author:  krido02 - 1/27/2017.
 */

const React = require('react');

/**
 * A counter button: tap the button to increase the count.
 */


let Counter = React.createClass({

    getInitialState: function () {
        let count = 0;
        if (this.props.count !== undefined && this.props.count !== null) {
            count = this.props.count;
        }
        return {
            count:  count
        }
    },

    componentWillReceiveProps: function (newProps) {
        console.log('componentWillReceiveProps', nextProps.count);
        this.setState({count: newProps.count});

    },

    render: function () {
        return (
            <div>
                <button onClick={() => {
                    this.setState({ count: this.state.count + 1 });
                }} >
                    Increase!
                </button>
                Count:  {this.state.count}
                <button onClick={() => {
                    this.setState({count: this.state.count - 1});
                }} >
                    Descrease!
                </button>
            </div>
        );
    }
});


module.exports = Counter;