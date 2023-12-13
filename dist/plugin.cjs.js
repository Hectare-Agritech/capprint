'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const CapPrint = core.registerPlugin('CapPrint', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.CapPrintWeb()),
});

class CapPrintWeb extends core.WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    nativePrint() {
        window.print();
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    CapPrintWeb: CapPrintWeb
});

exports.CapPrint = CapPrint;
//# sourceMappingURL=plugin.cjs.js.map
