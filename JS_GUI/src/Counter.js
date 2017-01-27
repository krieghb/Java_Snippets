/**
 * Created by krido02 on 1/27/2017.
 */
import React from 'react';

/**
 * A counter button: tap the button to increase the count.
 */
class Counter extends React.Component {
    constructor() {
        super();
        this.state = {
            count: 0,
        };
    }

    render() {
        return (
            <button
                onClick={() => {
                    this.setState({ count: this.state.count + 1 });
                }}
            >
                Count: {this.state.count}
            </button>
        );
    }
}
export default Counter;