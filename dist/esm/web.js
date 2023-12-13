import { WebPlugin } from '@capacitor/core';
export class CapPrintWeb extends WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    nativePrint() {
        window.print();
    }
}
//# sourceMappingURL=web.js.map