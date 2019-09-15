goog.provide("leapyears.util");

goog.scope(function() {
  var module = leapyears.util;

  module.isLeap = function(val) {
    return (0 === (val % 400)) || (((val % 100) > 0) && (0 === (val % 4)));
  };
});
