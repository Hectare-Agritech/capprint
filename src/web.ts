import { WebPlugin } from '@capacitor/core';

import type { CapPrintPlugin } from './definitions';

export class CapPrintWeb extends WebPlugin implements CapPrintPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  print(): void {
    window.print()
  }
}
