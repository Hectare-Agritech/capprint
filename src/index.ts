import { registerPlugin } from '@capacitor/core';

import type { CapPrintPlugin } from './definitions';

const CapPrint = registerPlugin<CapPrintPlugin>('CapPrint', {
  web: () => import('./web').then(m => new m.CapPrintWeb()),
});

export * from './definitions';
export { CapPrint };
