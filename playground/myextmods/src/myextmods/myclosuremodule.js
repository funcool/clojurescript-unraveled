goog.provide("myextmods.myclosuremodule");

goog.scope(function() {
  var module = myextmods.myclosuremodule;
  module.getGreetings = function() {
    return "Hello from google closure module.";
  };
});
