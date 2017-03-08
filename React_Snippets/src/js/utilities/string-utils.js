/**
 * @author krido02 - 2/3/2017.
 */
'use strict';

let Utilities = {

    /*
        Method to get (for printing) a stringified version of an object, this takes into consideration
        cyclic objects and returns singular items (ignore cyclic/repeats).
     */
    cyclicStringify:  function(obj) {
        let seen = [];
        let stringified = JSON.stringify(obj, function (key, val) {
            if (val != null && typeof val == "object") {
                if (seen.indexOf(val) >= 0) {
                    return;
                }
                seen.push(val);
            }
            return val;
        });

        return stringified;
    },

    /*
        Method to check if an object is null or empty.
     */
    isObjNull: function(obj) {
        let isNull = false;

        if (obj === undefined || obj === null || obj.size === 0) {
            isNull = true;
        }

        return isNull;
    }
};

module.exports = Utilities;
