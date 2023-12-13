var capacitorCapPrint = (function (exports, core) {
    'use strict';

    const CapPrint = core.registerPlugin('CapPrint', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.CapPrintWeb()),
    });

    class CapPrintWeb extends core.WebPlugin {
        async echo(options) {
            console.log('ECHO', options);
            return options;
        }
        print() {
            window.print();
        }
    }

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        CapPrintWeb: CapPrintWeb
    });

    exports.CapPrint = CapPrint;

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
