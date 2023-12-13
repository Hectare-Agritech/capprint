import { registerPlugin } from '@capacitor/core';
const CapPrint = registerPlugin('CapPrint', {
    web: () => import('./web').then(m => new m.CapPrintWeb()),
});
export * from './definitions';
export { CapPrint };
//# sourceMappingURL=index.js.map