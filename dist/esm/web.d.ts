import { WebPlugin } from '@capacitor/core';
import type { CapPrintPlugin } from './definitions';
export declare class CapPrintWeb extends WebPlugin implements CapPrintPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    nativePrint(): void;
}
