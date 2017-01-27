/**
 * @author:  krido02 - 1/27/2017.
 *
 */
var ReactTools = require('react-tools');

module.exports = {
    process: function(src) {
        return ReactTools.transform(src);
    }
};