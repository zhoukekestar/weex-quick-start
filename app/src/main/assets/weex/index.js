/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports) {

	;__weex_define__("@weex-component/068c1ab8c0ae58a88b729733426de575", [], function(__weex_require__, exports, __weex_module__){

	;
	  const modal = __weex_require__('@weex-module/modal');
	  const navigator = __weex_require__('@weex-module/navigator');

	  __weex_module__.exports = {
	    methods: {
	      toast() {
	        modal.toast({
	          'message': 'Hello Weex',
	          'duration': 1
	        });
	      },
	      oninput() {},
	      onclick() {
	        const path = this.$el('input').attr.value;
	        
	        navigator.push({
	          url: path,
	          animation: 'true',
	        }, () => {});
	      }
	    }
	  }

	;__weex_module__.exports.template = __weex_module__.exports.template || {}
	;Object.assign(__weex_module__.exports.template, {
	  "type": "div",
	  "children": [
	    {
	      "type": "text",
	      "classList": [
	        "title"
	      ],
	      "events": {
	        "click": "toast"
	      },
	      "attr": {
	        "value": "Hello WEEX."
	      }
	    },
	    {
	      "type": "div",
	      "classList": [
	        "input-container"
	      ],
	      "children": [
	        {
	          "type": "input",
	          "id": "input",
	          "classList": [
	            "input"
	          ],
	          "events": {
	            "input": "oninput"
	          }
	        },
	        {
	          "type": "text",
	          "classList": [
	            "button"
	          ],
	          "events": {
	            "click": "onclick"
	          },
	          "attr": {
	            "value": "跳转页面"
	          }
	        }
	      ]
	    }
	  ]
	})
	;__weex_module__.exports.style = __weex_module__.exports.style || {}
	;Object.assign(__weex_module__.exports.style, {
	  "title": {
	    "marginTop": 40,
	    "textAlign": "center",
	    "fontSize": 28
	  },
	  "input-container": {
	    "marginTop": 80,
	    "justifyContent": "center",
	    "alignItems": "center"
	  },
	  "input": {
	    "width": 700,
	    "borderWidth": 1,
	    "borderColor": "#cccccc",
	    "fontSize": 28,
	    "paddingTop": 10,
	    "paddingRight": 10,
	    "paddingBottom": 10,
	    "paddingLeft": 10
	  },
	  "button": {
	    "marginTop": 40,
	    "backgroundColor": "#27cafb",
	    "borderRadius": 4,
	    "paddingTop": 10,
	    "paddingRight": 10,
	    "paddingBottom": 10,
	    "paddingLeft": 10,
	    "color": "#ffffff"
	  }
	})
	})
	;__weex_bootstrap__("@weex-component/068c1ab8c0ae58a88b729733426de575", {
	  "transformerVersion": "0.3.1"
	},undefined)

/***/ }
/******/ ]);